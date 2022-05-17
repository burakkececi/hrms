package com.company.hrms.business.concretes;

import com.company.hrms.business.abstracts.CandidateService;
import com.company.hrms.core.ErrorResult;
import com.company.hrms.core.MernisServiceAdapter;
import com.company.hrms.core.Result;
import com.company.hrms.core.SuccessResult;
import com.company.hrms.dataAccess.abstracts.CandidateDao;
import com.company.hrms.entities.concretes.Candidate;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateManager implements CandidateService {

    private final CandidateDao candidateDao;

    @Autowired
    public CandidateManager(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }
    @Override
    public Result register(Candidate candidate) {
        MernisServiceAdapter mernisServiceAdapter = new MernisServiceAdapter();
        if (mernisServiceAdapter.checkIfRealPerson(
                candidate.getIdentityNumber(),
                candidate.getFirstName(),
                candidate.getLastName(),
                candidate.getDateOfBirth())) {
            if (checkPasswordsEqual(candidate)) {
                if (!(checkEmailExist(candidate.getEmail()) || checkIdentityNumberExist(candidate.getIdentityNumber()))) {

                    this.candidateDao.save(candidate);
                    String randomCode = RandomString.make(64);
                    //candidate.
                      //      user.setEnabled(false);
                    //sendVerificationEmail(user, siteURL);
                    return new SuccessResult("Verification success! Check your email for validation.");
                } else {
                    return new ErrorResult("You already registered!");
                }
            }else{
                return new ErrorResult("Your password doesn't match!");
            }
        }
        return new ErrorResult("Verification Failed!");
    }

    public boolean checkEmailExist(String email) {
        boolean result = false;
        if(candidateDao.getByEmail(email).isPresent())
            result = true;
        return result;
    }

    public boolean checkIdentityNumberExist(String identityNumber) {
        boolean result = false;
        if(candidateDao.getByIdentityNumber(identityNumber).isPresent())
            result = true;
        return result;
    }

    public boolean checkPasswordsEqual(Candidate candidate){
        boolean result = false;
        if(candidate.getPassword().equals(candidate.getConfirmPassword())){
            result = true;
        }
        return result;
    }


}
