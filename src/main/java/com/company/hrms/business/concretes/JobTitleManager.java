package com.company.hrms.business.concretes;

import com.company.hrms.business.abstracts.JobTitleService;
import com.company.hrms.core.DataResult;
import com.company.hrms.core.Result;
import com.company.hrms.core.SuccessDataResult;
import com.company.hrms.core.SuccessResult;
import com.company.hrms.dataAccess.abstracts.JobTitleDao;
import com.company.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private final JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleRepository){
        this.jobTitleDao = jobTitleRepository;
    }

    public DataResult<List<JobTitle>> findAllJobTitle(){
        return new SuccessDataResult<List<JobTitle>>(jobTitleDao.findAll());
    }

    public Result addJobTitle(JobTitle jobTitle){
        this.jobTitleDao.save(jobTitle);
        return new SuccessResult("Ekleme Basarili!");
    }

    public Result deleteJobTitle(int id){
        boolean exist = jobTitleDao.existsById(id);
        if(!exist){
            throw new IllegalStateException("student with id: "+ id + "does not exist!");
        }
        this.jobTitleDao.deleteById(id);
        return new SuccessResult("Silme Basarili!");
    }

}
