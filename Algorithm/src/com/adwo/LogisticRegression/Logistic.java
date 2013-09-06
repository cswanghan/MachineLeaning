package com.adwo.LogisticRegression;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hanwang
 * Date: 4/1/2013
 * Time: 
 * To change this template use File | Settings | File Templates.
 */
public class Logistic {

    /** the learning rate */
    private double rate;

    /** the weight to learn */
    private double[] weights;

    /** the number of iterations */
    private int ITERATIONS = 3000;

    public Logistic(int n) {
        this.rate = 0.0001;
        weights = new double[n];
    }

    private double sigmoid(double z) {
        return 1 / (1 + Math.exp(-z));
    }

    public void train(List<Instance> instances) {
        for (int n=0; n<ITERATIONS; n++) {
            double lik = 0.0;
            for (int i=0; i<instances.size(); i++) 
            {
        	double[] x = instances.get(i).getX();
                double predicted = classify(x);
                int label = instances.get(i).getLabel();
                for (int j=0; j<weights.length; j++) 
                {
                    weights[j] = weights[j] + rate * (label - predicted) * x[j];
                }
                // not necessary for learning
                lik += label * Math.log(classify(x)) + (1-label) * Math.log(1- classify(x));
            }
            System.out.println("iteration: " + n + " " + Arrays.toString(weights) + " mle: " + lik);
        }
    }

    private double classify(double[] x) {
        double logit = .0;
        for (int i=0; i<weights.length;i++)  {
            logit += weights[i] * x[i];
        }
        return sigmoid(logit);
    }


    public static void main(String[] args) throws FileNotFoundException {
        List<Instance> instances = DataSet.readDataSet("externalsrc/trainingsamplenew");
        Logistic logistic = new Logistic(4);
        logistic.train(instances);
        
        double[] p23 = {17,52,10292,3525};	//1
        double[] p24 = {4,24,8,569};		//1
        double[] p25 = {60,170,4100,1680};	//1
        double[] p100 = {5,18,121486,1704};	//0
        double[] p99 = {37,94,10810,7605};	//0
        double[] p98 = {6,18,7790,4900};	//0
        
        System.out.println("p23 = " + logistic.classify(p23));		//0
        System.out.println("p24 = " + logistic.classify(p24));		//0
        System.out.println("p25 = " + logistic.classify(p25));		//0
        System.out.println("p100 = " + logistic.classify(p100));	//0
        System.out.println("p99 = " + logistic.classify(p99));		//0
        System.out.println("p98 = " + logistic.classify(p98));		//0
    }
}
