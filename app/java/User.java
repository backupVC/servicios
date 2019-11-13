import org.bson.types.ObjectId;


public class User {
	

	private int _id;
	private String first_name;
	private String last_name;
	private String email;
	
	public User(){
		
	}
	
	public User(int id, String first_name, String last_name, String email) {
		this._id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}
	public int getId() {
		return _id;
	}
	public void setId(int id) {
		this._id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + "]";
	}
	
	

}

