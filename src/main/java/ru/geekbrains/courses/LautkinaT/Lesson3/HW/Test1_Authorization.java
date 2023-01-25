package ru.geekbrains.courses.LautkinaT.Lesson3.HW;

// Тест1. Авторизация на сайте.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test1_Authorization {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.livejournal.com/login.bml?returnto=https://www.livejournal.com/&ret=1");
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).sendKeys("tl_testing");
        driver.findElement(By.xpath("//input[@name='password']")).click();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test123");
        driver.findElement(By.xpath("//button[@name='action:login']")).click();
        String s = driver.findElement(By.xpath("//a[@class='s-header-item__link']")).getText();

        assert (s.equals("tl_testing"));

        System.out.println("Тест №1 пройден");

        driver.quit();
    }
}
