/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.Complex1;
import jade.core.Agent;

/**
 *
 * @author nahualli
 */
public class Complex1Agent extends Agent {

  @Override
  protected void setup() {
    addBehaviour( new Complex1( this, 300 ) );
  }

}
