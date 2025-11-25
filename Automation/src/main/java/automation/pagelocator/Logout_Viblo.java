package automation.pagelocator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout_Viblo {
	private WebDriver driver;

	@FindBy(css = "img.el-popover__reference")	WebElement avatar;
	@FindBy(css = "a[href*='logout']") 	WebElement btnDangXuat;
	    
	public Logout_Viblo(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void LogoutFunction()
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // CLICK Avatar (đúng thẻ)
	    WebElement avatar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img.el-popover__reference")));
	    js.executeScript("arguments[0].click();", avatar);

	    // CLICK Logout
	    WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable( By.cssSelector("a[href*='logout']") ));
	    js.executeScript("arguments[0].click();", logoutBtn);

	}
}
