package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchFlightPage {
    private WebDriver driver;
    private String extractedIdValue = ""; // Initialize the extractedIdValue variable


    public SearchFlightPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFlights(String source, String destination) {
        // Click on the 'Home' link
        WebElement homeLink = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
        homeLink.click();

        // Wait for source and destination fields to load
        waitForFieldsToLoad();

        // Find and fill in the source and destination fields
        WebElement sourceInput = driver.findElement(By.xpath("//select[@name='source']"));
        WebElement destinationInput = driver.findElement(By.xpath("//select[@name='destination']"));
        sourceInput.sendKeys(source);
        destinationInput.sendKeys(destination);

        // Click the 'Submit' button
        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        submitButton.click();
    }

    public boolean isBookFlightLinkVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement bookFlightLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Book Flight']")));

        return bookFlightLink.isDisplayed();
    }

    public void waitForFieldsToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait for source and destination fields to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='source']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='destination']")));
    }
    
    // Extract and return the ID value from the Book Flight link
    public String getExtractedIdValue() {
        WebElement bookFlightLinkCss = driver.findElement(By.cssSelector("a[href^='bookflight?id=']"));
        String hrefAttribute = bookFlightLinkCss.getAttribute("href");
        
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("id=(\\d+)");
        java.util.regex.Matcher matcher = pattern.matcher(hrefAttribute);
        
        if (matcher.find()) {
            extractedIdValue = matcher.group(1);
            System.out.println("The id value obtained from UI is: " + extractedIdValue);
        } else {
            System.out.println("Failed to retrieve the id value.");
        }
        
        return extractedIdValue;
    }
}










   