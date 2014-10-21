package id.co.skyforce.basicjsf;


import id.co.skyforce.basicjsf.domain.Address;
import id.co.skyforce.basicjsf.domain.Customer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import id.co.skyforce.basicjsf.HibernateUtil;;

public class CustomerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String submit_type= req.getParameter("action");

		if (submit_type.equals("create")){
			String first_name = req.getParameter("first_name");
			String last_name = req.getParameter("last_name");
			String password = req.getParameter("password");
			SimpleDateFormat formatter =  new SimpleDateFormat("dd-MM-yyyy");
			Date birth_date = null;
			try {
				birth_date = formatter.parse(req.getParameter("birth_date"));
			} catch (ParseException e) {
				e.printStackTrace();
				try {
					birth_date = formatter.parse("01-01-1991");
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			String mobile_phone = req.getParameter("mobile_phone");
			String home_phone = req.getParameter("home_phone");
			String email = req.getParameter("email");
			String city = req.getParameter("city");
			String street = req.getParameter("street");
			String postal_code = req.getParameter("postal_code");

			Customer cust = new Customer();
			Address address = new Address();
			cust.setFirstName(first_name);
			cust.setLastName(last_name);
			cust.setPassword(password);
			cust.setBirthDate(birth_date);
			cust.setMobileNo(mobile_phone);
			cust.setHomePhone(home_phone);
			cust.setEmail(email);
			address.setCity(city);
			address.setPostalCode(postal_code);
			address.setStreet(street);
			cust.setAddress(address);

			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			session.save(cust);;
			trx.commit();
			session.close();
			resp.sendRedirect("list_customer");
			//req.getRequestDispatcher("../success.jsp").forward(req, resp);
		}
		else if (submit_type.equals("update")){
			//String idCustomer = req.get
			String idCustomer = req.getParameter("customerId");
			long customerId = Long.parseLong((String) idCustomer);
			String first_name = req.getParameter("first_name");
			String last_name = req.getParameter("last_name");
			String password = req.getParameter("password");
			SimpleDateFormat formatter =  new SimpleDateFormat("dd-MM-yyyy");
			Date birth_date = null;
			try {
				birth_date = formatter.parse(req.getParameter("birth_date"));
			} catch (ParseException e) {
				e.printStackTrace();
				try {
					birth_date = formatter.parse("01-01-1991");
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
			String mobile_phone = req.getParameter("mobile_phone");
			String home_phone = req.getParameter("home_phone");
			String email = req.getParameter("email");
			String city = req.getParameter("city");
			String street = req.getParameter("street");
			String postal_code = req.getParameter("postal_code");

			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			Customer custEdit = (Customer) session.get(Customer.class, customerId);

			custEdit.setFirstName(first_name);
			custEdit.setLastName(last_name);
			custEdit.setPassword(password);
			custEdit.setBirthDate(birth_date);
			custEdit.setMobileNo(mobile_phone);
			custEdit.setHomePhone(home_phone);
			custEdit.setEmail(email);
			custEdit.getAddress().setCity(city);
			custEdit.getAddress().setPostalCode(postal_code);
			custEdit.getAddress().setStreet(street);

			session.save(custEdit);
			trx.commit();
			session.close();
			resp.sendRedirect("list_customer");
			//req.getRequestDispatcher("../success.jsp").forward(req, resp);
		}
		else if (submit_type.equals("delete")){
			String idCustomer = req.getParameter("customerId");
			long customerId = Long.valueOf(idCustomer);
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			Customer cust = (Customer) session.get(Customer.class, customerId);
			session.delete(cust);
			trx.commit();
			session.close();
			resp.sendRedirect("list_customer");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// list customer
		Session session = HibernateUtil.openSession();
		//Transaction trx = session.beginTransaction();
		Query query= session.createQuery("from Customer");
		List<Customer> listCustomer = query.list();
		req.setAttribute("listCustomer", listCustomer);
		RequestDispatcher rd = req.getRequestDispatcher("list_customer.jsp");
		rd.forward(req, resp);
		session.close();
	}

}
