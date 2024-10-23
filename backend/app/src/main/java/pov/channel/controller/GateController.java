package pov.channel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import pov.channel.gateservice.account.AccountGate;
import pov.channel.gateservice.agreement.AgreementGate;
import pov.channel.gateservice.security.SecurityGete;
import pov.gate.core.GateException;
import pov.gate.model.AccountData;
import pov.gate.model.AgreementData;
import pov.gate.model.SecurityData;

@RestController
@RequestMapping("/api/gate")
@Tag(name = "Gate Controller", description = "API endpoints for gate operations")
public class GateController {

    private static final Logger logger = LoggerFactory.getLogger(GateController.class);

    @Autowired
    private SecurityGete securityGete;

    @Autowired
    private AgreementGate agreementGate;

    @Autowired
    private AccountGate acctGate;

    @GetMapping("/security")
    @Operation(summary = "Get security list", description = "Retrieves a list of security data")
    public List<SecurityData> getSecurityList(@RequestParam("txntoken") String txntoken) throws GateException {
        logger.debug("Entering getSecurityList method");

        List<SecurityData> result = securityGete.getData(txntoken);

        logger.debug("Exiting getSecurityList method. Returned {} items", result.size());
        return result;
    }

    @GetMapping("/agreements")
    @Operation(summary = "Get agreement list", description = "Retrieves a list of agreement data")
    public List<AgreementData> getAgreementList(@RequestParam("txntoken") String txntoken) throws GateException {
        logger.debug("Entering getAgreementList method");

        List<AgreementData> result = agreementGate.getData(txntoken);

        logger.debug("Exiting getAgreementList method. Returned {} items", result.size());
        return result;
    }

    @GetMapping("/accounts")
    @Operation(summary = "Get account list", description = "Retrieves a list of account data")
    public List<AccountData> getAccountList(@RequestParam("txntoken") String txntoken) throws GateException {
        logger.debug("Entering getAccountList method");

        List<AccountData> result = acctGate.getData(txntoken);

        logger.debug("Exiting getAccountList method. Returned {} items", result.size());
        return result;
    }
}
