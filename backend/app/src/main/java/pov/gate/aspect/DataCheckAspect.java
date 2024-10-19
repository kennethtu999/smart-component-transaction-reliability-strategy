package pov.gate.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pov.gate.cache.TxSafeCache;
import pov.gate.core.ITxDoc;
import pov.gate.core.SafeException;

@Aspect
@Component
public class DataCheckAspect {
    @Autowired
    private TxSafeCache txSafeCache;

    @Around("execution(* pov.gate.core.AbstractTxService+.doTransaction(..))")
    public Object dataCheckAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof ITxDoc) {
            ITxDoc txDoc = (ITxDoc) args[0];
            isValidTxDoc(txDoc);
        }
        return joinPoint.proceed();
    }

    private void isValidTxDoc(ITxDoc txDoc) throws SafeException {
        try {
            txSafeCache.validate(txDoc);
        } catch (SafeException e) {
            throw new SafeException("Invalid transaction document: " + e.getMessage());
        }
    }
}
