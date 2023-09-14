package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pages.BookFlightPage;
import pages.ConfirmBookingPage;
import pages.LoginPage;
import pages.SearchFlightPage;

public class FlyAwayStepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;
    private SearchFlightPage searchFlightPage;
    private BookFlightPage bookFlightPage;
    private ConfirmBookingPage confirmBookingPage;
    private String textAfterBooking;

    @Given("the user is on the Login page")
    public void userIsOnLoginPage() {
        // Initialize WebDriver (you can use your initialization logic here)
        // Example: driver = DriverSetup.initializeWebDriver();
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
    }

    @When("they enter valid credentials")
    public void userEntersValidCredentials() {
        loginPage.performLogin("desi@example.com", "desi");
    }

    @Then("they should be successfully logged in")
    public void userSuccessfullyLoggedIn() {
    	boolean isDashboardDisplayed = loginPage.isDashboardDisplayed();
        
        if (isDashboardDisplayed) {
            System.out.println("Login Successful. Dashboard is displayed.");
        } else {
            System.out.println("Login Failed. Dashboard is not displayed.");
        }
    }

    @Given("the user is on the Search Flight page")
    public void userIsOnSearchFlightPage() {
        searchFlightPage = new SearchFlightPage(driver);
        searchFlightPage.waitForFieldsToLoad();
    }

    @When("they enter {string} as the source and {string} as the destination")
    public void userSearchesForFlights(String source, String destination) {
        searchFlightPage.searchFlights(source, destination);
    }

    @Then("they should see the Book Flight link")
    public void userShouldSeeBookFlightLink() {
        boolean isBookFlightLinkVisible = searchFlightPage.isBookFlightLinkVisible();
        Assert.assertEquals("Book Flight link should be visible.", isBookFlightLinkVisible);
    }
    @Then("they should extract and store the ID value from the Book Flight link")
    public void userExtractsAndStoresIdValue() {
        String extractedIdValue = searchFlightPage.getExtractedIdValue();
        // You can store the extractedIdValue in a variable or context for later use.
    }

    // Step definitions for the missing scenarios

    @Given("the user is on the Book Flight page")
    public void userIsOnBookFlightPage() {
        // Implement logic to navigate to the Book Flight page
    }

    @When("they select a flight")
    public void userSelectsAFlight() {
        // Implement logic to select a flight
    }

    @Then("they should see flight details")
    public void userSeesFlightDetails() {
        // Implement assertions for flight details
    }

    @Given("the user is on the Confirm Booking page")
    public void userIsOnConfirmBookingPage() {
        // Implement logic to navigate to the Confirm Booking page
    }

    @When("they click on the {string} link")
    public void userClicksOnLink(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        link.click();
    }

    @Then("they should see a confirmation message")
    public void userSeesConfirmationMessage() {
        // Implement assertions for confirmation message
    }

    @And("they should see the text after booking")
    public void userSeesTextAfterBooking() {
        textAfterBooking = confirmBookingPage.retrieveTextAfterBooking();
        System.out.println("Text after booking: " + textAfterBooking);
    }
}
