package pov.gate.cache;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import pov.gate.core.IGateDataEntity;
import pov.gate.core.ITxDoc;
import pov.gate.core.SafeException;

@Component
public class GateCache {

    private Map<String, List<IGateDataEntity>> dataMap;

    @PostConstruct
    private void init() {
        dataMap = Collections.synchronizedMap(new HashMap<>());
    }

    public void addGateData(String txnToken, IGateDataEntity safeDataEntry) {
        if (!dataMap.containsKey(txnToken)) {
            dataMap.put(txnToken, Collections.synchronizedList(new ArrayList<>()));
        }
        dataMap.get(txnToken).add(safeDataEntry);
    }

    public void validate(String txnToken, ITxDoc txDoc) throws SafeException {
        var dataList = dataMap.get(txnToken);
        for (IGateDataEntity entry : dataList) {
            // 1. Get data from txDoc by invocation
            Object data = getDataFromTxDoc(txDoc, entry);

            // 2. Check value inside entry
            entry.isValid(data);
        }
    }

    private Object getDataFromTxDoc(ITxDoc txDoc, IGateDataEntity entry) throws SafeException {
        try {
            Method method = txDoc.getClass().getMethod(entry.getDataAccessor());
            return method.invoke(txDoc);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new SafeException("Failed to get data from transaction document: " + e.getMessage());
        }
    }
}
