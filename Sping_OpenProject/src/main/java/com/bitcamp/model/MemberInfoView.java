package com.bitcamp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder= { "id", "password", "name", "birthdate", "gender", "email", "phone", "photoName" })
public class MemberInfoView {
	
	private String id;
	private String password;
	private String name;
	private String birthdate;
	private String gender;
	private String email;
	private String phone;
	private String photoName;
	
	public MemberInfoView() { }
	
	
	public MemberInfoView(String id, String password, String name, String birthdate, String gender, String email, String phone, String photoName) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.photoName = photoName;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPhotoName() {
		return photoName;
	}


	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
}