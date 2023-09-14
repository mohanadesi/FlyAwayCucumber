package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookFlightPage {
    private WebDriver driver;
    private String extractedIdValue;

    public BookFlightPage(WebDriver driver, String extractedIdValue) {
        this.driver = driver;
        this.extractedIdValue = extractedIdValue;
    }

    public void validateAndPrintId() {
        // Get the href attribute of the link
        WebElement bookFlightLinkcss = driver.findElement(By.cssSelector("a[href^='bookflight?id=']"));
        String hrefAttribute = bookFlightLinkcss.getAttribute("href");

        // Extract the 'id' value using regular expressions
        Pattern pattern = Pattern.compile("id=(\\d+)");
        Matcher matcher = pattern.matcher(hrefAttribute);

        if (matcher.find()) {
            String extractedIdValue = matcher.group(1);
            System.out.println("The id value obtained from UI is: " + extractedIdValue);
        } else {
            System.out.println("Failed to retrieve the id value.");
        }
    }

    public void validateWithDatabase() {
        // Database connection information
        String jdbcUrl = "jdbc:mysql://localhost:3306/flyaway";
        String dbUser = "root";
        String dbPassword = "";

        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            Statement statement = connection.createStatement();

            // Execute a query to retrieve the 'id' value from the 'f_flights' table
            String query = "SELECT id FROM f_flights WHERE id = " + extractedIdValue;
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                String dbIdValue = resultSet.getString("id");
                System.out.println("The id value obtained from the database is: " + dbIdValue);

                // Compare the extracted 'id' value with the database 'id' value
                if (extractedIdValue.equals(dbIdValue)) {
                    System.out.println("Validation successful. UI and database 'id' values match.");
                } else {
                    System.out.println("Validation failed. UI and database 'id' values do not match.");
                }
            } else {
                System.out.println("No matching record found in the database.");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

