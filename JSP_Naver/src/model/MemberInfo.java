package model;

public class MemberInfo {
	private String id;
	private String password;
	private String name;
	private String year;
	private String month;
	private String day;
	private String gender;
	private String email;
	private String phone;
	private String photo;
	
	public MemberInfo() { }

	public MemberInfo(String id, String password, String name, String year, String month, String day, String gender,
			String email, String phone, String photo) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.year = year;
		this.month = month;
		this.day = day;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.photo = photo;
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
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
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