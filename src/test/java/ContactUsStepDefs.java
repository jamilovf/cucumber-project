import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class ContactUsStepDefs extends AbstractStepDefs {

    @And("the Contact Us link is clicked")
    public void theContactUsLinkIsClicked() {
        homePage.getContactUsLink().click();
    }

    @When("the Send button is clicked")
    public void theSendButtonIsClicked() {
        homePage.getSendButton().click();
    }

    @Then("a {string} error message is shown")
    public void aErrorMessageIsShown(String arg0) {
        Optional<String> errorMessage = homePage.getContactError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(arg0, errorMessage.get());
        } else {
            fail();
        }
    }

    @Given("the email address is filled with {string}")
    public void theEmailAddressIsFilledWith(String arg0) {
        homePage.fillField("email", arg0);
    }

    @And("the order reference is filled with {string}")
    public void theOrderReferenceIsFilledWith(String arg0) {
        homePage.fillField("id_order", arg0);
    }

    @And("the message is filled with {string}")
    public void theMessageIsFilledWith(String arg0) {
        homePage.fillField("message", arg0);
    }
}
