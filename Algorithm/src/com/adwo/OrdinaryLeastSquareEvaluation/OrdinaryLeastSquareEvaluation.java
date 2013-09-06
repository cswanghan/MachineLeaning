/**
 * 
 */
package com.adwo.OrdinaryLeastSquareEvaluation;

import java.util.ArrayList;

/**
 * @author HanWang
 *
 */
public class OrdinaryLeastSquareEvaluation {

	private static double beta_a;
	private static double beta_b;
	
	public void OrdinaryLeastSquare(double[] a, double[] b)
	{
		/*
		 * beta_a = [(n * sum(x[i] * y[i])) - sum(x[i] * y[i])] / [(n * sum(x[i] * x[i])) - sum(x[i] * x[i])]
		 * beta_b = [sum(x[i] * x[i]) * sum(y[i]) - sum(x[i]) * sum(x[i] * y[i])] / [(n * sum(x[i] * x[i])) - sum(x[i] * x[i])]
		 */
		
		double temp_a = 0, temp_b = 0, temp_c = 0, temp_d = 0;
		for(int iter = 0; iter < a.length; iter++)
		{
			temp_a += a[iter] * a[iter];
			temp_b += a[iter];
			temp_c += a[iter] * b[iter];
			temp_d += b[iter];
		}
		beta_a = (temp_c * a.length - temp_b * temp_d) / (temp_a * a.length - temp_b * temp_b);
		beta_b = (temp_a * temp_d - temp_b * temp_c) / (temp_a * a.length - temp_b * temp_b);
	}
	
	public double getY (double x){
		return beta_a * x + beta_b;
	}
	
	public void print(){
		System.out.println("Beta_a = " + beta_a + "|" + "Beta_b = " + beta_b);
	}
	
	public static void main(String[] args) {
		
		double[] x = {1.1, 2.1, 3.1, 4.2};
		//int size = x.length;
		double[] y = {3.1, 4.2, 5.6, 7.8};
		double[] new_x = {1.1, 2.1, 0.9, 2.2};
		OrdinaryLeastSquareEvaluation ols = new OrdinaryLeastSquareEvaluation();
		ols.OrdinaryLeastSquare(new_x, y);
		ols.print();
		
		double test_x = 0.9;
		System.out.println("Input x is : " + test_x);
		System.out.println("result Y is : " + ols.getY(test_x));
	}

}
