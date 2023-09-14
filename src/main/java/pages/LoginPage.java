package pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        // Navigate to the login page
        driver.get("http://localhost:8081/FlyAway/login");
    }

    public void performLogin(String email, String password) {
        // Find and fill in the email and password fields
        WebElement emailInput = driver.findElement(By.xpath("//input[@name='email_id']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='pwd']"));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();
    }
        
        public boolean isDashboardDisplayed() {
        // Wait for the dashboard to be visible
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement flyawayDashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='FLYAWAY - DASHBOARD']")));

        // Verify if the header text matches the expected value
        String expectedHeaderText = "FLYAWAY - DASHBOARD";
        String actualHeaderText = flyawayDashboardHeader.getText();

        return actualHeaderText.equals(expectedHeaderText);
        
    }
    
}
