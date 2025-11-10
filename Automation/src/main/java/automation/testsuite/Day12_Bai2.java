package automation.testsuite;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12_Bai2 extends CommonBase{
	@Test
	public void ageRadio()
	{
		driver =initChromeDriver(CT_PageURL.SELENIUM_URL);
		WebElement underRadio= driver.findElement(By.id("under_18"));
		WebElement old18= driver.findElement(By.id("over_18"));		
		WebElement radioDisable= driver.findElement(By.id("radio-disabled"));
		//list Radio
		boolean under = underRadio.isSelected();
		 // Mong đợi, xác nhận rằng Under 18 chưa được bấm = False
	     assertFalse(under);
	        // Mong đợi, xác nhận rằng Older 18 chưa được bấm = False
	     assertFalse(old18.isSelected());
	        // Mong đợi, xác nhận rằng Other Disable chưa được bấm = False
	     assertFalse(radioDisable.isSelected());
	     // Click Female
	     driver.findElement(By.xpath("//label[text()='Under 18']")).click();
	     assertTrue(underRadio.isSelected());
	}

}
