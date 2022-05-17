package com.company.hrms.core;


import org.springframework.stereotype.Service;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

import java.rmi.RemoteException;

@Service
public class MernisServiceAdapter {

    public boolean checkIfRealPerson(String identityNumber, String firstName, String lastName, int dateOfBirth) {

        KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();
        boolean result = false;
        try {
            result = kpsPublicSoapProxy.TCKimlikNoDogrula(
                    Long.parseLong(identityNumber),
                    firstName,
                    lastName,
                    dateOfBirth
            );
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args){
        MernisServiceAdapter mernisServiceAdapter = new MernisServiceAdapter();
        mernisServiceAdapter.checkIfRealPerson("","","",0);
    }
}
