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
public class Complex1 extends TickerBehaviour {

  long t0 = System.currentTimeMillis();

  public Complex1( Agent a, long step ) {
    super( a, step );
  }

  @Override
  protected void onTick() {
    System.out.println( System.currentTimeMillis() - t0 + ": " + myAgent.getLocalName());
  }

}
