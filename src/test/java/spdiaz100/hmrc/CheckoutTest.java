package spdiaz100.hmrc;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class CheckoutTest {

	@Test
	public void withAnEmptyListOfItems_theTotalCost_isZero() {
		String[] listofItems = {};
		Checkout checkout = new Checkout();
		BigDecimal calculateTotalCost = checkout.calculateTotalCost(listofItems);
		assertEquals(BigDecimal.ZERO, calculateTotalCost);
	}

}
