package pov.channel.gateservice.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pov.business.service.AcctService;
import pov.gate.cache.GateCache;
import pov.gate.core.GateException;
import pov.gate.model.AccountData;

@Component
public class AccountGate {
    @Autowired
    private GateCache gateCache;

    @Autowired
    private AcctService acctService;

    public AccountGate(AcctService acctService) {
        this.acctService = acctService;
    }

    public List<AccountData> getData(String txntoken) throws GateException {
        List<AccountData> acctDataList = acctService.getAccountList();
        var checker = new AccountGateChecker<AccountData>(acctDataList);
        gateCache.addGateData(txntoken, checker);
        return checker.getData();
    }

}
