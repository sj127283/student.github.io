package student_bo;

public class add_bo 
{
		private String name,email, phone,doj,eoj,adhar,id;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public add_bo() {
			super();
		}
		@Override
		public String toString() {
			return "add_bo [name=" + name + ", email=" + email + ", phone=" + phone + ", doj=" + doj + ", eoj=" + eoj
					+ ", adhar=" + adhar + ", id=" + id + "]";
		}
		public add_bo(String name, String email, String phone, String doj, String eoj, String adhar, String id) {
			super();
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.doj = doj;
			this.eoj = eoj;
			this.adhar = adhar;
			this.id = id;
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
		public String getDoj() {
			return doj;
		}
		public void setDoj(String doj) {
			this.doj = doj;
		}
		public String getEoj() {
			return eoj;
		}
		public void setEoj(String eoj) {
			this.eoj = eoj;
		}
		public String getAdhar() {
			return adhar;
		}
		public void setAdhar(String adhar) {
			this.adhar = adhar;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
}
