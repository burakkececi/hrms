package com.company.hrms.dataAccess.abstracts;

import com.company.hrms.core.Result;
import com.company.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.color.ICC_Profile;
import java.util.Optional;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer> {

    Optional<Candidate> getByEmail(@Param("email") String email);

    Optional<Candidate> getByIdentityNumber(@Param("identityNumber") String identityNumber);

}
