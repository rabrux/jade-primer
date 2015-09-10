/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.SequenceTiker;
import Behaviours.SequentialDelay;
import jade.core.Agent;

/**
 *
 * @author nahualli
 */
public class Sequence2Agent extends Agent {

  private long t0 = System.currentTimeMillis();

  @Override
  protected void setup() {
    addBehaviour( new SequentialDelay( this, this.t0 ) );
    addBehaviour( new SequenceTiker( this, 3000, this.t0 ) );
  }

}
