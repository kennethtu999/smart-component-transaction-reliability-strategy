package pov.business.txn;

import lombok.Data;
import pov.channel.gateservice.account.IAccountGateAccessor;
import pov.channel.gateservice.agreement.IAgreementGateAccessor;
import pov.channel.gateservice.security.ISecurityGateAccessor;
import pov.gate.core.ITxDoc;

@Data
public class Mtwtx001Doc implements ITxDoc, IAccountGateAccessor, ISecurityGateAccessor,
        IAgreementGateAccessor {
    private String txnToken;
    private String acctNo;
    private String securityType;
    private String agreementTypes;
}
