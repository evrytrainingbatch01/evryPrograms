package com.evry.soapcxfproject.WS;


import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Use;
import javax.jws.soap.SOAPBinding.Style;



@WebService(name="BookShelfService")
public interface BookShelfService  {
	
	//@WebResult(name="bookResponse")
	
	@WebMethod
	public String getBookNameBasedOnISBN(String isbnNumber);
	
	

}
