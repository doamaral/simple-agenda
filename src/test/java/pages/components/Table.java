package pages.components;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Table extends BasePage {

    @FindBy(how = How.TAG_NAME, using = "table")
    private WebElement contactList;

    public String getTableAsText(){
        return contactList.getText();
    }

    public WebElement getElement() {
        return this.contactList;
    }
}
