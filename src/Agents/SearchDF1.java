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
public class SearchDF1 extends Agent {

  @Override
  protected void setup() {
    ServiceDescription sd = new ServiceDescription();
    sd.setType( "buyer" );
    sd.setName( getLocalName() );
    register(sd);

    try {
      DFAgentDescription dfd = new DFAgentDescription();
      DFAgentDescription[] result = DFService.search( this, dfd );

			System.out.println( "Search returns: " + result.length + " elements" );
			if (result.length > 0)
        System.out.println( " " + result[0].getName() );


			sd = new ServiceDescription();
			sd.setType( "buyer" );
			dfd.addServices( sd );
			result = DFService.search( this, dfd );
			System.out.println( "Search for BUYER: " + result.length + " elements" );
			if (result.length > 0)
				System.out.println( " " + result[0].getName() );

			sd.setType( "seller" );
			result = DFService.search(this, dfd);
			if (result==null)
        System.out.println("Search1 returns null");
			else {
				System.out.println("Search for SELLER: " + result.length + " elements" );
				if (result.length>0)
					System.out.println(" " + result[0].getName() );
			}
    } catch(FIPAException fe) {
      fe.printStackTrace();
    }
    System.exit(0);
  }

  protected void register(ServiceDescription sd) {
    DFAgentDescription dfd = new DFAgentDescription();
    dfd.setName( getAID() );
    dfd.addServices( sd );

    try {
      DFService.register( this , dfd );
    } catch(FIPAException fe) {
      fe.printStackTrace();
    }
  }

}
