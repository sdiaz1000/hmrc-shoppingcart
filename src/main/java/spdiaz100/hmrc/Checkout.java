package spdiaz100.hmrc;

import java.math.BigDecimal;

public class Checkout {

	public BigDecimal calculateTotalCost(String[] listofItems) {
		BigDecimal totalCost = BigDecimal.ZERO;
		if (listofItems != null) {
			for (String item : listofItems) {

				switch (item) {
				case "Apple":
					totalCost = totalCost.add(BigDecimal.valueOf(0.60));
					break;
				case "Orange":
					totalCost = totalCost.add(BigDecimal.valueOf(0.25));
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
		return BigDecimal.ZERO;
	}

	public BigDecimal calculate3For2OrangeDeduction(String[] listofItems) {
		return BigDecimal.ZERO;
	}
}
