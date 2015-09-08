/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

/**
 *
 * @author nahualli
 */
public class DF2 extends Agent {

  @Override
  protected void setup() {
    ServiceDescription sd = new ServiceDescription();
    sd.setType( "buyer" );
    sd.setName( getLocalName() );
    register(sd);
  }

  protected void register(ServiceDescription sd) {
    DFAgentDescription dfd = new DFAgentDescription();
    dfd.setName( getAID() );
    dfd.addServices( sd );

    try {
      DFService.register( this, dfd );
    }
    catch (FIPAException fe) {
      fe.printStackTrace();
    }
  }

}
