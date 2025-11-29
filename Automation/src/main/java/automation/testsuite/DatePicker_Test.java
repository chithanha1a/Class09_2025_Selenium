package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class DatePicker_Test extends CommonBase {
	@BeforeMethod
	public void openWebPage()
	{
		driver=initChromeDriver(CT_PageURL.DEMO_GURU_URL);
	}
	@Test
    public void handleDatePicker() {
		//driver.findElement(By.name("bdaytime"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("document.getElementsByName('bdaytime')[0].value = '2025-01-11T01:01';");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    System.out.println("Thành công");
    }
}
