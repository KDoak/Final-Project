package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score

	@Test
	public void PaymentGetterTester() {
		double EXPECTED = RateBLL.getPayment(4,30,300000,0,false);
		assertEquals("$1432.25",EXPECTED,1432.25);

}}
