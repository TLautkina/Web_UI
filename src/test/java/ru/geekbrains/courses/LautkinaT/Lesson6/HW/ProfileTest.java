package ru.geekbrains.courses.LautkinaT.Lesson6.HW;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileTest extends AbstractTest{

    @Test
    @DisplayName("Тест-кейс №6: Проверка заполнения текстовых полей профиля")
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
        new ProfilePage(getWebDriver())
                .setUsernameField("test1");
        new ProfilePage(getWebDriver())
                .setjournalTitleField("test2");
        new ProfilePage(getWebDriver())
                .setjournalSubtitleField("test3");
        new ProfilePage(getWebDriver())
                .setinterestsField("test4");
        new ProfilePage(getWebDriver())
                .setbioField("test5");
        new ProfilePage(getWebDriver())
                .seturlField("https://ya.ru/");
        new ProfilePage(getWebDriver())
                .seturlNameField("test6");
        new ProfilePage(getWebDriver())
                .setcityField("test7");
        new ProfilePage(getWebDriver()).clicksaveChangesBtn();

        assertTrue(new ProfilePage(getWebDriver()).testUsername("test1"));
        assertTrue(new ProfilePage(getWebDriver()).testJournalTitle("test2"));
        assertTrue(new ProfilePage(getWebDriver()).testJournalSubtitle("test3"));
        assertTrue(new ProfilePage(getWebDriver()).testBioInterests("test5"));

        new ProfilePage(getWebDriver()).clickInterests();

        assertTrue(new ProfilePage(getWebDriver()).testBioInterests("test4"));
        assertTrue(new ProfilePage(getWebDriver()).testUrlname("test6"));
        assertTrue(new ProfilePage(getWebDriver()).testCity("test7"));

        logger.info("Тест-кейс №6 пройден");
    }
}

