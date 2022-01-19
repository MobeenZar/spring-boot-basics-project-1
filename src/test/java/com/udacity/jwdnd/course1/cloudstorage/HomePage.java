package com.udacity.jwdnd.course1.cloudstorage;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
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

    @FindBy(css = "#edit-note-button")
    private WebElement editNoteButton;

    @FindBy(css = "#delete-note-button")
    private WebElement deleteNoteButton;

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

    @FindBy(css = "#edit-credential-button")
    private WebElement editCredentialButton;

    @FindBy(css = "#delete-credential-button")
    private WebElement deleteCredentialButton;

    @FindBy(css= "#credential-url")
    private WebElement credentialUrl;

    @FindBy(css= "#credential-username")
    private WebElement credentialUsername;

    @FindBy(css= "#credential-password")
    private WebElement credentialPassword;

    @FindBy(css= "#save-credential-button")
    private WebElement saveCredentialButton;

    @FindBy(css= "#rec-credential-url")
    private WebElement recUrl;

    @FindBy(css= "#rec-credential-username")
    private WebElement recUserName;

    @FindBy(css= "#rec-credential-password")
    private WebElement recPassword;

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
        addNoteButton.click();
        sleep();
        noteTitle.sendKeys(title);
        noteDescription.sendKeys(text);
        saveNoteButton.click();
        sleep();
    }

    public void editNote(String title, String text)  {
        goToNotesTab();
        editNoteButton.click();
        sleep();
        noteTitle.clear();
        noteTitle.sendKeys(title);
        noteDescription.clear();
        noteDescription.sendKeys(text);
        //sleep();
        saveNoteButton.click();
        sleep();
    }
    public Note getFirstNote() {
        String title = rowNoteTitle.getText(); //wait.until(ExpectedConditions.elementToBeClickable(rowNoteTitle)).getText();
        String description = rowNoteDesc.getText(); //rowNoteDesc.getText();
        return new Note(title, description);
    }

    public void deleteNote()  {
        goToNotesTab();
        deleteNoteButton.click();
        //sleep();
    }


    //Credential functionality
    public void goToCredentialsTab() {
        credentialsTab.click();
        sleep();
    }

    public void enterCredential(String url, String userName, String password)  {
        goToCredentialsTab();
        addCredentialButton.click();
        sleep();
        credentialUrl.sendKeys(url);
        credentialUsername.sendKeys(userName);
        credentialPassword.sendKeys(password);
        //sleep();
        saveCredentialButton.click();
        sleep();
    }

    public void editCredential(String url, String userName, String password)  {
        goToCredentialsTab();
        editCredentialButton.click();
        sleep();
        credentialUrl.clear();
        credentialUrl.sendKeys(url);

        credentialUsername.clear();
        credentialUsername.sendKeys(userName);

        credentialPassword.clear();
        credentialPassword.sendKeys(password);

        saveCredentialButton.click();
        sleep();
    }

    public Credential getFirstCredential() {
       return new Credential(recUrl.getText(), recUserName.getText(), recPassword.getText());
    }

    public void deleteCredential()  {
        goToCredentialsTab();
        deleteCredentialButton.click();
        //sleep();
    }
}
