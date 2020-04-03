package vn.fpt.edu.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @EqualsAndHashCode 
@Entity
@Table(name = "Account")
public class AccountEntity {
	@Id
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "isguest", nullable = false)
	private boolean isGuest;
	@Column(name = "birthday")
	private Date birthday;
	@Column(name = "email")
	private String email;
	@Column(name = "phonenumber")
	private String phoneNumber;
	
	public AccountEntity() {
		// TODO Auto-generated constructor stub
	}

	public AccountEntity(String username, String password, boolean isGuest, Date birthday, String email,
			String phoneNumber) {
		super();
		this.username = username;
		this.password = password;
		this.isGuest = isGuest;
		this.birthday = birthday;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	
}
