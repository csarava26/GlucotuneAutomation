package glucotune.com.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import glucotune.com.base.BaseTest;

	public class EditGlucoseReading  extends BaseTest {
		
		
		
		@Test(timeOut = 50000)
		  public void doAddGlucoseReading() throws InterruptedException{
			
			openBrowser("chrome");
			NavigateSite(prop.getProperty("glucotuneurl"));
			PatLogin();	
			
			WebDriverWait wait=new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-localize='PATIENT.sidebar.nav.GLUCOSEREADINGS']"))).click();
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='table-responsive']/table/tbody/tr[1]/td[5]"))).click();
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Glucose']"))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Glucose']"))).sendKeys("300");;
					
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='btn btn-primary' and @type = 'button']"))).click();

			Thread.sleep(5000);
			
			driver.close();
			driver.quit();
	}
	}  

