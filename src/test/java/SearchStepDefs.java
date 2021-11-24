import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class SearchStepDefs extends AbstractStepDefs{
    @When("the Search button is clicked")
    public void theCartLinkIsClicked() {
        homePage.getSearchButton().click();
    }

    @Then("a {string} search error message is shown")
    public void aSearchErrorMessageIsShown(String arg0) {
        Optional<String> errorMessage = homePage.getSearchError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(arg0, errorMessage.get());
        } else {
            fail();
        }
    }
}
