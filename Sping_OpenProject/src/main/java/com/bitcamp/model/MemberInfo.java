package com.bitcamp.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberInfo {
	//private int mIdx;
	private String id;
	private String password;
	private String name;
	private String year;
	private String month;
	private String day;
	private String gender;
	private String email;
	private String phone;
	
	//파일 업로드를 위한 변수
	private MultipartFile photo;
	
	//파일 이름을 저장하기 위한 변수
	private String photoName;
	
/*	public int getmIdx() {
		return mIdx;
	}

	public void setmIdx(int mIdx) {
		this.mIdx = mIdx;
	}*/

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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
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
	
	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public boolean matchPassword(String login_password) {
		return password != null && password.equals(login_password);
	}

	@Override
	public String toString() {
		return "MemberInfo [id=" + id + ", password=" + password + ", name=" + name + ", year=" + year + ", month="
				+ month + ", day=" + day + ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", photo=" + photo + "]";
	}
}