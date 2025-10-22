package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day8_Locator extends CommonBase{
	@Test
	/*public void getElementById()
	{
		
		driver=initWebDriver(CT_PageURL.RISE_URL);
		WebElement email=driver.findElement(By.name("email"));
		System.out.println(" - Email element is: "+email);
		WebElement pass=driver.findElement(By.name("password"));
		System.out.println(" - Pass element is: "+pass);
		closeDriver();
	}
	public void getElemntByLinkText()
	{
		driver =initWebDriver(CT_PageURL.BEPANTOAN_URL);
		WebElement mayhutmui = driver.findElement(By.linkText("Máy Hút Mùi"));
		System.out.println(" - Link element is: "+mayhutmui);
		
		WebElement chauvoilink = driver.findElement(By.partialLinkText("Chậu Vòi"));
		System.out.println(" - Link element is: "+chauvoilink);
		
		WebElement tubep = driver.findElement(By.linkText("Tủ Bếp"));
		System.out.println(" - Link element is: "+tubep);
		closeDriver();
	}*/
	
	public void getElementByClass()
	{
		driver =initWebDriver(CT_PageURL.BEPANTOAN_URL);
		WebElement h1=driver.findElement(By.className("inline-block"));
		System.out.println(" - Link element is: "+h1);
		
		WebElement h3=driver.findElement(By.tagName("h3"));
		System.out.println(" - Link element is: "+h3);
		
		closeDriver();
	}
	
}
