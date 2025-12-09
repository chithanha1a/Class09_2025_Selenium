package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day18_BTVN01 extends CommonBase {

    @BeforeMethod
    @Parameters("browser")
    public void openWebPage(@Optional("firefox") String browserSetup) {
        setupDriver(browserSetup);
        driver.get(CT_PageURL.DMNKGR_URL);
    }

    @Test
    public void clickZalo() {
        
        clicks(By.xpath("//img[@alt='Zalo']"));
    }

    @AfterMethod
    public void closeBrowser() {
    	closeDriver();
    }
}

