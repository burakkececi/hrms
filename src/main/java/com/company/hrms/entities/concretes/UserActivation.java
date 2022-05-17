package com.company.hrms.entities.concretes;

import com.company.hrms.entities.abstracts.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user_activations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UserActivation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "verification_code")
    private int verificationCode;

    @Column(name = "is_activated")
    private boolean isActivated;

    @Column(name = "activated_date")
    private Instant activatedDate;

    @OneToOne()
    private User user;


}
