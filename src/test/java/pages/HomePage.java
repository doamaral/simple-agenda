package pages;

import core.BasePage;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.components.AddContactForm;

import static core.DriverFactory.getDriver;

@Log4j
public class HomePage extends BasePage {

    @FindBy(how = How.TAG_NAME, using = "table")
    private WebElement contactList;

    @FindBy(how = How.TAG_NAME, using = "button")
    private WebElement addContactBtn;

    public void accessHomePage(){
        log.info("Opening home page");
        getDriver().get(envConfig.getString("server.app.url"));
    }
    public String getContactListToText(){
        return contactList.getText();
    }

    public AddContactForm accessAddContactForm() {
        addContactBtn.click();
        return new AddContactForm();
    }
    public void listIsLoaded(){
        shortWaitForElement.until(ExpectedConditions.visibilityOf(contactList));
    }
    public boolean searchForTextInList(String text){
        return contactList.getText().contains(text);
    }
    public void addContactToTheList(String contactName, String telephoneNumber){
        this.accessHomePage();
        AddContactForm addContactForm = this.accessAddContactForm();
        addContactForm.fillContactForm(contactName, telephoneNumber);
        addContactForm.submit();
    }
}
