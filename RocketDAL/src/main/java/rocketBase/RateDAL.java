package rocketBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import rocketDomain.RateDomainModel;
import util.HibernateUtil;

public class RateDAL {

	public static ArrayList<RateDomainModel> getAllRates()
	{		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		ArrayList<RateDomainModel> alRates = new ArrayList<RateDomainModel>();		
		
		try {
			tx = session.beginTransaction();	
			
			//TODO - RocketDALRateDAL.getAllRates
			
			String hql = ("from RateDomainModel TBLRATE ORDER BY TBLRATE.iMinCreditScore DESC");
			Query query = session.createQuery(hql);
			List results = query.list();
			
			List lRates = session.createQuery("FROM RateDomainModel").list();
			for (Iterator iterator = lRates.iterator(); iterator.hasNext();) {
				RateDomainModel rte = (RateDomainModel) iterator.next();
				alRates.add(rte);
			}
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return alRates;
	}

}