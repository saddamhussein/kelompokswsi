package id.co.skyforce.basicjsf.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.Transaction;

import id.co.skyforce.basicjsf.HibernateUtil;
import id.co.skyforce.basicjsf.domain.*;

@ManagedBean
public class ProductListController {

	private List <Product> prd;

	public ProductListController() {
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		
		prd = session.createQuery("from Product").list();
		
		trx.commit();
		session.close();
	}

	public List<Product> getPrd() {
		return prd;
	}

	public void setPrd(List<Product> prd) {
		this.prd = prd;
	}
}
