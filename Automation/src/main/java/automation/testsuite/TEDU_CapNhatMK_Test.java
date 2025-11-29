package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.TEDU_CapNhatMK_Page;

public class TEDU_CapNhatMK_Test extends CommonBase{
	@BeforeMethod
	public void openWebPage()
	{
		driver=initChromeDriver(CT_PageURL.TEDU_URL);
		
	}
	
	
	public void loginSucessfully()
	{
		TEDU_CapNhatMK_Page tedu = new TEDU_CapNhatMK_Page(driver);
		WebElement btnLater = driver.findElement(By.id("onesignal-slidedown-cancel-button"));
		btnLater.click();
		tedu.loginFunction("huuphuc310511@gmail.com", "Micky@4473");
		WebElement avatar = driver.findElement(By.xpath("//a[@title='Tài khoản' and @data-toggle='dropdown']"));
		assertTrue(avatar.isDisplayed());
	}
	@Test
	public void UpdatePasswordSuccessFul()
	{
		loginSucessfully();
		//driver.switchTo().alert().accept();
		TEDU_CapNhatMK_Page tedu = new TEDU_CapNhatMK_Page(driver);
		tedu.changePassword("Micky@4473", "Micky@4473");
		WebElement avatar = driver.findElement(By.xpath("//h2[text()='Đăng nhập']"));
		assertTrue(avatar.isDisplayed());
	}
}
