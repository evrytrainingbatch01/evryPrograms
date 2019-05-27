package com.evry.basicExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExampleDemo {

	public static void main(String[] args) {

		ArrayList<Integer> al =new ArrayList<Integer>();
		al.add(30);
		al.add(5);
		al.add(25);
		al.add(20);
		al.add(10);
		al.add(15);
		
		System.out.println(al);
		// the giiven no is odd or even 
	//	List<Integer> l=al.stream().filter(i->i%2==0).collect(Collectors.toList());
		
		// add 5 grace marks to each object 
		// List<Integer> l=al.stream().map(i->i+5).collect(Collectors.toList());
		
		// how many students failed in exam (I dont want list just count the members )
	// long l=al.stream().filter(i->i%2==0).count();
		
		// Ascinding and descending order of elements 
		List<Integer> l=al.stream().sorted((i1,i2)-> (i1>i2)?-1:(i1<i2)?1:0).collect(Collectors.toList());
		
		System.out.println(l);
		
	}

}
