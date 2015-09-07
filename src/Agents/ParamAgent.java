/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import jade.core.Agent;

/**
 *
 * @author nahualli
 */
public class ParamAgent extends Agent {

  @Override
  protected void setup() {
    Object[] args = getArguments();
    String s;
    if ( args != null ) {
      for (int i = 0; i < args.length; i++) {
        s = (String) args[1];
        System.out.println("p" + i + ": " + s);
      }
      int i = Integer.parseInt( (String) args[0] );
      System.out.println("i*i= " + i*i);
    }
  }

}
