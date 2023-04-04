package vn.sapo.demo.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import vn.sapo.demo.CalculatorService;
import vn.sapo.demo.dal.CalculatorHistory;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    CalculatorService calculatorService;

    @Test
    void shouldPlusSuccess() throws Exception {

        var json = "{\"firstNumber\": 1, \"secondNumber\": 2}";

        when(calculatorService.plus(eq(1), eq(2))).thenReturn(3);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/calculator/plus")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(3));

    }

    @Test
    void shouldMinusSuccess() throws Exception {

        var json = "{\"firstNumber\": 2, \"secondNumber\": 1}";

        when(calculatorService.minus(eq(2), eq(1))).thenReturn(1);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/calculator/minus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(1));

    }

    @Test
    void shouldMultiSuccess() throws Exception {

        var json = "{\"firstNumber\": 1, \"secondNumber\": 2}";

        when(calculatorService.multi(eq(1), eq(2))).thenReturn(2);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/calculator/multi")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(2));

    }

    @Test
    void shouldDivideSuccess() throws Exception {
        var json = "{\"firstNumber\": 2, \"secondNumber\": 1}";

        when(calculatorService.divide(eq(2), eq(1))).thenReturn(2);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/calculator/divide")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
        )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(2));
    }

    @Test
    void shouldGetByOperator() throws Exception {
        // input element include : {firsNumber, secondNumber, result, operator(0 : PLUS, 1 : MINUS, 2 : MULTI, 3 : DIVIDE)}
        int input[][] = {
                {1, 2, 3, 0},
                {2, 3, 5, 0}
        };
        // save from input
        var categories = new ArrayList<CalculatorHistory>();

        for(int i = 0; i < input.length; i++){
            categories.add(new CalculatorHistory());
            categories.get(i).setId(i + 1);
            categories.get(i).setFirstNumber(input[i][0]);
            categories.get(i).setSecondNumber(input[i][1]);
            categories.get(i).setResult(input[i][2]);
            categories.get(i).setOperatorByIndex(input[i][3]);
        }

        when(calculatorService.getHistoryByOperator(CalculatorHistory.Operator.PLUS)).thenReturn(categories);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/calculator/operator")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("operator", "PLUS")
        )

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(categories.get(0).getId()))
                .andExpect(jsonPath("$[1].id").value(categories.get(1).getId()));

    }

    @Test
    void shouldGetByTime() throws Exception {
        // input element include : {firsNumber, secondNumber, result, operator(0 : PLUS, 1 : MINUS, 2 : MULTI, 3 : DIVIDE)}
        int input[][] = {
                {1, 2, 3, 0},
                {2, 1, 1, 1},
                {2, 1, 2, 2},
                {2, 1, 2, 3},
        };
        // save from input
        var categories = new ArrayList<CalculatorHistory>();

        for(int i = 0; i < input.length; i++){
            categories.add(new CalculatorHistory());
            categories.get(i).setId(i + 1);
            categories.get(i).setFirstNumber(input[i][0]);
            categories.get(i).setSecondNumber(input[i][1]);
            categories.get(i).setResult(input[i][2]);
            categories.get(i).setOperatorByIndex(input[i][3]);
        }

        Instant end = Instant.now().plus(1, ChronoUnit.MINUTES);
        Instant start = end.minus(2, ChronoUnit.MINUTES);

        when(calculatorService.getHistoryByTime(start, end)).thenReturn(categories);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("start", start.toString());
        params.add("end", end.toString());

        mockMvc.perform(
                MockMvcRequestBuilders.get("/calculator/time")
                        .contentType(MediaType.APPLICATION_JSON)
                        .params(params)
        )

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(4))
                .andExpect(jsonPath("$[0].id").value(categories.get(0).getId()))
                .andExpect(jsonPath("$[1].id").value(categories.get(1).getId()));

    }

}