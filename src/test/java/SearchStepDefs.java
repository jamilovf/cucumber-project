import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class SearchStepDefs extends AbstractStepDefs {

    @Given("the search {string} is filled with {string}")
    public void theSearchFieldIsFilledWithParameter(String field, String parameter) {
        homePage.fillField(field, parameter);
    }

    @When("the Search button is clicked")
    public void theCartLinkIsClicked() {
        homePage.getSearchButton().click();
    }

    @Then("a {string} search error message is shown")
    public void aMsgSearchErrorMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getSearchError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }

    @Then("a {string} search result message is shown")
    public void aResultHasBeenFoundSearchResultMessageIsShown(String result) {
        Optional<String> errorMessage = homePage.getSearchResult();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(result, errorMessage.get());
        } else {
            fail();
        }
    }
}


