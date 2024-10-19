package pov.gate.service.security;

public interface ISecurityGateAccessor {
    public static final String ACCESSOR = "getSecurityType";

    public abstract String getSecurityType();

}