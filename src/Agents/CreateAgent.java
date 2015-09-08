/*****************************************************************

	Comm2.java:    Program which creates another Agent and sends
	------------     it some messages

    Author:  Jean Vaucher
    Date:    Aug 10 2003

*****************************************************************/


import jade.core.Agent;
import jade.core.behaviours.*;

import jade.core.AID;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

import jade.lang.acl.*;


public class CreateAgent extends Agent {

	String name = "Alice" ;
	AID alice = new AID( name, AID.ISLOCALNAME );

  @Override
    protected void setup() {
    	AgentContainer c = getContainerController();
      System.out.println( c );
    	try {
    		AgentController a = c.createNewAgent( name, "Agents.PongAgent", null );
    		a.start();
    		System.out.println("+++ Created: " + alice);
    	}
    	catch (Exception e){}

		addBehaviour(new SimpleBehaviour(this)
		  {
			 int n = 0;

			 public void action()
			 {
				ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
				msg.setContent("Message #" + n );
				msg.addReceiver(alice);
				System.out.println("+++ Sending: " + n);
				send(msg);
				block( 1000 );
			 }

			 public  boolean done() {  return ++n > 3;  }

		  });
	}
}
