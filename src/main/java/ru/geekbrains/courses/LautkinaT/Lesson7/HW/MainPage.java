package ru.geekbrains.courses.LautkinaT.Lesson7.HW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(text(),'Войти')]")
    private WebElement authBtn;


    @FindBy(id = "user")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@name='action:login']")
    private WebElement loginBtn;

    @FindBy(linkText = "TL_TESTING")
    private WebElement mainMenu;

    @FindBy(css = ".s-header-item__link--friends")
    private WebElement friends;

    @FindBy(css = ".s-header-item__link--shop")
    private WebElement shop;

    @FindBy(css = ".s-header-sub-list-item__link--logout")
    private WebElement logout;

    @FindBy(css = ".s-header-sub-list-item__link--messages")
    private WebElement mainMenuMessages;

    @FindBy(css = ".s-header-sub-list-item__link--settings")
    private WebElement mainMenuSettings;

    public MainPage(WebDriver driver) {
        super(driver);
    }


    public void clickauthBtn(){
        this.authBtn.click();
    }

    public void clickloginBtn(){
        this.loginBtn.click();
    }

    public void clickshop(){
        this.shop.click();
    }

    public void clickfriends(){
        this.friends.click();
    }



    public void clicklogout() throws InterruptedException{
        Actions actions = new Actions(getDriver());
        actions.moveToElement(mainMenu).build().perform();
        Thread.sleep(1000);
        actions.click(logout).perform();
    }

    public void showmainMenuMessages() throws InterruptedException{
        Actions actions = new Actions(getDriver());
        actions.moveToElement(mainMenu).build().perform();
        Thread.sleep(1000);
        actions.click(mainMenuMessages).perform();
    }

    public void showmainMenuSettings() throws InterruptedException{
        Actions actions = new Actions(getDriver());
        actions.moveToElement(mainMenu).build().perform();
        Thread.sleep(1000);
        actions.click(mainMenuSettings).perform();
    }

    public MainPage setLogin(String login){
        this.loginField.click();
        this.loginField.clear();
        this.loginField.sendKeys(login);
        return this;
    }

    public MainPage setPassword(String password){
        this.passwordField.click();
        this.passwordField.clear();
        this.passwordField.sendKeys(password);
        return this;
    }

    public Boolean checkUser(String chUserName){
        String s = mainMenu.getText();
        return s.equals(chUserName);
    }
}
