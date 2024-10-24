package pov.channel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import pov.gate.cache.GateCache;
import pov.gate.core.GateException;

@RestController
@RequestMapping("/api/txn001")
@Tag(name = "Txn001 Controller", description = "API endpoints for Txn001 operations")
public class Txn001Controller {

    @Autowired
    private GateCache gateCache;

    @GetMapping("/init")
    @Operation(summary = "init txn001 yyy", description = "init txn001 yyy")
    public void init(@RequestParam("txntoken") String txntoken) throws GateException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        gateCache.activate(txntoken);
    }

}
