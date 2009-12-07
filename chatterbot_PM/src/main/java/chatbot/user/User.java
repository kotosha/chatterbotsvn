package chatbot.user;

public class User {


	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public static enum Nastroj{dobry,zly,wesoly,smutny,przygnebiony };
	
	private String message;
	public Nastroj nastroj;
	private String name;
	private int age;

	/**
	 * ustala nastroj użytkownika
	 */
	public Nastroj getNastroj() {
		return nastroj;
	}
	public void setNastroj(Nastroj nastroj) {
		this.nastroj = nastroj;
	}
	
	/**
	 * zdanie napisane przez u�ytkownika
	 */
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
