/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.SequenceBehaviour;
import jade.core.Agent;

/**
 *
 * @author nahualli
 */
public class SequenceAgent extends Agent {

  @Override
  protected void setup() {
    addBehaviour( new SequenceBehaviour( this, 250, "... Message 1" ) );
    addBehaviour( new SequenceBehaviour( this, 750, "... Message 2" ) );
  }

}
