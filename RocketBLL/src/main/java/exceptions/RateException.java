package exceptions;

import java.util.ArrayList;
import rocketDomain.RateDomainModel;
import rocketBase.RateDAL;


public class RateException extends Exception {

	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	
	private RateDomainModel rateDomainModel;
	
	public RateException(){
		System.out.println("Rate is invalid.");
	}
	public RateException(RateDomainModel rateDomainModel){
		ArrayList <RateDomainModel> iRates = new ArrayList <RateDomainModel> (RateDAL.getAllRates());
		if (!(iRates.contains(rateDomainModel.getdInterestRate()))) {
			System.out.println("Rate is invalid.");
		}
	}
	public RateDomainModel getRateDomainModel(){
		return rateDomainModel;
	}






}
