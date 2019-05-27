package com.evry.soapcxfproject.WS;


import javax.jws.WebService;


//@WebService(serviceName="BookService", endpointInterface="com.evry.soapcxfproject.WS.BookShelfService")

public class BookShelfServiceImpl implements BookShelfService {

	 public String getBookNameBasedOnISBN(String isbnNumber) {
		 
	        if(isbnNumber.equalsIgnoreCase("ISBN-2134")){
	            return "Microbiology";
	        }
	        return "Invalid_ISBN_Number";
	    }
}
