package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ConfirmBookingPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ConfirmBookingPage(WebDriver driver) {
        this.driver = driver;
    }

    // Validate the text "FLYAWAY - PAYMENT GATEWAY" with XPath
    public boolean validateHeaderText() {
        WebElement headerElement = driver.findElement(By.xpath("//h3[normalize-space()='FLYAWAY - PAYMENT GATEWAY']"));
        
        //return headerElement.isDisplayed();
        boolean isHeaderTextValid = headerElement.isDisplayed();
        if (isHeaderTextValid) {
            System.out.println("Header text validation passed.(FLYAWAY - PAYMENT GATEWAY)");
        } else {
            System.out.println("Header text validation failed.");
        }
        return isHeaderTextValid;
    }

    // Click on the link "Click to complete booking" with XPath
    public void clickCompleteBookingLink() {
        WebElement completeBookingLink = driver.findElement(By.xpath("//a[normalize-space()='Click to complete booking']"));
        completeBookingLink.click();
    }
    // Retrieve text with XPath //body/br[1]
    public String retrieveTextAfterBooking() {
    	
    	// Find the element containing the desired text
    	WebElement textElement = driver.findElement(By.xpath("//body"));

    	// Retrieve and print the text
    	String pageText = textElement.getText();
    	
		return pageText;
}
 
  
    }
    

