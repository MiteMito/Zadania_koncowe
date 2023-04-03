import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;

import java.io.File;


import java.io.IOException;
import java.time.Duration;

import static org.apache.commons.io.FileUtils.copyFile;
//import java.util.Scanner;


public class Zad2 {
    public static void main(String[] args) throws IOException {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver(options);
        // Maximize window
        driver.manage().window().maximize();

//         Navigate to the Login page
        driver.get("http://mystore-testlab.coderslab.pl/index.php");
//            Wait for the paige to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            Enter the username and password and click on the Login button
        WebElement element = driver.findElement(By.className("user-info"));
        element.click();
        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("rmswipkdczeksazbma@tcwlx.com");
        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("1qazxsw2");
        password.submit();
//             Navigate to the product page and select the product by clicking on it
        WebElement searchHummingbirdPrintedTshirt = driver.findElement(By.xpath("//*[@id=\"search_widget\"]/form/input[2]"));
        searchHummingbirdPrintedTshirt.click();
        searchHummingbirdPrintedTshirt.clear();
        searchHummingbirdPrintedTshirt.sendKeys("HUMMINGBIRD PRINTED T-SHIRT");
        searchHummingbirdPrintedTshirt.submit();
        WebElement hummingbirdPrintedTshirt = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a"));
        hummingbirdPrintedTshirt.click();
//            boolean save20 = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[2]")).isDisplayed();
//            Scanner sizeChoice = new Scanner(System.in);
//            System.out.println("Wybierz rozmiar /n S /n M /n L /n XL");
//            String rozmiar = sizeChoice.nextLine();
//            Adding product to cart
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
        addToCart.click();
//            Confirm product
        WebElement checkoutProduct = driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a"));
        checkoutProduct.click();
//            Check order
        WebElement chekoutProduct2 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"));
        chekoutProduct2.click();
//            Confirm address
        WebElement confirmAddress = driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button"));
        confirmAddress.click();
//            Add coment to order
        WebElement commentOrder = driver.findElement(By.xpath("//*[@id=\"delivery_message\"]"));
        commentOrder.clear();
        commentOrder.sendKeys("I would like to pick up an order in the store.");
        commentOrder.submit();
//            Confirm delivery
        WebElement confirmDelivery = driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button"));
        confirmDelivery.click();
//            Choice and confirm pay method
        WebElement payByCheck = driver.findElement(By.xpath("//*[@id=\"payment-option-1\"]"));
        payByCheck.click();
//            Agree terms confirm
        WebElement agreeTerms = driver.findElement(By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]"));
        agreeTerms.click();
        WebElement placeOrder = driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
        placeOrder.click();
//        Take a screenshot and save it to a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("C:\\screenshot\\pic1.png"));

//        Close the browser window
        driver.quit();


    }
}