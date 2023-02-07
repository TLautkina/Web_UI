package ru.geekbrains.courses.LautkinaT.Lesson6.HW;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MessageTests extends AbstractTest{


    @Test
    @DisplayName("Тест-кейс №2: Отправить новое сообщение")
    public void testCase2() throws InterruptedException {
        getWebDriver().get("https://livejournal.com");
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
        logger.info("Тест-кейс №2 пройден");

    }

    @Test
    @DisplayName("Тест-кейс №3: Сделать сообщение во Входящих непрочитанным")
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
        logger.info("Тест-кейс №3 пройден");
    }
}


