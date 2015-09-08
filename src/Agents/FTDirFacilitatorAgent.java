/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAException;

/**
 *
 * @author nahualli
 */
public class FTDirFacilitatorAgent extends Agent {

  @Override
  protected void setup() {

    DFAgentDescription dfd = new DFAgentDescription();
    dfd.setName( getAID() );
    register( dfd );
    System.exit(0);
  }

  protected void register(DFAgentDescription dfd) {
    try {
      DFService.register(this, dfd );
    } catch( FIPAException fe ) {
      fe.printStackTrace();
    }
  }

}