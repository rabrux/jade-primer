/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author nahualli
 */
public class PongBehaviour extends CyclicBehaviour {

  private ACLMessage msg;

  public PongBehaviour( Agent a ) {
    super( a );
  }

  @Override
  public void action() {
    msg = myAgent.receive();
    if ( msg != null ) {
      System.out.println( " - " + myAgent.getLocalName() + " received: " + msg.getContent() );

      ACLMessage reply = msg.createReply();
      reply.setPerformative( ACLMessage.INFORM );
      reply.setContent(" Pong" );
      myAgent.send(reply);
    }
  }

}
