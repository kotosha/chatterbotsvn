package chatbot.chatbot;

import chatbot.chatbot.Chatbot.Nastroj;

public class Chatbot {
	

	/**
	 * Opisuje nastrój Chatbota
	 * @author Kotosha
	 *
	 */
public static enum Nastroj{dobry,zly,wesoly,smutny,przygnebiony };
	
		public Nastroj nastrojChatbota;
		
	public Nastroj getNastrojChatbota() {
		return nastrojChatbota;
	}

	public void setNastrojChatbota(Nastroj nastrojChatbota) {
		this.nastrojChatbota = nastrojChatbota;
	}

	public Chatbot() {
		
	}
}
