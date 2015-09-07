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
public class TwoStep extends SimpleBehaviour {

  public TwoStep( Agent a ) {
    super( a );
  }

  @Override
  public void action() {
    block( 250 );
    System.out.println( "Message 1 ---------------" );
    block( 500 );
    System.out.println( "       Message 2 ---------------" );
  }

  @Override
  public boolean done() {
    return false;
  }

}
