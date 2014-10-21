package id.co.skyforce.basicjsf.controller;

import id.co.skyforce.basicjsf.HibernateUtil;
import id.co.skyforce.basicjsf.domain.Category;
import id.co.skyforce.basicjsf.domain.Customer;
import id.co.skyforce.basicjsf.domain.Product;
import id.co.skyforce.basicjsf.domain.Supplier;

import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean(name="pc")
public class ProductController {

	private Long productId;
	private String name;
	private BigDecimal price;
	private Integer stock;
	private String description;
	private Long categoryId;
	private Long supplierId;
	

	
	public ProductController() {
		String idProduct = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("id");
		
		if(idProduct != null){
			productId = Long.valueOf(idProduct);
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			Product p = (Product) session.get(Product.class, productId);
			trx.commit();session.close();
			
			name = p.getName();
			price = p.getPrice();
			stock = p.getStock();
			description = p.getDescription();
			supplierId = p.getSupplier().getId();
			categoryId = p.getCategory().getId();
		}
	}
	
	public void save(){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		Category cat = (Category) session.get(Category.class, categoryId);
		Supplier sup = (Supplier) session.get(Supplier.class, supplierId);
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		p.setStock(stock);
		p.setDescription(description);
		p.setCategory(cat);
		p.setSupplier(sup);
		session.saveOrUpdate(p);
		trx.commit();
		session.close();
	}
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	
	
	
}
