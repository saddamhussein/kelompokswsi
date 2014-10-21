package id.co.skyforce.basicjsf;
import java.io.IOException;
import java.util.List;
import id.co.skyforce.basicjsf.domain.Customer;
import id.co.skyforce.basicjsf.domain.Address;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class ListCustomerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		Query query= session.createQuery("from Customer");
		//Query query2= session.createQuery("from Address");
		//List<Address> listAddress = query2.list();
		List<Customer> listCustomer = query.list();
		trx.commit();session.close();
		req.setAttribute("listCustomer", listCustomer);
		getServletContext().getRequestDispatcher("list_customer.jsp").forward(req, resp);
		
	}

}
