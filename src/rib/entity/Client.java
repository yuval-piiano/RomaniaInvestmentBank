package rib.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Hibernate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Client")
@Getter
@Setter
@NoArgsConstructor
public class Client {
	@Id
	@Column(name = "No")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;

	@Column(name = "ID")
	private String id;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "CNP")
	private long cnp;

	@Column(name = "Email")
	private String email;

	@Column(name = "PhoneNumber")
	private String phoneNumber;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private BankAccount bankAccount;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Address_No")
	private Address address;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private CustomerAdvisors customerAdvisors;

	public Client(String id, String firstName, String lastName, long cnp, String email, Address address,
			String phoneNumber, CustomerAdvisors customerAdvisors, BankAccount bankAccount) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cnp = cnp;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.customerAdvisors = customerAdvisors;
		this.bankAccount=bankAccount;
		this.address = address;
	}

	@Override
	public String toString() {
		String finalString;
		finalString = "\nClient no. " + no + "\nId: " + id + "\nFirst name: " + firstName + "\nLast name: " + lastName
				+ "\nCNP: " + cnp + "\nEmail: " + email + "\nPhone: " + phoneNumber;
//		if (Hibernate.isInitialized(this.customerAdvisors) && this.customerAdvisors != null)
//			finalString += this.customerAdvisors;
		if (Hibernate.isInitialized(this.address) && this.address != null)
			finalString += this.address;
		else
			finalString += "\n";
		return finalString;
	}
}

