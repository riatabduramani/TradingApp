package com.db.trading.api;

import com.db.trading.dto.TradeSignalRequest;
import com.db.trading.service.TradeSignalService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping
@Slf4j
public class CreateTradeSignalController {

    private final TradeSignalService signalService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public void handle(@RequestBody TradeSignalRequest request) {
        log.info("Incoming request: {}", request);
        signalService.saveTradeSignal(request);
    }
}
