package automation.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonBase {
	public static WebDriver driver;
	public WebDriver initWebDriver(String URL)	
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		//FirefoxDriver driver = new FirefoxDriver();
		ChromeDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		return driver;
	}
	
	public void closeDriver()
	{
		if(driver!=null)
		{
			driver.close();
		}
	}
	
}
