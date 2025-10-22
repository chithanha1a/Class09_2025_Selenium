package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day8_Locator extends CommonBase{
	@Test
	public void getElementById()
	{
		
		driver=initWebDriver(CT_PageURL.RISE_URL);
		WebElement email=driver.findElement(By.id("email"));
		System.out.println(" - Email element is: "+email);
		WebElement pass=driver.findElement(By.id("password"));
		System.out.println(" - Pass element is: "+pass);
	}
}
