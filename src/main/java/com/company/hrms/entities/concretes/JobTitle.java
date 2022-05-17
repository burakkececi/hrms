package com.company.hrms.entities.concretes;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "job_titles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Override
    public String toString() {
        return "JobTitle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
