package com.evry.basicExamples;

interface Drawable{  
  //  public void draw(String s); 
    
    int add(int a,int b);  
}  


public class FunctionalInterfaceDemo {

	public static void main(String[] args) {  
        int width=10;  
          
      /*  //with lambda  
        Drawable d2=(a)->{  
            System.out.println("Drawing "+width+"...."+a);  
        };  
        d2.draw("Arp");  
    }  */
	
	Drawable ad2=(int a,int b)->{  
        return (a+b);   
        };  
System.out.println(ad2.add(100,200));  
	
	}
}
