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
public class TemplateSenderBehaviourOne extends CyclicBehaviour {

  MessageTemplate mt1 =
    MessageTemplate.and(
      MessageTemplate.MatchPerformative( ACLMessage.INFORM ),
      MessageTemplate.MatchSender( new AID( "a1", AID.ISLOCALNAME))
    ) ;

  public TemplateSenderBehaviourOne( Agent a ) {
    super( a );
  }

  @Override
  public void action() {
    System.out.print("Behaviour ONE: ");
    ACLMessage msg= myAgent.receive( mt1 );
    if (msg!=null)
      System.out.println( "gets " + ACLMessage.getPerformative( msg.getPerformative() ) + " from " +  msg.getSender().getLocalName() + ":" +  msg.getContent() );
    else
      System.out.println( "gets NULL" );
    block();
  }

}
