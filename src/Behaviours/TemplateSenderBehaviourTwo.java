/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

/**
 *
 * @author nahualli
 */
public class TemplateSenderBehaviourTwo extends CyclicBehaviour {

  public TemplateSenderBehaviourTwo( Agent a ) {
    super( a );
  }

  @Override
  public void action() {
    System.out.print("Behaviour TWO: ");
    ACLMessage msg= myAgent.receive();
    if (msg!=null)
      System.out.println( "gets "
        +  msg.getPerformative() + " from "
        +  msg.getSender().getLocalName() + "="
        +  msg.getContent() );
    else
      System.out.println( "gets NULL" );
    block();
  }

}
