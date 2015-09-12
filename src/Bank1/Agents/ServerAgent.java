/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Bank1.Agents;

import Bank1.Behaviours.RegisterInDF;
import Bank1.Ontologies.BankOntology;
import Bank1.Ontologies.BankVocabulary;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.core.Agent;
import jade.core.behaviours.SequentialBehaviour;
import jade.util.leap.HashMap;
import jade.util.leap.Map;

/**
 *
 * @author nahualli
 */
public class ServerAgent extends Agent implements BankVocabulary {

  private Map accounts = new HashMap();
  private Map operations = new HashMap();
  private int idCnt = 0;
  private Codec codec = new SLCodec();
  private Ontology ontology = BankOntology.getInstance();

  @Override
  protected void setup() {
  // ------------------------

    // Register language and ontology
    getContentManager().registerLanguage(codec);
    getContentManager().registerOntology(ontology);

    // Set this agent main behaviour
    SequentialBehaviour sb = new SequentialBehaviour();
    sb.addSubBehaviour(new RegisterInDF(this));
    sb.addSubBehaviour(new ReceiveMessages(this));
    addBehaviour(sb);
  }

}
