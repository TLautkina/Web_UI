package ru.geekbrains.courses.LautkinaT.Lesson3.HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test4_comment_to_Fave_post {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://www.livejournal.com/login.bml?returnto=https://www.livejournal.com/&ret=1");
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).sendKeys("tl_testing");
        driver.findElement(By.xpath("//input[@name='password']")).click();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test123");
        driver.findElement(By.xpath("//button[@name='action:login']")).click();
        driver.findElement(By.cssSelector(".s-header-item__link--friends")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@title='Избранное']")).click();
        Thread.sleep(1000);
        js.executeScript("window.scrollTo(0, 1433)");
        driver.findElement(By.id("body422")).click();
        driver.findElement(By.id("body422")).sendKeys("test001" + Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class='ng-isolate-scope']")).click();
        driver.get("https://tl-testing2.livejournal.com/422.html?view=comments#comments");
        Thread.sleep(1000);

        String s = driver.findElement(By.cssSelector(".acomments")).getText();

        assert (s.equals("test001"));

        System.out.println("Тест №4 пройден");

        driver.quit();
    }
}
