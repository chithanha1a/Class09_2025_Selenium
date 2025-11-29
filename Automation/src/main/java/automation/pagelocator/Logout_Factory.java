package automation.pagelocator;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout_Factory {
	private WebDriver driver;
	@FindBy(id="dropdownMenuLink") WebElement adminDropDown;
	@FindBy(xpath="//button[text()='Đăng xuất' and @type='button']") WebElement btnDangXuat;
	@FindBy(xpath="//button[text()='Đăng xuất' and @type='submit']") WebElement btnConfirmDangXuat;

	public Logout_Factory(WebDriver _driver) {
		
		this.driver = _driver;
		PageFactory.initElements(_driver, this);
	}
	
	public void LogoutFunction()
	{
		//D9oi cho toast massage Login thanh cong bien mat
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		adminDropDown.click();
		btnDangXuat.click();
		// Doi button Dang Xuat hien thi ra.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		btnConfirmDangXuat.click();
		
	}
}
