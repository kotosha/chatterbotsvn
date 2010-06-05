package chatbot;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import chatbot.Chatbot;

import org.antlr.runtime.debug.TraceDebugEventListener;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.event.rule.AgendaEventListener;
import org.drools.event.rule.DebugAgendaEventListener;
import org.drools.event.rule.DebugWorkingMemoryEventListener;
import org.drools.event.rule.WorkingMemoryEventListener;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;


/**
 * ChatbotEngine to klasa, w której inicjalizowany jest Chatbot oraz silnik Drools
 * @author Kotosha
 *
 */

public class ChatbotEngine {
	static User user;
	static Chatbot chatbot;
	 private static int counter;
	 static Helper h;
	 
	 public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		ChatbotEngine.counter += counter;
	}
	
	public ChatbotEngine() {
		// TODO Auto-generated constructor stub
		counter=0;
		user = new User(User.Nastroj.DOBRY, User.Przywitanie.NIEPRZYWITANY);	
		chatbot = new Chatbot(Chatbot.Nastroj.DOBRY);
		h = new Helper();
		final String path = "D:\\praca magisterska\\magisterka_workspace\\chatterbot_PM";
		//System.out.println("path"+path);
		FileOpen fop = new FileOpen();
		List<String> listaTematow = new ArrayList();
		try {

			for (int i = 0; i < 25; i++) {
				listaTematow.add("+");
			}
			fop.FileOutput(path + File.separator + "listaTematow.txt", listaTematow);
		// TODO Auto-generated constructor stub
		/**
		 * listaTematow = new List();
		 listaTematow.add("Mnozenie");
		 listaTematow.add("Dzielenie");
		 listaTematow.add("Odejmowanie");
		 listaTematow.add("Dodawanie");
		 listaTematow.add("Potegowanie");
		 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public static final String main(String zdanie) {
	       
		KnowledgeBase kbase = createKnowledgeBase();
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		
	//    SimpleAgendaEventListener sael = new SimpleAgendaEventListener();
	//	ksession.addEventListener( sael );
		

		 try {
	        	
			KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
			ksession.addEventListener( new DebugAgendaEventListener() );
			ksession.addEventListener( new DebugWorkingMemoryEventListener() );
					// setCounter(1);
				//	 System.out.print("counter: "+getCounter());
					
					//User user2 = new User("daniel",23);
					 
					 
				/*	System.out.print("che " +chatbot.getNastroj());
					chatbot.setNastroj(Nastroj.ZLY);				
					System.out.print("che2 " +chatbot.getNastroj());
				*/	
					user.setMessage(zdanie);
	
			
					//chatbot
				//	ksession.addEventListener( (WorkingMemoryEventListener) new DebugAgendaEventListener() );
				//	ksession.addEventListener( (WorkingMemoryEventListener) new DebugWorkingMemoryEventListener() );
	                    
      
					ksession.insert( user );
					ksession.insert(h);
				//ksession.insert( user2 );
					ksession.insert(chatbot);

	            ksession.fireAllRules();   
	            logger.close();
	            
	            
	        }
				 finally {
					ksession.dispose();
					 	
				 }
	        
	        return "";
	    }
	 

	
		

	    /**
	     * Please note that this is the "low level" rule assembly API.
	     */
	 private static KnowledgeBase createKnowledgeBase() {
			KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
			kbuilder.add(ResourceFactory.newClassPathResource("Salutation.drl"), ResourceType.DRL);
			kbuilder.add(ResourceFactory.newClassPathResource("Test.drl"), ResourceType.DRL);
			kbuilder.add(ResourceFactory.newClassPathResource("Wulgaryzmy.drl"), ResourceType.DRL);
			kbuilder.add(ResourceFactory.newClassPathResource("Humor.drl"), ResourceType.DRL);
			kbuilder.add(ResourceFactory.newClassPathResource("Nauka.drl"), ResourceType.DRL);
				
			KnowledgeBuilderErrors errors = kbuilder.getErrors();
			if (kbuilder.hasErrors()) {
				throw new RuntimeException(kbuilder.getErrors().toString());
			}
			KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
			kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
			return kbase;
		}
	 
	
}
