package pov.gate.core;

public interface ISafeDataEntry {
    String getDataAccessor();

    void isValid(Object data) throws SafeException;
}
