/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

/**
 *
 * @author nahualli
 */
public class SequenceTiker extends TickerBehaviour {
  private final long t0;

  public SequenceTiker( Agent a, long timeout, long t0 ) {
    super( a, timeout );
    this.t0 = t0;
  }

  @Override
  protected void onTick() {
    System.out.println( System.currentTimeMillis() - this.t0 + ": " + myAgent.getLocalName());
  }

}
