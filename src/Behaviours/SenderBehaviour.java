/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author nahualli
 */
public class SenderBehaviour extends CyclicBehaviour {

  public SenderBehaviour( Agent a ) {
    super( a );

    ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.setContent( "Ping" );
    
    for (int i = 1; i<=2; i++)
      msg.addReceiver( new AID( "a" + i, AID.ISLOCALNAME) );

		myAgent.send(msg);

  }

  @Override
  public void action() {
    ACLMessage msg = myAgent.receive();
    if ( msg != null ) {
      System.out.println( "== Answer" + " <- " +  msg.getContent() + " from " +  msg.getSender().getLocalName() );
    }
    
  }

}
