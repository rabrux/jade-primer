/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.TemplateSenderBehaviourOne;
import Behaviours.TemplateSenderBehaviourTwo;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author nahualli
 */
public class TemplateSenderAgent extends Agent {

  @Override
  protected void setup() {
    System.out.println("Sender");
    ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
    msg.setContent( "Ping" );
    for (int i = 1; i<=2; i++)
      msg.addReceiver( new AID( "a" + i, AID.ISLOCALNAME) );
    send(msg);

    addBehaviour( new TemplateSenderBehaviourOne( this ) );
    addBehaviour( new TemplateSenderBehaviourTwo( this ) );
  }

}
