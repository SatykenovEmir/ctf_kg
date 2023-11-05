package com.ctf_kg.ctf_kg.service.impl;

import com.ctf_kg.ctf_kg.entities.*;
import com.ctf_kg.ctf_kg.repositories.*;
import com.ctf_kg.ctf_kg.service.ParserService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private BudgetInstitutionRepository budgetInstitutionRepository;
    @Autowired
    private NotBudgetInstitutionRepository notBudgetInstitutionRepository;
    @Autowired
    private PublicPlanRepository publicPlanRepository;

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

                // Use Selenium to parse the page
                // Implement logic to navigate to the next page if necessary
            }
        } finally {
            driver.quit(); // Always quit the driver
        }
    }

    private void parseSeleniumPage() {
        // Assume we have a button to go to the next page


        // Wait for the presence of the table after clicking next page
        List<WebElement> tableRows = driver.findElements(By.cssSelector("div.ui-datatable-tablewrapper > table > tbody"));
        System.out.println("tableRows size: "+tableRows.size());
        for (WebElement row : tableRows) {
            System.out.println("\nstart\n");
            List<WebElement> webElements = row.findElements(By.className("ui-widget-content"));
            System.out.println("webElement size: "+webElements.size());
            for (int i = 0;i < webElements.size();i++){
                System.out.println("\none user:\n");
                WebElement webElement = webElements.get(i);
                String[] parts = webElement.getText().split("\n");
                System.out.println("the lengs of array: "+parts.length);
//                for (int k = 0; k < parts.length;k++){
//                    addToNotBadgetInstitution(parts[k]);
//                }
                addToContract(parts);
                //addToProduct(parts);
                //addToBadgetInstitution(parts);
                //addToNotBadgetInstitution(parts);
                //addToPublicPlans(parts);
            }
            System.out.println("\nend\n");

        }
        System.out.println("\n\nnew page\n\n");
        WebElement nextPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("ui-paginator-next")));
        nextPageButton.click();
        try {
            Thread.sleep(7000); // 5000 миллисекунд = 5 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addToPublicPlans(String[] parts) {
        PublicPlans publicPlans = new PublicPlans();
        publicPlans.setNumber((parts[1]));
        publicPlans.setTypeOfPlan(parts[3]);
        publicPlans.setINN(parts[5]);
        publicPlans.setNameOfCompany(parts[7]);
        publicPlans.setYear(parts[11]);
        publicPlans.setAmount(parts[13]);
        publicPlans.setLastChange(parts[13]);
        publicPlanRepository.save(publicPlans);
    }

    private void addToNotBadgetInstitution(String input) {
        int yearIndex = input.lastIndexOf(" ");
        String year = input.substring(yearIndex + 1);
        String rest = input.substring(0, yearIndex);

        // Теперь, когда у нас есть оставшаяся часть без года, найдем индекс, где начинается сумма
        // Сумма предшествует году и отделена пробелом
        int amountIndex = rest.lastIndexOf(" ");
        String amount = rest.substring(amountIndex + 1).replace(",", ""); // Удаляем запятые для чистоты числа
        String name = rest.substring(0, amountIndex);

        System.out.println("Название: " + name);
        System.out.println("Сумма: " + amount);
        System.out.println("Год: " + year);

        NotBudgetInstitution institution = new NotBudgetInstitution();
        institution.setAccountName(name);
        institution.setAmount(amount);
        institution.setYear(year);

        notBudgetInstitutionRepository.save(institution);
    }

    private void addToBadgetInstitution(String[] parts) {
        BudgetInstitution institution = new BudgetInstitution();
        institution.setBudgetId((parts[1]));
        institution.setAccountNumber(parts[3]);
        institution.setAccountName(parts[5]);
        institution.setExpenditure(parts[7]);
        institution.setAmount(parts[9]);
        institution.setReservedAmount(parts[11]);
        institution.setSavedAmount(parts[13]);
        institution.setResidualAmount(parts[13]);
        institution.setYear(parts[13]);
        budgetInstitutionRepository.save(institution);
    }

    private void addToContract(String[] parts) {
        Contracts contracts = new Contracts();
        contracts.setContractId((parts[1]));
        contracts.setContractNumber(parts[3]);
        contracts.setAccountName(parts[5]);
        contracts.setExpendITure(parts[7]);
        contracts.setAmount(parts[9]);
        contracts.setReservedAmount(parts[11]);
        contracts.setSavedAmount(parts[13]);
        contracts.setResidualAmount(parts[13]);
        contracts.setYear(parts[13]);
        contractRepository.save(contracts);
    }

    private void addToProduct(String[] parts) {
            Product product = new Product();
            product.setNumber((parts[1]));
            product.setOrganizationName(parts[3]);
            product.setTypeofProduct(parts[5]);
            product.setNameOfProduct(parts[7]);
            product.setPlannedPrize(parts[9]);
            product.setPublicationDate(parts[11]);
            product.setSupplierProposalDeadLine(parts[13]);
            productRepository.save(product);
    }

    private void initializeWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        System.out.println("success1");
    }




}
