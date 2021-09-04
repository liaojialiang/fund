package xyz.liaojl.fund.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.liaojl.fund.entity.Holding;

@Repository
public interface HoldingRepository extends CrudRepository<Holding, Long> {
}
