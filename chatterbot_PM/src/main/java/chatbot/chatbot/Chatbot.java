package chatbot.chatbot;

public class Chatbot {
	

	/**
	 * Opisuje nastrój Chatbota
	 * @author Kotosha
	 *
	 */
public static enum Nastroj{dobry,zly,wesoly,smutny,przygnebiony };
	
		public Nastroj nastrojChatbota;
		public boolean pytanie;
		
		
		
	public boolean isPytanie() {
			return pytanie;
		}

		public void setPytanie(boolean pytanie) {
			this.pytanie = pytanie;
		}

	public Nastroj getNastrojChatbota() {
		return nastrojChatbota;
	}

	public void setNastrojChatbota(Nastroj nastrojChatbota) {
		this.nastrojChatbota = nastrojChatbota;
	}

	public Chatbot() {
		this.pytanie = false;
		this.nastrojChatbota = Chatbot.Nastroj.dobry;
	}
}
