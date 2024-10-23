package pov.gate.service.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import pov.gate.core.IGateDataEntity;
import pov.gate.core.GateException;
import pov.gate.model.SecurityData;

public class SecurityGateChecker<T> extends ArrayList<T> implements IGateDataEntity {
    public List<SecurityData> securityDataList;

    public SecurityGateChecker(List<SecurityData> securityDataList) {
        this.securityDataList = securityDataList;
    }

    @Override
    public String getDataAccessor() {
        return "getSecurityType";
    }

    @Override
    public void isValid(Object data) throws GateException {
        if (data == null) {
            throw new GateException("Security data is null");
        }
        if (securityDataList == null || securityDataList.isEmpty()) {
            throw new GateException("Security data is empty");
        }

        Optional<SecurityData> securityDataOpt = securityDataList.stream()
                .filter(securityData -> data.equals(securityData.getSecurityType()))
                .findFirst();
        if (securityDataOpt.isPresent()) {
            System.out.println("Security data found: " + securityDataOpt.get().getSecurityName());
        } else {
            throw new GateException("Security data not found");
        }
    }
}