package ru.geekbrains.courses.LautkinaT.Lesson6.HW;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopTest extends AbstractTest {

    @Test
    @DisplayName("Тест-кейс №5: Проверка работы добавления платного тарифа в корзину и соответствия стоимости")
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

        logger.info("Тест-кейс №5 пройден");
    }
}
