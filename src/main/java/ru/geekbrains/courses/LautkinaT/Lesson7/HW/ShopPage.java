package ru.geekbrains.courses.LautkinaT.Lesson7.HW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends AbstractPage {

    @FindBy(partialLinkText = "Подключить пакет")
    private WebElement professionalPackage;

    @FindBy(xpath = "//button[@name='send']")
    private WebElement addToCartBtn;

    @FindBy(id = "total")
    private WebElement totalSum;

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public void buyProfessionalPackage() {
        this.professionalPackage.click();
    }

    public void addToCart() {
        this.addToCartBtn.click();
    }

    public Boolean checkTotalSum(String chTotalSum){
        String s = totalSum.getText();
        return s.equals(chTotalSum);
    }

}

