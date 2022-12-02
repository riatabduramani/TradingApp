package com.db.trading.signal;

import com.db.library.algolib.SignalHandler;
import com.db.trading.TradeAlgo;
import com.db.trading.dto.Signal;
import com.db.trading.enums.TradeType;
import com.db.trading.exception.TradeAppException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class SignalHandlerImpl implements SignalHandler {

    private final SignalProcessor signalProcessor;
    private final TradeAlgo tradeAlgo;

    @Override
    public void handleSignal(int signal) {
        signalProcessor.payload()
                .stream()
                .filter(s -> Objects.nonNull(s.getSignal()) && s.getSignal() == signal)
                .filter(s -> Objects.nonNull(s.getParams()) && !s.getParams().isEmpty())
                .findFirst()
                .ifPresent(this::runTradeAlgoLib);
    }

    private void runTradeAlgoLib(Signal tradeSignal) {

        log.info("Running Signal#: {}", tradeSignal.getSignal());

        if (Objects.isNull(tradeSignal.getType())) {
            tradeAlgo.cancelTrades();
            throw new TradeAppException("Trade signal type not found");
        }

        processingType(tradeSignal.getType());

        tradeSignal.getParams().forEach(paramList -> tradeAlgo.setAlgoParam(paramList.getParam(), paramList.getValue()));

        if (tradeSignal.getCalculate().equals(true)) {
            tradeAlgo.performCalc();
        }

        tradeAlgo.submitToMarket();
        tradeAlgo.doAlgo();

        log.info("End of Signal#: {}", tradeSignal.getSignal());
    }

    private void processingType(TradeType type) {
        switch (type) {
            case SETUP -> tradeAlgo.setUp();
            case REVERSE -> tradeAlgo.reverse();
        }
    }
}
