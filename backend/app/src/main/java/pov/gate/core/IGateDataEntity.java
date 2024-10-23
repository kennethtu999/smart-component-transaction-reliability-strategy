package pov.gate.core;

public interface IGateDataEntity {
    String getDataAccessor();

    void isValid(Object data) throws GateException;
}
