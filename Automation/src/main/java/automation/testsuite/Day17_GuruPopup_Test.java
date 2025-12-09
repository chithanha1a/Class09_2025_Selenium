package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.Day17_GuruPopup;

public class Day17_GuruPopup_Test extends CommonBase {
	
	@BeforeMethod
	@Parameters("browser")
	public void openWebPage(String browserSetup)
	{
		//driver=initFirefoxDriver(CT_PageURL.GURUPOPUP_URL);
		setupDriver(browserSetup);
		driver.get(CT_PageURL.CODESTART2_URL);
	}
	@Test
	public void getDetailAccess_Successfully()
	{
	    // 1. Find the first window (main, first)
	    String firstWindow = driver.getWindowHandle();
	    // Click button to open child windows
	    click(By.xpath("//a[text()='Click Here']"));
	    // Get child windows and process them on the page under test
	    Set<String> windows = driver.getWindowHandles();
	    for(String childWindow : windows)
	    {
	        if(!childWindow.equals(firstWindow))
	        {
	            driver.switchTo().window(childWindow);
	            Day17_GuruPopup guruPage = new Day17_GuruPopup(driver);
	            guruPage.getAccessDetails();
	            assertTrue(isDisplay_fluent(By.xpath("//h2[text()='Access details to demo site.']")));
	            driver.close(); // Close the child window after processing
	        }
	    }

	    // Go back to the first window to continue execution
	    driver.switchTo().window(firstWindow);
	    String actualUrl = driver.getCurrentUrl();
	    // Expected: https://demo.guru99.com/popup.php
	    assertEquals(actualUrl, "https://demo.guru99.com/popup.php");
	}

}
