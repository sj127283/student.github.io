package student_bo;

public class login_bo
{
	
	
	private String user_name,name ,dob,city,course;
	private int password, confirm_pass;
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int getConfirm_pass() {
		return confirm_pass;
	}
	public void setConfirm_pass(int confirm_pass) {
		this.confirm_pass = confirm_pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public login_bo(String user_name, int password, int confirm_pass, String name, String dob, String city,
			String course) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.confirm_pass = confirm_pass;
		this.name = name;
		this.dob = dob;
		this.city = city;
		this.course = course;
	}
	@Override
	public String toString() {
		return "login_bo [user_name=" + user_name + ", password=" + password + ", confirm_pass=" + confirm_pass
				+ ", name=" + name + ", dob=" + dob + ", city=" + city + ", course=" + course + "]";
	}
	public login_bo() {
		super();
	}

}
