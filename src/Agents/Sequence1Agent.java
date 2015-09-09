/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.Sequence1;
import jade.core.Agent;

/**
 *
 * @author nahualli
 */
public class Sequence1Agent extends Agent {

  @Override
  protected void setup() {
    addBehaviour( new Sequence1(this, 1000, 2000) );
  }

}
