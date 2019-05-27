package com.evry.basicExamples;

import java.util.function.Predicate;

public class PredicateExampleDemo {

	public static void main(String[] args) {
		/*
		 * Predicate<Integer> p = i -> i % 2 == 0;
		 * 
		 * System.out.println(p.test(10));
		 * 
		 * System.out.println(p.test(11));
		 */
		
		String[] s= {"ARP","Raki","Akshay","Lohith"};
		
		Predicate<String> p = s1 -> s1.length()>5; //declaaring 
		
		for (String s2 : s) {
			
			if(p.test(s2))
				System.out.println(s2);
			
		}
		
		
	}

}
