/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Bank1.Behaviours;

import Bank1.Ontologies.BankVocabulary;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

/**
 *
 * @author nahualli
 */
public class RegisterInDF extends OneShotBehaviour implements BankVocabulary {
// ---------------------------------------------  Register in the DF for the client agent
//                                                be able to retrieve its AID
  public RegisterInDF(Agent a) {
    super(a);
  }

  public void action() {

    ServiceDescription sd = new ServiceDescription();
    sd.setType(SERVER_AGENT);
    sd.setName(myAgent.getName());
    sd.setOwnership("Prof6802");
    DFAgentDescription dfd = new DFAgentDescription();
    dfd.setName(myAgent.getAID());
    dfd.addServices(sd);
    try {
      DFAgentDescription[] dfds = DFService.search(myAgent, dfd);
      if (dfds.length > 0 ) {
        DFService.deregister(myAgent, dfd);
      }
      DFService.register(myAgent, dfd);
      System.out.println( myAgent.getLocalName() + " is ready.");
    } catch (Exception ex) {
      System.out.println("Failed registering with DF! Shutting down...");
      ex.printStackTrace();
      myAgent.doDelete();
    }
  }
}
