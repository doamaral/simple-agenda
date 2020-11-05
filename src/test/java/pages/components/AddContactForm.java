package pages.components;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AddContactForm extends BasePage {
    @FindBy(how = How.CSS, using = "input[placeholder='Nome'")
    private WebElement nomeTxt;

    @FindBy(how = How.CSS, using = "input[placeholder='Telefone'")
    private WebElement telefoneTxt;

    @FindBy(how = How.CSS, using = "div.modal-content div.modal-footer button.btn.btn-primary")
    private WebElement confirmAddContactBtn;

    @FindBy(how = How.CSS, using = "div.modal-content div.modal-footer button.btn.btn-success")
    private WebElement cancelAddContactBtn;

    @FindBy(how = How.XPATH, using = "//div[@class=\"modal-body\"]/span")
    private WebElement personAlreadyExistsMsg;

    @FindBy(how = How.CSS, using = "div.help-block")
    private List<WebElement> requiredFieldAlertsMsg;

    public void fillContactForm(String contactName, String cellPhone) {
        nomeTxt.sendKeys(contactName);
        telefoneTxt.sendKeys(cellPhone);
    }

    public String getPersonAlreadyExistsMsgTxt(){
        return personAlreadyExistsMsg.getText();
    }
    public Integer countRequiredFieldsAlertMsg(){
        return requiredFieldAlertsMsg.size();
    }
    public boolean confirmAddContactBtnIsEnabled(){
        return confirmAddContactBtn.isEnabled();
    }
    public void submit(){
        confirmAddContactBtn.click();
    }
}
