/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.DelayBehaviour;

import Behaviours.GCAgent;
import Behaviours.myReceiver;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.Random;

/**
 *
 * @author nahualli
 */
public class BuyerAgent extends Agent {

  static long t0 = System.currentTimeMillis();

  Random     rnd  = newRandom();
  int        bestPrice = 9999;

  ACLMessage msg, bestOffer;
  Behaviour flusher;

  @Override
  protected void setup() {
    if (flusher==null) {
      flusher = new GCAgent( this, 2000, this.t0);
      // addBehaviour( flusher);
    }
    bestPrice = 9999;
    bestOffer = null;

    msg = newMsg( ACLMessage.QUERY_REF );

    MessageTemplate template = MessageTemplate.and(
    MessageTemplate.MatchPerformative( ACLMessage.INFORM ),
    MessageTemplate.MatchConversationId( msg.getConversationId() ));

    System.out.println("Buyer " + getLocalName() + " gets prices.");

    SequentialBehaviour seq = new SequentialBehaviour();
    addBehaviour( seq );

    ParallelBehaviour par = new ParallelBehaviour( ParallelBehaviour.WHEN_ALL );
    seq.addSubBehaviour( par );

    for (int i = 1; i<=3; i++) {
      msg.addReceiver( new AID( "s" + i,  AID.ISLOCALNAME ));
      par.addSubBehaviour( new myReceiver( this, 1000, template) {
        @Override
        public void handle( ACLMessage msg) {
          if (msg != null) {
            int offer = Integer.parseInt( msg.getContent());
            System.out.println("Got quote $" + offer
              +  " from " + msg.getSender().getLocalName());
            if (offer < bestPrice) {
              bestPrice = offer;
              bestOffer = msg;
            }
          }
        }
      });
    }

    seq.addSubBehaviour( new DelayBehaviour( this, rnd.nextInt( 2000 )) {
      @Override
      public void handleElapsedTimeout() {
        if (bestOffer == null) {
          System.out.println("Got no quotes");
        } else {
          System.out.println("\nBest Price $" + bestPrice
            +  " from " + bestOffer.getSender().getLocalName());
          ACLMessage reply = bestOffer.createReply();
          if ( bestPrice <= 80 ) {
            reply.setPerformative( ACLMessage.REQUEST );
            reply.setContent( "" + rnd.nextInt( 80 ) );
            System.out.print(" ORDER at "+ reply.getContent());
            send ( reply );
          }
        }
      }
    });

    seq.addSubBehaviour( new myReceiver( this, 1000,
      MessageTemplate.and(
        MessageTemplate.MatchConversationId( msg.getConversationId()) ,
        MessageTemplate.or(
          MessageTemplate.MatchPerformative( ACLMessage.AGREE ),
          MessageTemplate.MatchPerformative( ACLMessage.REFUSE ))) ) {
      @Override
      public void handle( ACLMessage msg) {
        if (msg != null ) {
          System.out.println("Got "
            +  ACLMessage.getPerformative(msg.getPerformative() )
            +  " from " + msg.getSender().getLocalName());

          if( msg.getPerformative() == ACLMessage.AGREE)
            System.out.println("  --------- Finished ---------\n");
          else
            setup();
        } else {
          System.out.println("==" + getLocalName()
            +" timed out");
          setup();
        }
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

  //  --- generating distinct Random generator -------------------

  Random newRandom() {
    return  new Random( hashCode() + System.currentTimeMillis());
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
