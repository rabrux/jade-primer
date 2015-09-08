/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.Looper;
import Behaviours.TwoStep2;
import jade.core.Agent;

/**
 *
 * @author nahualli
 */
public class AgentBad3 extends Agent {

  @Override
  protected void setup() {
    addBehaviour( new TwoStep2( this ) );
    addBehaviour( new Looper( this, 300 ) );
  }

}
