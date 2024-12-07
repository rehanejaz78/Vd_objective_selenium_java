package hcc.automation.testcomponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import hcc.automation.pageobjects.FDN;
import hcc.automation.utility.Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver driver;
    public FDN home;




    public WebDriver initializeDriver() {
        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : Utils.getElementFromPropertiesFile("browser", "global");

        if (browserName.contains("chrome")) {

//            WebDriverManager.chromedriver().browserVersion("131.0.6778.109").setup();
            WebDriverManager.chromedriver().clearResolutionCache().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().window().maximize();
            return driver;

//            System.setProperty("webdriver.chrome.driver", "chromedriver/chromedriver");
//            ChromeOptions options = new ChromeOptions();
//            options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome"); // Correct binary path
//            options.addArguments("--remote-allow-origins=*");
//            options.addArguments("--window-size=1920,1080"); // To prevent mobile-size window
//            driver = new ChromeDriver(options);



        } else if (browserName.equalsIgnoreCase("firefox")) {

            // Firefox
        } else if (browserName.equalsIgnoreCase("edge")) {
            // Edge

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;

    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }

    @BeforeTest(alwaysRun = true)
    public void launchApplication() {


        driver = initializeDriver();
        home = new FDN(driver);

    }
    public void getUrl(String url){
        driver.get(Utils.getElementFromPropertiesFile(url,"global"));
    }
    @AfterTest(alwaysRun = true)
    public void teardown() {

        driver.close();
    }
}
