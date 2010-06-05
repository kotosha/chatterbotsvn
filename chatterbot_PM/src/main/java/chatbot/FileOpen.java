package chatbot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileOpen {
	public List<String> FileInput(String plik)throws IOException{
 		List<String> rob = new ArrayList<String>();
 		BufferedReader inputStream = null;
 		
 		String l;
 try
    	{
  	      inputStream = new BufferedReader(new FileReader(plik));
          while ((l = inputStream.readLine()) != null) 
           {
             rob.add(l);
           }
        } 
 finally 
  		{
         if (inputStream != null) {
            inputStream.close();
          }
  	    }
	return rob;
}
	
	 public void FileOutput(String plik,List<String> dane)throws IOException
	 {
		 PrintWriter outputStream = null;
   
     try
     {
    	     outputStream = new PrintWriter(new FileWriter(plik));
    	     for (int i=0;i<dane.size();i++)
    	     {
    	      outputStream.println(dane.get(i));
    	     } 
     }   
	 finally {
         
         if (outputStream != null) {
             outputStream.close();
         }
	 }
   }
 
}
