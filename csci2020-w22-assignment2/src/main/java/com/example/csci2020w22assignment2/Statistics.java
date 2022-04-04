package com.example.csci2020w22assignment2;

import java.util.List;

public class Statistics {
    double minimum;
    double maximum;
    double average;

    public Statistics(List<Integer> column ) {
        double sum = 0;
        int val;

        for (int i = 0; i < column.size(); i++) {
            val = column.get(i);
            sum += val;

            if(i==0){
                minimum = val;
                maximum = val;
            }
            else{
                if (maximum < val){
                    maximum = val;
                }
                else if (minimum > val){
                    minimum = val;
                }
            }
        }

        average = sum/column.size();
    }

    public Statistics(List<Double> column, String typeDouble) {
        double sum = 0;
        double val;

        for (int i = 0; i < column.size(); i++) {
            val = column.get(i);
            sum += val;

            if(i==0){
                minimum = val;
                maximum = val;
            }
            else{
                if (maximum < val){
                    maximum = val;
                }
                else if (minimum > val){
                    minimum = val;
                }
            }
        }

        average = sum/column.size();
    }

    public double getMinimum() {
        return minimum;
    }

    public double getMaximum() {
        return maximum;
    }

    public double getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "minimum=" + minimum +
                ", maximum=" + maximum +
                ", average=" + String.format("%.2f",average) +
                '}';
    }
}
