//package com.ctf_kg.ctf_kg.service.impl;
//
//import com.ctf_kg.ctf_kg.service.ParserService;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import static io.opentelemetry.api.internal.ValidationUtil.log;
//
//
//@Service
//public class ParserServiceImpl implements ParserService {
//
//
////...
//
//    @Override
//    public void parsePages(String baseUrl, int maxPages) throws IOException {
//        // Инициализация WebDriver
//        System.setProperty("webdriver.chrome.driver", "/Users/bambook/Downloads/chromedriver-mac-x64/chromedriver");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        System.out.println("\n\ngoing to try\n\n");
//        log("\n\ngoing to try\n\n");
//        try {
//            for (int i = 0; i < maxPages; i++) {
//                // Используем Jsoup для первой страницы или Selenium если это не первая страница
//                if (i == 0) {
//                    Document doc = Jsoup.connect(baseUrl).timeout(100000)
//                            .get();
//                    parseDocument(doc); // Ваш метод парсинга Jsoup
//                } else {
//                    // Ожидаем загрузки и парсим страницу с помощью Selenium
//                   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ui-datatable-tablewrapper > table > tbody > tr")));
//                    parseSeleniumPage(driver); // Ваш метод парсинга Selenium
//                }
//            }
//        } finally {
//            driver.quit(); // Закрываем браузер в любом случае
//        }
//    }
//
//    private void parseDocument(Document doc) {
//        Elements tableRows = doc.select("div.ui-datatable-tablewrapper > table > tbody > tr");
//
//        for (Element row : tableRows) {
//            Elements tds = row.select("td");
//            List<String> rowData = new ArrayList<>();
//
//            for (Element td : tds) {
//                rowData.add(td.text());
//            }
//
//            // Здесь вы можете обрабатывать данные каждой строки, например, сохранять их в базу данных или печатать в консоль
//            System.out.println(rowData);
//        }
//    }
//
//    private void parseSeleniumPage(WebDriver driver) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        System.out.println("here1");
//        System.out.println("here2");
//        ChromeOptions options2 = new ChromeOptions();
//        options2.addArguments("--remote-allow-origins=*");
//        WebElement nextPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-paginator-next.ui-state-default.ui-corner-all")));
//        System.out.println("here3");
//
//        nextPageButton.click();
//
//        List<WebElement> tableRows = driver.findElements(By.cssSelector("div.ui-datatable-tablewrapper > table > tbody > tr"));
//
//        for (WebElement row : tableRows) {
//            List<WebElement> tds = row.findElements(By.tagName("td"));
//            List<String> rowData = new ArrayList<>();
//
//            for (WebElement td : tds) {
//                rowData.add(td.getText());
//            }
//
//            // Здесь вы также можете обрабатывать данные каждой строки
//            System.out.println(rowData);
//        }
//    }
//
//
//
//    @Override
//    public void parse(String url) throws IOException {
//        Document doc = Jsoup.connect(url).timeout(100000)
//                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3")
//                .get();
//
//        Elements tableRows = doc.select("div.ui-datatable-tablewrapper > table > tbody > tr");
//        System.out.println("the size: " + tableRows.size());
//
//        List<List<String>> tableData = new ArrayList<>();
//
//        for (Element row : tableRows) {
//            Elements tds = row.select("td");
//            List<String> rowData = new ArrayList<>();
//            System.out.println("\n\nNew row");
//            for (Element td : tds) {
//                String text = td.text();
//                rowData.add(text);
//                System.out.println(text);
//            }
//            tableData.add(rowData);
//        }
//
//        // Here you can return the tableData or process it further as needed
//    }
//    void driverLoadNextPage(String url){
//        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
//
//        WebDriver driver = new ChromeDriver();
//        driver.get(url); // replace with your URL
//
//        // Wait for JavaScript to load content
//        // new WebDriverWait(driver, Duration.ofSeconds(10)).until(...);
//
//        // Interact with the page, e.g., click on the pagination link
//        WebElement nextPageButton = driver.findElement(By.id("nextPageButtonId")); // replace with actual button ID or selector
//        nextPageButton.click();
//
//        // After clicking, you need to wait for the page to load the content
//        // new WebDriverWait(driver, Duration.ofSeconds(10)).until(...);
//
//        // Now the new content is loaded, and you can parse it
//        List<WebElement> newPageElements = driver.findElements(By.cssSelector("yourSelector"));
//
//        // Do your stuff with newPageElements
//
//        driver.quit();
//    }
//}
