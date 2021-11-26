import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class NewProductsStepDefs extends AbstractStepDefs{

    @When("the New Products link is clicked")
    public void theNewProductsLinkIsClicked() {
        homePage.getNewProductsLink().click();
    }

    @Then("a {string} new products error message is shown")
    public void aNewProductsErrorMessageIsShown(String arg0) {
        Optional<String> errorMessage = homePage.getNewProductsError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(arg0, errorMessage.get());
        } else {
            fail();
        }
    }
}
