package automation.testsuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class practiceXpathDay8  extends CommonBase{
	
	@Test
	public void getElementById()
	{
		
		driver=initWebDriver(CT_PageURL.GITHUB_URL);
		WebElement name=driver.findElement(By.id("name"));		
		System.out.println(" - Email element is: "+name);
		WebElement address=driver.findElement(By.name("address"));		
		System.out.println(" - Address element is: "+address);
		WebElement email=driver.findElement(By.id("email"));
		System.out.println(" - Pass element is: "+email);
		WebElement pass=driver.findElement(By.name("password"));
		System.out.println(" - Pass element is: "+pass);
				
		closeDriver();
	}
}
