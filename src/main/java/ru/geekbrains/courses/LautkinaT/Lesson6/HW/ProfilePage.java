package ru.geekbrains.courses.LautkinaT.Lesson6.HW;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class  ProfilePage extends AbstractPage {

    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    @FindBy(linkText = "Редактировать профиль")
    private WebElement editProfile;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement usernameField;

    @FindBy(xpath = "//textarea[@name='journal_title']")
    private WebElement journalTitleField;

    @FindBy(xpath = "//textarea[@name='journal_subtitle']")
    private WebElement journalSubtitleField;

    @FindBy(xpath = "//textarea[@name='interests']")
    private WebElement interestsField;

    @FindBy(xpath = "//textarea[@name='bio']")
    private WebElement bioField;

    @FindBy(xpath = "//input[@name='url']")
    private WebElement urlField;

    @FindBy(xpath = "//input[@name='urlname']")
    private WebElement urlNameField;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityField;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement saveChangesBtn;


    //for asserts

    @FindBy(xpath = "//div[@class='b-profile-group-body']")
    private WebElement username;

    @FindBy(linkText = "test2")
    private WebElement journalTitle;

    @FindBy(xpath = "//h2[@class='b-profile-intro-subtitle']")
    private WebElement journalSubtitle;

    @FindBy(xpath = "//div[@class='b-tabs-content']")
    private WebElement bioInterests;

    @FindBy(xpath = "//a[contains(text(),'Интересы')]")
    private WebElement interests;

    @FindBy(linkText = "test6")
    private WebElement urlname;

    @FindBy(linkText = "test7")
    private WebElement city;



    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void clickeditProfile() throws InterruptedException{
        this.editProfile.click();
        Thread.sleep(2500);
    }

    public ProfilePage setUsernameField(String sUsernameField){
        this.usernameField.click();
        this.usernameField.clear();
        this.usernameField.sendKeys(sUsernameField);
        return this;
    }

    public ProfilePage setjournalTitleField(String sjournalTitleField){
        this.journalTitleField.click();
        this.journalTitleField.clear();
        this.journalTitleField.sendKeys(sjournalTitleField);
        return this;
    }

    public ProfilePage setjournalSubtitleField(String sjournalSubtitleField){
        this.journalSubtitleField.click();
        this.journalSubtitleField.clear();
        this.journalSubtitleField.sendKeys(sjournalSubtitleField);
        return this;
    }

    public ProfilePage setinterestsField(String sinterestsField){
        this.interestsField.click();
        this.interestsField.clear();
        this.interestsField.sendKeys(sinterestsField);
        return this;
    }

    public ProfilePage setbioField(String sbioField){
        this.bioField.click();
        this.bioField.clear();
        this.bioField.sendKeys(sbioField);
        return this;
    }

    public ProfilePage seturlField(String surlField){
        this.urlField.click();
        this.urlField.clear();
        this.urlField.sendKeys(surlField);
        return this;
    }

    public ProfilePage seturlNameField(String surlNameField){
        this.urlNameField.click();
        this.urlNameField.clear();
        this.urlNameField.sendKeys(surlNameField);
        return this;
    }

    public ProfilePage setcityField(String scityField){
        this.cityField.click();
        this.cityField.clear();
        this.cityField.sendKeys(scityField);
        return this;
    }

    public void clicksaveChangesBtn() throws InterruptedException{
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2500);
        this.saveChangesBtn.click();
    }

    public void clickInterests() throws InterruptedException{
        Thread.sleep(2500);
        this.interests.click();
    }

    public Boolean testUsername(String tUserName){
        String s = username.getText();
        return s.equals(tUserName);
    }
    public Boolean testJournalTitle(String tJournalTitle){
        String s = journalTitle.getText();
        return s.equals(tJournalTitle);
    }
    public Boolean testJournalSubtitle(String tJournalSubtitle){
        String s = journalSubtitle.getText();
        return s.equals(tJournalSubtitle);
    }
    public Boolean testBioInterests(String tBioInterests){
        String s = bioInterests.getText();
        return s.equals(tBioInterests);

    }
    public Boolean testUrlname(String tUrlname){
        String s = urlname.getText();
        return s.equals(tUrlname);
    }
    public Boolean testCity(String tCity){
        String s = city.getText();
        return s.equals(tCity);
    }


}



