/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Bank1.Behaviours;

import Bank1.Ontologies.CreateAccount;
import jade.content.Concept;
import jade.content.ContentElement;
import jade.content.onto.basic.Action;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author nahualli
 */
public class ReceiveMessages extends CyclicBehaviour {
// -----------------------------------------------  Receive requests and queries from client
//                                                  agent and launch appropriate handlers

  public ReceiveMessages(Agent a) {
    super(a);
  }

  public void action() {

    ACLMessage msg = myAgent.receive();
    if (msg == null) { block(); return; }
    try {
      ContentElement content = myAgent.getContentManager().extractContent(msg);
      Concept action = ((Action)content).getAction();

      switch (msg.getPerformative()) {

        case (ACLMessage.REQUEST):
          System.out.println("Request from " + msg.getSender().getLocalName());
          if (action instanceof CreateAccount)
            addBehaviour(new HandleCreateAccount(myAgent, msg));
          else if (action instanceof MakeOperation)
            addBehaviour(new HandleOperation(myAgent, msg));
          else replyNotUnderstood(msg);
          break;

      case (ACLMessage.QUERY_REF):

      System.out.println("Query from " + msg.getSender().getLocalName());

      if (action instanceof Information)
      addBehaviour(new HandleInformation(myAgent, msg));
      else replyNotUnderstood(msg);
      break;

      default: replyNotUnderstood(msg);
      }
    } catch(Exception ex) { ex.printStackTrace(); }
  }

}
