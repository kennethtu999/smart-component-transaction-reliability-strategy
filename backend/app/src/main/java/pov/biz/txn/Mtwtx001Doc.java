package pov.biz.txn;

import lombok.Data;
import pov.gate.core.ITxDoc;
import pov.gate.service.account.IAccountGateAccessor;
import pov.gate.service.agreement.IAgreementGateAccessor;
import pov.gate.service.security.ISecurityGateAccessor;

@Data
public class Mtwtx001Doc implements ITxDoc, IAccountGateAccessor, ISecurityGateAccessor,
        IAgreementGateAccessor {
    private String txId;
    private String acctNo;
    private String securityType;
    private String agreementTypes;
}
