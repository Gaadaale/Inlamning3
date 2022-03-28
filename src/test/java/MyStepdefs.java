import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyStepdefs {
    private String myemail, myusername, mypassword, mycheckbox;
    private WebDriver driver;

    @Given("I have written my email {string}")
    public void iHaveWrittenMyEmail(String email) {
        myemail = email;
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        sendKeys(driver, By.id("email"), email);


           }

    @Given("I have written my username {string}")
    public void iHaveWrittenMyUsername(String username) {
        myusername = username;
        if (username.equals("longname")) {
            for (int i = 0; i < 100; i++) {
                sendKeys(driver, By.id("new_username"), username);
            }
        } else if (username.equals("geeedi11@gmail.com")) {
            System.out.println("Användare är redan upptagen");
        } else if (username.equals("")) {
            System.out.println("Användare saknas");
        } else {
            sendKeys(driver, By.id("new_username"), username);

        }

    }
    @Given("I have written my password {string}")
    public void iHaveWrittenMyPassword(String password) {
        mypassword = password;
        scroll(driver);
        sendKeys(driver, By.id("new_password"), password);
    }

    @Given("I have written my checkbox {string}")
    public void iHaveWrittenMyCheckbox(String checkbox) {
        mycheckbox = checkbox;
        scroll(driver);
        sendKeys(driver, By.name("marketing_newsletter"), checkbox);
    }

    @When("I click the SingUp button")
    public void iClickTheSingUpButton() {

        scroll(driver);
        click(driver, By.id("create-account") );
    }

    @Then("the following error message is displayed")
    public void myContactInformationIsDisplayed() {
        String expected = "email:" + myemail + "\n" +
                "username:" + myusername + "\n" +
                "password:" + mypassword + "\n" +
                "checkbox:" + mycheckbox;

    }

    private String getText(WebDriver driver, By by) {
        WebDriverWait footbarr = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = footbarr.until(ExpectedConditions.presenceOfElementLocated(by));
        String text = element.getText();
        return text;
    }

    private static void scroll(WebDriver driver) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,200)");
    }

    private static void sendKeys(WebDriver driver, By by, String text) {
        WebDriverWait footbarr = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = footbarr.until(ExpectedConditions.presenceOfElementLocated(by));
        element.sendKeys(text);
    }

    private static void click(WebDriver driver, By by) {
        WebDriverWait footbar = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = footbar.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
    }

    @Then("the following error message is displayed {string}")
    public void theFollowingErrorMessageIsDisplayed(WebDriver driver, By by) {
        WebDriverWait footbar = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = footbar.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
        driver.quit();
    }

}