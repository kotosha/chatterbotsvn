package chatbot.engine;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import chatbot.helper.Helper;
import chatbot.user.User;

public class ChatbotEngine {
	
	int countVulgarism;




	public int getCountVulgarism() {
		return countVulgarism;
	}

	public void setCountVulgarism(int countVulgarism) {
		this.countVulgarism += countVulgarism;
	}

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


//	//testowy
//	 public static final String main(String zdanie) {
//		 System.out.println("wywolanie");
//		 return "";
//	 }
	
	 public final String main(String zdanie) {
	       
	        	
	        	//user.getMessage();
	        	//user.setMessage(zdanie);
	        //	user.setRegula_rozpoznana(false);
	        	//load up the rulebase
	        	KnowledgeBase kbase = createKnowledgeBase();
				StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
			//	KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
																
				 try {
					User user = new User();	 
					User user2 = new User("daniel",23);
					user.setMessage(zdanie);
				//	System.out.println("User mowi: "+zdanie);
//	          setup the debug listeners
				//logger.addEventListener( new DebugAgendaEventListener() );
	     //      workingMemory.addEventListener( new DebugWorkingMemoryEventListener() );
	                    
//	             setup the audit logging
	       //     ((WorkingMemoryFileLogger) logger).setFileName( "log/hello" );     
	            
					ksession.insert( user );
					ksession.insert( user2 );
	           // workingMemory.insert( kontekst );            
	          

	            ksession.fireAllRules();   
	       //     logger.close();
	            
	            //System.out.println(message.getMessage());
	            
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
			kbuilder.add(ResourceFactory.newClassPathResource("Wulgaryzmy.drl"), ResourceType.DRL);
			
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
