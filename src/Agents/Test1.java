/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.myReceiver;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.Random;

/**
 *
 * @author nahualli
 */
public class Test1 extends Agent {

  long t0;
	Random  rnd = new Random(hashCode());
	MessageTemplate mt = MessageTemplate.MatchPerformative( ACLMessage.INFORM );

  @Override
	protected void setup() {
    t0 = System.currentTimeMillis();
    addBehaviour( new TickerBehaviour( this, 2000 ) {
      int n = 0;

      protected void onTick() {
				ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
				msg.addReceiver( myAgent.getAID() );
				msg.setContent( "#" + n );
		    myAgent.send(msg);
		    if (n++ > 3) stop();
			}
		});

    addBehaviour( new myReceiver( this, 1000, mt ) {
      @Override
      public void handle( ACLMessage msg) {
        System.out.println("R1:");
        if (msg==null) {
          System.out.println("Timeout:" + time());
          reset(500);
        }
        else
          dumpMessage( msg );
      }
    });
    addBehaviour( new myReceiver( this, 3000, mt ) {
      @Override
      public void handle( ACLMessage msg) {
        System.out.println("R2:");
        if (msg==null)
          System.out.println("Timeout at 3000");
        else
          dumpMessage( msg );
      }
    });
    addBehaviour( new myReceiver( this, 4000, mt ) {
      @Override
      public void handle( ACLMessage msg) {
        System.out.println("R3:");
        if (msg==null)
          System.out.println("Timeout at 4000");
        else
          dumpMessage( msg );
      }
    });
	}


	void dumpMessage( ACLMessage msg ) {
		System.out.println( time() + ": "
		      + getLocalName() + " gets "
					+ ACLMessage.getPerformative(msg.getPerformative() )
					+ " from "
					+  msg.getSender().getLocalName()
					+ ", content: " +  msg.getContent()
					+ ", cid=" + msg.getConversationId());
	}

	int time() { return (int)(System.currentTimeMillis()-t0); }

}
