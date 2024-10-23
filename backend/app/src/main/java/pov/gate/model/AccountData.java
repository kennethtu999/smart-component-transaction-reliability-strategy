package pov.gate.model;

import lombok.Data;

@Data
public class AccountData {
    private String acctNo;
    private String acctName;
    private String acctType;

    public AccountData(String acctNo, String acctName, String acctType) {
        this.acctNo = acctNo;
        this.acctName = acctName;
        this.acctType = acctType;
    }
}
