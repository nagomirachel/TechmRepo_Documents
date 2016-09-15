package com.mums.bean;

import java.io.Serializable;


public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String cdsId;
    
    private String firstName;
    
    private String lastName;
	
	
	public String getCdsId() {
		return cdsId;
	}
	public void setCdsId(String cdsId) {
		this.cdsId = cdsId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}