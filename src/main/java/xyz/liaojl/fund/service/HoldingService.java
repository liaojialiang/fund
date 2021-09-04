package xyz.liaojl.fund.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liaojl.fund.entity.Holding;
import xyz.liaojl.fund.repository.HoldingRepository;

@Service
public class HoldingService {
    @Autowired
    private HoldingRepository holdingRepository;

    public void updateHolding(Holding holding) {
        holdingRepository.save(holding);
    }
}
