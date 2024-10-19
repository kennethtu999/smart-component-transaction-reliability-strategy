package pov.gate.cache;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pov.gate.core.ISafeDataEntry;
import pov.gate.core.ITxDoc;
import pov.gate.core.SafeException;

@Component
public class TxSafeCache {
    private List<ISafeDataEntry> safeDataEntryList;

    public void addSafeDataEntry(ISafeDataEntry safeDataEntry) {
        if (safeDataEntryList == null) {
            safeDataEntryList = new ArrayList<>();
        }
        safeDataEntryList.add(safeDataEntry);
    }

    public void validate(ITxDoc txDoc) throws SafeException {
        for (ISafeDataEntry entry : safeDataEntryList) {
            // 1. Get data from txDoc by invocation
            Object data = getDataFromTxDoc(txDoc, entry);

            // 2. Check value inside entry
            entry.isValid(data);
        }
    }

    private Object getDataFromTxDoc(ITxDoc txDoc, ISafeDataEntry entry) throws SafeException {
        try {
            Method method = txDoc.getClass().getMethod(entry.getDataAccessor());
            return method.invoke(txDoc);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new SafeException("Failed to get data from transaction document: " + e.getMessage());
        }
    }
}
