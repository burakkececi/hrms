package com.company.hrms.business.abstracts;

import com.company.hrms.core.Result;
import com.company.hrms.entities.concretes.Employer;

public interface EmployerService {

    Result register(Employer employer);
}
