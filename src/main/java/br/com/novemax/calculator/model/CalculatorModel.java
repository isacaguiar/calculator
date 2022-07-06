package br.com.novemax.calculator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculatorModel implements Serializable {
    private double value1;
    private double value2;
    private int operator;
    private double result;
    private String error;
}
