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
public class Rest implements AgentState
{
    private static Rest instance;
    
    private Rest()
    {
    }
    
    public static Rest getInstance()
    {
        if(instance == null)
            instance = new Rest();
        return instance;
    }

    @Override
    public void Execute(Agent agentEntity) 
    {
        int energy = agentEntity.getEnergy();
        if(energy!=agentEntity.getMaxEnergy())
        {
            energy+=2;
            agentEntity.setEnergy(energy);
        }
        else
        {
            agentEntity.changeState(Chase.getInstance());
        }
    }

    @Override
    public void performAction(Agent agentEntity) 
    {
    }
}
