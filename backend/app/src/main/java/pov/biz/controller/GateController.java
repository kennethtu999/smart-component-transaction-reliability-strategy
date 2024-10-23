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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/gate")
@Tag(name = "Gate Controller", description = "API endpoints for gate operations")
public class GateController {

    @Autowired
    private SecurityGete securityGete;

    @Autowired
    private AgreementGate agreementGate;

    @Autowired
    private AccountGate acctGate;

    @GetMapping("/security")
    @Operation(summary = "Get security list", description = "Retrieves a list of security data")
    public List<SecurityData> getSecurityList() {
        return securityGete.getList();
    }

    @GetMapping("/agreements")
    @Operation(summary = "Get agreement list", description = "Retrieves a list of agreement data")
    public List<AgreementData> getAgreementList() {
        return agreementGate.getList();
    }

    @GetMapping("/accounts")
    @Operation(summary = "Get safe account list", description = "Retrieves a list of safe account data")
    public List<AcctData> getSafeAcctList() {
        return acctGate.getSafeAcctList();
    }
}
