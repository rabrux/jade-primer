/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.PongBehaviour;
import jade.core.Agent;

/**
 *
 * @author nahualli
 */
public class PongAgent extends Agent {

  @Override
  protected void setup() {
    addBehaviour( new PongBehaviour( this ) );
  }

}
