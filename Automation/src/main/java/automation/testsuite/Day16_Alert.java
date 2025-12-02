package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day16_Alert extends CommonBase{
	
	@BeforeMethod
	public void openWebPage()
	{
		driver=initFirefoxDriver(CT_PageURL.GURU_URL);
		
	}
	@Test
	public void deleteCustSuccessfully()
	{
		type(By.name("cusid"), "123");
        click(By.name("submit"));

        // Alert 1: Confirm delete
        driver.switchTo().alert().accept();

        // Wait for Alert 2 to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        // Alert 2: Success message
        String actualMessage = driver.switchTo().alert().getText();
        assertEquals(actualMessage, "Customer Successfully Delete!");

        // Close Alert 2
        driver.switchTo().alert().accept();
	}
}
