package com.evry.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestEvenOddProgram {
	
	 @Test
	 public void testEvenOddNumber(){
		 EvenOddProgram program = new EvenOddProgram();
	        assertEquals("10 is a even number", true, program.isEvenNumber(10));
	    }

}
