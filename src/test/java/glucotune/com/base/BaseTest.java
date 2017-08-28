package glucotune.com.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class BaseTest{
	
	public WebDriver driver;
	public Properties prop;
	
	
	
	public void openBrowser(String BType){
		

		
		if (prop==null){			 
			 try {
				 File src =new File("./src/test/java/glucotune/com/resources/projectconfig.properties");			 
				FileInputStream fs = new FileInputStream(src);
				prop=new Properties();
				System.out.println(fs);
				prop.load(fs);
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 

		if (BType == "chrome"){
		ChromeDriverManager.getInstance().setup();
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--start-maximized");

		 Map<String, Object> prefs = new HashMap<String, Object>();
		 prefs.put("credentials_enable_service", false);
		 prefs.put("profile.password_manager_enabled", false);
		 options.setExperimentalOption("prefs", prefs);

		 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		 capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		 driver = new ChromeDriver(capabilities);
		 
		
		}
	}
	
	public void NavigateSite(String url){
		driver.get(url);	
	}
	

	public void DocLogin(){
		WebDriverWait wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='exampleInputEmail1']"))).sendKeys(prop.getProperty("glucotuneuser"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='exampleInputPassword1']"))).sendKeys(prop.getProperty("glucotunepwd"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div/div/div/div[2]/form[1]/button"))).click();
	}
	
	public void PatLogin(){
		WebDriverWait wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='exampleInputEmail1']"))).sendKeys(prop.getProperty("glucotuneparuser"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='exampleInputPassword1']"))).sendKeys(prop.getProperty("glucotuneparpwd"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div/div/div/div[2]/form[1]/button"))).click();
	}
	
	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

}
}