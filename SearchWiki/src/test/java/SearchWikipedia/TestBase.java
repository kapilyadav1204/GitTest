package SearchWikipedia;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

	public static Properties Repository = new Properties();
	public File f;
	public FileInputStream FI;
	public static WebDriver driver;
	public String startTime;
	public static int indexSI = 1;

	public void init() throws IOException {
		loadPropertiesFile();

		selectBrowser(Repository.getProperty("browser"));

		driver.get(Repository.getProperty("url"));

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void navigateBack() throws IOException {
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void loadPropertiesFile() throws IOException {
		f = new File(System.getProperty("user.dir") + "//src//test//java//config//config.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);

	}

	/**
	 * This method initialize browser object
	 * 
	 * @param browser
	 * @return browser driver
	 */
	public WebDriver selectBrowser(String browser) {
		if (browser.equals("firefox") || browser.equals("FIREFOX")) {
			System.setProperty("webdriver.gecko.drive",
					System.getProperty("user.dir") + "\\src\\test\\java\\BrowserDrivers\\geckodriver.exe");
			driver = (WebDriver) new FirefoxDriver();
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("marionette", true);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("");
			return driver;
		} else if (browser.equals("chrome") || browser.equals("CHROME")) {
			System.out.println("chrome browser");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\java\\BrowserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("marionette", true);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("ie") || browser.equals("IE")) {

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\java\\BrowserDrivers\\IEDriverServer.exe");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("marionette", true);
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		}

		else if (browser.equals("edge") || browser.equals("EDGE")) {

			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "\\src\\test\\java\\BrowserDrivers\\MicrosoftWebDriver.exe");
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("marionette", true);
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			return driver;
		}

		return null;
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.close();
		}

	}
}