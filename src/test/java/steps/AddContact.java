package steps;

import io.cucumber.java.en.*;

public class AddContact {
    @Given("I know someone named {string}")
    public void iKnowSomeoneNamed(String string) {
        //TODO
    }

    @Given("his telephone number is {string}")
    public void hisTelephoneNumberIs(String string) {
        //TODO
    }
    @When("I add him to the list")
    public void iAddHimToTheList() {
        //TODO
    }
    @Then("I get {string} listed on my contact list")
    public void iGetListedOnMyContactList(String string) {
        //TODO
    }
    @Given("I have a contact named {string}")
    public void iHaveAContactNamed(String string) {
        //TODO
    }
    @Then("I get message informing this user already exists")
    public void iGetMessageInformingThisUserAlreadyExists() {
        //TODO
    }
    @Given("I don't fill contact's name and phone number")
    public void iDonTFillContactSNameAndPhoneNumber() {
        //TODO
    }
    @Then("I get message informing the required fields")
    public void iGetMessageInformingTheRequiredFields() {
        //TODO
    }
    @Given("I enter a user with a phone number larger than {int} characters")
    public void iEnterAUserWithAPhoneNumberLargerThanCharacters(Integer int1) {
        //TODO
    }

    @Then("I get a message informing the phone is to long")
    public void iGetAMessageInformingThePhoneIsToLong() {
        //TODO
    }
    @Given("I enter a user with a phone number shorter than {int} characters")
    public void iEnterAUserWithAPhoneNumberShorterThanCharacters(Integer int1) {
        //TODO
    }
    @Then("I get a message informing the phone is to short")
    public void iGetAMessageInformingThePhoneIsToShort() {
        //TODO
    }
}
