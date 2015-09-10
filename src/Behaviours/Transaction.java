/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.SequentialBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.Random;

/**
 *
 * @author nahualli
 */
public class Transaction extends SequentialBehaviour {
  
  ACLMessage msg, reply ;
  String     ConvID ;
  Random rnd = new Random();

  int    price  = rnd.nextInt(100);

  public Transaction(Agent a, ACLMessage msg) {
    super( a );
    this.msg = msg;
    ConvID = msg.getConversationId();
  }

  @Override
  public void onStart() {
    int delay = delay = rnd.nextInt( 2000 );
    System.out.println( " - "
      +  myAgent.getLocalName() + " <- QUERY from "
      +  msg.getSender().getLocalName()
      +  ".  Will answer $" + price + " in " + delay + " ms");

    addSubBehaviour( new DelayBehaviour( myAgent, delay) {
      @Override
      public void handleElapsedTimeout() {
        reply = msg.createReply();
        reply.setPerformative( ACLMessage.INFORM );
        reply.setContent("" + price );
        myAgent.send(reply);
      }
    });

    MessageTemplate template = MessageTemplate.and(
      MessageTemplate.MatchPerformative( ACLMessage.REQUEST ),
      MessageTemplate.MatchConversationId( ConvID ));

    addSubBehaviour( new myReceiver( myAgent, 2000, template) {
      @Override
      public void handle( ACLMessage msg1) {
        if (msg1 != null ) {

          int offer = Integer.parseInt( msg1.getContent());
          System.out.println("Got proposal $" + offer
            +  " from " + msg1.getSender().getLocalName()
            +  " & my price is $" + price );

          reply = msg1.createReply();
          if ( offer >= rnd.nextInt(price) )
            reply.setPerformative( ACLMessage.AGREE );
          else
            reply.setPerformative( ACLMessage.REFUSE );
          myAgent.send(reply);
          System.out.println("  == "
            +  ACLMessage.getPerformative(reply.getPerformative() ));
        } else {
          System.out.println("Timeout ! quote $" + price
            +  " from " + myAgent.getLocalName()
            +  " is no longer valid");
        }
      }
    });
  }

}  // --- Answer class ---
