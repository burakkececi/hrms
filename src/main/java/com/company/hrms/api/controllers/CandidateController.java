package com.company.hrms.api.controllers;

import com.company.hrms.business.abstracts.CandidateService;
import com.company.hrms.core.Result;
import com.company.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
public class CandidateController {

    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService){
        this.candidateService = candidateService;
    }

    @PostMapping("/register")
    public Result register(@RequestBody Candidate candidate){
        return this.candidateService.register(candidate);
    }

}
