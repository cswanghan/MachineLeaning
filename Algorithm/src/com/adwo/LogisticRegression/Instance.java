package com.adwo.LogisticRegression;

/**
 * Created with IntelliJ IDEA.
 * User: hanwang
 * Date: 4/1/2013
 * Time: 
 * To change this template use File | Settings | File Templates.
 */
public class Instance {
    public int label;
    public double[] x;

    public Instance(int label, double[] x) {
        this.label = label;
        this.x = x;
    }

    public int getLabel() {
        return label;
    }

    public double[] getX() {
        return x;
    }
}
