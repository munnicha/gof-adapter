package com.munnicha.patterns.gof.structural.adapter.model;

import java.util.List;

/**
 *
 * @author munnicha
 */
public interface StatisticsCalculator {
    public Double calculateAverage(List<Double> input);
}
