package glucotune.com.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import glucotune.com.base.BaseTest;



public class AddGlucoseReading  extends BaseTest {
	
	
	
	@Test(timeOut = 50000)
	  public void doAddGlucoseReading() throws InterruptedException{
		
		openBrowser("chrome");
		NavigateSite(prop.getProperty("glucotuneurl"));
		PatLogin();	
		
		WebDriverWait wait=new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-localize='PATIENT.sidebar.nav.ADDGLUCOSE']"))).click();
		
		Select TypeDrop = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-name='Event type']"))));		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		TypeDrop.selectByIndex(1);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Enter Value']"))).sendKeys("100");;
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Select Date']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='app']/div/div/section/div[2]/div[2]/div/form/fieldset/div/div[3]/label"))).click();	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Select Time']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='app']/div/div/section/div[2]/div[2]/div/form/fieldset/div/div[4]/label"))).click();	

		Select InstrumentDrop = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Select Instrument']"))));		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		InstrumentDrop.selectByIndex(1);
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='col-xs-12 btn btn-primary' and @type = 'submit']"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@data-localize='PATIENT.sidebar.nav.GLUCOSEREADINGS']"))).click();

		Thread.sleep(5000);
		
		driver.close();
		driver.quit();
}
}  
	
	