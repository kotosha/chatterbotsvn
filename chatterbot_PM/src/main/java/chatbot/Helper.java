package chatbot;

import java.awt.List;
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
	
	private void mowDowcip()
	{
		System.out.println("Kawal 1");
	}
	
	private void zgadywanka()
	{
		System.out.println("zgadywanka 1");
	}
	
	public void rozweselUsera()
	{
		System.out.println("Sprobuje Cie rozweselic");
		switch (randomGen(2)){
		case 1: mowDowcip();break;
		case 2: zgadywanka();break;
		default: System.out.println("Usmiechnij sie");
		}
	}

	public Helper() {
		super();
		 
			// TODO Auto-generated constructor stub
	}
	
	

}
