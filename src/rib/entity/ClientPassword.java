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
@Table(name = "ClientPassword")
@Getter
@Setter
@NoArgsConstructor
public class ClientPassword {
	@Id
	@Column(name = "No")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
	@Column(name="Password")
	private int password;
	
	@OneToOne(mappedBy = "clientPassword")
	private Client client;

	public ClientPassword(int no, int password, Client client) {
		super();
		this.no = no;
		this.password = password;
		this.client = client;
	}
	
}
