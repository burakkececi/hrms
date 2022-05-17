package com.company.hrms.entities.abstracts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Email(message = "Please enter valid email!")
	@NotBlank(message = "Email cannot be blank!")
	@NotNull
	@Column(name = "email", nullable = false)
	private String email;

	@NotBlank(message = "Password cannot be blank!")
	@NotNull
	@Column(name = "password")
	private String password;

	@Transient
	private String confirmPassword;


	public User(User oldUser){
		if(oldUser == null){
			System.out.println("User cannot be null @User");
			System.exit(0);
		}
		this.id = oldUser.id;
		this.email = oldUser.email;
		this.password = oldUser.password;
	}

	@Override
	public boolean equals(Object object){
		if(object == null) return false;
		else if(object.getClass() != getClass()) return false;
		else{
			try{
				User tempUser = (User) object;
				return (getId() == tempUser.getId() &&
						getEmail().equals(tempUser.getEmail()) &&
						getPassword().equals(tempUser.getPassword()));
			}catch (ClassCastException e){
				System.out.println(e.getMessage());
				return false;
			}

		}
	}
}
