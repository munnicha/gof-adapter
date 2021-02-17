package com.munnicha.patterns.gof.structural.adapter.test;

import com.munnicha.patterns.gof.structural.adapter.model.Calculator;
import com.munnicha.patterns.gof.structural.adapter.model.CalculatorAdapter;
import com.munnicha.patterns.gof.structural.adapter.model.MyCalculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author munnicha
 */
public class AdapterTest {
    
    @Test
    public void testAdapter(){
        String command;
        double[] input;
        Calculator myCalc=new MyCalculator();
        command="sum";
        input = new double[]{1.0,2.0,3.0,4.5};
        double result1=myCalc.operation(command,input);
        
        command="product";
        input=new double[]{1.0,2.0,3.0,0.0};
        double result2=myCalc.operation(command,input);
        Calculator myCalcAdapter = new CalculatorAdapter("statistics");
        
        command="avg";
        input=new double[]{1.0,2.0,3.0,0.0};
        double result3=myCalcAdapter.operation(command,input);
        
        command="avg";
        input=new double[]{8.9,2.7,3.2,12.0};
        double result4=myCalcAdapter.operation(command,input);
        
        command="avg";
        input=new double[]{1.0,2.0,3.0,4.5};
        double result5=myCalc.operation(command,input);
        
        command="avg";
        input=new double[]{6.0,7.1,3.9,19.95};
        double result6=myCalc.operation(command,input);
        
        //assertation
        assertEquals(10.5,result1,0.0001);
        assertEquals(0.0,result2,0.0001);
        assertEquals(1.5,result3,0.0001);
        assertEquals(6.7,result4,0.0001);
        assertEquals(2.625,result5,0.0001);
        assertEquals(9.2375,result6,0.0001);   
    }
    
    @Test
    public void testAdapterNaN(){
        String command;
        double[] input;
        Calculator myCalc=new MyCalculator();
        command="sum";
        input = new double[0];
        double result1=myCalc.operation(command,input);
        
        command="avg";
        input=new double[0];
        double result2=myCalc.operation(command,input);
        
        command="sd";
        input=new double[0];
        double result3=myCalc.operation(command,input);
        
        //assertations
        assertEquals(Double.NaN,result1,0.0001);
        assertEquals(Double.NaN,result2,0.0001);  
        assertEquals(Double.NaN,result3,0.0001); 
        
    }
    
}
