/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

/**
 *
 * @author nahualli
 */
public class OneShotMessage extends OneShotBehaviour {
  private final long t0;
  
  public OneShotMessage( Agent a, long time) {
    super( a );
    this.t0 = time;
  }

  @Override
  public void action() {
    System.out.println( time() + ": " + "... Message1");
  }

  private long time() {
    return System.currentTimeMillis() - this.t0;
  }

}
