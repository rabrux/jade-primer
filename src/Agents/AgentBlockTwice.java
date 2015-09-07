/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.BlockTwice;
import jade.core.Agent;

/**
 *
 * @author nahualli
 */
public class AgentBlockTwice extends Agent {

  @Override
  protected void setup() {
    addBehaviour( new BlockTwice( this ) );
  }

}
