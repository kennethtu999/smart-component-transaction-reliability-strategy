package pov.channel.gateservice.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pov.gate.cache.GateCache;
import pov.gate.core.GateException;
import pov.gate.model.SecurityData;

@Component
public class SecurityGete {
    @Autowired
    private GateCache gateCache;

    public List<SecurityData> getData(String txntoken) throws GateException {
        List<SecurityData> securityDataList = new ArrayList<>();
        securityDataList.add(new SecurityData("PXSSWD", "Pxssword"));
        securityDataList.add(new SecurityData("OTP", "One Time Pxssword"));

        var checker = new SecurityGateChecker<SecurityData>(securityDataList);
        gateCache.addGateData(txntoken, checker);
        return checker.getData();
    }
}
