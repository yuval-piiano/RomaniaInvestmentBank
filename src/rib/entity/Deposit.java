package rib.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

import org.hibernate.Hibernate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Deposit")
@Getter
@Setter
@NoArgsConstructor
@Positive
public class Deposit {

	@Id
	@Column(name = "No")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;

	@Column(name = "Deposit_RON")
	@Min(value = 0)
	private Integer ron;

	@Column(name = "Deposit_EUR")
	@Min(value = 0)
	private Integer eur;

	@Column(name = "Deposit_USD")
	@Min(value = 0)
	private Integer usd;

	@Column(name = "Deposit_GBP")
	@Min(value = 0)
	private Integer gbp;

	@OneToOne(mappedBy = "deposit")
	private BankAccount bankAccount;

	public Deposit(int no, int ron, int eur, int usd, int gbp, BankAccount bankAccount) {
		super();
		this.no = no;
		this.ron = ron;
		this.eur = eur;
		this.usd = usd;
		this.gbp = gbp;
		this.bankAccount=bankAccount;
	}

	@Override
	public String toString() {
		String finalString = "SOLD ";
		if (Hibernate.isInitialized(this.no))
			finalString += this.no+": ";
		if (Hibernate.isInitialized(this.ron) && this.getRon() != null)
			finalString += "RON: " + this.ron;
		else if (this.getRon() == null)
			finalString += ", RON: " + 0;
		if (Hibernate.isInitialized(this.eur) && this.getEur() != null)
			finalString += ", EUR: " + this.eur;
		else if (this.getEur() == null)
			finalString += ", EUR: " + 0;
		if (Hibernate.isInitialized(this.usd) && this.getUsd() != null)
			finalString += ", USD: " + this.usd;
		else if (this.getUsd() == null)
			finalString += ", USD: " + 0;
		if (Hibernate.isInitialized(this.gbp) && this.getGbp() != null)
			finalString += ", GBP: " + this.gbp+"\n";
		else if (this.getGbp() == null)
			finalString += ", GBP: " + 0;
		return finalString;
	}

}
