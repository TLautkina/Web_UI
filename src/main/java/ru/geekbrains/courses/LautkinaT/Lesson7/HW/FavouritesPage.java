package ru.geekbrains.courses.LautkinaT.Lesson7.HW;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.openqa.selenium.Keys.ENTER;


public class FavouritesPage extends AbstractPage {
    JavascriptExecutor js = (JavascriptExecutor) getDriver();

        @FindBy(xpath = "//a[@title='Избранное']")
        private WebElement favourites;

        @FindBy(id = "body422")
        private WebElement textFastComment;

        @FindBy(css = ".quick-comment-entryunit__comment.js-font-family.js-font-color.ng-binding")
        private WebElement testComment;

        public FavouritesPage(WebDriver driver) {
                super(driver);
        }

    public void clickFavourites() throws InterruptedException{
        this.favourites.click();
        Thread.sleep(1000);
    }
    public FavouritesPage setTextFastComment(String sTestComment) throws InterruptedException{
        js.executeScript("window.scrollTo(0, 500)");
        this.textFastComment.click();
        this.textFastComment.sendKeys(sTestComment);
        this.textFastComment.sendKeys(ENTER);
        Thread.sleep(5000);
        return this;
    }
    public Boolean checkTestComment(String chTestComment){
        String s = testComment.getText();
        return s.equals(chTestComment);
    }
}



