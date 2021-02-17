package com.munnicha.patterns.gof.structural.adapter;

import com.munnicha.patterns.gof.structural.adapter.model.Calculator;
import com.munnicha.patterns.gof.structural.adapter.model.CalculatorAdapter;
import com.munnicha.patterns.gof.structural.adapter.model.MyCalculator;

/**
 *
 * @author munnicha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Adapter pattern");
        
        String command;
        double[] input;
        //Call MyCalculator
        //1.
        Calculator myCalc=new MyCalculator();
        command="sum";
        input = new double[]{1.0,2.0,3.0,4.5};
        double result=myCalc.operation(command,input);
        businessLogic(result);
        //2.
        command="product";
        input=new double[]{1.0,2.0,3.0,0.0};
        result=myCalc.operation(command,input);
        businessLogic(result);
        
        //Call MyStatisticsCalculator by using adapter directly
        //1.
        Calculator myCalcAdapter = new CalculatorAdapter("statistics");
        command="avg";
        input=new double[]{1.0,2.0,3.0,0.0};
        result=myCalcAdapter.operation(command,input);
        businessLogic(result);
        //2.
        command="avg";
        input=new double[]{8.9,2.7,3.2,12.0};
        result=myCalcAdapter.operation(command,input);
        businessLogic(result);
        
        //Call MyCalculator again and use adapter as a new feature of MyCalculator
        //1.
        command="avg";
        input=new double[]{1.0,2.0,3.0,4.5};
        result=myCalc.operation(command,input);
        businessLogic(result);
        //2.
        command="avg";
        input=new double[]{6.0,7.1,3.9,19.95};
        result=myCalc.operation(command,input);
        businessLogic(result);
        
    }
    
    private static void businessLogic(double result){
        if(result>5.0){
            System.out.println("Hurray, it is more than 5: "+result);
        }else{
            System.out.println("Sorry, it is under 5: "+result);
        }
    }
}
