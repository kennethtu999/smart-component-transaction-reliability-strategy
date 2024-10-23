package pov.biz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pov.gate.model.AcctData;
import pov.gate.model.AgreementData;
import pov.gate.model.SecurityData;
import pov.gate.service.account.AccountGate;
import pov.gate.service.agreement.AgreementGate;
import pov.gate.service.security.SecurityGete;

@RestController
@RequestMapping("/api/gate")
public class GateController {

    @Autowired
    private SecurityGete securityGete;

    @Autowired
    private AgreementGate agreementGate;

    @Autowired
    private AccountGate acctGate;

    @GetMapping("/security")
    public List<SecurityData> getSecurityList() {
        return securityGete.getList();
    }

    @GetMapping("/agreements")
    public List<AgreementData> getAgreementList() {
        return agreementGate.getList();
    }

    @GetMapping("/accounts")
    public List<AcctData> getSafeAcctList() {
        return acctGate.getSafeAcctList();
    }
}
