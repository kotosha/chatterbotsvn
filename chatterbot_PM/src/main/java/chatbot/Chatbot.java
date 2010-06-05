package chatbot;


public class Chatbot {
	

	/**
	 * Opisuje nastrój Chatbota
	 * @author Kotosha
	 *
	 */
	public enum Nastroj {
		DOBRY,
		ZLY,
		WESOLY,
		SMUTNY
		}
	
	public enum Stany {
		PYTANIE_NAUKA,
		NAUKA
		
	}
	
	private Nastroj nastroj;
	private Stany stany;
	
	private int countVulgarism;

	public int getCountVulgarism() {
		return countVulgarism;
	}

	public void setCountVulgarism(int countVulgarism) {
		this.countVulgarism += countVulgarism;
	}


	public Nastroj getNastroj() {
		return nastroj;
	}

	public Chatbot(Nastroj nastroj) {
		this.nastroj = nastroj;
		this.countVulgarism = 0;
	}

	public void setNastroj(Nastroj nastroj) {
		this.nastroj = nastroj;
	}

	public Stany getStany() {
		return stany;
	}

	public void setStany(Stany stany) {
		this.stany = stany;
	}
	
	

}
