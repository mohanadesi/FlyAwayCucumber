package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utilities.DriverSetup;

public class MainExecution {
	private WebDriver driver;
	@BeforeClass
    public void setUp() {
        // Initialize WebDriver (you can use the common driver setup from previous examples)
        driver = DriverSetup.initializeWebDriver();
    }
	
	@AfterClass
    public void tearDown() {
        // Close the WebDriver
        if (driver != null) {
            driver.quit();
        }
	}

	 @Test
	    public void executeMain() {
	        // Create an instance of the LoginPage
	        LoginPage loginPage = new LoginPage(driver);

	        // Navigate to the Login Page
	        loginPage.navigateToLoginPage();

	        // Perform Login
	        loginPage.performLogin("desi@example.com", "desi");

	        WebElement HomeLink = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
	        HomeLink.click();
	     // Create an instance of the SearchFlightPage
	        SearchFlightPage searchFlightPage = new SearchFlightPage(driver);

	        // Wait for source and destination fields to load
	        searchFlightPage.waitForFieldsToLoad();

	        // Search for Flights
	        searchFlightPage.searchFlights("Bangalore", "Chennai");
        
	        // Extract and validate id with BookFlightPage
	        BookFlightPage bookFlightPage = new BookFlightPage(driver, searchFlightPage.getExtractedIdValue());

	        // Validate with the database
	        bookFlightPage.validateWithDatabase();

	        // Click on the "BookFlight" link
	        WebElement bookFlightLink = driver.findElement(By.cssSelector("a[href='bookflight?id=3']"));
	        bookFlightLink.click();
        
	     // Create an instance of the ConfirmBookingPage
	        ConfirmBookingPage confirmBookingPage = new ConfirmBookingPage(driver);

	        // Validate the text "FLYAWAY - PAYMENT GATEWAY"
	        confirmBookingPage.validateHeaderText();

	        // Click on the link "Click to complete booking"
	        confirmBookingPage.clickCompleteBookingLink();
        // Retrieve and print the text after booking
        String textAfterBooking = confirmBookingPage.retrieveTextAfterBooking();
        System.out.println("Text after booking: " + textAfterBooking);


	 }
    }


