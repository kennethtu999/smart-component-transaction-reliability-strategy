package pov.channel.gateservice.agreement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pov.business.service.AgreementService;
import pov.gate.cache.GateCache;
import pov.gate.core.GateException;
import pov.gate.model.AgreementData;

@Component
public class AgreementGate {
    @Autowired
    private GateCache gateCache;

    private AgreementService agreementService;

    public AgreementGate(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    public List<AgreementData> getData(String txntoken) throws GateException {
        List<AgreementData> list = agreementService.getList();
        var checker = new AgreementGateChecker<AgreementData>(list);
        gateCache.addGateData(txntoken, checker);
        return checker.getData();
    }
}
