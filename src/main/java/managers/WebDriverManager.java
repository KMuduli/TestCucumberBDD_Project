package managers;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {

	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static String url;

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}
	
	public String appURL() {
		url = FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
		return url;
		}


	private WebDriver createDriver() {
		   switch (environmentType) {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case REMOTE : driver = createRemoteDriver();
	        	break;
		   }
		   return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private WebDriver createLocalDriver()  {
        switch (driverType) {	    
        case FIREFOX : driver = new FirefoxDriver();
	    	break;
        case CHROME : 
        	ChromeOptions chromeOptions = new ChromeOptions();
    		io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
    		chromeOptions.addArguments("--remote-allow-origins=*");
    		driver = new ChromeDriver(chromeOptions);
    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    		driver.get(appURL());
    		driver.manage().window().maximize();
    		break;
        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
    		break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}

