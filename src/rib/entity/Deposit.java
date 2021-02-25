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
@Table(name = "Deposit")
@Getter
@Setter
@NoArgsConstructor
public class Deposit {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
	@Column(name="Deposit_RON")
	private Integer ron;
	
	@Column(name="Deposit_EUR")
	private Integer eur;
	
	@Column(name="Deposit_USD")
	private Integer usd;
	
	@Column(name="Deposit_GBP")
	private Integer gbp;
	
	@OneToOne(mappedBy = "bankAccount")
	private Client client;

	public Deposit(int no, int ron, int eur, int usd, int gbp, Client client) {
		super();
		this.no = no;
		this.ron = ron;
		this.eur = eur;
		this.usd = usd;
		this.gbp = gbp;
		this.client = client;
	}
	
	
}
