package chatbot.engine;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.event.rule.DebugAgendaEventListener;
import org.drools.event.rule.DebugWorkingMemoryEventListener;
import org.drools.event.rule.WorkingMemoryEventListener;
import org.drools.io.Resource;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import chatbot.chatbot.Chatbot;
import chatbot.user.User;

/**
 * ChatbotEngine to klasa, w której inicjalizowany jest Chatbot oraz silnik Drools
 * @author Kotosha
 *
 */

public class ChatbotEngine {
	
	 public final String main(String zdanie) {
	       
	        
	        	KnowledgeBase kbase = createKnowledgeBase();
				StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
			//	KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
																
				 try {
					User user = new User();	 
			//		User user2 = new User("daniel",23);
					user.setMessage(zdanie);
	
					Chatbot chatbot = new Chatbot();
						//chatbot
			//		ksession.addEventListener( (WorkingMemoryEventListener) new DebugAgendaEventListener() );
				//	ksession.addEventListener( (WorkingMemoryEventListener) new DebugWorkingMemoryEventListener() );
	                    
      
					ksession.insert( user );
					ksession.insert(chatbot);
		//			System.out.println("$c.pytanie"+chatbot.isPytanie());
			//		System.out.println("$c.nastrojChatbota"+chatbot.getNastrojChatbota());
				
		//			ksession.insert( user2 );
				//	ksession.setGlobal("chatbot", chatbot);

	            ksession.fireAllRules();   
	          //  logger.close();
	            
	            
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
		//	kbuilder.add(ResourceFactory.newClassPathResource("Sample.drl"), ResourceType.DRL);
			kbuilder.add(ResourceFactory.newClassPathResource("Salutation.drl"), ResourceType.DRL);
		//	kbuilder.add(ResourceFactory.newClassPathResource("Test.drl"), ResourceType.DRL);
//		/	kbuilder.add(ResourceFactory.newClassPathResource("Wulgaryzmy.drl"), ResourceType.DRL);
			//kbuilder.add(ResourceFactory.newClassPathResource("humor.drl"), ResourceType.DRL);
			
			KnowledgeBuilderErrors errors = kbuilder.getErrors();
			if (kbuilder.hasErrors()) {
				throw new RuntimeException(kbuilder.getErrors().toString());
			}
			KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
			kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
			return kbase;
		}
	 
		public ChatbotEngine() {
			// TODO Auto-generated constructor stub
		}
}
