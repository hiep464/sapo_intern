package vn.sapo.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import vn.sapo.demo.dal.CalculatorHistory;
import vn.sapo.demo.dal.CalculatorHistoryRepository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Import(AppTestConfiguration.class)
@DataJpaTest
class CalculatorServiceTest {

    @Autowired
    CacheService cacheService;
    @Autowired
    CalculatorHistoryRepository calculatorHistoryRepository;

    @Test
    void shouldPlusSuccess() {
        var service = new CalculatorService(cacheService, calculatorHistoryRepository);
        var firstNumber = 1;
        var secondNumber = 2;
        cacheService.set("2_plus_3", 5);
        //when
        var result = service.plus(firstNumber, secondNumber);
        var resultCache = service.plus(2, 3);
        //then
        assertEquals(3, result);
        assertEquals(5, resultCache);

        var data = calculatorHistoryRepository.findAll();
        assertEquals(2, data.size());
        assertEquals(3, data.get(0).getResult());
        assertEquals(1, data.get(0).getFirstNumber());
        assertEquals(2, data.get(0).getSecondNumber());
        assertEquals(CalculatorHistory.Operator.PLUS, data.get(0).getOperator());

        assertEquals(5, data.get(1).getResult());
        assertEquals(2, data.get(1).getFirstNumber());
        assertEquals(3, data.get(1).getSecondNumber());
        assertEquals(CalculatorHistory.Operator.PLUS, data.get(1).getOperator());
    }

    @Test
    void shouldMinusSuccess() {
        var service = new CalculatorService(cacheService, calculatorHistoryRepository);
        var firstNumber = 1;
        var secondNumber = 2;
        cacheService.set("3_minus_3", 0);
        //when
        var result = service.minus(firstNumber, secondNumber);
        var resultCache = service.minus(3, 3);
        //then
        assertEquals(-1, result);
        assertEquals(0, resultCache);

        var data = calculatorHistoryRepository.findAll();
        assertEquals(2, data.size());
        assertEquals(-1, data.get(0).getResult());
        assertEquals(1, data.get(0).getFirstNumber());
        assertEquals(2, data.get(0).getSecondNumber());
        assertEquals(CalculatorHistory.Operator.MINUS, data.get(0).getOperator());

        assertEquals(0, data.get(1).getResult());
        assertEquals(3, data.get(1).getFirstNumber());
        assertEquals(3, data.get(1).getSecondNumber());
        assertEquals(CalculatorHistory.Operator.MINUS, data.get(1).getOperator());
    }

    @Test
    void shouldMultiSuccess() {
        var service = new CalculatorService(cacheService, calculatorHistoryRepository);
        var firstNumber = 1;
        var secondNumber = 2;
        cacheService.set("3_multi_3", 9);
        //when
        var result = service.multi(firstNumber, secondNumber);
        var resultCache = service.multi(3,3);
        //then
        assertEquals(2, result);
        assertEquals(9, resultCache);

        var data = calculatorHistoryRepository.findAll();
        assertEquals(2, data.size());
        assertEquals(2, data.get(0).getResult());
        assertEquals(1, data.get(0).getFirstNumber());
        assertEquals(2, data.get(0).getSecondNumber());
        assertEquals(CalculatorHistory.Operator.MULTI, data.get(0).getOperator());

        assertEquals(9, data.get(1).getResult());
        assertEquals(3, data.get(1).getFirstNumber());
        assertEquals(3, data.get(1).getSecondNumber());
        assertEquals(CalculatorHistory.Operator.MULTI, data.get(1).getOperator());
    }

    @Test
    void shouldDivideSuccess() {
        var service = new CalculatorService(cacheService, calculatorHistoryRepository);
        var firstNumber = 2;
        var secondNumber = 1;
        cacheService.set("3_divide_3", 1);
        //when
        var result = service.divide(firstNumber, secondNumber);
        var resultCache = service.divide(3, 3);
        //then
        assertEquals(2, result);
        assertEquals(1, resultCache);

        var data = calculatorHistoryRepository.findAll();
        assertEquals(2, data.size());
        assertEquals(2, data.get(0).getResult());
        assertEquals(2, data.get(0).getFirstNumber());
        assertEquals(1, data.get(0).getSecondNumber());
        assertEquals(CalculatorHistory.Operator.DIVIDE, data.get(0).getOperator());

        assertEquals(1, data.get(1).getResult());
        assertEquals(3, data.get(1).getFirstNumber());
        assertEquals(3, data.get(1).getSecondNumber());
        assertEquals(CalculatorHistory.Operator.DIVIDE, data.get(1).getOperator());
    }

    @Test
    void shouldGetHistoryByOperatorSuccess(){
        // input element include : {firsNumber, secondNumber, result, operator(0 : PLUS, 1 : MINUS, 2 : MULTI, 3 : DIVIDE)}
        int input[][] = {
                {1, 2, 3, 0},
                {2, 1, 1, 1},
                {2, 1, 2, 2},
                {2, 1, 2, 3},
                {2, 3, 5, 0},
                {3, 2, 1, 1},
                {2, 3, 6, 2},
                {4, 2, 2, 3}
        };
        // save from input
        var categories = new ArrayList<CalculatorHistory>();
        var service = new CalculatorService(cacheService, calculatorHistoryRepository);

        for(int i = 0; i < input.length; i++){
            categories.add(new CalculatorHistory());
            categories.get(i).setFirstNumber(input[i][0]);
            categories.get(i).setSecondNumber(input[i][1]);
            categories.get(i).setResult(input[i][2]);
            categories.get(i).setOperatorByIndex(input[i][3]);
            calculatorHistoryRepository.save(categories.get(i));
        }
        //when
        var data = service.getHistoryByOperator(CalculatorHistory.Operator.PLUS);
        //then
        int output[][] = {
                {1, 2, 3, 0},
                {2, 3, 5, 0}
        };
        assertEquals(output.length, data.size());

        for(int i = 0; i < data.size(); i++){
            assertEquals(output[i][0], data.get(i).getFirstNumber());
            assertEquals(output[i][1], data.get(i).getSecondNumber());
            assertEquals(output[i][2], data.get(i).getResult());
            assertEquals(CalculatorHistory.Operator.getByIndex(output[i][3]), data.get(i).getOperator());
        }
    }

    @Test
    void shouldGetHistoryByTime(){
        // input element include : {firsNumber, secondNumber, result, operator(0 : PLUS, 1 : MINUS, 2 : MULTI, 3 : DIVIDE)}
        int input[][] = {
                {1, 2, 3, 0},
                {2, 1, 1, 1},
                {2, 1, 2, 2},
                {2, 1, 2, 3},
        };
        // save from input
        var categories = new ArrayList<CalculatorHistory>();
        var service = new CalculatorService(cacheService, calculatorHistoryRepository);

        for(int i = 0; i < input.length; i++){
            categories.add(new CalculatorHistory());
            categories.get(i).setFirstNumber(input[i][0]);
            categories.get(i).setSecondNumber(input[i][1]);
            categories.get(i).setResult(input[i][2]);
            categories.get(i).setOperatorByIndex(input[i][3]);
            calculatorHistoryRepository.save(categories.get(i));
        }

        Instant end = Instant.now().plus(1, ChronoUnit.MINUTES);
        Instant start = end.minus(2, ChronoUnit.MINUTES);
        // when
        var data = service.getHistoryByTime(start, end);
        // then
        assertEquals(4, data.size());
        for(int i = 0; i < data.size(); i++){
            assertEquals(true, data.get(i).getCreatedAt().isAfter(start));
            assertEquals(true, data.get(i).getCreatedAt().isBefore(end));
        }
    }
}