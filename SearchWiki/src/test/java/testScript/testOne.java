package testScript;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import SearchWikipedia.TestBase;
import pagelibrary.wikipediaPage;

/**
 * @author kapil.yadav
 *
 */
public class testOne extends TestBase {
	wikipediaPage wikipediaPage;

	// test case will be enter "India" and check headline should be displayed as
	// "India or not"

	@Test
	public void verifySearchIsWorking() throws Exception {
		init();
		wikipediaPage = PageFactory.initElements(driver, wikipediaPage.class);
		wikipediaPage.checkIconOnPage();
		wikipediaPage.searchWikipedia("india");

		assertEquals(wikipediaPage.returnToHeadLine(), "India");// title
																// should
																// be
																// india

	}

	// test case will be enter "India" and check headline should be displayed as
	// "India or not"
	@Test
	public void verifySearchIsWorkingAndTilteNotMatch() throws Exception {
		init();
		wikipediaPage = PageFactory.initElements(driver, wikipediaPage.class);
		wikipediaPage.checkIconOnPage();
		wikipediaPage.searchWikipedia("india");
		assertEquals(wikipediaPage.returnToHeadLine(), "intensely not matching headline and failed test case");// Negative
		// Test
		// Case
		// title
		// should
		// not
		// match

	}

	// Type something which not match with result"
	@Test
	public void verifyNoResultsMatchingTheQuery() throws Exception {
		init();
		wikipediaPage = PageFactory.initElements(driver, wikipediaPage.class);
		wikipediaPage.checkIconOnPage();
		wikipediaPage.searchWikipedia("xxxxxxxxxxxxXno result foundXxxxxxxxxxx");// type
		// something
		// which not
		// match
		// with
		// result

		assertEquals(wikipediaPage.returnNoResultFound(), "There were no results matching the query.");// Negative
																										// Test
																										// Case
																										// title
																										// should
																										// not
																										// match

	}

	@AfterTest
	public void closeBrowser1() {
		closeBrowser();

	}

	@AfterMethod(alwaysRun = true)
	public void afterTestMethod() {
		closeBrowser();

	}

	@AfterSuite(alwaysRun = true)
	public void afterTestSuite() {
		closeBrowser();

	}

}
