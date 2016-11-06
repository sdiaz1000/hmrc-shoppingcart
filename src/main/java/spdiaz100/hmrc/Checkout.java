package spdiaz100.hmrc;

import java.math.BigDecimal;

public class Checkout {

	public BigDecimal calculateTotalCost(String[] listofItems) {
		BigDecimal totalCost = BigDecimal.ZERO;
		if (listofItems != null && listofItems.length > 0) {
			switch (listofItems[0]) {
			case "Apple":
				totalCost = BigDecimal.valueOf(0.60);
				break;
			case "Orange":
				totalCost = BigDecimal.valueOf(0.25);
				break;
			default:
				totalCost = BigDecimal.ZERO;
				break;
			}
		}
		return totalCost;
	}
}
