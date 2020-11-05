package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.HomePage;

public class BasicSteps {
    HomePage homePage = new HomePage();
    @Given("I'm in the home page")
    public void iMInTheHomePage() {
        //homePage.accessHomePage();
    }

    @When("the list is loaded")
    public void theListIsLoaded() {
        //TODO
    }

    @Then("I get the list of my contacts")
    public void iGetTheListOfMyContacts() {
        //Arrange (Act)
        //String contacts = homePage.getContactListToText();

        //Assert
        //Assert.assertTrue(contacts.contains("Nome Telefone Apagar"));
    }
}
