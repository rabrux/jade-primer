/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Bank1.Behaviours;

import Bank1.Ontologies.Account;
import Bank1.Ontologies.CreateAccount;
import Bank1.util.BankUtil;
import jade.content.ContentElement;
import jade.content.onto.basic.Action;
import jade.content.onto.basic.Result;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author nahualli
 */
public class HandleCreateAccount extends OneShotBehaviour {
// ----------------------------------------------------  Handler for a CreateAccount request

  private ACLMessage request;
  private int idCnt;
  BankUtil bt = new BankUtil();

  HandleCreateAccount(Agent a, ACLMessage request, int idCnt) {

    super(a);
    this.request = request;
    this.idCnt = idCnt;

  }

  public void action() {

    try {
      ContentElement content = myAgent.getContentManager().extractContent(request);
      CreateAccount ca = (CreateAccount)((Action)content).getAction();
      Account acc = new Account();
      String id = bt.generateId( this.idCnt );
      acc.setId(id);
      acc.setName(ca.getName());
      Result result = new Result((Action)content, acc);
      ACLMessage reply = request.createReply();
      reply.setPerformative(ACLMessage.INFORM);
      myAgent.getContentManager().fillContent(reply, result);
      myAgent.send(reply);
      accounts.put(id, acc);
      operations.put(id, new ArrayList());
      System.out.println("Account [" + acc.getName() + " # " +
      acc.getId() + "] created!");
    } catch(Exception ex) { ex.printStackTrace(); }

  }
  
}