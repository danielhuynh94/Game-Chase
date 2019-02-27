/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.stateMachine;

import edu.moravian.model.Agent;

/**
 *
 * @author danielhuynh
 */
public interface AgentState 
{   
    public void Execute(Agent agentEntity);
    public void performAction(Agent agentEntity);
}
