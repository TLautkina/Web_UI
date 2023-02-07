package ru.geekbrains.courses.LautkinaT.Lesson7.HW;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import ru.geekbrains.courses.LautkinaT.Lesson6.HW.FavouritesPage;
import ru.geekbrains.courses.LautkinaT.Lesson6.HW.MessagePage;
import ru.geekbrains.courses.LautkinaT.Lesson6.HW.ProfilePage;
import ru.geekbrains.courses.LautkinaT.Lesson6.HW.ShopPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LJTests extends AbstractTest {
    JavascriptExecutor js = (JavascriptExecutor) getWebDriver();

    void saveBrowserLogs() {
        LogEntries browserLogs = getWebDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        if (allLogRows.size() > 0) {
            allLogRows.forEach(logEntry -> {
                logger.debug("BROWSERLOGS: " + logEntry.getMessage());
            });
        }
    }

    @Test
    @DisplayName("Тест-кейс №1: Авторизация на сайте")
    @Description("Тест-кейс №1: Авторизация на сайте")
    @Link("ссылка на tms")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Авторизация на сайте")
    @Story("Вход на сайт по имени пользователя и паролю")

    public void testCase1() {
        new MainPage(getWebDriver()).clickauthBtn();
        new MainPage(getWebDriver())
                .setLogin("tl_testing")
                .setPassword("Test123")
                .clickloginBtn();
        assertTrue(new MainPage(getWebDriver()).checkUser("TL_TESTING"));
        saveBrowserLogs();
        String fileName = "test-case1-" + System.currentTimeMillis() + ".png";
        CommonUtils.makeScreenshot(getWebDriver(), fileName);
        logger.info("Тест-кейс №1 пройден");
    }

    @Test
    @DisplayName("Тест-кейс №2: Отправить новое сообщение")
    @Description("Тест-кейс №2: Отправить новое сообщение")
    @Link("ссылка на tms")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Отправка сообщения")
    @Story("Отправка нового сообщения другому пользователю")

    public void testCase2() throws InterruptedException {
        new MainPage(getWebDriver()).clickauthBtn();
        new MainPage(getWebDriver())
                .setLogin("tl_testing")
                .setPassword("Test123")
                .clickloginBtn();
        assertTrue(new MainPage(getWebDriver()).checkUser("TL_TESTING"));
        logger.debug(" - тесткейс № 2: авторизация успешна");
        new MainPage(getWebDriver()).showmainMenuMessages();
        new MessagePage(getWebDriver()).clickNewMsg();
        new MessagePage(getWebDriver()).setReceiverField("tl_testing2");
        new MessagePage(getWebDriver()).setSubjectField("test");
        new MessagePage(getWebDriver()).setMessageField("test");
        new MessagePage(getWebDriver()).clickSendMsg();
        new MessagePage(getWebDriver()).clickReturnToReceivedMessages();
        new MessagePage(getWebDriver()).clickSentMessages();
        assertTrue(new MessagePage(getWebDriver()).checkTimeOfSentMessages("несколько секунд назад"));
        saveBrowserLogs();
        String fileName = "test-case2-" + System.currentTimeMillis() + ".png";
        CommonUtils.makeScreenshot(getWebDriver(), fileName);
        logger.info("Тест-кейс №2 пройден");

    }

    @Test
    @DisplayName("Тест-кейс №3: Сделать сообщение во Входящих непрочитанным")
    @Description("Тест-кейс №3: Сделать сообщение во Входящих непрочитанным")
    @Link("ссылка на tms")
    @Severity(SeverityLevel.NORMAL)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Маркировка сообщения")
    @Story("Выделить прочитанное входящее сообщение и отметить его как непрочитанное")

    public void testCase3() throws InterruptedException {
        new MainPage(getWebDriver()).clickauthBtn();
        new MainPage(getWebDriver())
                .setLogin("tl_testing")
                .setPassword("Test123")
                .clickloginBtn();
        assertTrue(new MainPage(getWebDriver()).checkUser("TL_TESTING"));
        logger.debug(" - тесткейс № 3: авторизация успешна");
        new MainPage(getWebDriver()).showmainMenuMessages();
        new MessagePage(getWebDriver()).clickReceivedMessages();
        new MessagePage(getWebDriver()).clickCheckboxChooseMessage();
        new MessagePage(getWebDriver()).clickMakeUnreadMessage();
        assertTrue(new MessagePage(getWebDriver()).checkHeaderUnreadMessage("700"));
        saveBrowserLogs();
        String fileName = "test-case3-" + System.currentTimeMillis() + ".png";
        CommonUtils.makeScreenshot(getWebDriver(), fileName);
        logger.info("Тест-кейс №3 пройден");
    }

    @Test
    @DisplayName("Тест-кейс №4: Оставить новый комментарий к посту в избранном")
    @Description("Тест-кейс №4: Оставить новый комментарий к посту в избранном")
    @Link("ссылка на tms")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Отправка комментария")
    @Story("Отправить новый комментарий к посту в избранном")

    public void testCase4() throws InterruptedException {
        new MainPage(getWebDriver()).clickauthBtn();
        new MainPage(getWebDriver())
                .setLogin("tl_testing")
                .setPassword("Test123")
                .clickloginBtn();
        assertTrue(new MainPage(getWebDriver()).checkUser("TL_TESTING"));
        logger.debug(" - тесткейс № 4: авторизация успешна");
        new MainPage(getWebDriver()).clickfriends();
        new FavouritesPage(getWebDriver()).clickFavourites();
        new FavouritesPage(getWebDriver())
                .setTextFastComment("test002");
        assertTrue(new FavouritesPage(getWebDriver()).checkTestComment("test002"));
        logger.info("Тест-кейс №4 пройден");
        saveBrowserLogs();
        String fileName = "test-case4-" + System.currentTimeMillis() + ".png";
        CommonUtils.makeScreenshot(getWebDriver(), fileName);
        logger.info("Тест-кейс №4 пройден");
    }

    @Test
    @DisplayName("Тест-кейс №5: Проверка работы добавления платного тарифа в корзину и соответствия стоимости")
    @Description("Тест-кейс №5: Проверка работы добавления платного тарифа в корзину и соответствия стоимости")
    @Link("ссылка на tms")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Тестированеи корзины")
    @Story("Положить платный тариф в корзину и проверить соответствие стоимости при оформлении заказа")

    public void testCase5() {
        new MainPage(getWebDriver()).clickauthBtn();
        new MainPage(getWebDriver())
                .setLogin("tl_testing")
                .setPassword("Test123")
                .clickloginBtn();
        assertTrue(new MainPage(getWebDriver()).checkUser("TL_TESTING"));
        logger.debug(" - тесткейс № 5 : авторизация успешна");
        new MainPage(getWebDriver()).clickshop();
        new ShopPage(getWebDriver()).buyProfessionalPackage();
        new ShopPage(getWebDriver()).addToCart();
        assertTrue(new ShopPage(getWebDriver()).checkTotalSum("1399 RUB"));
        saveBrowserLogs();
        String fileName = "test-case5-" + System.currentTimeMillis() + ".png";
        CommonUtils.makeScreenshot(getWebDriver(), fileName);
        logger.info("Тест-кейс №5 пройден");
    }

    @Test
    @DisplayName("Тест-кейс №6: Проверка заполнения текстовых полей профиля")
    @Description("Тест-кейс №6: Проверка заполнения текстовых полей профиля")
    @Link("ссылка на tms")
    @Severity(SeverityLevel.CRITICAL)
    @Epic("Тестирование интерфейса сайта")
    @Feature("Рекдактирование профиля")
    @Story("Отредактировать профиль пользователя, заполнив все текстовые поля")

    public void testCase6() throws InterruptedException {
        new MainPage(getWebDriver()).clickauthBtn();
        new MainPage(getWebDriver())
                .setLogin("tl_testing")
                .setPassword("Test123")
                .clickloginBtn();
        assertTrue(new MainPage(getWebDriver()).checkUser("TL_TESTING"));
        logger.debug(" - тесткейс № 6: авторизация успешна");
        new MainPage(getWebDriver()).showmainMenuSettings();
        new ProfilePage(getWebDriver()).clickeditProfile();
        new ProfilePage(getWebDriver()).setUsernameField("test1");
        new ProfilePage(getWebDriver()).setjournalTitleField("test2");
        new ProfilePage(getWebDriver()).setjournalSubtitleField("test3");
        new ProfilePage(getWebDriver()).setinterestsField("test4");
        new ProfilePage(getWebDriver()).setbioField("test5");
        new ProfilePage(getWebDriver()).seturlField("https://ya.ru/");
        new ProfilePage(getWebDriver()).seturlNameField("test6");
        new ProfilePage(getWebDriver()).setcityField("test7");
        new ProfilePage(getWebDriver()).clicksaveChangesBtn();
        assertTrue(new ProfilePage(getWebDriver()).testUsername("test1"));
        assertTrue(new ProfilePage(getWebDriver()).testJournalTitle("test2"));
        assertTrue(new ProfilePage(getWebDriver()).testJournalSubtitle("test3"));
        assertTrue(new ProfilePage(getWebDriver()).testBioInterests("test5"));
        new ProfilePage(getWebDriver()).clickInterests();
        assertTrue(new ProfilePage(getWebDriver()).testBioInterests("test4"));
        assertTrue(new ProfilePage(getWebDriver()).testUrlname("test6"));
        String fileName = "test-case6-" + System.currentTimeMillis() + ".png";
        CommonUtils.makeScreenshot(getWebDriver(), fileName);
        logger.info("Тест-кейс №6 пройден");
    }
}
