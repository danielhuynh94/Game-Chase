/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.model;

import edu.moravian.stateMachine.AgentState;
import edu.moravian.stateMachine.Chase;
import java.awt.Point;

/**
 *
 * @author danielhuynh
 */
public class Agent extends Entity 
{
    private AgentState currentState;
    private final int maxEnergy;
    private int energy;
    private final int maxHealth;
    private int health;

    public Agent(int maxHealth, int maxEnergy) 
    {
        this.currentState = Chase.getInstance();
        this.maxEnergy = maxEnergy;
        this.energy = maxEnergy;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.entityWX = (int) (Math.random()*((ct.getWorldWidth()*32)*ct.getWorldWidth()/ct.getScreenWidth()));
        this.entityWY = (int) (Math.random()*((ct.getWorldHeight()*32)*ct.getWorldHeight()/ct.getScreenHeight()));
    }
    
    @Override
    public void update() 
    {
        Point entityCo = ct.worldToScreen(entityWX, entityWY);
        entityMX = (int) entityCo.getX();
        entityMY = (int)(entityCo.getY() - ct.getScreenHeight())*-1;
        currentState.Execute(this);
    }
    
    @Override
    public void reset()
    {
        this.entityWX = (int) (Math.random()*((ct.getWorldWidth()*32)*ct.getWorldWidth()/ct.getScreenWidth()));
        this.entityWY = (int) (Math.random()*((ct.getWorldHeight()*32)*ct.getWorldHeight()/ct.getScreenHeight()));
    }
    
    public void changeState(AgentState newState)
    {
        currentState = newState;
    }
    
    public void setEntityWX(double entityWX)
    {
        this.entityWX = entityWX;
    }
    
    public void setEntityWY(double entityWY)
    {
        this.entityWY = entityWY;
    }
    
    public int getEnergy() {
        return energy;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }
    
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
