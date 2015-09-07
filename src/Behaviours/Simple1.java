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
public class Simple1 extends SimpleBehaviour {

  private int n = 0;

  public Simple1( Agent a ) {
    super( a );
  }

  @Override
  public void action() {
    System.out.println( "Hello World! My name is " + myAgent.getLocalName() );
    n++;
  }

  @Override
  public boolean done() {
    return n >= 3;
  }

}
