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
	
	@OneToOne(mappedBy = "bankAccount")
	private Client client;
	
	public BankAccount(String username, int password) {
		super();
		this.username=username;
		this.password=password;
	}
}

