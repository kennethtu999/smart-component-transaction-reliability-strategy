package pov.business.service;

import org.springframework.stereotype.Component;

import pov.gate.model.AcctData;

import java.util.ArrayList;
import java.util.List;

@Component
public class AcctService {
    public List<AcctData> getSafeAcctList() {
        List<AcctData> safeAcctList = new ArrayList<>();
        safeAcctList.add(new AcctData("1234567890", "John Doe", "Savings"));
        safeAcctList.add(new AcctData("1234567891", "Jane Doe", "Checking"));
        safeAcctList.add(new AcctData("1234567892", "John Smith", "Savings"));
        safeAcctList.add(new AcctData("1234567893", "Jane Smith", "Checking"));
        safeAcctList.add(new AcctData("1234567894", "John Doe", "Savings"));
        safeAcctList.add(new AcctData("1234567895", "Jane Doe", "Checking"));
        return safeAcctList;
    }
}
