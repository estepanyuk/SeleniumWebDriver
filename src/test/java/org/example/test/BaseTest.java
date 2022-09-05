package org.example.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.example.page.PracticeFormPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BaseTest {

    protected PracticeFormPage practiceFormPage;

    protected WebDriver driver = null;
    protected SoftAssertions softAssertions = null;

    @BeforeEach
    public void prepare() {
        softAssertions = new SoftAssertions();

        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = "chrome";
        }
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "opera" -> {
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
            }
        }

        driver.manage().window().maximize();

        practiceFormPage = new PracticeFormPage(driver);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
