package id.co.skyforce.basicjsf.controller;

import id.co.skyforce.basicjsf.HibernateUtil;
import id.co.skyforce.basicjsf.domain.Address;
import id.co.skyforce.basicjsf.domain.Customer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class CustomerController {

	public CustomerController() {
		String idCustomer = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("id");

		if(idCustomer!=null){
			customerId = Long.valueOf(idCustomer);
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			Customer cust = (Customer) session.get(Customer.class, customerId);

			email=cust.getEmail();
			password = cust.getPassword();
			salutation = cust.getSalutation();
			first_name = cust.getFirstName();
			last_name = cust.getLastName();
			gender = cust.getGender();
			birth_date = cust.getBirthDate();
			mobile_phone = cust.getMobileNo();
			home_phone = cust.getHomePhone();
			street = cust.getAddress().getStreet();
			city = cust.getAddress().getCity();
			postal_code = cust.getAddress().getPostalCode();

			trx.commit();
			session.close();
		}
	}

	private Long customerId;
	private Long addressId;
	private String email;
	private String password;
	private String salutation;
	private String first_name;
	private String last_name;
	private Character gender;
	private Date birth_date;
	private String mobile_phone;
	private String home_phone;
	private String street;
	private String city;
	private String postal_code;

	public void save(){

		if(customerId==0)customerId=null;
		if (addressId==0)addressId=null;
		
		Customer cust = new Customer();
		Address address = new Address();

		cust.setId(customerId);
		cust.setSalutation(salutation);
		cust.setFirstName(first_name);
		cust.setLastName(last_name);
		cust.setPassword(password);
		cust.setGender(gender);
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
		session.saveOrUpdate(cust);
		trx.commit();
		session.close();
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		try {
			
			externalContext.redirect("list.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getfirst_name() {
		return first_name;
	}
	public void setfirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getlast_name() {
		return last_name;
	}
	public void setlast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getbirth_date() {
		return birth_date;
	}
	public void setbirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public String getmobile_phone() {
		return mobile_phone;
	}
	public void setmobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}
	public String gethome_phone() {
		return home_phone;
	}
	public void sethome_phone(String home_phone) {
		this.home_phone = home_phone;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getpostal_code() {
		return postal_code;
	}
	public void setpostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	


}
