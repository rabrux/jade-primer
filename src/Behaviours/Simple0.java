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
public class Simple0 extends SimpleBehaviour {

  private boolean finished = false;

  public Simple0( Agent a ) {
    super( a );
  }

  @Override
  public void action() {
    System.out.println( "Hello World! My name is " + myAgent.getLocalName() );
  }

  @Override
  public boolean done() {
    return finished;
  }

}
