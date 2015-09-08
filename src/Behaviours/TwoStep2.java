/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

/**
 *
 * @author nahualli
 */
public class TwoStep2 extends SimpleBehaviour {

  long t0 = System.currentTimeMillis();
  private int n = 0;

  public TwoStep2( Agent a ) {
    super( a );
  }

  @Override
  public void action() {
    try {
      System.out.println( "--- TwoStep start: " + (System.currentTimeMillis()-t0)/10*10 );
      Thread.sleep(200);
      System.out.println( " -- Message 1 ---: " + (System.currentTimeMillis()-t0)/10*10 );
      Thread.sleep(500);
      System.out.println( "  - message 2    : " + (System.currentTimeMillis()-t0)/10*10 );
    } catch (Exception e) {}
  }

  @Override
  public boolean done() {
    return ++n > 2;
  }

}
