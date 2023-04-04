package vn.sapo.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.sapo.demo.CalculatorService;
import vn.sapo.demo.dal.CalculatorHistory;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @PostMapping(value = "/plus")
    public CalculatorResponse plus(@RequestBody CalculatorRequest request) {
        var result = calculatorService.plus(request.getFirstNumber(), request.getSecondNumber());
        return new CalculatorResponse(result);
    }

    @PostMapping(value = "/minus")
    public CalculatorResponse minus(@RequestBody CalculatorRequest request) {
        var result = calculatorService.minus(request.getFirstNumber(), request.getSecondNumber());
        return new CalculatorResponse(result);
    }

    @PostMapping(value = "/multi")
    public CalculatorResponse multi(@RequestBody CalculatorRequest request) {
        var result = calculatorService.multi(request.getFirstNumber(), request.getSecondNumber());
        return new CalculatorResponse(result);
    }

    @PostMapping(value = "/divide")
    public CalculatorResponse divide(@RequestBody CalculatorRequest request) {
        var result = calculatorService.divide(request.getFirstNumber(), request.getSecondNumber());
        return new CalculatorResponse(result);
    }

    @GetMapping(value = "/operator")
    public ResponseEntity<Object> getByOperator(@RequestParam(name = "operator") CalculatorHistory.Operator operatorType){
        List<CalculatorHistory> calculatorHistories = calculatorService.getHistoryByOperator(operatorType);
        return new ResponseEntity<>(calculatorHistories, HttpStatus.OK);
    }

    @GetMapping(value = "/time")
    public ResponseEntity<Object> getByTime(@RequestParam(name = "start") Instant start, @RequestParam(name = "end") Instant end){
        List<CalculatorHistory> calculatorHistories = calculatorService.getHistoryByTime(start, end);
        return new ResponseEntity<>(calculatorHistories, HttpStatus.OK);
    }
}
