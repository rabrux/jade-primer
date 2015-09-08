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
public class ReceiverBehaviour extends CyclicBehaviour {

  private ACLMessage msg;

  public ReceiverBehaviour( Agent a ) {
    super( a );
  }

  @Override
  public void action() {
    msg = myAgent.receive();
    if ( msg != null ) {
      System.out.println( " - " + myAgent.getLocalName() + " <- " + msg.getContent() );
    }
    block();
  }

}
