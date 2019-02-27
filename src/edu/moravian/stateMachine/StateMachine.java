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
public class StateMachine 
{
    private final Agent agentEntity;
    private AgentState currentState, previousState, globalState;
    
    public StateMachine(Agent agentEntity)
    {
        this.agentEntity = agentEntity;
    }
    
    public void setCurrentState(AgentState state)
    {
        this.currentState = state;
    }

    public void setPreviousState(AgentState state) {
        this.previousState = state;
    }

    public void setGlobalState(AgentState state) {
        this.globalState = state;
    }
    
    public void update()
    {
        if(globalState!=null)
            globalState.Execute(agentEntity);
        if(currentState!=null)
            currentState.Execute(agentEntity);
    }
    
    public void changeState(AgentState newState)
    {
        previousState = currentState;
        currentState = newState;
    }
    
    public void revertToPreviousState()
    {
        this.changeState(previousState);
    }

    public AgentState getCurrentState() {
        return currentState;
    }

    public AgentState getPreviousState() {
        return previousState;
    }

    public AgentState getGlobalState() {
        return globalState;
    }
}
