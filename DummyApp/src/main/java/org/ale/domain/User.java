package org.ale.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="user")
public class User {

	@Id
	private long id;
	
	private String name;
	private String password;
	
	private String fullName;
	private String email;
	
}
