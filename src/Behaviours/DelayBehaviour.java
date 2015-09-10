/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

/**
 *
 * @author nahualli
 */
public class DelayBehaviour extends SimpleBehaviour {
	private long    timeout,
	                wakeupTime;
	private boolean finished;

	public DelayBehaviour(Agent a, long timeout)
	{
		super(a);
		this.timeout = timeout;
		finished = false;
	}

  @Override
	public void onStart() {
		wakeupTime = System.currentTimeMillis() + timeout;
	}

	public void action()
	{
		long dt = wakeupTime - System.currentTimeMillis();
		if (dt <= 0) {
			finished = true;
			handleElapsedTimeout();
		} else
			block(dt);

	}

	protected void handleElapsedTimeout() {}

	public void reset(long timeout) {
	  wakeupTime = System.currentTimeMillis() + timeout ;
	  finished = false;
	}

	public boolean done() {
	  return finished;
	}
}
