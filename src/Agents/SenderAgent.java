/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.SenderBehaviour;
import jade.core.Agent;

/**
 *
 * @author nahualli
 */
public class SenderAgent extends Agent {

  @Override
  protected void setup() {
    addBehaviour( new SenderBehaviour( this ) );
  }

}
