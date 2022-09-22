package com.ch.page.actions.web;

import static com.ch.reporter.ExtentReporter.info;
import static com.ch.utils.selenium.WebUtils.click;
import static com.ch.utils.selenium.WebUtils.waitForElementVisibility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ch.utils.selenium.WebUtils;

/**
 * This class contains all actions/operations that will be performed on Home
 * page in Desktop web view.
 * 
 * @author Jaikant
 *
 */
public class SearchResultsPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(SearchResultsPage.class);

	private WebDriver driver;

	@FindBy(how = How.CSS, using = "#search  div.s-result-list h2  a")
	List<WebElement> results;
	
	@FindBy(how = How.CSS, using = "#search  div.s-result-list h2  a")
	WebElement firstResult;

	@FindBy(how = How.ID, using = "a-autoid-0-announce")
	WebElement btn_sortBy;
	
	@FindBy(how = How.XPATH, using = "//a[.='Price: High to Low']")
	WebElement btn_highToLow;
	
	@FindBy(how = How.CSS, using = "#hmenu-content  ul.hmenu.hmenu-visible li a")
	List<WebElement> menuItems;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * It will sort the results by [Price: High to Low].
	 */
	public void sortByHighToLowPrice() {
		info("Sorting the results by [Price: High to Low]");
		waitForElementVisibility(btn_sortBy, 10);
		click(btn_sortBy);
		waitForElementVisibility(btn_highToLow, 10);
		click(btn_highToLow);
		waitForElementVisibility(firstResult, 10);

	}

	/**
	 * It will sort the results by [Price: High to Low].
	 */
	public void openResultedItemAndSwitchToIt(int itemIndex) {
		info("Opening the item on index" + itemIndex);
		waitForElementVisibility(results.get(itemIndex), 10);
		click(results.get(itemIndex));
		WebUtils.switchToNextTab();
	}

	
	
}
