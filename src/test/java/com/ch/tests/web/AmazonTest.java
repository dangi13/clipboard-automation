package com.ch.tests.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ch.core.BaseConfiguration;
import com.ch.listeners.CustomReporter;
import com.ch.page.actions.web.MenuPage;
import com.ch.page.actions.web.ProductPage;
import com.ch.page.actions.web.SearchResultsPage;
import com.ch.page.validators.web.ProductInfoValidator;

public class AmazonTest extends BaseConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(AmazonTest.class);

	private MenuPage menupage;
	private SearchResultsPage searchResultsPage;
	private ProductPage productPage;

	@BeforeClass
	public void setUp() {
		menupage = new MenuPage(driver);
		searchResultsPage = new SearchResultsPage(driver);
		productPage = new ProductPage(driver);
	}

	@Test(testName = "TC_01", description = "[AMAZON] Test about this section of a product")
	public void test_abount_this_item_section() {
		menupage.openMenu();
		menupage.selectMenuItem("TV, Appliances, Electronics");
		menupage.selectMenuItem("Televisions");
		menupage.filterBySectionAndItem("Brands", "Samsung");
		searchResultsPage.sortByHighToLowPrice();
		searchResultsPage.openResultedItemAndSwitchToIt(1);
		ProductInfoValidator.validateAboutThisSection(productPage.isAboutThisItemSectionPresent(), true);
		productPage.printProductContent();
	}

}
