package rib.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CustomerAdvisorsPassword")
@Getter
@Setter
@NoArgsConstructor
public class CustomerAdvisorsPassword {
	@Id
	@Column(name = "No")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
	@Column(name="Password")
	private int password;
	
	@OneToOne(mappedBy = "customerAdvisorsPassword")
	private CustomerAdvisors customerAdvisors;

	public CustomerAdvisorsPassword(int no, int password, CustomerAdvisors customerAdvisors) {
		super();
		this.no = no;
		this.password = password;
		this.customerAdvisors = customerAdvisors;
	}
	
}
