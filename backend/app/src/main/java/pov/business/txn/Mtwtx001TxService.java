package pov.business.txn;

import org.springframework.stereotype.Service;

import pov.gate.core.AbstractTxService;
import pov.gate.core.GateException;

@Service
public class Mtwtx001TxService extends AbstractTxService<Mtwtx001Doc> {

    /**
     * Create a new transaction document
     * 
     * @throws GateException
     */
    @Override
    public Mtwtx001Doc createTransaction() throws GateException {
        Mtwtx001Doc doc = new Mtwtx001Doc();
        doc.setTxnToken(activateTxnToken());

        return doc;
    }

    /**
     * TODO: implement the transaction logic
     */
    @Override
    public void doTransaction(Mtwtx001Doc txDoc) {
        System.out.println("doTransaction");
    }
}
