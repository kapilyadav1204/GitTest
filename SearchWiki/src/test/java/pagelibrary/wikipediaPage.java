package pagelibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import SearchWikipedia.TestBase;
import SearchWikipedia.Util;

public class wikipediaPage extends Util {

	WebDriver driver;

	TestBase testbase = new TestBase();

	public wikipediaPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	@FindBy(how = How.ID, using = "searchInput")
	@CacheLookup
	WebElement searchBox;

	@FindBy(how = How.ID, using = "searchButton")
	@CacheLookup
	WebElement searchButton;

	@FindBy(how = How.XPATH, using = ".//*[@id='p-logo']/a")
	@CacheLookup
	WebElement icon;

	@FindBy(how = How.ID, using = "firstHeading")
	WebElement firstHeading;

	@FindBy(how = How.XPATH, using = ".//*[@id='mw-content-text']/div/p[2]")
	WebElement noResultFound;

	public void checkIconOnPage() throws Exception {

		Util.highLightElement(driver, icon);
		icon.click();

	}

	public void searchWikipedia(String textInput) throws Exception {

		Util.highLightElement(driver, searchBox);
		searchBox.sendKeys(textInput);
		Util.highLightElement(driver, searchButton);
		searchButton.click();

	}

	public String returnNoResultFound() throws Exception {
		Util.highLightElement(driver, noResultFound);
		return noResultFound.getText().trim();
	}

	public String returnToHeadLine() throws Exception {
		Util.highLightElement(driver, firstHeading);
		return firstHeading.getText().trim();
	}

}
