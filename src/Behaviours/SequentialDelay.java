/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.SequentialBehaviour;

/**
 *
 * @author nahualli
 */
public class SequentialDelay extends SequentialBehaviour {
  private final long t0;

  public SequentialDelay( Agent a, long t0 ) {
    super( a );
    this.t0 = t0;
    this.addSubBehaviour( new DelayBehaviour( myAgent, 2500 ) );
    this.addSubBehaviour( new OneShotMessage( myAgent, this.t0  ) );
    this.addSubBehaviour( new DelayBehaviour( myAgent, 5000 ) {
      @Override
      protected void handleElapsedTimeout() {
        System.out.println( time() + ": " + "  ...and then Message 2");

        myAgent.doDelete();
        System.exit(1);
      }
    });
  }

  private long time() {
    return System.currentTimeMillis() - this.t0;
  }

}
