package vn.sapo.demo.dal;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "calculator_histories")
public class CalculatorHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int firstNumber;
    private int secondNumber;
    private Operator operator;
    private int result;
    @CreationTimestamp
    private Instant createdAt;


    public enum Operator {
        PLUS, MINUS, MULTI, DIVIDE;
        public static Operator getByIndex(Integer index){
            switch (index){
                case 0:
                    return PLUS;
                case 1:
                    return MINUS;
                case 2:
                    return MULTI;
                case 3:
                    return DIVIDE;
                default:
                    return null;
            }
        }
    }

    public void setOperatorByIndex(Integer index){
        switch (index){
            case 0:
                setOperator(Operator.PLUS);
                break;
            case 1:
                setOperator(Operator.MINUS);
                break;
            case 2:
                setOperator(Operator.MULTI);
                break;
            case 3:
                setOperator(Operator.DIVIDE);
                break;
            default:
                System.out.println("Invalid Index");
        }
    }

}
