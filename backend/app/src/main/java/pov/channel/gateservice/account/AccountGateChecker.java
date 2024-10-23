package pov.channel.gateservice.account;

import java.util.ArrayList;
import java.util.List;

import pov.gate.core.IGateDataEntity;
import pov.gate.core.GateException;
import pov.gate.model.AccountData;

public class AccountGateChecker<T> extends ArrayList<T> implements IGateDataEntity {
    private List<AccountData> acctDataList;

    public AccountGateChecker(List<AccountData> acctDataList) {
        this.acctDataList = acctDataList;
    }

    public List<AccountData> getData() {
        return acctDataList;
    }

    @Override
    public String getDataAccessor() {
        return "getAcctNo";
    }

    @Override
    public void isValid(Object data) throws GateException {
        if (data == null) {
            throw new GateException("Acct data is null");
        }
        if (acctDataList == null || acctDataList.isEmpty()) {
            throw new GateException("Acct data is empty");
        }

        acctDataList.stream()
                .filter(acctData -> data.equals(acctData.getAcctNo()))
                .findFirst()
                .orElseThrow(() -> new GateException("Acct data not found"));
    }
}