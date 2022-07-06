package br.com.novemax.calculator.service.impl;

import br.com.novemax.calculator.model.CalculatorModel;
import br.com.novemax.calculator.service.CalculatorService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public CalculatorModel execute(String value1, String value2, String operator) {
        CalculatorModel calculatorModel = new CalculatorModel();
        try {
            calculatorModel.setValue1(getNumericValue(value1));
            calculatorModel.setValue2(getNumericValue(value2));
            calculatorModel.setOperator(getIntValue(operator));
            validOperation(calculatorModel.getOperator());
            executeOperation(calculatorModel);
        } catch (Exception e) {
            calculatorModel.setError(e.getMessage());
        }
        return calculatorModel;
    }

    private void validOperation(int operator) throws Exception {
        List<Integer> listOperator = Arrays.asList(1, 2, 3, 4);
        if(!listOperator.contains(operator)) {
            throw new Exception("Invalid operator!");
        }
    }

    private double getNumericValue(String strNum) throws Exception {
        if (strNum == null) {
            throw new Exception("Number is empty");
        }
        try {
            return Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            throw new Exception("Invalid number");
        }
    }

    private int getIntValue(String strNum) throws Exception {
        if (strNum == null) {
            throw new Exception("Operator is empty");
        }
        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            throw new Exception("Invalid operator");
        }
    }

    private void executeOperation(CalculatorModel calculatorModel) {
        double result = 0;
        if (calculatorModel.getOperator() == 1) {
            result = calculatorModel.getValue1() + calculatorModel.getValue2();
        } else if (calculatorModel.getOperator() == 2) {
            result = calculatorModel.getValue1() - calculatorModel.getValue2();
        } else if (calculatorModel.getOperator() == 3) {
            result = calculatorModel.getValue1() * calculatorModel.getValue2();
        } else if (calculatorModel.getOperator() == 4) {
            result = calculatorModel.getValue1() / calculatorModel.getValue2();
        }
        calculatorModel.setResult(result);
    }
}
