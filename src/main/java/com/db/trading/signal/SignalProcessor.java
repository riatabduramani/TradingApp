package com.db.trading.signal;

import com.db.library.algolib.Algo;
import com.db.library.algolib.SignalHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class SignalProcessor implements SignalHandler {

    @Override
    public void handleSignal(int signal) {
        log.info("Handle Signal: {}", signal);

        Algo algo = new Algo();
        switch (signal) {
            case 1 -> {
                algo.setUp();
                algo.setAlgoParam(1, 60);
                algo.performCalc();
                algo.submitToMarket();
            }
            case 2 -> {
                algo.reverse();
                algo.setAlgoParam(1, 80);
                algo.submitToMarket();
            }
            case 3 -> {
                algo.setAlgoParam(1, 90);
                algo.setAlgoParam(2, 15);
                algo.performCalc();
                algo.submitToMarket();
            }
            default -> algo.cancelTrades();
        }

        algo.doAlgo();
    }
}
