package ru.geekbrains.courses.LautkinaT.Lesson6.HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AbstractTest {

    static WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;
    Logger logger = LoggerFactory.getLogger("Test-Case's 1-6");


    @BeforeAll
    static void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");

        //options.addArguments("enable-automation");
        //options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        //options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    }

    @BeforeEach
    void initMainPage(){
        Assertions.assertDoesNotThrow( ()-> getWebDriver().navigate().to("https://www.livejournal.com"),
                "Страница не доступна");
        Assertions.assertTrue(true);

    }
    @AfterEach
    void quit () throws InterruptedException {
        new MainPage(getWebDriver()).clicklogout();
    }


    @AfterAll
    public static void exit(){

        if(driver !=null) driver.quit();
    }

    public WebDriver getWebDriver(){

        return this.driver;
    }
}
