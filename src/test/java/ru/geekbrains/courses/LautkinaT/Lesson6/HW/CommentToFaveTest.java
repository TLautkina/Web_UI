package ru.geekbrains.courses.LautkinaT.Lesson6.HW;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommentToFaveTest extends AbstractTest{

    @Test
    @DisplayName("Тест-кейс №4: Оставить новый комментарий к посту в избранном")
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
    }
}
