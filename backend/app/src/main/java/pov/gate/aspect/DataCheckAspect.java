package pov.gate.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pov.gate.cache.GateCache;
import pov.gate.core.ITxDoc;
import pov.gate.core.GateException;

@Aspect
@Component
public class DataCheckAspect {
    @Autowired
    private GateCache txSafeCache;

    @Around("execution(* pov.gate.core.AbstractTxService+.doTransaction(..))")
    public Object dataCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof ITxDoc) {
            ITxDoc txDoc = (ITxDoc) args[0];
            isValidTxDoc(txDoc);
        }
        return joinPoint.proceed();
    }

    private void isValidTxDoc(ITxDoc txDoc) throws GateException {
        try {
            txSafeCache.validate(txDoc.getTxnToken(), txDoc);
        } catch (GateException e) {
            throw new GateException("Invalid transaction document: " + e.getMessage());
        }
    }
}
