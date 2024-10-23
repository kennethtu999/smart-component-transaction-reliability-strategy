package pov.business.service;

import org.springframework.stereotype.Component;

import pov.gate.model.AgreementData;

import java.util.ArrayList;
import java.util.List;

@Component
public class AgreementService {
    public List<AgreementData> getList() {
        List<AgreementData> agreementDataList = new ArrayList<>();
        agreementDataList.add(new AgreementData("AGREE1", "Agreement 1"));
        agreementDataList.add(new AgreementData("AGREE2", "Agreement 2"));
        return agreementDataList;
    }
}
