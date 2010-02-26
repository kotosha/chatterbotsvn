package chatbot.user;

public class User {



	public static enum Nastroj{dobry,zly,wesoly,smutny,przygnebiony };
	public static enum Status{przywitany,nieprzywitany,pozegnany};
	
	private String message;
	public Nastroj nastroj;
	private String name;
	private int age;
	public Status status;
	private int countVulgarism = 0;

	public int getCountVulgarism() {
		return countVulgarism;
	}

	public void setCountVulgarism() {
		this.countVulgarism += 1;
	}


	/**
	 * Ustala akcje ktora nastapila
	 * @return
	 */
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
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
	

	public User(String name, int age) {
		this.name = name;
		this.age = age;
		this.status = User.Status.nieprzywitany;
	}
	
	
	public User() {
		this.status = User.Status.nieprzywitany;
	}

	
}
