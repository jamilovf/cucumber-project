import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class RegistrationStepDefs extends AbstractStepDefs{

    @Given("the registration {string} is filled with {string}")
    public void theRegistrationFieldIsFilledWithParameter(String field, String parameter) {
        homePage.fillField(field, parameter);
    }

    @When("the Register button is clicked")
    public void theRegisterButtonIsClicked() {
        homePage.getRegisterButton().click();
    }

    @Then("the {string} registration error message is shown")
    public void theMsgRegistrationErrorMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getRegistrationError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }
}
