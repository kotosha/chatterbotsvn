package chatbot.helper;

import java.util.Random;

public class Helper {


	/**
	 * Pomocnicza funkcja dopasowujaca @szablon do @wzorca
	 * @param wzorzec
	 * @param szablon
	 * @return jest
	 * @return_type boolean
	 */
	public static boolean pasuje(String value, String pattern )
	{
		boolean jest=false;
		String rob=" "+value+" ";
		if (rob.indexOf(" "+pattern+" ")>=0)
		  jest=true;
		 
		return jest;  
	}
	
	public static int randomGen(int ile)
	  {
	   Random generator = new Random();  
	  
	   return (generator.nextInt(ile))+1;
	  
	  } 

}
