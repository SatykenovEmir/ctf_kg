package com.ctf_kg.ctf_kg.service.impl;

import com.ctf_kg.ctf_kg.service.ParserService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.opentelemetry.api.internal.ValidationUtil.log;


@Service
public class ParserServiceImpl implements ParserService {

    private WebDriver driver;
    private WebDriverWait wait;

    // ... (Other methods and variables)

    @Override
    public void parsePages(String baseUrl, int maxPages) throws IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/bambook/Downloads/chromedriver-mac-x64/chromedriver");
        initializeWebDriver();

        try {
            driver.get(baseUrl);
            System.out.println("success2");
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            System.out.println("success3");


            for (int i = 0; i < maxPages; i++) {
                parseSeleniumPage();
                System.out.println("success23");
                System.out.println("the index:"+i);

                // Use Selenium to parse the page
                // Implement logic to navigate to the next page if necessary
            }
        } finally {
            driver.quit(); // Always quit the driver
        }
    }

    private void parseSeleniumPage() {
        System.out.println("success3");

        WebElement nextPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-paginator-next")));
        System.out.println("success4");
        nextPageButton.click();

        try {
            Thread.sleep(7000); // 5000 миллисекунд = 5 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("success5");

        List<WebElement> tableRows = driver.findElements(By.cssSelector("div.ui-datatable-tablewrapper > table > tbody > tr > td"));
        System.out.println("success7");

        for (WebElement row : tableRows) {
            //row.get

        }

//            List<WebElement> tds = row.findElements(By.cssSelector("td[role='gridcell']"));
//            System.out.println("success9");
//
//            List<String> rowData = new ArrayList<>();
//            for (WebElement td : tds) {
//                System.out.println("success10");
//                String data = td.getText();
//                rowData.add(data);
//
//                System.out.println("success11");
//                System.out.println(data);
//                System.out.println("success11.5");
//
//            }
//            System.out.println("success12");

            // Here you can process the row data
           // System.out.println(rowData);

    }

    private void initializeWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        System.out.println("success1");
    }




}
