package com.evry.soapcxfproject;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="BookRequestType")
@XmlAccessorType(XmlAccessType.FIELD)
public class BookRequestType {
	
	@XmlElement(name="isbnNumber")
	protected String isbnNumber;

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
	
	
	
	

}
 