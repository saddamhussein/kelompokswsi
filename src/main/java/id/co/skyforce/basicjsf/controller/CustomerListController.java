package id.co.skyforce.basicjsf.controller;

import id.co.skyforce.basicjsf.HibernateUtil;
import id.co.skyforce.basicjsf.domain.Customer;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class CustomerListController {
	private List<Customer> customer;

	
	
	public CustomerListController() {
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		
		customer = session.createQuery("from Customer").list();
		
		
		trx.commit();
		session.close();
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}
	
}
