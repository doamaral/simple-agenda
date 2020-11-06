package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.HomePage;
public class AddContact {

    HomePage homePage = new HomePage();
    Faker faker = new Faker();

    private String contactName = "";
    private String telephoneNumber = "";

    @Given("I know someone named {string}")
    public void iKnowSomeoneNamed(String contactName) {
        this.contactName = contactName;
    }

    @Given("his telephone number is {string}")
    public void hisTelephoneNumberIs(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @When("I add him to the list")
    public void iAddHimToTheList() {
        if(this.contactName.length() == 0){
            this.contactName = faker.name().fullName();
        }
        if(this.telephoneNumber.length() == 0){
            this.telephoneNumber = faker.phoneNumber().cellPhone();
        }
        homePage.addContactToTheList(this.contactName, this.telephoneNumber);
    }

    @Then("I get {string} listed on my contact list")
    public void iGetListedOnMyContactList(String text) {
        Assert.assertTrue(homePage.searchForTextInList(text));
    }

    @Given("I have a contact named {string}")
    public void iHaveAContactNamed(String contactName) {
        this.contactName = contactName;
        homePage.addContactToTheList(contactName, faker.phoneNumber().cellPhone());
    }
    @Then("I get message informing this user already exists")
    public void iGetMessageInformingThisUserAlreadyExists() {
        Assert.assertEquals(homePage.getAddContactForm().getPersonAlreadyExistsMsgTxt(), "Pessoa já existe.");
    }
    @Given("I don't fill contact's name and phone number")
    public void iDonTFillContactSNameAndPhoneNumber() {
        this.contactName = "";
        this.telephoneNumber = "";
    }

    @When("I try to add him to the list")
    public void iTryToAddHimToTheList() {
        homePage.addContactToTheList(this.contactName, this.telephoneNumber);
    }

    @Then("I get message informing the required fields")
    public void iGetMessageInformingTheRequiredFields() {
        Assert.assertFalse(homePage.getAddContactForm().confirmAddContactBtnIsEnabled());
        Assert.assertTrue(homePage.getAddContactForm().countRequiredFieldsAlertMsg().equals(2));
    }
    @Given("I enter a user with a phone number larger than {int} characters")
    public void iEnterAUserWithAPhoneNumberLargerThanCharacters(Integer maxSize) {
        this.telephoneNumber = faker.lorem().characters(maxSize+1,maxSize+3);
    }

    @Then("I get a message informing the phone is to long")
    public void iGetAMessageInformingThePhoneIsToLong() {
        Assert.assertTrue(homePage.getAddContactForm().countRequiredFieldsAlertMsg().equals(1));
    }
    @Given("I enter a user with a phone number shorter than {int} characters")
    public void iEnterAUserWithAPhoneNumberShorterThanCharacters(Integer minSize) {
        this.telephoneNumber = faker.lorem().characters(minSize-3,minSize-1);
    }
    @Then("I get a message informing the phone is to short")
    public void iGetAMessageInformingThePhoneIsToShort() {
        Assert.assertTrue(homePage.getAddContactForm().countRequiredFieldsAlertMsg().equals(1));
    }
}
