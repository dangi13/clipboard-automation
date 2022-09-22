package com.ch.page.validators.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ch.utils.common.CustomAssertion;

/** This class contains all validations related to Product Info Page.
 * 
 * @author Jaikant
 *
 */
public class ProductInfoValidator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductInfoValidator.class);

	public static void validateAboutThisSection(boolean actual, boolean expected) {
		CustomAssertion.assertEquals(actual, expected, "Error while asserting [About this item] label");
	}


}
