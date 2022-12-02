package com.db.trading.repository;

import com.db.trading.entity.TradeSignal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeSignalRepository extends JpaRepository<TradeSignal, Long> {
    TradeSignal findFirstBySignalOrderByIdDesc(int signalNr);
}
