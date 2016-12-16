package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

	// For some reason, the test classes aren't recognized by my complier,
	// though I have written out code regardless.
	
	
	//TODO - RocketDAL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketDAL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void IntrestRateTester() { //using examples given in SQL
		ArrayList<RateDomainModel> aRates = RateDAL.getAllRates();
		assertTrue(aRates.get(0).getdInterestRate() == 3.5 && aRates.get(0).getiMinCreditScore() == 800);
		assertTrue(aRates.get(1).getdInterestRate() == 3.75 && aRates.get(1).getiMinCreditScore() == 750);
		assertTrue(aRates.get(2).getdInterestRate() == 4 && aRates.get(2).getiMinCreditScore() == 700);
		assertTrue(aRates.get(3).getdInterestRate() == 4.5 && aRates.get(3).getiMinCreditScore() == 650);
		assertTrue(aRates.get(4).getdInterestRate() == 5 && aRates.get(4).getiMinCreditScore() == 600);
	}
		@Test
		public void RatesSizeTester(){
		ArrayList<RateDomainModel> aRates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + aRates.size());
		assert(aRates.size() > 0);
		
		
	}

}
