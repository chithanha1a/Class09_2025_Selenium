package automation.testsuite;

import java.time.Duration;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pagelocator.Login_Viblo;
import automation.pagelocator.Logout_Viblo;

public class Day14_BTVN extends CommonBase {
	@BeforeMethod
	public void openWebPage()
	{
		driver = initFirefoxDriver(CT_PageURL.VIBLO_URL);
	}

	public void LoginAccountSuccessFully()
	{
		Login_Viblo login = new Login_Viblo(driver);
		//login.CreateAccount("HPhuc", "huuphuc310511@gmail.com", "huuphuc310511", "Micky@4473");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		login.LoginFunction("huuphuc310511@gmail.com", "Micky@4473");
		
	}
	
	@Test
	public void LogoutAccountSuccesFully()
	{
		LoginAccountSuccessFully();
		Logout_Viblo logout = new Logout_Viblo(driver);
		logout.LogoutFunction();
	}
}
