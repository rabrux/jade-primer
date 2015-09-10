/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.myReceiver;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.Random;

/**
 *
 * @author nahualli
 */
public class Archeteur1Agent extends Agent {

  Random rnd = new Random( hashCode());

  MessageTemplate template ;

  @Override
  protected void setup() {
    ACLMessage msg = newMsg( ACLMessage.QUERY_REF, "",
    new AID( "s1", AID.ISLOCALNAME) );

    template = MessageTemplate.and(
    MessageTemplate.MatchPerformative( ACLMessage.INFORM ),
    MessageTemplate.MatchConversationId( msg.getConversationId() ));

    addBehaviour( new myReceiver(this, 1000, template ) {
      @Override
      public void handle( ACLMessage msg ) {
      if (msg == null)
        System.out.println("Buyer: Timeout");
      else
        System.out.println("Buyer received: $"+ msg);
      }
    });

    send ( msg );

  }

// ========== Utility methods =========================


//  --- generating Conversation IDs -------------------

  protected static int cidCnt = 0;
  String cidBase ;

  String genCID() {
    if (cidBase==null) {
      cidBase = getLocalName() + hashCode() +
      System.currentTimeMillis()%10000 + "_";
    }
    return  cidBase + (cidCnt++);
  }


//  --- Methods to initialize ACLMessages -------------------

  ACLMessage newMsg( int perf, String content, AID dest) {
    ACLMessage msg = newMsg(perf);
    if (dest != null) msg.addReceiver( dest );
    msg.setContent( content );
    return msg;
  }

  ACLMessage newMsg( int perf) {
    ACLMessage msg = new ACLMessage(perf);
    msg.setConversationId( genCID() );
    return msg;
  }

}
