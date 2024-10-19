package pov.biz.service;

import java.util.List;

import org.springframework.stereotype.Component;

import pov.gate.model.SecurityData;
import pov.gate.service.security.SecurityGateChecker;
import pov.gate.service.security.SecurityGete;

@Component
public class SafeSecurityService {
    private SecurityGete securityService;

    public SafeSecurityService(SecurityGete securityService) {
        this.securityService = securityService;
    }

    public SecurityGateChecker<SecurityData> getList() {
        List<SecurityData> list = securityService.getList();
        return new SecurityGateChecker<>(list);
    }
}
