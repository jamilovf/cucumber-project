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

    @Given("the contact us {string} is filled with {string}")
    public void theFirstFieldFieldIsFilledWithParameter(String field, String parameter) {
        homePage.fillField(field, parameter);
    }

    @When("the Send button is clicked")
    public void theSendButtonIsClicked() {
        homePage.getSendButton().click();
    }

    @Then("a {string} contact us error message is shown")
    public void aMsgContactUsErrorMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getContactError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }

}
