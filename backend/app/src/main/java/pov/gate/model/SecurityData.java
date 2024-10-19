package pov.gate.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SecurityData {
    private String securityType;
    private String securityName;
}
