package pov.gate.service.agreement;

import java.util.List;

import org.springframework.stereotype.Component;

import pov.biz.service.AgreementService;
import pov.gate.model.AgreementData;

@Component
public class AgreementGate {
    private AgreementService agreementService;

    public AgreementGate(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    public AgreementGateChecker<AgreementData> getList() {
        List<AgreementData> list = agreementService.getList();
        return new AgreementGateChecker<>(list);
    }
}
