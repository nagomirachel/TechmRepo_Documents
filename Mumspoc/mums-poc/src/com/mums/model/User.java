package com.mums.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
/**
 * @author Dinesh Rajput
 *
 */
@Entity
@Table(name="user")
//@XmlRootElement(name = "employee",namespace="com.java.model")
//@XmlAccessorType(XmlAccessType.NONE)

public class User implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@Column(name = "cdsid")
   // @XmlElement
	private String cdsId;
	@Column(name="first_name")
	private String firstName;
	@XmlElement
	@Column(name="last_name")
	private String lastName;
	
	//private DocumentGroup documentgroup;
	
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
