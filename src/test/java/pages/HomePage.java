package pages;

import core.BasePage;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.components.AddContactForm;
import pages.components.Table;

import static core.DriverFactory.getDriver;

@Log4j
public class HomePage extends BasePage {

    private AddContactForm addContactForm = new AddContactForm();
    private Table contactList = new Table();

    @FindBy(how = How.TAG_NAME, using = "button")
    private WebElement addContactBtn;

    public AddContactForm getAddContactForm() {
        return addContactForm;
    }

    public Table getContactList() {
        return contactList;
    }

    public void accessHomePage(){
        log.info("Opening home page");
        getDriver().get(envConfig.getString("server.app.url"));
    }
    public String getContactListToText(){
        return contactList.getTableAsText();
    }

    public AddContactForm accessAddContactForm() {
        addContactBtn.click();
        return new AddContactForm();
    }
    public void listIsLoaded(){
        shortWaitForElement.until(ExpectedConditions.visibilityOf(contactList.getElement()));
    }
    public boolean searchForTextInList(String text){
        return contactList.getTableAsText().contains(text);
    }
    public void addContactToTheList(String contactName, String telephoneNumber){
        this.accessHomePage();
        addContactForm = this.accessAddContactForm();
        addContactForm.fillContactForm(contactName, telephoneNumber);
        addContactForm.submit();
    }
}
