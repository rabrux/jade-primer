/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agents;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;

/**
 *
 * @author nahualli
 */
public class DFSearch2 extends Agent {

  @Override
  protected void setup() {

    ServiceDescription sd = new ServiceDescription();
    sd.setType( "buyer" );
    sd.setName( getLocalName() );
    register( sd ) ;

    AID agent = getService( "buyer" );
    System.out.println( "\nBuyer: " + ( agent==null ? "not Found" : agent.getName() ) );

    agent = getService( "auction" );
    System.out.println( "\nAuction: " + ( agent==null ? "not Found" : agent.getName() ) );

    AID [] buyers = searchDF("buyer");
    System.out.print("\nBUYERS: ");
    for (int i=0; i<buyers.length; i++)
      System.out.print( buyers[i].getLocalName() + ",  ");

    System.out.println();

		doDelete();
		System.exit(0);

  }

  protected void register(ServiceDescription sd) {
    DFAgentDescription dfd = new DFAgentDescription();
    dfd.setName( getAID() );
    try {
      DFAgentDescription list[] = DFService.search( this , dfd );
      if ( list.length > 0 ) {
        System.out.println("Des");
        DFService.deregister( this );
        dfd.addServices( sd );
        DFService.register( this, dfd );
      } else {
        System.out.println("no");
        dfd.addServices( sd );
        DFService.register( this, dfd );
      }
    } catch( FIPAException fe ) {
      fe.printStackTrace();
    }
  }

  protected AID getService(String service) {
    DFAgentDescription dfd = new DFAgentDescription();
    ServiceDescription sd = new ServiceDescription();
    sd.setType( service );
    dfd.addServices( sd );
    try {
      DFAgentDescription[] result = DFService.search( this, dfd );
      if ( result.length > 0 )
        return result[0].getName();
    } catch( FIPAException fe ) {
      fe.printStackTrace();
    }
    return null;
  }

  @Override
  protected void takeDown() {
	  try {
      DFService.deregister(this);
    } catch (Exception e) {}
  }

  private AID[] searchDF(String service) {
    DFAgentDescription dfd = new DFAgentDescription();
    ServiceDescription sd = new ServiceDescription();
    sd.setType( service );
		dfd.addServices(sd);

		SearchConstraints ALL = new SearchConstraints();
		ALL.setMaxResults(new Long(-1));

		try {
			DFAgentDescription[] result = DFService.search(this, dfd, ALL);
			AID[] agents = new AID[result.length];
			for (int i=0; i<result.length; i++)
			agents[i] = result[i].getName() ;
			return agents;
		} catch (FIPAException fe) {
      fe.printStackTrace();
    }
    return null;
  }

}
