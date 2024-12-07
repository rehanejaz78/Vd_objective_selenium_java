package hcc.automation.abstractcomponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.SkipException;

// This page is to store all the methods and variables that are to be repeatedly used in the program
// common headers are also to be placed here.

public class AbstractComponent {

    WebDriver driver;


    JavascriptExecutor javaScriptExecutor;


    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        javaScriptExecutor = (JavascriptExecutor) driver;

    }



    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement clickSearchBtn;





    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractComponent.class);


    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(32));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitForWebElementToAppear(WebElement findBy, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitForWebElementToClickable(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }

    public void waitForWebElementToClickable(WebElement findBy, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }







    public void scrollToElement(WebElement webElement) {
        waitForWebElementToAppear(webElement);
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }



    public void clickOnFilterSearchBtn() {
        waitForWebElementToAppear(clickSearchBtn);
        clickSearchBtn.click();
    }











}
