package automation.testsuite;

import org.openqa.selenium.By;

//import static org.testng.Assert.assertFalse;
import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day18_Checkbox extends CommonBase {
	
	/*@Test
	public void checkboxHandle()
	{
		driver =initChromeDriver(CT_PageURL.DEMOQA_URL);
		// Case 1: Kiem tra gia tri mac dinh ( Theo yeu cau REQ), vd: Vao trang web thi cac checkbox chua dc check.
		WebElement sportCheckbox= driver.findElement(By.id("hobbies-checkbox-1"));
		WebElement readCheckbox= driver.findElement(By.id("hobbies-checkbox-2"));		
		WebElement musicCheckbox= driver.findElement(By.id("hobbies-checkbox-3"));
		// Mong doi ca 3 checkbox deu chua check (Theo REQ)
		boolean checkSport=sportCheckbox.isSelected();
		boolean checkReading=readCheckbox.isSelected();
		boolean checkMusic=musicCheckbox.isSelected();
		//kiem tra check.
		assertFalse(checkSport);
		assertFalse(checkReading);
		assertFalse(checkMusic);
		
	}*/
	@Test
	public void clickToCheck()
	{
		driver =initChromeDriver(CT_PageURL.DEMOQA_URL);
		WebElement sportCheckbox= driver.findElement(By.id("hobbies-checkbox-1"));
		WebElement readCheckbox= driver.findElement(By.id("hobbies-checkbox-2"));		
		WebElement musicCheckbox= driver.findElement(By.id("hobbies-checkbox-3"));
//		/((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sportCheckbox);
		List<WebElement> listCheckbox=driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));
		for (WebElement webElement : listCheckbox) {
	        if (webElement.isSelected() == false) {
	            webElement.click();
	            System.out.println(" WebElement: "+webElement);
	            //assertTrue(webElement.isSelected());
	        }
	    }
		assertTrue(sportCheckbox.isSelected());
		assertTrue(readCheckbox.isSelected());
		assertTrue(musicCheckbox.isSelected());
		/*if(sportCheckbox.isSelected()==false)
		{
			driver.findElement(By.xpath("//label[text()='Sports']")).click();
			//sportCheckbox.click();
			assertTrue(sportCheckbox.isSelected());
			
		}
		if(readCheckbox.isSelected()==false)
		{
			driver.findElement(By.xpath("//label[text()='Reading']")).click();
			//readCheckbox.click();
			assertTrue(readCheckbox.isSelected());
			
		}
		if(musicCheckbox.isSelected()==false)
		{
			driver.findElement(By.xpath("//label[text()='Music']")).click();
			//musicCheckbox.click();
			assertTrue(musicCheckbox.isSelected());
			
		}*/
		closeDriver();
	}
}
