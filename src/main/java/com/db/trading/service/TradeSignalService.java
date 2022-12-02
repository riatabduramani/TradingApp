package com.db.trading.service;

import com.db.trading.dto.TradeSignalRequest;
import com.db.trading.entity.TradeSignal;

public interface TradeSignalService {
    TradeSignal getTradeSignal(int signalNr);

    void saveTradeSignal(TradeSignalRequest tradeSignal);
}
