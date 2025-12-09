package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day18_BTVN02 extends CommonBase {

    @BeforeMethod
    @Parameters("browser")
    public void openWebPage(@Optional("firefox") String browserSetup) {
        setupDriver(browserSetup);
        driver.get(CT_PageURL.BEPANTOAN_URL);
    }

    @Test
    public void clickChat() {
        By chatBtn = By.xpath("//span[text()='Chat với chúng tôi']");
        By titleDanhMuc = By.xpath("//h3[text()='Danh mục nổi bật']");

        // Scroll đến phần Danh mục nổi bật
        scrollToElement(titleDanhMuc);

 
        clicks(chatBtn);
    }

    @AfterMethod
    public void closeBrowser() {
    	closeDriver();
    }
}
