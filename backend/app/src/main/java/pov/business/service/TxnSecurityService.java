package pov.business.service;

import java.util.List;

import org.springframework.stereotype.Component;

import pov.channel.gateservice.security.SecurityGateChecker;
import pov.channel.gateservice.security.SecurityGete;
import pov.gate.model.SecurityData;

@Component
public class TxnSecurityService {
    private SecurityGete securityService;

    public TxnSecurityService(SecurityGete securityService) {
        this.securityService = securityService;
    }

    public SecurityGateChecker<SecurityData> getList() {
        List<SecurityData> list = securityService.getList();
        return new SecurityGateChecker<>(list);
    }
}
