/**
 * 
 */
package edu.ucsd.som.test.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Utility class to format BigDecimal values
 * 
 * @author somdev5
 *
 */
public class BigDecimalUtil {
	
	private static final String CURRENCY_FORMAT = "$###,###.##";
	
	private static final String RVU_FORMAT = "###,###";
	
	private static final String PERCENT_FORMAT = "###.##";
	
	private static final BigDecimal HUNDRED = BigDecimal.TEN.multiply(BigDecimal.TEN);

	/**
	 * Converts BigDecimal to Currency String
	 * 
	 * @param value
	 * @return
	 */
	public static final String toCurrencyString(BigDecimal value) {
		return new DecimalFormat(CURRENCY_FORMAT).format(value.doubleValue());
	}
	
	/**
	 * Converts a BigDecimal to RVU format
	 * 
	 * @param value
	 * @return
	 */
	public static final String toRVUString(BigDecimal value) {
		return new DecimalFormat(RVU_FORMAT).format(value.doubleValue());
	}
	
	/**
	 * Converts a BigDecimal to a Percent
	 * 
	 * @param value
	 * @return
	 */
	public static final String toPercentString(BigDecimal value) {
		return new DecimalFormat(PERCENT_FORMAT).format(value.doubleValue()) + "%";
	}
	
	/**
	 * Divides by 100 and adds one for easy percentage multiplication
	 * 
	 * @param percentage
	 * @return
	 */
	public static final BigDecimal toPercentProduct(BigDecimal percentage) {
		
		if (percentage.abs().compareTo(BigDecimal.ONE) >= 1) {
			return percentage.divide(HUNDRED).add(BigDecimal.ONE);
		}
		
		return percentage;
	}
	
	/**
	 * Convenience method used for comparisons
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static final boolean isEqual(BigDecimal d1, BigDecimal d2) {
		return (d1.setScale(2).compareTo(d2.setScale(2)) == 0);
	}
}
