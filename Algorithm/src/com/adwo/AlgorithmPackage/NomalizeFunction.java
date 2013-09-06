/**
 * 
 */
package com.adwo.AlgorithmPackage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.adwo.LogisticRegression.DataSet;
import com.adwo.AlgorithmPackage.Instance;

/**
 * @author dev
 * @description This class is a basic implementation of Normalization function
 */
public class NomalizeFunction {

	public static int Array_length = 2865;
	/**
	 * @param args
	 * @throws Exception 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub

		//int[] testarray = {3,2,1,5,9,10};
		NomalizeFunction nf = new NomalizeFunction();
		//int max = nf.FindMax(testarray);
		//int min = nf.FindMin(testarray);
		//double normalanswer = nf.LinearNomalizer(max, min, 4);
		//System.out.println("linear = " + nf.LinearNomalizer(max, min, 4));
		//System.out.println("log = " + nf.LogNomalizer(4));
		//System.out.println("atan = " + nf.aTanNomalizer(4));
		List<Instance> instances = nf.ArrayGenerator("externalsrc/allbookstatistic");
		int[] downnumarray = instances.get(0).getX();
		int[] opennumarray = instances.get(1).getX();
		int[] staytimearray = instances.get(2).getX();
		int[] averagestaytimearray = instances.get(3).getX();
		nf.NormalizerFactory(averagestaytimearray);
	}
	
	public void NormalizerFactory(int[] testarray)
	{
		int max = FindMax(testarray);
		int min = FindMin(testarray);
		for(int i = 0; i < testarray.length; i++)
			System.out.println(LinearNomalizer(max, min, testarray[i]));
	}
	
	public List<Instance> ArrayGenerator(String inputfilepath) throws IOException, Exception
	{
		List<Instance> dataset = new ArrayList<Instance>();
		String input = inputfilepath;
		InputStreamReader InputFile = new InputStreamReader(new FileInputStream(input),"UTF-8");
		BufferedReader FileReader = new BufferedReader(InputFile);
		String temp = null;
		int[] sumdown = new int[Array_length];
		int[] sumopen = new int[Array_length];
		int[] sumstaytime = new int[Array_length];
		int[] sumaveragestaytime = new int[Array_length];
		int count = 0;
		while((temp = FileReader.readLine()) != null)
		{
			if(!temp.contains("#"))
			{
				String[] details = temp.split("\t");
				sumdown[count] = Integer.valueOf(details[1]);
				sumopen[count] = Integer.valueOf(details[2]);
				sumstaytime[count] = Integer.valueOf(details[3]);
				sumaveragestaytime[count] = Integer.valueOf(details[4]);
				count++;
			}
			
		}
		Instance downins = new Instance(sumdown);
		Instance openins = new Instance(sumopen);
		Instance stayins = new Instance(sumstaytime);
		Instance avgins = new Instance(sumaveragestaytime);
		dataset.add(downins);
		dataset.add(openins);
		dataset.add(stayins);
		dataset.add(avgins);
		return dataset;
	}
	
	public double LogNomalizer(int x)
	{
		double y = Math.log10(x);
		return y;
	}
	
	public double aTanNomalizer(int x)
	{
		double y = Math.atan(x)/Math.PI;
		return y;
	}
	
	public double LinearNomalizer(int max, int min, int x)
	{
		/*
		 * @description:
		 * 	y = (x - min)/(max - min)
		 */
		double answer = 0.0;
		answer = (double)(x - min)/(max - min);
		return answer;
	}

	public int FindMin(int[] InputArray)
	{
		int min = InputArray[0];
		for(int i = 0; i < InputArray.length; i++)
		{
			if(min > InputArray[i])
				min = InputArray[i];
		}
		return min;
	}
	
	public int FindMax(int[] InputArray)
	{
		int max = InputArray[0];
		for(int i = 0; i < InputArray.length; i++)
		{
			if(max < InputArray[i])
				max = InputArray[i];
		}
		return max;
	}
}
