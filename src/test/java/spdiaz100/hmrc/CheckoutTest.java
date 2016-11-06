package spdiaz100.hmrc;

import static org.junit.Assert.assertEquals;

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
	
	@Test
	public void withAListContainingOneApple_theTotalCost_is60p(){
		String[] listofItems = {"Apple"};
		Checkout checkout = new Checkout();
		BigDecimal calculateTotalCost = checkout.calculateTotalCost(listofItems);
		assertEquals(BigDecimal.valueOf(0.60), calculateTotalCost);
	}
	
	@Test
	public void withAListContainingOneOrange_theTotalCost_is25p(){
		String[] listofItems = {"Orange"};
		Checkout checkout = new Checkout();
		BigDecimal calculateTotalCost = checkout.calculateTotalCost(listofItems);
		assertEquals(BigDecimal.valueOf(0.25), calculateTotalCost);
	}
	
	@Test
	public void withAListContainingUnknownItem_theTotalCost_isZero(){
		String[] listofItems = {"Appange"};
		Checkout checkout = new Checkout();
		BigDecimal calculateTotalCost = checkout.calculateTotalCost(listofItems);
		assertEquals(BigDecimal.ZERO, calculateTotalCost);
	}
	

}
