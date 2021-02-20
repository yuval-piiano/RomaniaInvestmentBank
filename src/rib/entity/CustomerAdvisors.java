package rib.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Hibernate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Customer_Advisors")
@Getter
@Setter
@NoArgsConstructor
public class CustomerAdvisors{
	@Id
	@Column(name = "No")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "CNP")
	private String cnp;

	@Column(name = "PhoneNumber")
	private String phoneNumber;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "customerAdvisors")
	private List<Client> client;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private BankAgency bankAgency;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Address address;

	public CustomerAdvisors(String firstName, String lastName, String cnp, Address address, String phoneNumber,
			BankAgency bankAgency) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.cnp = cnp;
		this.phoneNumber = phoneNumber;
		this.bankAgency = bankAgency;
		this.address = address;
	}

	@Override
	public String toString() {
		String finalString;
		finalString = "\nCustomer advisor " + id + "\nName: " + firstName + " " + lastName + "\nCNP: " + cnp
				+ super.toString() + "\nPhone number: " + phoneNumber;
		if (Hibernate.isInitialized(this.bankAgency) && this.bankAgency != null) {
			finalString += "\nId: ";
			finalString += this.bankAgency.getId();
			finalString += "\n";
		}
		if (Hibernate.isInitialized(this.address) && this.address != null)
			finalString += this.address;
//		else
//			finalString += "\n";
		return finalString;
	}

}

