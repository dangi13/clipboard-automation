package com.ch.page.actions.web;

import static com.ch.reporter.ExtentReporter.info;
import static com.ch.utils.selenium.WebUtils.click;
import static com.ch.utils.selenium.WebUtils.getAttribute;
import static com.ch.utils.selenium.WebUtils.jsClick;
import static com.ch.utils.selenium.WebUtils.retryingClick;
import static com.ch.utils.selenium.WebUtils.scrollingToElementofAPage;
import static com.ch.utils.selenium.WebUtils.waitForElementPresence;
import static com.ch.utils.selenium.WebUtils.waitForElementVisibility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ch.utils.selenium.WebUtils;

/**
 * This class contains all actions/operations that will be performed on Menu
 * page in Desktop web view.
 * 
 * @author Jaikant
 *
 */
public class MenuPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuPage.class);

	private WebDriver driver;

	@FindBy(how = How.ID, using = "nav-hamburger-menu")
	WebElement menuHamburger;

	@FindBy(how = How.CSS, using = "#hmenu-content")
	WebElement menuConetntSection;
	
	@FindBy(how = How.CSS, using = "#hmenu-content  ul.hmenu.hmenu-visible li a")
	List<WebElement> menuItems;
	
	@FindBy(how = How.CSS, using = ".acsUxWidget")
	List<WebElement> offerWidgets;

	public MenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * It will open the login page.
	 */
	public void openMenu() {
		info("Opening menu ...");
		waitForElementPresence("nav-hamburger-menu_id", 10);
		click(menuHamburger);
	}

	/**
	 * Its a dynamic method to open any menu item from amazon home page. Just give the name as you on the UI and it will open the section.
	 * @param itemName ex. [Best Sellers, TV, Appliances, Electronics, ....]
	 *                      The text that you see on the UI under menus.
	 */
	public void selectMenuItem(String itemName) {
		info("Opening menu item [" + itemName + "]....");

		waitForElementVisibility(menuConetntSection, 10);
		for (WebElement item :menuItems) {
			if (getAttribute(item, "innerText").equals(itemName)) {
				scrollingToElementofAPage(item);
				retryingClick(item);
				break;
			}
		}
		
	}

	/**	
	 * It will filter the item based on the section you provide.
	 * @param section any section present in Bold in menu [Brands, Resolution,...]
	 * @param itemName filter values like, Samsung, LG etc
	 */
	public void filterBySectionAndItem(String section, String itemName) {
			
			info("Filtering [" + section + "] [" + itemName + "]");
			String commonFilterLocator = "//span[.='" + section+ "']/parent::div/following-sibling::ul/li/span//span[.='" + itemName + "']/parent::a//input";
			WebUtils.waitForElementPresence(commonFilterLocator + "_xpath", 10);;
			WebElement itemTofilter = driver.findElement(By.xpath(commonFilterLocator));
			scrollingToElementofAPage(itemTofilter);
			jsClick(itemTofilter);
			if (offerWidgets.size() > 0){
				jsClick(itemTofilter);
			}
		
		// Note We could have easily done it just by clicking Samsung filter.
		// But since there can be many filters going ahead.Just creating a generic method for all sections.
	}
}
