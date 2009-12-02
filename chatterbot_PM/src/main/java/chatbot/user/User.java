package chatbot.user;

public class User {


	public static enum Nastroj{dobry,zly,wesoly,smutny,przygnebiony };
	
	private String message;
	public Nastroj nastroj;

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
}
