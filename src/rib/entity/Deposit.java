package rib.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private long ron;
	
	@Column(name="Deposit_EUR")
	private long eur;
	
	@Column(name="Deposit_USD")
	private long usd;
	
	@Column(name="Deposit_GBP")
	private long gbp;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Client_No")
	private Client client;

	public Deposit(int no, long ron, long eur, long usd, long gbp, Client client) {
		super();
		this.no = no;
		this.ron = ron;
		this.eur = eur;
		this.usd = usd;
		this.gbp = gbp;
		this.client = client;
	}
	
	
}
