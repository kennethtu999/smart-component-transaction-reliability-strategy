package pov.gate.service.account;

import java.util.ArrayList;
import java.util.List;

import pov.gate.core.ISafeDataEntry;
import pov.gate.core.SafeException;
import pov.gate.model.AcctData;

public class AccountGateChecker<T> extends ArrayList<T> implements ISafeDataEntry {
    public List<AcctData> acctDataList;

    public AccountGateChecker(List<AcctData> acctDataList) {
        this.acctDataList = acctDataList;
    }

    @Override
    public String getDataAccessor() {
        return "getAcctNo";
    }

    @Override
    public void isValid(Object data) throws SafeException {
        if (data == null) {
            throw new SafeException("Acct data is null");
        }
        if (acctDataList == null || acctDataList.isEmpty()) {
            throw new SafeException("Acct data is empty");
        }

        acctDataList.stream()
                .filter(acctData -> data.equals(acctData.getAcctNo()))
                .findFirst()
                .orElseThrow(() -> new SafeException("Acct data not found"));
    }
}