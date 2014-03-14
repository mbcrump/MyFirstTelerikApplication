package com.telerik.telerikapp;

/**
 * Created by Michael on 2/13/14.
 */
public class MonthResult {
    private String month;
    private double result;

    public MonthResult(String month, double result) {
        this.setMonth(month);
        this.setResult(result);
    }

    public double getResult() {
        return this.result;
    }

    public void setResult(double value) {
        this.result = value;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String value) {
        this.month = value;
    }
}

