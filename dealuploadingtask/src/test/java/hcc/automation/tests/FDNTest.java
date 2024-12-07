package hcc.automation.tests;

import hcc.automation.pageobjects.FDN;
import hcc.automation.testcomponents.Retry;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import hcc.automation.testcomponents.BaseTest;

public class FDNTest extends BaseTest {



    @BeforeClass
    public void urlAccess() {
        getUrl("task3_url");

    }

    @Test(retryAnalyzer = Retry.class)
    public void verify_invalid_Login() {

//        FDN home = new FDN(driver);
        home.login("valid_username", "invalid_password");
        home.verifyLogin();

    }

    @Test(retryAnalyzer = Retry.class)
    public void verify_valid_Login() {

//        FDN home = new FDN(driver);
        home.login("valid_username", "valid_password");

        home.verify_dashboard();

    }


}
