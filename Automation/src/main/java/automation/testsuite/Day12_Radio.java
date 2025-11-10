package automation.testsuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12_Radio extends CommonBase {
	
	@Test
	public void clickToRadio()
	{
		driver = initChromeDriver(CT_PageURL.DEMOQA_URL);
		// Kiem Tra gia tri mac dinh issSelected la false
		WebElement maleRadio =driver.findElement(By.id("gender-radio-1"));
		WebElement feMaleRadio =driver.findElement(By.id("gender-radio-2"));
		WebElement ortherRadio =driver.findElement(By.id("gender-radio-3"));
		
		Select dropdown1=new Select(driver.findElement(By.id("production")));
		
		 boolean male = maleRadio.isSelected();
	        // Mong đợi, xác nhận rằng male chưa được bấm = False
	     assertFalse(male);
	        // Mong đợi, xác nhận rằng Female chưa được bấm = False
	     assertFalse(feMaleRadio.isSelected());
	        // Mong đợi, xác nhận rằng Other chưa được bấm = False
	     assertFalse(ortherRadio.isSelected());

	     //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", feMaleRadio);
	        // Click Female
	     driver.findElement(By.xpath("//label[text()='Male']")).click();
	     assertTrue(maleRadio.isSelected());
	}
}
