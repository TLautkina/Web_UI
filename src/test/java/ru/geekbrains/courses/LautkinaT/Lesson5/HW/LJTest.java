package ru.geekbrains.courses.LautkinaT.Lesson5.HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LJTest {
    static WebDriver driver;
    Logger logger = LoggerFactory.getLogger("Test-Case's 1-6");
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @BeforeAll
    static void initClass() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);


    }

    @AfterAll
    static void finalClass() {

        driver.quit();
    }

    @BeforeEach
    void initTest() {
        driver.get("https://www.livejournal.com/");
        driver.findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
        driver.findElement(By.id("user")).click();
        driver.findElement(By.id("user")).sendKeys("tl_testing");
        driver.findElement(By.xpath("//input[@name='password']")).click();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test123");
        driver.findElement(By.xpath("//button[@name='action:login']")).click();
    }

    @AfterEach
    void quit() {

        WebElement hoverable = driver.findElement(By.linkText("TL_TESTING"));
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();
        driver.findElement(By.cssSelector(".s-header-sub-list-item__link--logout")).click();
    }

    @Test
    @DisplayName("Тест-кейс №1: Авторизация на сайте")
    public void testCase1() {
        //самый короткий тест, по сути проверка предусловия - залогин тестовым пользователем
        String s = driver.findElement(By.cssSelector(".s-nav-item__name")).getText();
        assertTrue(s.equals("TL_TESTING"));
        logger.info("Тест-кейс №1 пройден");

    }

    @Test
    @DisplayName("Тест-кейс №2: Отправить новое сообщение другому пользователю")
    public void testCase2() {

        WebElement hoverable = driver.findElement(By.linkText("TL_TESTING"));
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();
        driver.findElement(By.cssSelector(".s-header-sub-list-item__link--messages")).click();
        driver.findElement(By.xpath("//input[@class='inbox-sidebar__button-message']")).click();
        driver.findElement(By.id("msg_to")).click();
        driver.findElement(By.id("msg_to")).sendKeys("tl_testing2");
        driver.findElement(By.xpath("//input[@name='msg_subject']")).click();
        driver.findElement(By.xpath("//input[@name='msg_subject']")).sendKeys("Test");
        driver.findElement(By.name("msg_body")).click();
        driver.findElement(By.name("msg_body")).sendKeys("test1");
        driver.findElement(By.xpath("//button[@value='Отправить']")).click();
        driver.findElement(By.linkText("Вернуться во Входящие")).click();
        driver.findElement(By.id("esn_folder_usermsg_sent")).click();
        String s = driver.findElement(By.xpath("//td[@class='time']")).getText();
        assertTrue(s.equals("несколько секунд назад"));
        logger.info("Тест-кейс №2 пройден");


    }

    @Test
    @DisplayName("Тест-кейс №3: Сделать сообщение от другого пользователя непрочитанным")
    public void testCase3() {

        WebElement hoverable = driver.findElement(By.linkText("TL_TESTING"));
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();
        driver.findElement(By.cssSelector(".s-header-sub-list-item__link--messages")).click();
        driver.findElement(By.id("esn_folder_usermsg_recvd")).click();
        driver.findElement(By.id("all_Check-8")).click();
        driver.findElement(By.id("all_MarkUnread_1")).click();
        String s = driver.findElement(By.id("all_Title_8")).getCssValue("font-weight");
        assertTrue(s.equals("700"));
        logger.info("Тест-кейс №3 пройден");

    }

    @Test
    @DisplayName("Тест-кейс №4: Оставить новый комментарий к посту в избранном")
    public void testCase4() throws InterruptedException {

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
        String s = driver.findElement(By.xpath("//div[@class='mdspost-comment__body']")).getText();
        assertTrue(s.equals("test001"));
        logger.info("Тест-кейс №4 пройден");

    }

    @Test
    @DisplayName("Тест-кейс №5: Проверка работы добавления платного тарифа в корзину и соответствия стоимости")
    public void testCase5() throws InterruptedException {

        driver.findElement(By.cssSelector(".s-header-item__link--shop")).click();
        Thread.sleep(1000);
        driver.findElement(By.partialLinkText("Подключить пакет")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@name='send']")).click();
        Thread.sleep(1000);
        String s = driver.findElement(By.id("total")).getText();

        assertTrue(s.equals("1399 RUB"));
        logger.info("Тест-кейс №5 пройден");

    }

    @Test
    @DisplayName("Тест-кейс №6: Проверка работы текстовых полей формы ввода личных данных")
    public void testCase6() throws InterruptedException {

        WebElement hoverable = driver.findElement(By.linkText("TL_TESTING"));
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();
        driver.findElement(By.cssSelector(".s-header-sub-list-item__link--settings")).click();
        driver.get("https://www.livejournal.com/manage/settings/");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Редактировать профиль")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='name']")).clear();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("test1");
        driver.findElement(By.xpath("//textarea[@name='journal_title']")).clear();
        driver.findElement(By.xpath("//textarea[@name='journal_title']")).sendKeys("test2");
        driver.findElement(By.xpath("//textarea[@name='journal_subtitle']")).clear();
        driver.findElement(By.xpath("//textarea[@name='journal_subtitle']")).sendKeys("test3");
        driver.findElement(By.xpath("//textarea[@name='interests']")).clear();
        driver.findElement(By.xpath("//textarea[@name='interests']")).sendKeys("test4");
        driver.findElement(By.xpath("//textarea[@name='bio']")).clear();
        driver.findElement(By.xpath("//textarea[@name='bio']")).sendKeys("test5");
        driver.findElement(By.xpath("//input[@name='url']")).clear();
        driver.findElement(By.xpath("//input[@name='url']")).sendKeys("https://ya.ru/");
        driver.findElement(By.xpath("//input[@name='urlname']")).clear();
        driver.findElement(By.xpath("//input[@name='urlname']")).sendKeys("test6");
        driver.findElement(By.xpath("//input[@id='city']")).clear();
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("test7");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

        String a1 = driver.findElement(By.xpath("//div[@class='b-profile-group-body']")).getText();
        assertEquals("test1", a1);
        String a2 = driver.findElement(By.linkText("test2")).getText();
        assertEquals("test2", a2);
        String a3 = driver.findElement(By.xpath("//h2[@class='b-profile-intro-subtitle']")).getText();
        assertEquals("test3", a3);
        String a4 = driver.findElement(By.xpath("//div[@class='b-tabs-content']")).getText();
        assertEquals("test5", a4);
        driver.findElement(By.xpath("//a[contains(text(),'Интересы')]")).click();
        String a5 = driver.findElement(By.xpath("//div[@class='b-tabs-content']")).getText();
        assertEquals("test4", a5);
        String a6 = driver.findElement(By.linkText("test6")).getText();
        assertEquals("test6", a6);
        String a7 = driver.findElement(By.linkText("test7")).getText();
        assertEquals("test7", a7);

        logger.info("Тест-кейс №6 пройден");

    }

}
