package ru.geekbrains.courses.LautkinaT.Lesson3.HW;

// Тест2. Отправить новое сообщение другому пользователю.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test2_NewMessage {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://www.livejournal.com/inbox/");


        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).sendKeys("tl_testing");
        driver.findElement(By.xpath("//input[@name='password']")).click();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test123");
        driver.findElement(By.xpath("//button[@name='action:login']")).click();
        driver.findElement(By.xpath("//input[@class='inbox-sidebar__button-message']")).click();
        driver.findElement(By.id("msg_to")).click();
        driver.findElement(By.id("msg_to")).sendKeys("tl_testing2");
        driver.findElement(By.xpath("//input[@name='msg_subject']")).click();
        driver.findElement(By.xpath("//input[@name='msg_subject']")).sendKeys("Test");
        driver.findElement(By.name("msg_body")).click();
        driver.findElement(By.name("msg_body")).sendKeys("test1");
        driver.findElement(By.xpath("//button[@value='Отправить']")).click();

        String s = driver.findElement(By.id("js")).getText();

        assert (s.equals("Ваше сообщение успешно отправлено"));

        System.out.println("Тест №2 пройден");

        driver.quit();
    }
}

