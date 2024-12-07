package hcc.automation.pageobjects;

import hcc.automation.abstractcomponent.AbstractComponent;
import hcc.automation.utility.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.util.logging.Logger;


public class FDN extends AbstractComponent {

    public WebDriver driver;

    private static final Logger LOGGER = Logger.getLogger(FDN.class.getName());


    String email;
    String password;


    @FindBy(id = "user-name")
    WebElement username_text_box;

    @FindBy(id = "password")
    WebElement pass;

    @FindBy(id = "login-button")
    WebElement btn_login;

    @FindBy(xpath = "//button[@class='error-button']")
    WebElement error;

    @FindBy(xpath = "//div[@class='app_logo']")
    WebElement dashboard;


    public FDN(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void login(String emailKey, String passwordKey) {
        email = Utils.getElementFromPropertiesFile(emailKey, "global");
        password = Utils.getElementFromPropertiesFile(passwordKey, "global");
        username_text_box.clear();
        username_text_box.sendKeys(email);
        pass.clear();
        pass.sendKeys(password);
        btn_login.click();
    }


    public void verifyLogin(){

        AssertJUnit.assertTrue(error.isDisplayed());
        LOGGER.info("Invalid username or password");
    }

    public void verify_dashboard(){
        AssertJUnit.assertTrue(dashboard.isDisplayed());
        LOGGER.info("Dashboard displaying --> " + dashboard.getText());
    }






}
