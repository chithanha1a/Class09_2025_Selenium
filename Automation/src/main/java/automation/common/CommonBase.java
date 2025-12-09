package automation.common;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonBase {
	public static WebDriver driver;
	Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout( Duration.ofSeconds(30))
	        //.withTimeout(Duration.ofSeconds(30)) // Maximum time to wait
	        .pollingEvery(Duration.ofMillis(500)) // Interval between each poll
	        .ignoring(NoSuchElementException.class); // Exceptions to ignore
	public static WebDriver initWebDriver(String URL)	
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		//FirefoxDriver driver = new FirefoxDriver();
		ChromeDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds(30));
		return driver;
	}
	
	public static WebDriver initFirefoxDriver(String URL) {
		FirefoxOptions options = new FirefoxOptions();
	    FirefoxProfile profile = new FirefoxProfile();
	    profile.setPreference("network.cookie.cookieBehavior", 0);
	    options.setProfile(profile);
		System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		return driver;
	}
	
	public WebDriver initFirefoxDrivers(String URL) {
	    FirefoxOptions options = new FirefoxOptions();
	    FirefoxProfile profile = new FirefoxProfile();
	    profile.setPreference("network.cookie.cookieBehavior", 0);
	    // Tắt tracking protection và cookie warnings
	    profile.setPreference("privacy.trackingprotection.enabled", false);
	    profile.setPreference("privacy.trackingprotection.pbmode.enabled", false);
	    profile.setPreference("network.cookie.cookieBehavior", 0);
	    profile.setPreference("network.cookie.lifetimePolicy", 0);
	    profile.setPreference("dom.webnotifications.enabled", false);
	    profile.setPreference("dom.push.enabled", false);
	    
	    options.setProfile(profile);
	    
	    WebDriver driver = new FirefoxDriver(options);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get(URL);
	    
	    return driver;
	}
	
	public WebDriver initChromeDriver(String URL) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		ChromeOptions chromeOptions= new ChromeOptions();
		Map<String, Object> chromePrefs = new HashMap<>();
	    chromePrefs.put("credentials_enable_service", false); // Disables the "save password" prompt
	    chromePrefs.put("profile.password_manager_enabled", false); // Disables the password manager
	    chromePrefs.put("profile.password_manager_leak_detection", false); // Disables the password leak detection warning
	    chromeOptions.setExperimentalOption("prefs", chromePrefs);
		ChromeDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		return driver;
	}
	
	
	public WebDriver initChromeDrivers(String URL) {		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.addArguments("--allow-third-party-cookies");
		
		Map<String, Object> chromePrefs = new HashMap<>();
	    chromePrefs.put("credentials_enable_service", false); // Disables the "save password" prompt
	    chromePrefs.put("profile.password_manager_enabled", false); // Disables the password manager
	    chromePrefs.put("profile.password_manager_leak_detection", false); // Disables the password leak detection warning
	    chromeOptions.setExperimentalOption("prefs", chromePrefs);
		ChromeDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		return driver;
	}
	// 1. Explicit wait
		public WebElement findElement_Ex(By locator) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return driver.findElement(locator);
		}

		// 2. Fluent wait
		public WebElement findElement_fluent(By locator) {
			Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)) // Maximum time to wait
					.pollingEvery(Duration.ofMillis(200)) // Interval between each poll
					.ignoring(NoSuchElementException.class);
			// Exceptions to ignore
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return driver.findElement(locator);
		}

		// Wrap click method
		public void click(By locator) {
			WebElement element = findElement_fluent(locator);
			Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15)) // Maximum time to wait
					.pollingEvery(Duration.ofMillis(200)) // Interval between each poll
					.ignoring(NoSuchElementException.class);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
		}
		
		public void click2(By locator) {
		    Wait<WebDriver> wait = new FluentWait<>(driver)
		        .withTimeout(Duration.ofSeconds(15))
		        .pollingEvery(Duration.ofMillis(200))
		        .ignoring(NoSuchElementException.class)
		        .ignoring(StaleElementReferenceException.class);

		    WebElement element = wait.until(driver -> driver.findElement(locator));
		    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		}
		
		public void clicks(By locator) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		    WebElement element = wait.until(
		        ExpectedConditions.presenceOfElementLocated(locator)
		    );

		    ((JavascriptExecutor) driver).executeScript(
		        "arguments[0].scrollIntoView({block:'center'});", element
		    );

		    try {
		        wait.until(ExpectedConditions.elementToBeClickable(locator));
		        element.click();
		    } catch (Exception e) {
		        // Fallback dùng JavaScript click
		        ((JavascriptExecutor) driver)
		            .executeScript("arguments[0].click();", element);
		    }
		}



		// Wrap sendKeys method
		public void type(By locator, String value) {
			WebElement element = findElement_fluent(locator);
			element.clear();
			element.sendKeys(value);
		}

		// Click by javascript
		public void clickByJS(By locator) {
			WebElement element = findElement_fluent(locator);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}

		public boolean isDisplay_fluent(By locator) {
			try {
				WebElement element = findElement_fluent(locator);
				return element.isDisplayed(); // true
			} catch (NoSuchElementException ex1) {
				return false; // mean element is not Display, error in findElement_fluent
			} catch (Exception ex) {
				return false;
			}
		}
		//Scroll to element
		public void scrollToElement (By locator)
		{
			WebElement element = findElement_fluent(locator);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}

		public void closeDriver() {
			if (driver != null)
				driver.close();
		}
		
		public WebDriver initFirefoxDriver() {

	        System.setProperty("webdriver.firefox.driver",System.getProperty("user.dir") + "\\\\driver\\\\geckodriver.exe");
	        FirefoxDriver driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	        
	        return driver;
	    }
		
		private WebDriver initChromeDriver() {
	        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\\\driver\\\\chromedriver.exe");
	        ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.addArguments("--allow-third-party-cookies");
	        Map<String, Object> chromePrefs = new HashMap<>();
	        chromePrefs.put("credentials_enable_service", false); 
	        chromePrefs.put("profile.password_manager_enabled", false); 
	        chromePrefs.put("profile.password_manager_leak_detection", false); 
	        chromeOptions.setExperimentalOption("prefs", chromePrefs);
	        
	        ChromeDriver driver = new ChromeDriver(chromeOptions);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	        return driver;
	    }
		
		public WebDriver initMSEdgeDriver() {

	        System.setProperty("webdriver.edge.driver",  System.getProperty("user.dir") + "\\\\driver\\\\msedgedriver.exe"); 

	        WebDriver driver = new EdgeDriver(); 

	        driver.manage().window().maximize();
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));	        
        
	        return driver;
	    }
		
		public WebDriver setupDriver(String browserName) {
	        switch (browserName.trim().toLowerCase()) {
	            case "chrome":
	            	//System.out.println("Initialing chorme driver....");
	                driver = initChromeDriver(); // Gọi hàm initChrome không tham số
	                break;
	            case "firefox":
	            	//System.out.println("Initialing firefox driver....");
	                driver = initFirefoxDriver(); // Gọi hàm initFirefox không tham số (thiếu trong ảnh gốc)
	                break;
	            case "edge":
	            	//System.out.println("Initialing edge driver....");
	                driver = initMSEdgeDriver();
	                break;
	            default:
	                System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
	                driver = initChromeDriver();
	        }
	        return driver;
	    }
		public void quitDriver()
		{
			closeDriver();
		}
}
