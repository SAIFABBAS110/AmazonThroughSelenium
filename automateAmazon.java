package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Set;

public class automateAmazon {

        public static void main(String[] args) throws InterruptedException {
                
            // Set the path to ChromeDriver
            WebDriverManager.chromedriver().setup();

            // Create a new instance of ChromeDriver
            WebDriver driver = new ChromeDriver();

            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to Amazon.in
            driver.get("https://www.amazon.in");

            // Locate the SignIn button and click it
            WebElement signInButton = driver.findElement(By.id("nav-link-accountList"));
            signInButton.click();

            // Enter email or phone number in the login field
            WebElement emailField = driver.findElement(By.id("ap_email"));
            emailField.sendKeys("saifabbas110@gmail.com");

            // Click on the Continue button
            WebElement continueButton = driver.findElement(By.id("continue"));
            continueButton.click();

            // Enter password
            WebElement passwordField = driver.findElement(By.id("ap_password"));
            passwordField.sendKeys("yahussain110");

            // Click on the SignIn button
            WebElement signInSubmitButton = driver.findElement(By.id("signInSubmit"));
            signInSubmitButton.click();

            // Search for shoes
            Thread.sleep(5000);
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("shoes");

            // Click on the search button
            Thread.sleep(2000);
            WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
            searchButton.click();

            // Click on the first search result
            Thread.sleep(2000);
            WebElement firstSearchResult = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div[2]/div[2]/h2/a/span"));
            firstSearchResult.click();

            // Handling Multple Windows
            Set<String> s = driver.getWindowHandles ();
            ArrayList ar = new ArrayList(s);
            System.out.println(ar.get(0));
            System.out.println(ar.get(1));
            driver.switchTo() .window ((String)ar.get(1));

            // Add the item to the cart
            Thread.sleep(2000);
            WebElement addToCartButton = driver.findElement(By.xpath("//input[@id = 'add-to-cart-button']"));
            addToCartButton.click();

            // Proceed to checkout
            Thread.sleep(2000);
            WebElement proceedToBuy = driver.findElement(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span"));
            proceedToBuy.click();

            // Proceed to Address
            Thread.sleep(2000);
            WebElement addAddress = driver.findElement(By.xpath("//span[@id = 'orderSummaryPrimaryActionBtn']"));
            addAddress.click();

            //Proceed to Payment
            // Thread.sleep(2000);
            // WebElement paymentMethod = driver.findElement(By.xpath("//*[@id=\"orderSummaryPrimaryActionBtn\"]/span/input"));
            // paymentMethod.click();

            // Close the browser
            driver.quit();
        }
    }


