package pov.gate.cache;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import pov.gate.core.GateException;
import pov.gate.core.IGateDataEntity;
import pov.gate.core.ITxDoc;

@Component
public class GateCache {

    private Map<String, List<IGateDataEntity>> dataMap;

    @PostConstruct
    private void init() {
        dataMap = Collections.synchronizedMap(new LinkedHashMap<String, List<IGateDataEntity>>(10, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, List<IGateDataEntity>> eldest) {
                return size() > 10;
            }
        });
    }

    /**
     * Activate a transaction token
     * 
     * @param txntoken
     * @return
     * @throws GateException
     */
    public void activate(String txnToken) throws GateException {
        if (!dataMap.containsKey(txnToken)) {
            dataMap.put(txnToken, Collections.synchronizedList(new ArrayList<>()));
        } else {
            throw new GateException("Txn token already activated: " + txnToken);
        }
    }

    /**
     * Add a gate data entry to the cache
     * 
     * @param txnToken
     * @param safeDataEntry
     * @throws GateException
     */
    public void addGateData(String txnToken, IGateDataEntity safeDataEntry) throws GateException {
        if (!dataMap.containsKey(txnToken)) {
            throw new GateException("Txn token not activated: " + txnToken);
        }
        dataMap.get(txnToken).add(safeDataEntry);
    }

    public void validate(String txnToken, ITxDoc txDoc) throws GateException {
        var dataList = dataMap.get(txnToken);
        for (IGateDataEntity entry : dataList) {
            // 1. Get data from txDoc by invocation
            Object data = getDataFromTxDoc(txDoc, entry);

            // 2. Check value inside entry
            entry.isValid(data);
        }
    }

    private Object getDataFromTxDoc(ITxDoc txDoc, IGateDataEntity entry) throws GateException {
        try {
            Method method = txDoc.getClass().getMethod(entry.getDataAccessor());
            return method.invoke(txDoc);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new GateException("Failed to get data from transaction document: " + e.getMessage());
        }
    }

}
