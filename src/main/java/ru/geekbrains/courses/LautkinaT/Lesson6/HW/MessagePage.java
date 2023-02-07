package ru.geekbrains.courses.LautkinaT.Lesson6.HW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.courses.LautkinaT.Lesson6.HW.AbstractPage;

public class MessagePage extends AbstractPage {

        @FindBy(xpath = "//input[@class='inbox-sidebar__button-message']")
        private WebElement newMsg;

        @FindBy(id = "msg_to")
        private WebElement receiverField;

        @FindBy(xpath = "//input[@name='msg_subject']")
        private WebElement subjectField;

        @FindBy(name = "msg_body")
        private WebElement messageField;

        @FindBy(xpath = "//button[@value='Отправить']")
        private WebElement sendMsg;

        @FindBy(linkText = "Вернуться во Входящие")
        private WebElement returnToReceivedMessages;

        @FindBy(id = "esn_folder_usermsg_sent")
        private WebElement sentMessages;

        @FindBy(xpath = "//td[@class='time']")
        private WebElement timeOfSentMessages;

        @FindBy(id = "esn_folder_usermsg_recvd")
        private WebElement receivedMessages;

        @FindBy(id = "all_Check-8")
        private WebElement checkboxChooseMessage;

        @FindBy(id = "all_MarkUnread_1")
        private WebElement makeUnreadMessage;

        @FindBy(id = "all_Title_8")
        private WebElement headerUnreadMessage;

        public MessagePage(WebDriver driver) {
                super(driver);
        }

        public void clickNewMsg(){
                this.newMsg.click();
        }

        public MessagePage setReceiverField(String sReceiverField){
                this.receiverField.click();
                this.receiverField.sendKeys(sReceiverField);
                return this;
        }
        public MessagePage setSubjectField(String sSubjectField){
                this.subjectField.click();
                this.subjectField.sendKeys(sSubjectField);
                return this;
        }
        public MessagePage setMessageField(String sMessageField){
                this.messageField.click();
                this.messageField.sendKeys(sMessageField);
                return this;
        }

        public void clickSendMsg(){
                this.sendMsg.click();
        }

        public void clickReturnToReceivedMessages(){
                this.returnToReceivedMessages.click();
        }

        public void clickSentMessages(){
                this.sentMessages.click();
        }

        public Boolean checkTimeOfSentMessages(String chTimeOfSentMessages){
                String s = timeOfSentMessages.getText();
                return s.equals(chTimeOfSentMessages);
        }

        public void clickReceivedMessages(){
                this.receivedMessages.click();
        }

        public void clickCheckboxChooseMessage(){
                this.checkboxChooseMessage.click();
        }

        public void clickMakeUnreadMessage(){
                this.makeUnreadMessage.click();
        }

        public Boolean checkHeaderUnreadMessage(String chHeaderUnreadMessage){
                String s = headerUnreadMessage.getCssValue("font-weight");
                return s.equals(chHeaderUnreadMessage);
        }

}

