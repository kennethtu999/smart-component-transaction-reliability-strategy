package pov.gate.core;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;

import pov.gate.cache.GateCache;

public abstract class AbstractTxService<T extends ITxDoc> {

    @Autowired
    protected GateCache gateCache;

    public abstract T createTransaction() throws GateException;

    public abstract void doTransaction(T txDoc);

    protected String activateTxnToken() throws GateException {
        String txnToken = "TX" + new SecureRandom().nextInt(1000000);
        gateCache.activate(txnToken);
        return txnToken;
    }
}
