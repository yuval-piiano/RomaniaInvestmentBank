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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BankAccount")
@Getter
@Setter
@NoArgsConstructor
public class BankAccount {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private int password;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Deposit deposit;
	
	public BankAccount(String username, int password, Deposit deposit) {
		super();
		this.username=username;
		this.password=password;
		this.deposit=deposit;
	}
}

