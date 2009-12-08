package chatbot.helper;

import java.util.Random;

public class Helper {


	public boolean pasuje(String value, String pattern )
	{
		boolean jest=false;
		String rob=" "+value+" ";
		if (rob.indexOf(" "+pattern+" ")>=0)
		  jest=true;
		 
		return jest;  
	}
	
	public int randomGen(int ile)
	  {
	   Random generator = new Random();  
	  
	   return (generator.nextInt(ile))+1;
	  
	  } 

}
