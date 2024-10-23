package pov.gate;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import pov.business.txn.Mtwtx001Doc;
import pov.business.txn.Mtwtx001TxService;
import pov.channel.DemoApplication;
import pov.channel.gateservice.account.AccountGate;
import pov.channel.gateservice.agreement.AgreementGate;
import pov.channel.gateservice.security.SecurityGete;
import pov.gate.core.GateException;
import pov.gate.model.AccountData;
import pov.gate.model.AgreementData;
import pov.gate.model.SecurityData;

@SpringBootTest(classes = DemoApplication.class)
@ComponentScan(basePackages = "pov.secure")
@ActiveProfiles("dummy")
public class ServiceGateTest {

    @Autowired
    private AccountGate accountGate;

    @Autowired
    private SecurityGete securityGate;

    @Autowired
    private AgreementGate agreementGate;

    @Autowired
    private Mtwtx001TxService txService;

    /**
     * Test method to validate safe data after getting it
     */
    @ParameterizedTest(name = "{index} - {0}")
    @CsvSource({
            "success,       1234567890,OTP,'AGREE1,AGREE2',false",
            "wrong-acct-no, 9909999999,SMS,'AGREE1,AGREE2',true"
    })
    public void validateSafeDataAfterGet(String testName, String acctNo, String securityType, String agreementTypes,
            Boolean expectedException) throws Throwable {
        try {
            // 建立交易使用的TXN TOKEN
            // PAGE 1
            Mtwtx001Doc txDoc = txService.createTransaction();

            // 使用微前端時會取得資料再寫入暫存區
            // PAGE 1～N
            List<AccountData> accountDataList = accountGate.getData(txDoc.getTxnToken());
            Assertions.assertNotNull(accountDataList);
            Assertions.assertFalse(accountDataList.isEmpty());

            // PAGE 2
            List<SecurityData> securityDataList = securityGate.getData(txDoc.getTxnToken());
            Assertions.assertNotNull(securityDataList);
            Assertions.assertFalse(securityDataList.isEmpty());

            // PAGE 3
            List<AgreementData> agreementDatas = agreementGate.getData(txDoc.getTxnToken());
            Assertions.assertNotNull(agreementDatas);
            Assertions.assertFalse(agreementDatas.isEmpty());

            // 更新交易資料
            // PAGE 1～N
            txDoc.setAcctNo(acctNo);
            txDoc.setSecurityType(securityType);
            txDoc.setAgreementTypes(agreementTypes);

            // 執行交易
            // PAGE CONFIRM
            txService.doTransaction(txDoc);
        } catch (Throwable e) {
            if (expectedException) {
                Assertions.assertEquals(GateException.class, e.getCause().getClass());
            } else {
                throw e.getCause() == null ? e : e.getCause();
            }
        }
    }
}
