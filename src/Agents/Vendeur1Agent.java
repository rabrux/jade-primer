/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.DelayBehaviour;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.Random;

/**
 *
 * @author nahualli
 */
public class Vendeur1Agent extends Agent {

  Random rnd = newRandom();
  MessageTemplate template =
  MessageTemplate.MatchPerformative( ACLMessage.QUERY_REF );

  ACLMessage reply;

  @Override
  protected void setup() {
    addBehaviour(new CyclicBehaviour(this) {
      public void action() {
        ACLMessage msg = receive( template );
        if (msg!=null) {

          // we create the reply
          reply = msg.createReply();
          reply.setPerformative( ACLMessage.INFORM );
          reply.setContent("" + rnd.nextInt(100));

          int delay = rnd.nextInt( 2000 );
          System.out.println( " - " +
          myAgent.getLocalName() + " <- QUERY from " +
          msg.getSender().getLocalName() +
          ".  Will answer in " + delay );

          // but only send it after a random delay

          addBehaviour( new DelayBehaviour( myAgent, delay) {
            @Override
            public void handleElapsedTimeout() {
              send(reply);
            }
          });
        }
        block();
      }
    });
  }

// ==========================================
// ========== Utility methods ===============
// ==========================================


//  --- generating distinct Random generator -------------------

  Random newRandom() {	return  new Random( hashCode() + System.currentTimeMillis()); }

}
