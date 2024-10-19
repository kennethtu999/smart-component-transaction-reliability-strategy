package pov.gate.service.security;

import org.springframework.stereotype.Component;

import pov.gate.model.SecurityData;

import java.util.ArrayList;
import java.util.List;

@Component
public class SecurityGete {
    public List<SecurityData> getList() {
        List<SecurityData> securityDataList = new ArrayList<>();
        securityDataList.add(new SecurityData("PXSSWD", "Pxssword"));
        securityDataList.add(new SecurityData("OTP", "One Time Pxssword"));
        return securityDataList;
    }
}
