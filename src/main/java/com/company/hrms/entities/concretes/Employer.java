package com.company.hrms.entities.concretes;

import com.company.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "employer_id")
public class Employer extends User{

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "web_address")
	private String webAddress;

    public Employer(Employer oldEmployer){
        super(oldEmployer);
        this.webAddress = oldEmployer.webAddress;
        this.companyName = oldEmployer.companyName;
    }

    @Override
    public String toString() {
        return "Employer{" +
                ", companyName='" + companyName + '\'' +
                ", webAddress='" + webAddress + '\'' +
                '}';
    }
}
