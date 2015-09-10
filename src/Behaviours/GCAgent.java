/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author nahualli
 */
public class GCAgent extends TickerBehaviour {

  private final long t0;
  
  Set seen = new HashSet(), old  = new HashSet();

  public GCAgent( Agent a, long dt, long t0) {
    super(a,dt);
    this.t0 = t0;
  }

  protected void onTick() {
    ACLMessage msg = myAgent.receive();
    while (msg != null) {
      if (! old.contains(msg))
        seen.add( msg);
      else {
        System.out.println("==== Flushing message:");
        dumpMessage( msg );
      }
      msg = myAgent.receive();
    }
    for( Iterator it = seen.iterator(); it.hasNext(); )
      myAgent.putBack( (ACLMessage) it.next() );

    old.clear();
    Set tmp = old;
    old = seen;
    seen = tmp;
  }

  private void dumpMessage(ACLMessage msg) {
    System.out.print( "t=" + ( System.currentTimeMillis() - this.t0 ) / 1000F + " in "
      + myAgent.getLocalName() + ": "
      + ACLMessage.getPerformative(msg.getPerformative() ));
    System.out.print( "  from: "
      +  (msg.getSender()==null ? "null" : msg.getSender().getLocalName())
      +  " --> to: ");
    for ( Iterator it = msg.getAllReceiver(); it.hasNext();)
      System.out.print( ((AID) it.next()).getLocalName() + ", ");
    System.out.println( "  cid: " + msg.getConversationId());
    System.out.println( "  content: " +  msg.getContent());
  }
}
