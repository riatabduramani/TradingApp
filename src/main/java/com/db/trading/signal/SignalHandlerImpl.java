package com.db.trading.signal;

import com.db.library.algolib.SignalHandler;
import com.db.trading.TradeAlgo;
import com.db.trading.entity.TradeSignal;
import com.db.trading.enums.TradeType;
import com.db.trading.exception.TradeAppException;
import com.db.trading.service.TradeSignalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class SignalHandlerImpl implements SignalHandler {

    private final TradeSignalService signalService;
    private final TradeAlgo tradeAlgo;

    @Override
    public void handleSignal(int signal) {
        TradeSignal tradeSignal = signalService.getTradeSignal(signal);

        if (Objects.isNull(tradeSignal)) {
            tradeAlgo.cancelTrades();
            throw new TradeAppException("Trading signal couldn't found: " + signal);
        }

        runTradeAlgoLib(tradeSignal);
    }

    private void runTradeAlgoLib(TradeSignal tradeSignal) {

        log.info("Processing Trading Signal #: {}", tradeSignal.getSignal());

        if (Objects.isNull(tradeSignal.getType())) {
            tradeAlgo.cancelTrades();
            throw new TradeAppException("Trade signal type not found");
        }

        processingType(tradeSignal.getType());

        if (tradeSignal.getSpecifications().isEmpty()) {
            tradeAlgo.cancelTrades();
            throw new TradeAppException("Trading signal params are missing");
        }

        tradeSignal.getSpecifications()
                .forEach(specification -> tradeAlgo.setAlgoParam(specification.getParam(), specification.getValue()));

        if (tradeSignal.getCalculate().equals(true)) {
            tradeAlgo.performCalc();
        }

        tradeAlgo.submitToMarket();
        tradeAlgo.doAlgo();

        log.info("End processing of Trading Signal #: {}", tradeSignal.getSignal());
    }

    private void processingType(TradeType type) {
        switch (type) {
            case SETUP -> tradeAlgo.setUp();
            case REVERSE -> tradeAlgo.reverse();
        }
    }
}
