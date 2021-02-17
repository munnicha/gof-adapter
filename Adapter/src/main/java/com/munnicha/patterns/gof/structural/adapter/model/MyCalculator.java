package com.munnicha.patterns.gof.structural.adapter.model;

/**
 *
 * @author munnicha
 */
public class MyCalculator implements Calculator{
    
    CalculatorAdapter calcAdapter;

    @Override
    public double operation(String command, double[] input) {
        if("sum".equalsIgnoreCase(command)){
            return calculateSum(input);
        }else if("product".equalsIgnoreCase(command)){
            return calculateProduct(input);
        }else if("avg".equalsIgnoreCase(command)){
            //Statistics feature added here by using adapter
            calcAdapter=new CalculatorAdapter("statistics");
            return calcAdapter.operation(command, input);
        }else{
            return Double.NaN;
        }
    }
    
    private double calculateSum(double[] input){
        double sum=0.0;
        int len=input.length;
        if(len>0){
            for(int i=0;i<len;i++){
                sum+=input[i];
            }
        }else{
            return Double.NaN;
        }
        return sum;
    }
    
    private double calculateProduct(double[] input){
        double product=0.0;
        int len=input.length;
        if(len>0){
            for(int i=0;i<len;i++){
                product*=input[i];
            }
        }else{
            return Double.NaN;
        }
        return product;
    }
}
