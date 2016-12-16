package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException
	{
		//TODO - RocketBLL RateBLL.getRate - make sure you throw any exception
		
		ArrayList <RateDomainModel> aRates = new ArrayList <RateDomainModel> (RateDAL.getAllRates());
		double finishediRate = 0;
		for(RateDomainModel Rate : aRates) {
			if(GivenCreditScore == Rate.getiMinCreditScore()) {
				finishediRate = Rate.getdInterestRate();
			}
			else if (aRates.contains(Rate.getdInterestRate())){
				//If rate is matching pre-existing rate, keep calm and carry on
				continue;	
			}
			else { //If rate does not match with anything provided, throw the exception we wrote out.
				throw new RateException();
			}
		}
		
		//TODO - RocketBLL RateBLL.getRate
		return finishediRate;
		
		
	}
	
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
