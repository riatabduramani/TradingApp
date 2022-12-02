package com.db.trading.repository;

import com.db.trading.entity.TradeSignalSpecifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeSignalSpecificationRepository extends JpaRepository<TradeSignalSpecifications, Long> {
}
