package br.com.novemax.calculator.service;

import br.com.novemax.calculator.model.CalculatorModel;

public interface CalculatorService {
    CalculatorModel execute(String value1, String value2, String operator);
}
