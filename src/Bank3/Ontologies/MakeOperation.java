/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank3.Ontologies;

import jade.content.AgentAction;

/**
 *
 * @author nahualli
 */
public class MakeOperation implements AgentAction {
// ------------------------------------------------

   private int type;
   private float amount;
   private String accountId;

   public int getType() {
      return type;
   }

   public float getAmount() {
     return amount;
   }

   public String getAccountId() {
      return accountId;
   }

   public void setType(int type) {
      this.type = type;
   }

   public void setAmount(float amount) {
      this.amount = amount;
   }

   public void setAccountId(String accountId) {
      this.accountId = accountId;
   }
}