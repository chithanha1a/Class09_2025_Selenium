package automation.common;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonBase {

    public WebDriver driver;

    // ========================
    // DRIVER SETUP
    // ========================
    public WebDriver setupDriver(String browserName) {

        switch (browserName.toLowerCase().trim()) {

        case "chrome":
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-gpu");

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            chromeOptions.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(chromeOptions);
            break;

        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addPreference("network.cookie.cookieBehavior", 0);
            firefoxOptions.addPreference("dom.webnotifications.enabled", false);
            driver = new FirefoxDriver(firefoxOptions);
            break;

        case "edge":
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            break;

        default:
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    // ========================
    // CLICK ACTION (CHROME/FIREFOX/EDGE STABLE)
    // ========================
    public void clicks(By locator) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        WebElement element = driver.findElement(locator);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            driver.findElement(locator).click();
        } catch (Exception ex) {

            // Remove overlay if exists
            try {
                ((JavascriptExecutor) driver).executeScript(
                        "document.querySelectorAll('*[style*=\"z-index\"]').forEach(e=>e.style.display='none');");
            } catch (Exception ignore) {}

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    driver.findElement(locator));
        }
    }

    // ========================
    // SCROLL TO ELEMENT
    // ========================
    public void scrollToElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        WebElement element = driver.findElement(locator);

        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        try {
            driver.findElement(locator);
        } catch (StaleElementReferenceException e) {
            driver.findElement(locator);
        }
    }

    // ========================
    // COMMON ACTIONS
    // ========================
    public void type(By locator, String value) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(value);
    }

    // ========================
    // QUIT DRIVER
    // ========================
    public void closeDriver() {
        if (driver != null) {
            driver.quit();  // FIX LỖI CHROME
        }
    }
    public static WebDriver initWebDriver(String URL) 
    { 
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe"); 
    	//FirefoxDriver driver = new FirefoxDriver(); 
    	ChromeDriver driver = new ChromeDriver();
    	driver.get(URL); driver.manage().window().maximize(); 
    	driver.manage().timeouts().pageLoadTimeout( Duration.ofSeconds(30)); 
    	return driver; 
} 
    public static WebDriver initFirefoxDriver(String URL) 
    {
    	FirefoxOptions options = new FirefoxOptions(); 
    	FirefoxProfile profile = new FirefoxProfile(); 
    	profile.setPreference("network.cookie.cookieBehavior", 0); 
    	options.setProfile(profile); System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe"); 
    	FirefoxDriver driver = new FirefoxDriver(); 
    	driver.get(URL); 
    	driver.manage().window().maximize(); driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50)); 
    	return driver; 
    } 
    public WebDriver initFirefoxDrivers(String URL) { 
    	FirefoxOptions options = new FirefoxOptions(); 
    	FirefoxProfile profile = new FirefoxProfile();
    	profile.setPreference("network.cookie.cookieBehavior", 0); // Tắt tracking protection và cookie warnings 
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
    	driver.get(URL); return driver; 
    	} 
    public WebDriver initChromeDriver(String URL) 
    {
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe"); 
    	ChromeOptions chromeOptions= new ChromeOptions(); 
    	Map<String, Object> chromePrefs = new HashMap<>(); 
    	chromePrefs.put("credentials_enable_service", false); // Disables the "save password" prompt 
    	chromePrefs.put("profile.password_manager_enabled", false); // Disables the password manager 
    	chromePrefs.put("profile.password_manager_leak_detection", false); // Disables the password leak detection warning 
    	chromeOptions.setExperimentalOption("prefs", chromePrefs); 
    	ChromeDriver driver = new ChromeDriver(); driver.get(URL); 
    	driver.manage().window().maximize(); 
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50)); 
    	return driver; 
    } 
    public WebDriver initChromeDrivers(String URL) 
    {
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe"); 
    	ChromeOptions chromeOptions= new ChromeOptions(); 
    	chromeOptions.addArguments("--allow-third-party-cookies"); 
    	Map<String, Object> chromePrefs = new HashMap<>(); 
    	chromePrefs.put("credentials_enable_service", false); // Disables the "save password" prompt 
    	chromePrefs.put("profile.password_manager_enabled", false); // Disables the password manager 
    	chromePrefs.put("profile.password_manager_leak_detection", false); // Disables the password leak detection warning 
    	chromeOptions.setExperimentalOption("prefs", chromePrefs); 
    	ChromeDriver driver = new ChromeDriver(); 
    	driver.get(URL); driver.manage().window().maximize(); 
    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50)); 
    	return driver; 
    	} // 1. Explicit wait 
    public WebElement findElement_Ex(By locator) 
    { 
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    	return driver.findElement(locator); 
    } // 2. Fluent wait 
    public WebElement findElement_fluent(By locator) 
    {
    	Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10));
    			// Maximum time to wait .pollingEvery(Duration.ofMillis(200)) 
    	// Interval between each poll .ignoring(NoSuchElementException.class); 
    	// Exceptions to ignore wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); 
    		return driver.findElement(locator); 
    	} 
    	// Wrap click method 
    public void click(By locator) 
    { 
    	WebElement element = findElement_fluent(locator); 
    	Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(15)) ;
    	// Maximum time to wait .pollingEvery(Duration.ofMillis(200))
    	// Interval between each poll .ignoring(NoSuchElementException.class); 
    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(locator)); 
    	element.click();
    	
    }
 // Wrap sendKeys method
     
    public void clickByJS(By locator) 
    { 
    	WebElement element = findElement_fluent(locator); 
    	JavascriptExecutor js = (JavascriptExecutor) driver; js.executeScript("arguments[0].click();", element); 
    } 
    public boolean isDisplay_fluent(By locator) 
    { 
    	try {
    		WebElement element = findElement_fluent(locator); 
    		return element.isDisplayed(); // true
    	} catch (NoSuchElementException ex1) 
    	{ 
    		return false; // mean element is not Display, error in findElement_fluent 
    	} catch (Exception ex) 
    	{ return false; } 
    }
    
    
}
