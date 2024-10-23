package pov.biz.txn;

import org.springframework.stereotype.Service;

import pov.gate.core.AbstractTxService;

@Service
public class Mtwtx001TxService extends AbstractTxService<Mtwtx001Doc> {

    /**
     * Create a new transaction document
     */
    @Override
    public Mtwtx001Doc createTransaction() {
        Mtwtx001Doc doc = new Mtwtx001Doc();
        doc.setTxnToken(generateTxnToken());
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
