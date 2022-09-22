package com.ch.page.actions.web;

import static com.ch.reporter.ExtentReporter.info;
import static com.ch.utils.common.Constants.INNER_TEXT;
import static com.ch.utils.selenium.WebUtils.getAttribute;
import static com.ch.utils.selenium.WebUtils.scrollingToElementofAPage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class contains all actions/operations that will be performed on the product page that you have opened in new window.
 * 
 * @author Jaikant
 *
 */
public class ProductPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductPage.class);

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//h1[.=' About this item ']")
	List<WebElement> label_aboutThisItem;
	
	@FindBy(how = How.XPATH, using = "//h1[.=' About this item ']/parent::div")
	WebElement aboutThisItemContent;
	
	@FindBy(how = How.CSS, using = "#hmenu-content  ul.hmenu.hmenu-visible li a")
	List<WebElement> menuItems;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * We check if the about section is present where we have the product description with details.
	 */
	public boolean isAboutThisItemSectionPresent() {
		info("Checking if [About this item] section is present");
		
		return label_aboutThisItem.size() > 0;
	}

	public void printProductContent() {
		info("Logging Product description");
		scrollingToElementofAPage(aboutThisItemContent);
		info(getAttribute(aboutThisItemContent, INNER_TEXT));
	}

	
	
}
