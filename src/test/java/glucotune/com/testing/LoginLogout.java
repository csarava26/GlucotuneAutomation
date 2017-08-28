package glucotune.com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import glucotune.com.base.BaseTest;


public class LoginLogout  extends BaseTest {
			
	@Test(timeOut = 50000)
		  public void doLoginLogout() throws InterruptedException{
			
			openBrowser("chrome");
			NavigateSite(prop.getProperty("glucotuneurl"));
			PatLogin();	
			
			WebDriverWait wait=new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='logout']"))).click();
			
			Thread.sleep(5000);
			
			driver.close();
			driver.quit();
	}
}
