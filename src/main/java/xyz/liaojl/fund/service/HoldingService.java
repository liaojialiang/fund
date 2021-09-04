package xyz.liaojl.fund.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.liaojl.fund.common.CommonException;
import xyz.liaojl.fund.entity.Holding;
import xyz.liaojl.fund.repository.HoldingRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HoldingService {
    @Autowired
    private HoldingRepository holdingRepository;

    public Holding updateHolding(Holding holding) {
        if (holding.getId() == null || !holdingRepository.existsById(holding.getId()))
            throw new CommonException("Fund Id not exists!");
        return holdingRepository.save(holding);
    }

    public void deleteHolding(Long id) {
        holdingRepository.deleteById(id);
    }

    public Holding add(Holding holding) {
        if (holdingRepository.existsByCode(holding.getCode()))
            throw new CommonException("Fund with code:" + holding.getCode() + "already exists!");
        holding.setCreateTime(LocalDateTime.now());
        return holdingRepository.save(holding);
    }

    public Holding get(Long id) {
        return holdingRepository.findById(id).orElse(new Holding());
    }

    public List<Holding> getAll() {
        return holdingRepository.findAll();
    }
}
