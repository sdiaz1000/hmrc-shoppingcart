package spdiaz100.hmrc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Checkout {

	private static final String ORANGE = "Orange";
	private static final String APPLE = "Apple";
	private static final double APPLE_PRICE = 0.60;
	private static final double ORANGE_PRICE = 0.25;

	public BigDecimal calculateTotalCost(String[] listofItems) {
		BigDecimal totalCost = BigDecimal.ZERO;
		if (listofItems != null) {
			BigDecimal total = calculateValueOfItems(listofItems);
			BigDecimal deductions = calculateTotalDeductions(listofItems);
			totalCost = total.subtract(deductions);
		}
		return totalCost.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	private BigDecimal calculateTotalDeductions(String[] listofItems) {
		BigDecimal bOGOFFApplesDeduction = calculateBOGOFFApplesDeduction(listofItems);
		BigDecimal threeFor2OrangeDeduction = calculate3For2OrangeDeduction(listofItems);
		BigDecimal totalDeductions = bOGOFFApplesDeduction.add(threeFor2OrangeDeduction);
		return totalDeductions.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal calculateValueOfItems(String[] listofItems) {
		BigDecimal totalCost = BigDecimal.ZERO;
		if (listofItems != null) {
			for (String item : listofItems) {

				switch (item) {
				case APPLE:
					totalCost = totalCost.add(BigDecimal.valueOf(APPLE_PRICE));
					break;
				case ORANGE:
					totalCost = totalCost.add(BigDecimal.valueOf(ORANGE_PRICE));
					break;
				default:
					totalCost = totalCost.add(BigDecimal.ZERO);
					break;
				}
			}
		}
		return totalCost;
	}

	public BigDecimal calculateBOGOFFApplesDeduction(String[] listofItems) {
		List<String> itemList = Arrays.asList(listofItems);  
		long apples = itemList.stream().filter(i -> i.equals(APPLE)).count();
		long validForOffer = apples / 2l; // rounds down using long
		BigDecimal deduction = BigDecimal.valueOf(APPLE_PRICE).multiply(BigDecimal.valueOf(validForOffer));
		return deduction.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal calculate3For2OrangeDeduction(String[] listofItems) {
		List<String> itemList = Arrays.asList(listofItems);  
		long apples = itemList.stream().filter(i -> i.equals(ORANGE)).count();
		long validForOffer = apples / 3l; // rounds down using long
		BigDecimal deduction = BigDecimal.valueOf(ORANGE_PRICE).multiply(BigDecimal.valueOf(validForOffer));
		return deduction.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
