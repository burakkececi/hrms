package com.company.hrms.business.abstracts;

import com.company.hrms.core.DataResult;
import com.company.hrms.core.Result;
import com.company.hrms.entities.concretes.JobTitle;


import java.util.List;

public interface JobTitleService {

    DataResult<List<JobTitle>> findAllJobTitle();
    Result addJobTitle(JobTitle jobTitle);
    Result deleteJobTitle(int id);
}
