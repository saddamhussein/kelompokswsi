package id.co.skyforce.basicjsf.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class FreelanceEmployee extends Employee {

	@Column(name="rate_per_hour")
	private BigDecimal rate_per_hour;

	public BigDecimal getRate_per_hour() {
		return rate_per_hour;
	}

	public void setRate_per_hour(BigDecimal rate_per_hour) {
		this.rate_per_hour = rate_per_hour;
	}

	
}
