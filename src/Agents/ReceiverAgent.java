/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.ReceiverBehaviour;
import jade.core.Agent;

/**
 *
 * @author nahualli
 */
public class ReceiverAgent extends Agent {
  
  @Override
  protected void setup() {
    addBehaviour( new ReceiverBehaviour( this ) );
  }

}
