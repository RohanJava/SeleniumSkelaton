package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;




import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


public class base {

	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initialiseDriver() throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(".\\src\\main\\java\\resources\\InputData.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();	
		}
		else if (browserName.equals("firefox"))
		{
			
		}
		else if (browserName.equals("IE"))
		{
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://pic//"+result+"-screenshot.png"));

    }
	
}
