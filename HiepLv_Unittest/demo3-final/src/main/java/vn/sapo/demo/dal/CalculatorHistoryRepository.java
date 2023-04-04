package vn.sapo.demo.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface CalculatorHistoryRepository extends JpaRepository<CalculatorHistory, Integer> {
    public List<CalculatorHistory> findAllByOperator(CalculatorHistory.Operator operator);

    public List<CalculatorHistory> findAllByCreatedAtBetween(Instant start, Instant end);
}
