package chatbot;



public class User {



	public enum Nastroj{DOBRY, ZLY, WESOLY, SMUTNY, PRZYGNEBIONY};
	
	public enum Przywitanie {
		NIEPRZYWITANY,
		PRZYWITANY,
		CHCE_ZEGNAC,
		POZEGNANY,
		ZEGNAJ
	}

	
	
	
	private String message;
	private Nastroj nastroj;
	private Przywitanie przywitanie;
	private String name;
	private int age;
	

	
	public Przywitanie getPrzywitanie() {
		return przywitanie;
	}

	public void setPrzywitanie(Przywitanie przywitanie) {
		this.przywitanie = przywitanie;
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
	

	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Nastroj nastroj, Przywitanie przywitanie) {
		this.nastroj = nastroj;
		this.przywitanie = przywitanie;
	}
	
	

	
}
