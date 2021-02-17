package com.munnicha.patterns.gof.structural.adapter.model;

import java.util.ArrayList;

/**
 *
 * @author munnicha
 */
public class CalculatorAdapter implements Calculator{
    
    StatisticsCalculator statCalc;
    
    public CalculatorAdapter(String calculatorType){
        if("statistics".equalsIgnoreCase(calculatorType)){
            this.statCalc=new MyStatisticsCalculator();
        }
    }

    @Override
    public double operation(String command, double[] input) {
        if("avg".equalsIgnoreCase(command)){
            ArrayList<Double> convertedInput=new ArrayList<>();
            int len=input.length;
            if(len>0){
                Double number;
                for(int i=0;i<len;i++){
                    number=input[i];
                    convertedInput.add(number);
                }
                double result = statCalc.calculateAverage(convertedInput);
                return result;
            }else{
                return Double.NaN;
            }
        }else{
            return Double.NaN;
        }
    }
    
}
