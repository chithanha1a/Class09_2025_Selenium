package automation.testsuite;

import static org.testng.Assert.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.LoginPage_Factory;
import automation.pagelocator.Logout_Factory;

public class Day14_Test extends CommonBase{
	@BeforeMethod
	public void openWebPage()
	{
		driver = initFirefoxDriver(CT_PageURL.CRMSTAR_URL);
	}
	
	@Test
	public void loginSucessfully()
	{
		LoginPage_Factory login = new LoginPage_Factory(driver);
		login.LoginFunction("admin@gmail.com", "12345678");
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
	}
	@Test
	public void logoutSuccessfully()
	{
		loginSucessfully();
		Logout_Factory logout = new Logout_Factory(driver);
		logout.LogoutFunction();
		assertTrue(driver.findElement(By.xpath("//h4[text()='Đăng nhập']")).isDisplayed());
	}
	
	@AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
