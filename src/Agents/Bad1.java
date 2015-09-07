/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.Looper;
import Behaviours.TwoStep;
import jade.core.Agent;

/**
 *
 * @author nahualli
 */
public class Bad1 extends Agent {

  @Override
  protected void setup() {
    addBehaviour( new Looper( this, 300 ) );
    addBehaviour( new TwoStep( this ) );
  }

}
