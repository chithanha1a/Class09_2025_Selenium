package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day8_Bai1 extends CommonBase
{
	@Test
	public void getElementById()
	{
		
		driver=initWebDriver(CT_PageURL.Selector_URL);
		WebElement email=driver.findElement(By.name("email"));
		//WebElement email=driver.findElement(By.id("shub92"));
		System.out.println(" - Email element is: "+email);
		//WebElement pass=driver.findElement(By.name("Password"));
		WebElement pass=driver.findElement(By.id("pass"));
		System.out.println(" - Password element is: "+pass);
		WebElement company=driver.findElement(By.name("company"));
		System.out.println(" - Company element is: "+company);
		WebElement mobile=driver.findElement(By.name("mobile number"));
		System.out.println(" - Mobile Number element is: "+mobile);
		
		closeDriver();
	}
}
