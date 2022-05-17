package com.company.hrms.business.abstracts;

import com.company.hrms.core.Result;
import com.company.hrms.entities.concretes.Candidate;


public interface CandidateService {

    Result register(Candidate candidate);

}
