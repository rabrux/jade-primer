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
public class SequenceBehaviour extends WakerBehaviour {

  private final String message;
  private long t0 = System.currentTimeMillis();

  public SequenceBehaviour( Agent a, long timeout, String message ) {
    super( a, timeout );
    this.message = message;
  }

  @Override
  protected void onWake() {
    System.out.println( System.currentTimeMillis() - t0 + ": " + this.message );
  }

}
