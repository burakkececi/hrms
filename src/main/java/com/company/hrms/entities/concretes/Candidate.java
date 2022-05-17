package com.company.hrms.entities.concretes;

import javax.persistence.*;

import com.company.hrms.entities.abstracts.User;

import lombok.*;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@Table(name = "candidates")
public class Candidate extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "identity_number")
	private String identityNumber;

	@Column(name = "date_of_birth")
	private int dateOfBirth;

	public Candidate(Candidate oldEmployee){
		super(oldEmployee);
		this.firstName = oldEmployee.firstName;
		this.lastName = oldEmployee.lastName;
		this.identityNumber = oldEmployee.identityNumber;
		this.dateOfBirth = oldEmployee.dateOfBirth;
	}

	@Override
	public String toString() {
		return "Employee{" +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", turkishIdentityNumber=" + identityNumber +
				'}';
	}
}
