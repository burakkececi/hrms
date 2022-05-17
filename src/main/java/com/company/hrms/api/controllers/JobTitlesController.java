package com.company.hrms.api.controllers;

import com.company.hrms.business.abstracts.JobTitleService;
import com.company.hrms.core.DataResult;
import com.company.hrms.core.Result;
import com.company.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/jobtitle")
public class JobTitlesController {

    private final JobTitleService jobTitleService;

    @Autowired
    public JobTitlesController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping(path ="/findAll")
    public DataResult<List<JobTitle>> findAll(){
        return this.jobTitleService.findAllJobTitle();
    }

    @PostMapping(path = "/add")
    public Result add(@RequestBody JobTitle jobTitle){
        return this.jobTitleService.addJobTitle(jobTitle);
    }

    @DeleteMapping(path = "/{studentId}")
    public Result remove(@PathVariable(name = "studentId") int id){
        return this.jobTitleService.deleteJobTitle(id);
    }
}
