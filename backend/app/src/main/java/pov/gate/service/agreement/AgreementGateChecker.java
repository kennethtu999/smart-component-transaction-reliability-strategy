package pov.gate.service.agreement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import pov.gate.core.IGateDataEntity;
import pov.gate.core.GateException;
import pov.gate.model.AgreementData;

public class AgreementGateChecker<T> extends ArrayList<T> implements IGateDataEntity {
    public List<AgreementData> agreementDataList;

    public AgreementGateChecker(List<AgreementData> agreementDataList) {
        this.agreementDataList = agreementDataList;
    }

    @Override
    public String getDataAccessor() {
        return "getAgreementTypes";
    }

    @Override
    public void isValid(Object data) throws GateException {
        if (data == null) {
            throw new GateException("Agreement data is null");
        }
        if (agreementDataList == null || agreementDataList.isEmpty()) {
            throw new GateException("Agreement data is empty");
        }

        String allAgreementTypes = agreementDataList.stream()
                .map(AgreementData::getAgreementType)
                .collect(Collectors.joining(","));

        if (!allAgreementTypes.equals(data)) {
            throw new GateException("Agreement data not all granted");
        }

        System.out.println("Agreement data validated successfully");
    }
}