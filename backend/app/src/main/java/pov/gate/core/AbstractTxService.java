package pov.gate.core;

import java.security.SecureRandom;

public abstract class AbstractTxService<T extends ITxDoc> {
    public abstract T createTransaction();

    public abstract void doTransaction(T txDoc);

    protected String generateTxnToken() {
        return "TX" + new SecureRandom().nextInt(1000000);
    }
}
