package SearchWikipedia;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Util {

	WebDriver driver;
	static Logger log = Logger.getLogger(Util.class.getName());

	public Util(WebDriver driver) {
		this.driver = driver;
	}

	public static void highLightElement(WebDriver driver, WebElement element) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].setAttribute('style', 'background:
		// yellow; border: 2px solid red;');", element);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		Thread.sleep(1000);
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}

	public static void highLightElement(WebDriver driver, By element) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		// js.executeScript("arguments[0].setAttribute('style', 'background:
		// blue; border: 2px solid red;');", element);
		Thread.sleep(1000);
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}

}
