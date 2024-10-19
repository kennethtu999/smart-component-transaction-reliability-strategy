package pov.gate.service.account;

import java.util.List;

import org.springframework.stereotype.Component;

import pov.biz.service.AcctService;
import pov.gate.model.AcctData;

@Component
public class AccountGate {
    private AcctService acctService;

    public AccountGate(AcctService acctService) {
        this.acctService = acctService;
    }

    public AccountGateChecker<AcctData> getSafeAcctList() {
        List<AcctData> acctDataList = acctService.getSafeAcctList();
        return new AccountGateChecker<>(acctDataList);
    }

}
