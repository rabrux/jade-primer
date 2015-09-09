/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;

/**
 *
 * @author nahualli
 */
public class Sequence1 extends WakerBehaviour {

  private long t0 = time();
  private final long secondTimeout;

  public Sequence1( Agent a, long timeout, long secondTimeout ) {
    super( a, timeout );
    this.secondTimeout = secondTimeout;
  }

  @Override
  protected void handleElapsedTimeout() {
    System.out.println( time() + ": " + "... Message1");
    myAgent.addBehaviour( new SequenceBehaviour( myAgent, this.secondTimeout, "  ...and then Message 2" ) );
  }

  private long time() {
    return System.currentTimeMillis();
  }

}
