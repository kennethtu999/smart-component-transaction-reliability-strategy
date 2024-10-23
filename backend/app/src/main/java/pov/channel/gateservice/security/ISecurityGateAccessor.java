package pov.channel.gateservice.security;

public interface ISecurityGateAccessor {
    public static final String ACCESSOR = "getSecurityType";

    public abstract String getSecurityType();

}