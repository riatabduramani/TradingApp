package com.db.trading.service;

import com.db.trading.dto.TradeSignalRequest;
import com.db.trading.entity.TradeSignal;
import com.db.trading.entity.TradeSignalSpecifications;
import com.db.trading.repository.TradeSignalRepository;
import com.db.trading.repository.TradeSignalSpecificationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class TradeSignalServiceImpl implements TradeSignalService {

    private final TradeSignalRepository signalRepository;
    private final TradeSignalSpecificationRepository specificationRepository;

    public TradeSignal getTradeSignal(int signalNr) {
        return signalRepository.findFirstBySignalOrderByIdDesc(signalNr);
    }

    @Transactional
    public void saveTradeSignal(TradeSignalRequest request) {
        TradeSignal tradeSignal = tradeSignalMapper(request);
        signalRepository.save(tradeSignal);
        specificationRepository.saveAll(getTradeSignalSpecifications(request.getSpecifications(), tradeSignal.getId()));
    }

    private ArrayList<TradeSignalSpecifications> getTradeSignalSpecifications(List<TradeSignalRequest.Specification> specifications, Long signalId) {
        ArrayList<TradeSignalSpecifications> spec = new ArrayList<>();
        specifications.forEach(s -> spec.add(tradeSignalSpecificationMapper(s, signalId)));
        return spec;
    }

    private TradeSignal tradeSignalMapper(TradeSignalRequest request) {
        TradeSignal tradeSignalEntity = new TradeSignal();
        tradeSignalEntity.setSignal(request.getSignal());
        tradeSignalEntity.setType(request.getType());
        tradeSignalEntity.setCalculate(request.getCalculate());
        return tradeSignalEntity;
    }

    private TradeSignalSpecifications tradeSignalSpecificationMapper(TradeSignalRequest.Specification s, Long signalId) {
        TradeSignalSpecifications specification = new TradeSignalSpecifications();
        specification.setSignal(signalId);
        specification.setParam(s.getParam());
        specification.setValue(s.getValue());
        return specification;
    }
}
