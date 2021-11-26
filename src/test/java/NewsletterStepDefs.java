import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;
import java.util.Random;

import static org.junit.Assert.fail;

public class NewsletterStepDefs extends AbstractStepDefs{

    @Given("the newsletter {string} is filled with {string}")
    public void theNewsletterFieldIsFilledWithParameter(String field, String parameter) {
        homePage.fillField(field, parameter);
    }

    @When("the Newsletter button is clicked")
    public void theNewsletterButtonIsClicked() {
        homePage.getNewsletterButton().click();
    }

    @Then("the {string} newsletter error message is shown")
    public void theMsgNewsletterErrorMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getNewsletterError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }

    @Given("the newsletter {string} is filled with random {string}")
    public void theNewsletterNewsletterInputIsFilledWithRandomRandomEmail(String field, String parameter) {
        parameter = Util.getSaltString() + "@gmail.com";
        homePage.fillField(field, parameter);
    }

}
