package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Override
	public List<Customer> getCustomer() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}



	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
		
	}



	@Override
	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, theId);
		
		return customer;
	}



	@Override
	public void delete(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", theId);
		query.executeUpdate();
	}

}
