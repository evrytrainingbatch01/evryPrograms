package com.evry.basicExamples;


interface inter{
	public void add(int a,int b);
		
	}


public class MethodRefrenceExampleDemo  {
	
	public static void sum(int a,int b) {
		
		System.out.println("Sum :"+(a+b));
		
	}

	public static void main(String[] args) {

		inter i=MethodRefrenceExampleDemo::sum;
		i.add(20,30);
		
	}

}
