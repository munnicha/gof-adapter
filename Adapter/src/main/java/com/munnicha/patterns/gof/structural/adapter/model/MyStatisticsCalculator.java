package com.munnicha.patterns.gof.structural.adapter.model;

import java.util.List;

/**
 *
 * @author munnicha
 */
public class MyStatisticsCalculator implements StatisticsCalculator{

    @Override
    public Double calculateAverage(List<Double> input) {
        Double avg;
        int len=input.size();
        if(input.size()>0){
            Double sum=0.0;
            for(int i=0;i<len;i++){
                sum+=input.get(i);
            }
            avg=sum/len;
            return avg;
        }else{
            return null;
        }
    }
    
}
