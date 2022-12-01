package com.db.trading.api;

import com.db.library.algolib.SignalHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/signal")
@Slf4j
public class SignalController {

    private final SignalHandler signalHandler;

    @GetMapping("/{signalParam}")
    @ResponseStatus(HttpStatus.OK)
    public void getSignalByParam(@PathVariable Integer signalParam) {
        log.info("Requesting data for signal: {}", signalParam);
        signalHandler.handleSignal(signalParam);
    }
}
