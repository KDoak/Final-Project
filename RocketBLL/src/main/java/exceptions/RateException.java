package exceptions;

import java.util.ArrayList;
import rocketDomain.RateDomainModel;
import rocketBase.RateDAL;


public class RateException extends Exception {

	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	
	private RateDomainModel rateDomainModel;
	
	public RateException(){
		System.out.println("Loan cannot go through.");
	}
	public RateException(RateDomainModel rateDomainModel){
		this.rateDomainModel = rateDomainModel;
		}
	
	public RateDomainModel getRateDomainModel(){
		return rateDomainModel;
	}






}
