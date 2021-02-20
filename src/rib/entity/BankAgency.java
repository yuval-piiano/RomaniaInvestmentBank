package rib.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Hibernate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BankAgency")
@Getter
@Setter
@NoArgsConstructor
public class BankAgency {
	@Id
	@Column(name = "No")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;

	@Column(name = "ID")
	private String id;

	@Column(name = "PhoneBankNumber")
	private String phoneBankNumber;

	@Column(name = "OperatingMorningHours")
	private String operatingMorningHours;

	@Column(name = "OperatingAfternoonHours")
	private String operatingAfternoonHours;

	@Column(name = "LunchBreak")
	private String lunchBreak;

	@OneToOne(mappedBy = "bankAgency")
	private CustomerAdvisors customerAdvisors;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Address address;

	public BankAgency(String id, String phoneBankNumber, String operatingMorningHours, String operatingAfternoonHours,
			String lunchBreak, Address address) {
		super();
		this.id = id;
		this.phoneBankNumber = phoneBankNumber;
		this.operatingMorningHours = operatingMorningHours;
		this.operatingAfternoonHours = operatingAfternoonHours;
		this.lunchBreak = lunchBreak;
		this.address = address;
	}

	@Override
	public String toString() {
		String finalString;
		finalString = "\nBank agency " + "\nId: " + id + "\nPhone: " + phoneBankNumber
				+ "\nOperating hours\nMonday-Friday: " + operatingMorningHours + " and " + operatingAfternoonHours
				+ "\nSaturday and Sunday: closed" + "\nLunch break: " + lunchBreak;

		if (Hibernate.isInitialized(this.address) && this.address != null)
			finalString += this.address;
//		else
//			finalString += "\n".toString();

		return finalString;
	}

}

