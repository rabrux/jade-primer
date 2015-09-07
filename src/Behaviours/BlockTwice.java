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
public class BlockTwice extends SimpleBehaviour {

  static long t0 = System.currentTimeMillis();
  private int n = 0;

  public BlockTwice( Agent a ) {
    super( a );
  }

  @Override
  public void action() {
    System.out.println( "Start: " + (System.currentTimeMillis()-t0) );
    block(250);
    System.out.println( "   after block(250): " + (System.currentTimeMillis()-t0) );
    block(1000);
    System.out.println( "   after block(1000): " + (System.currentTimeMillis()-t0) );
    System.out.println();
  }

  @Override
  public boolean done() {
    return ++n > 3;
  }

}
