package pov.business.service;

import org.springframework.stereotype.Component;

import pov.gate.model.AccountData;

import java.util.ArrayList;
import java.util.List;

@Component
public class AcctService {
    public List<AccountData> getAccountList() {
        List<AccountData> safeAcctList = new ArrayList<>();
        safeAcctList.add(new AccountData("1234567890", "John Doe", "Savings"));
        safeAcctList.add(new AccountData("1234567891", "Jane Doe", "Checking"));
        safeAcctList.add(new AccountData("1234567892", "John Smith", "Savings"));
        safeAcctList.add(new AccountData("1234567893", "Jane Smith", "Checking"));
        safeAcctList.add(new AccountData("1234567894", "John Doe", "Savings"));
        safeAcctList.add(new AccountData("1234567895", "Jane Doe", "Checking"));
        return safeAcctList;
    }
}
