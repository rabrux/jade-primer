/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.Transaction;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.Random;

/**
 *
 * @author nahualli
 */
public class SellerAgent extends Agent {

  Random  rnd = newRandom();

  MessageTemplate query  = MessageTemplate.MatchPerformative( ACLMessage.QUERY_REF );

  @Override
  protected void setup() {
  addBehaviour( new CyclicBehaviour(this) {
    public void action() {
      ACLMessage msg = receive( query );
      if (msg!=null)
        addBehaviour( new Transaction(myAgent, msg) );
      block();
    }
  });
  // addBehaviour( new GCAgent( this, 5000));
}

  // ========== Utility methods =========================


  //  --- generating Conversation IDs -------------------

  protected static int cidCnt = 0;
  String cidBase ;

  String genCID()
  {
  if (cidBase==null) {
  cidBase = getLocalName() + hashCode() +
  System.currentTimeMillis()%10000 + "_";
  }
  return  cidBase + (cidCnt++);
  }

  //  --- generating distinct Random generator -------------------

  Random newRandom()
  {	return  new Random( hashCode() + System.currentTimeMillis()); }

}
