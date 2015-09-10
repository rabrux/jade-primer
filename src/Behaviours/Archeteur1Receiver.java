/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

/**
 *
 * @author nahualli
 */
public class Archeteur1Receiver extends myReceiver {
  
  protected static int cidCnt = 0;
  String cidBase ;

  ACLMessage msg = newMsg( ACLMessage.QUERY_REF, "", new AID( "s1", AID.ISLOCALNAME) );

  public Archeteur1Receiver( Agent a, int millis, MessageTemplate mt ) {
    super( a, millis, mt );
  }

  @Override
  public void handle( ACLMessage msg ) {
    if (msg == null)
      System.out.println("Buyer: Timeout");
    else
      System.out.println("Buyer received: $"+ msg);
  }

  String genCID() {
    if (cidBase==null) {
      this.cidBase = myAgent.getLocalName() + hashCode() +
      System.currentTimeMillis()%10000 + "_";
    }
    return  cidBase + (cidCnt++);
  }

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
