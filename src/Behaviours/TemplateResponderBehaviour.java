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
public class TemplateResponderBehaviour extends CyclicBehaviour {

  public TemplateResponderBehaviour( Agent a ) {
    super( a );
  }

  @Override
  public void action() {
    ACLMessage msg = myAgent.receive();
    if (msg!=null) {
      ACLMessage reply = msg.createReply();
      reply.setPerformative( ACLMessage.INFORM );
      reply.setContent(" Gossip....." );
      myAgent.send(reply);

      reply.setPerformative( ACLMessage.PROPOSE );
      reply.setContent(" Really sexy stuff... cheap! " );
      myAgent.send(reply);
     }
     block();
  }

}
