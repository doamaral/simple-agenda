package pages;

import core.BasePage;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static core.DriverFactory.getDriver;

@Log4j
public class HomePage extends BasePage {

    @FindBy(how = How.TAG_NAME, using = "table")
    private WebElement contactList;

    public void accessHomePage(){
        log.info("Opening home page");
        getDriver().get(envConfig.getString("server.app.url"));
    }
    public String getContactListToText(){
        return contactList.getText();
    }
}
