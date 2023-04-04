package vn.sapo.demo;

import org.springframework.stereotype.Service;
import vn.sapo.demo.dal.CalculatorHistory;
import vn.sapo.demo.dal.CalculatorHistoryRepository;

import java.time.Instant;
import java.util.List;

@Service
public class CalculatorService {

    private final CacheService cacheService;
    private final CalculatorHistoryRepository calculatorHistoryRepository;

    public CalculatorService(CacheService cacheService,
                             CalculatorHistoryRepository calculatorHistoryRepository) {
        this.cacheService = cacheService;
        this.calculatorHistoryRepository = calculatorHistoryRepository;
    }

    public int plus(int firstNumber, int secondNumber) {
        var cacheKey = firstNumber + "_plus_" + secondNumber;
        var data = cacheService.get(cacheKey);
        if (data != null) {
            saveHistory(firstNumber, secondNumber, data, 0);
            return data;
        }

        var result = firstNumber + secondNumber;

        saveHistory(firstNumber, secondNumber, result, 0);
        cacheService.set(cacheKey, result);
        return result;
    }

    public int minus(int firstNumber, int secondNumber) {
        var cacheKey = firstNumber + "_minus_" + secondNumber;
        var data = cacheService.get(cacheKey);
        if (data != null) {
            saveHistory(firstNumber, secondNumber, data, 1);
            return data;
        }

        var result = firstNumber - secondNumber;

        saveHistory(firstNumber, secondNumber, result, 1);
        cacheService.set(cacheKey, result);
        return result;
    }

    public int multi(int firstNumber, int secondNumber) {
        var cacheKey = firstNumber + "_multi_" + secondNumber;
        var data = cacheService.get(cacheKey);
        if (data != null) {
            saveHistory(firstNumber, secondNumber, data, 2);
            return data;
        }

        var result = firstNumber * secondNumber;

        saveHistory(firstNumber, secondNumber, result, 2);
        cacheService.set(cacheKey, result);
        return result;
    }

    public int divide(int firstNumber, int secondNumber) {
        var cacheKey = firstNumber + "_divide_" + secondNumber;
        var data = cacheService.get(cacheKey);
        if (data != null) {
            saveHistory(firstNumber, secondNumber, data, 3);
            return data;
        }

        var result = firstNumber / secondNumber;

        saveHistory(firstNumber, secondNumber, result, 3);
        cacheService.set(cacheKey, result);
        return result;
    }

    private void saveHistory(int firstNumber, int secondNumber, int result, int operator) {
        var history = new CalculatorHistory();
        history.setFirstNumber(firstNumber);
        history.setSecondNumber(secondNumber);
        history.setOperatorByIndex(operator);
        history.setResult(result);
        calculatorHistoryRepository.save(history);
    }

    public List<CalculatorHistory> getHistoryByOperator(CalculatorHistory.Operator operator){
        List<CalculatorHistory> calculatorHistories = calculatorHistoryRepository.findAllByOperator(operator);
        return calculatorHistories;
    }

    public List<CalculatorHistory> getHistoryByTime(Instant start, Instant end){
        return calculatorHistoryRepository.findAllByCreatedAtBetween(start, end);
    }
}
