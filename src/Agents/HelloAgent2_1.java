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
public class HelloAgent2_1 extends Agent {

  @Override
  protected void setup() {
    System.out.println( "Hello world." );
    System.out.println( "My name is: " + getLocalName() );
  }

}
