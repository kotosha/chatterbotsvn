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

import chatbot.user.User;

public class ChatbotEngine {
	User user;
	
	
	

	public ChatbotEngine() {
		super();
		// TODO Auto-generated constructor stub
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

	/**
	 * Pomocnicza funkcja dopasowujaca @szablon do @wzorca
	 * @param wzorzec
	 * @param szablon
	 * @return jest
	 * @return_type boolean
	 */
	public boolean pasuje(String wzorzec,String szablon) {
		boolean jest=false;
		String rob=" "+wzorzec+" ";
		if (rob.indexOf(" "+szablon+" ")>=0)
		 {
		  jest=true;
		 }
		 
		return jest;  
		}
	
	 public String main(String zdanie) {
	        try {
	        	//System.out.println(zdanie);
	        	//TODO cos tu nie gra
	       //	user.setMessage(zdanie);
	        	user.getMessage();
	        	//user.setMessage(zdanie);
	        //	user.setRegula_rozpoznana(false);
	        	//load up the rulebase
	        	KnowledgeBase kbase = readKnowledgeBase();
				StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
				KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
																
	                  
//	          setup the debug listeners
				//logger.addEventListener( new DebugAgendaEventListener() );
	     //      workingMemory.addEventListener( new DebugWorkingMemoryEventListener() );
	                    
//	             setup the audit logging
	       //     ((WorkingMemoryFileLogger) logger).setFileName( "log/hello" );     
	            
	           ksession.insert( user );
	           // workingMemory.insert( kontekst );            
	          

	            ksession.fireAllRules();   
	            logger.close();
	            
	            //System.out.println(message.getMessage());
	            
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
	        
	        return "";
	    }
	 

		public ChatbotEngine(Nastroj nastrojChatbota) {
			super();
			user = new User();
			this.nastrojChatbota = nastrojChatbota;
		}
		

	    /**
	     * Please note that this is the "low level" rule assembly API.
	     */
	 private static KnowledgeBase readKnowledgeBase() throws Exception {
			KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
			kbuilder.add(ResourceFactory.newClassPathResource("Sample.drl"), ResourceType.DRL);
			kbuilder.add(ResourceFactory.newClassPathResource("Salutation.drl"), ResourceType.DRL);
			KnowledgeBuilderErrors errors = kbuilder.getErrors();
			if (errors.size() > 0) {
				for (KnowledgeBuilderError error: errors) {
					System.err.println(error);
				}
				throw new IllegalArgumentException("Could not parse knowledge.");
			}
			KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
			kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
			return kbase;
		}

}
