package glucotune.com.testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import glucotune.com.base.BaseTest;

public class AddMedication  extends BaseTest {
	
	
	@Test(timeOut = 50000)
	  public void doAddMedication() throws InterruptedException{
		
		openBrowser("chrome");
		NavigateSite(prop.getProperty("glucotuneurl"));
		PatLogin();	
		
		WebDriverWait wait=new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-localize='PATIENT.sidebar.nav.ADDMEDICATION']"))).click();
		
		Select TypeDrop = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Select Event Type']"))));		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		TypeDrop.selectByIndex(1);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Select Date']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='app']/div/div/section/div[2]/div[2]/div/form/fieldset/div[1]/div[2]/label"))).click();	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Select Time']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='app']/div/div/section/div[2]/div[2]/div/form/fieldset/div[1]/div[3]/label"))).click();	

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='btn-block btn btn-primary' and @type = 'button']"))).click();

		Select MedicationTypeDrop = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Select Medication']"))));		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		MedicationTypeDrop.selectByIndex(1);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Enter Insulin/Medication Value']"))).sendKeys("10");;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='col-xs-12 btn btn-primary' and @type = 'submit']"))).click();
		Thread.sleep(100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-localize='PATIENT.sidebar.nav.MEDICATIONSREADINGS']"))).click();

		Thread.sleep(5000);
		driver.close();
		driver.quit();
		
}
}

