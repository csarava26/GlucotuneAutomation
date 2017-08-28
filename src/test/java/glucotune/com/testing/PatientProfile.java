package glucotune.com.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import glucotune.com.base.BaseTest;

public class PatientProfile  extends BaseTest {
	
	
	@Test(timeOut = 50000)
	  public void doPatientProfile() throws InterruptedException{
		
		openBrowser("chrome");
		NavigateSite(prop.getProperty("glucotuneurl"));
		PatLogin();	
		
		WebDriverWait wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-localize='PATIENT.sidebar.nav.PROFILE']"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Street Address']"))).clear();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Street Address']"))).sendKeys("Test Automation_street");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='City']"))).clear();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='City']"))).sendKeys("Test Automation_City");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='col-xs-12 btn btn-primary' and @type = 'submit']"))).click();

		Thread.sleep(5000);
		driver.close();
		driver.quit();
}
}