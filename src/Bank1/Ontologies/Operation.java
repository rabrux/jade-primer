/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Bank1.Ontologies;

import jade.content.Concept;

/**
 *
 * @author nahualli
 */
public class Operation implements BankVocabulary, Concept {
// --------------------------------------------------------

  private int type;
  private float amount;
  private float balance;
  private String accountId;
  private java.util.Date date;

  public int getType() {
    return type;
  }

  public float getAmount() {
    return amount;
  }

  public float getBalance() {
    return balance;
  }

  public String getAccountId() {
    return accountId;
  }

  public java.util.Date getDate() {
    return date;
  }

  public void setType(int type) {
    this.type = type;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public void setBalance(float balance) {
    this.balance = balance;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public void setDate(java.util.Date date) {
    this.date = date;
  }

  public String getName() {
    if (type == DEPOSIT) return "Depos.";
    if (type == WITHDRAWAL) return "Withd.";
    return "Admin.";
  }

  @Override
  public String toString() {
    return "\n\t" + date + "  " + getName()
      +  "  " + amount + "  " + balance;
  }

}