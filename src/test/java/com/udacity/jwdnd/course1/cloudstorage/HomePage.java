package com.udacity.jwdnd.course1.cloudstorage;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(css= "#logout-button")
    private WebElement logoutButton;

    @FindBy(css= "#nav-notes-tab")
    private WebElement notesTab;

    @FindBy(css= "#nav-credentials-tab")
    private WebElement credentialsTab;

    @FindBy(css= "#add-note-button")
    private WebElement addNoteButton;

    @FindBy(css= "#note-title")
    private WebElement noteTitle;

    @FindBy(css= "#note-description")
    private WebElement noteDescription;

    @FindBy(css= "#save-note-button")
    private WebElement saveNoteButton;

    @FindBy(css= "#row-note-title")
    private WebElement rowNoteTitle;

    @FindBy(css= "#row-note-desc")
    private WebElement rowNoteDesc;


    
    // Credential 
    @FindBy(css= "#add-credential-button")
    private WebElement addCredentialButton;

    @FindBy(css= "#credential-url")
    private WebElement credentialUrlText;

    @FindBy(css= "#credential-username")
    private WebElement credentialUsernameText;

    @FindBy(css= "#credential-password")
    private WebElement credentialPasswordText;

    @FindBy(css= "#save-credential-button")
    private WebElement saveCredentialButton;

    public void sleep() {
       try{
           Thread.sleep(1000);
       } catch (InterruptedException e){}
    }
    
    public HomePage(WebDriver webDriver) {
       PageFactory.initElements(webDriver, this);
    }
    public void logout() {
        this.logoutButton.click();
    }
    //Notes functionality
    public void goToNotesTab() {
        notesTab.click();
        sleep();
    }

    public void enterNote(String title, String text)  {
        goToNotesTab();
        sleep();
        addNoteButton.click();
        sleep();
        noteTitle.sendKeys(title);
        noteDescription.sendKeys(text);
        sleep();
        saveNoteButton.click();
        sleep();
    }
    public Note getFirstNote() {
        String title = rowNoteTitle.getText(); //wait.until(ExpectedConditions.elementToBeClickable(tableNoteTitle)).getText();
        String description = rowNoteDesc.getText(); //tableNoteDescription.getText();
        return new Note(title, description);
    }


    //Credential functionality ------------------------------------------------------------
    public void goToCredentialsTab() throws InterruptedException {
        credentialsTab.click();
    }
//    public void enterCredential(CredentialInTest credentialTest) throws InterruptedException {
//        goToCredentialsTab();
//        Thread.sleep(2000);
//        addCredentialButton.click();
//        Thread.sleep(1000);
//        credentialUrlText.sendKeys(credentialTest.url);
//        credentialUsernameText.sendKeys(credentialTest.username);
//        credentialPasswordText.sendKeys(credentialTest.password);
//        credentialSaveButton.click();
//        Thread.sleep(2000);
//        //  goToCredentialsTab();
//    }
}
