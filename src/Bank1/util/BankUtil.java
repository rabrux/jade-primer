/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Bank1.util;

import Bank1.Ontologies.BankVocabulary;
import Bank1.Ontologies.Problem;

/**
 *
 * @author nahualli
 */
public class BankUtil implements BankVocabulary {

  public BankUtil() {}

  public String generateId(int idCnt) {
    return hashCode() + "" + (idCnt++);
  }

  public Problem newProblem(int num) {
  // -----------------------------

    String msg = "";

    if (num == ACCOUNT_NOT_FOUND)
    msg = PB_ACCOUNT_NOT_FOUND;

    else if (num == NOT_ENOUGH_MONEY)
    msg = PB_NOT_ENOUGH_MONEY;

    else if (num == ILLEGAL_OPERATION)
    msg = PB_ILLEGAL_OPERATION;

    Problem prob = new Problem();
    prob.setNum(num);
    prob.setMsg(msg);
    return prob;
    
  }

//  public String generateId(int idCnt) {
//  // ----------------------------
//    return hashCode() + "" + (idCnt++);
//  }

}
