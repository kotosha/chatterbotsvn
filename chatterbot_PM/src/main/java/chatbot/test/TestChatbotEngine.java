package chatbot.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import chatbot.engine.ChatbotEngine;

public class TestChatbotEngine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String zdanie = "";
		//System.out.println();
		
		InputStreamReader stdin = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(stdin);
		
		try {
			ChatbotEngine chatbot = new ChatbotEngine();
			System.out.println("Uzytkownik: ");
			zdanie = in.readLine().toUpperCase();
			
			while(!zdanie.equals("exit"))
			{
			
				System.out.println("Chatbot: ");	
				System.out.println(chatbot.main(zdanie));
				zdanie = "";
				System.out.println("Uzytkownik: ");
				zdanie=in.readLine().toUpperCase();
				
				//chatbot.main(zdanie);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}


}
