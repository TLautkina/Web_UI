package ru.geekbrains.courses.LautkinaT.Lesson3.HW;

// Тест3. Сделать сообщение от другого пользователя непрочитанным.

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test3_UnreadMessage {

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
        driver.findElement(By.id("esn_folder_usermsg_recvd")).click();
        driver.findElement(By.id("all_Check-8")).click();
        driver.findElement(By.id("all_MarkUnread_1")).click();

        String s = driver.findElement(By.id("all_Title_8")).getCssValue("font-weight");
        assert (s.equals("700"));

        System.out.println("Тест №3 пройден");

        driver.quit();
    }
}
