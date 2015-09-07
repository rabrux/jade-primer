/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.Simple0;

import jade.core.Agent;

/**
 *
 * @author nahualli
 */
public class AgentSimple0 extends Agent {

  @Override
  protected void setup() {
    addBehaviour( new Simple0( this ) );
  }

}
