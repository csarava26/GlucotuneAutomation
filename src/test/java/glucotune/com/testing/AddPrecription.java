package glucotune.com.testing;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import glucotune.com.base.BaseTest;

public class AddPrecription  extends BaseTest {
	
	
	@Test(timeOut = 50000)
	  public void doAddPrescription() throws InterruptedException{
		
		openBrowser("chrome");
		NavigateSite(prop.getProperty("glucotuneurl"));
		PatLogin();	
		
		WebDriverWait wait=new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-localize='PATIENT.sidebar.nav.PRESCRIPTION']"))).click();

		
		/*Select TypeDrop = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@data-name='Medication']"))));		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		TypeDrop.selectByIndex(1);*/
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@data-name='Potency value']"))).clear();
		Thread.sleep(200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@data-name='Potency value']"))).sendKeys("10");
		
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Min']"))).clear();
		Thread.sleep(200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Min']"))).sendKeys("1");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Max']"))).clear();
		Thread.sleep(200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@placeholder='Max']"))).sendKeys("10");


		Select MedicationTypeDrop = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@data-name='Time of day']"))));		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		MedicationTypeDrop.selectByIndex(1);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='app']/div/div/section/div[2]/div[2]/div/form/div/div/button"))).click();

		Thread.sleep(5000);
		driver.close();
		driver.quit();
}
}