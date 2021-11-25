import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class CreateAnAccountStepDefs extends AbstractStepDefs{

    @Given("the create an account {string} is filled with {string}")
    public void theCreateAnAccountFieldIsFilledWithParameter(String field, String parameter) {
        homePage.fillField(field, parameter);
    }

    @When("the Create an account button is clicked")
    public void theCreateAnAccountButtonIsClicked() {
        homePage.getCreateAnAccountButton().click();
    }

    @Then("the {string} create an account error message is shown")
    public void theMsgCreateAnAccountErrorMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getCreateAnAccountError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }
}
