import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class CartStepDefs extends AbstractStepDefs{

    @When("the Cart link is clicked")
    public void theCartLinkIsClicked() {
        homePage.getCartLink().click();
    }

    @Then("a {string} cart error message is shown")
    public void aCartErrorMessageIsShown(String arg0) {
        Optional<String> errorMessage = homePage.getCartError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(arg0, errorMessage.get());
        } else {
            fail();
        }
    }

}
