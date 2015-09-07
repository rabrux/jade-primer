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
public class Looper extends SimpleBehaviour {

  static String offset = "";
	static long   t0 = System.currentTimeMillis();

	String tab = "" ;
	int    n   = 1;
	long   dt;

  public Looper( Agent a, long milli ) {
    super( a );
    this.dt = milli;
    offset += "    " ;
    tab = offset;
  }

  @Override
  public void action() {
    System.out.println( tab + (System.currentTimeMillis()-t0)/10*10 + ": " + myAgent.getLocalName() );
		block( dt );
		n++;
  }

  @Override
  public boolean done() {
    return n > 6;
  }

}
