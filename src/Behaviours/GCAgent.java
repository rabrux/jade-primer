/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author nahualli
 */
class GCAgent extends TickerBehaviour {
		Set seen = new HashSet(), old  = new HashSet();

		GCAgent( Agent a, long dt) { super(a,dt); }

		protected void onTick()
		{
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
	}
