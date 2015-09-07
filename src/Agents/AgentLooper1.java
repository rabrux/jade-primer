/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.Looper;
import jade.core.Agent;

/**
 *
 * @author nahualli
 */
public class AgentLooper1 extends Agent {

  @Override
  protected void setup() {
    addBehaviour( new Looper( this, 300 ) );
    addBehaviour( new Looper( this, 500 ) );
  }

}
