/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import Behaviours.TemplateResponderBehaviour;
import jade.core.Agent;

/**
 *
 * @author nahualli
 */
public class TemplateResponderAgent extends Agent {

  @Override
  protected void setup() {
    addBehaviour( new TemplateResponderBehaviour( this ) );
  }

}
