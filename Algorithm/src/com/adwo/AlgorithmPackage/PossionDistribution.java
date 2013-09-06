/**
 * 
 */
package com.adwo.AlgorithmPackage;

import java.util.Iterator;
import java.util.List;

/**
 * @author dev
 *
 */
public class PossionDistribution {
	
	/*
	 * @Description: This function will generate lambda in Possion Function 
	 * 		 by using the mean value of input
	 */
	public static double LambdaGenerator(int[] input)
	{
		double lamda = 0;
		
		for(int i = 1; i <= input.length; i++)
			lamda = (lamda + input[i-1]) / i;
		
		return lamda;
	}
	
	public static double PossionCalculator(int[] input, int factor)
	{
		double result = 1.0;
		
		double lamda = LambdaGenerator(input);
		
		double factorialresult = GetFactorialResult(factor);
		
		double exponentresult = getExponentValue(Math.E, factor);
		
		double exponentresult1 = getExponentValue(lamda,factor);
		
		result = (exponentresult1 / factorialresult) * exponentresult ;
		
		return result;
	}
	
	public static double GetFactorialResult(int factor)
	{
		double result = 1;
		for(int i = factor; i > 0; i--)
			result = result * i;
		return result;
	}
	
	public static double getExponentValue(double e2,int e) 
	{  
	        double result = 1;  
	        for(int i = 0; i < e; i++)  
	        {  
	            result = result * e2;  
	        }  
	        return result;  
	}  
	
	
	public static void main(String[] args)
	{
		int[] input = {2,5,7,3,6,4};
		double result = PossionCalculator(input,5);
		System.out.println(result);
	}
}
