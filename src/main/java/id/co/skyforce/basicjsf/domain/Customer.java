package id.co.skyforce.basicjsf.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.collections.functors.FalsePredicate;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "password", length = 50, nullable = false)
	private String password;
	
	@Column(name="salutation")
	private String salutation;
	
	@Column(name = "first_name", length = 50, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;
	
	@Column(name = "birth_date", length = 50, nullable = false)
	private Date birthDate;
	
	
	
	@Column(name = "mobile_phone", length = 50, nullable = false)
	private String mobileNo;
	
	@Column(name = "home_phone", length = 50, nullable = false)
	private String homePhone;
	
	@Column(name="gender", nullable=false )
	private Character gender;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "address_id", unique = true)
	private Address address;
	
	@OneToMany
	@JoinColumn(name = "customer_id")
	private Set<Order> orders;
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
//		SimpleDateFormat formatter =  new SimpleDateFormat("dd-MM-yyyy");
//		birthDate = formatter.parse(arg0)
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", password="
				+ password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", birthDate=" + birthDate + ", mobileNo="
				+ mobileNo + ", homePhone=" + homePhone + ", address="
				+ address + "]";
	}

}
