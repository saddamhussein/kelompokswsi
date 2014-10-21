package id.co.skyforce.basicjsf.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("T")
public class PartTimeEmployee extends Employee {

	@Column(name="work_hour")
	private int work_hour;

	public int getWork_hour() {
		return work_hour;
	}

	public void setWork_hour(int work_hour) {
		this.work_hour = work_hour;
	}
	
	
}
