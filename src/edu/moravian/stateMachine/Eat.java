/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.stateMachine;
import edu.moravian.main.Game;
import edu.moravian.model.Agent;

/**
 *
 * @author danielhuynh
 */
public class Eat implements AgentState
{
    private static Eat instance;
    private Eat()
    {}
    
    public static Eat getInstance()
    {
        if(instance == null)
            instance = new Eat();
        return instance;
    }

    @Override
    public void Execute(Agent agentEntity) 
    {
        int health = agentEntity.getHealth();
        if(agentEntity.getEnergy()!=0 && health!=agentEntity.getMaxHealth())
        {
            if(agentEntity.getEntityMX() != 1703 || agentEntity.getEntityMY() != 1125)
            {
                int energy = agentEntity.getEnergy();
                this.performAction(agentEntity);
                energy -= 1;
                agentEntity.setEnergy(energy);
            }
            else
            {
                health+=5;
                agentEntity.setHealth(health);
            }
        }
        else if (agentEntity.getEnergy()==0)
        {
            agentEntity.changeState(Rest.getInstance());
        }
        else
        {
            agentEntity.changeState(Chase.getInstance());
        }
    }

    @Override
    public void performAction(Agent agentEntity) 
    {
        int agentMX = agentEntity.getEntityMX();
        int agentMY = agentEntity.getEntityMY();
        double agentWX = 0;
        double agentWY = 0;
        int delta = Game.getInstance().getDelta();
        if(1703 != agentMX)
        {
            if(1703 > agentMX)
            {
                agentWX =(agentEntity.getEntityWX() +1*delta / 80.0) % ((Game.getInstance().getWorldWidth()*32*Game.getInstance().getWorldWidth())/Game.getInstance().getScreenWidth());
            }
            else if(1703 < agentMX)
            {
                agentWX = (agentEntity.getEntityWX() -1*delta / 80.0);
            }
            agentEntity.setEntityWX(agentWX);
        }
        if(1125 != agentMY)
        {
            if(1125 > agentMY)
            {
                agentWY =(agentEntity.getEntityWY() +1*delta / 80.0) % ((Game.getInstance().getWorldHeight()*32*Game.getInstance().getWorldHeight())/Game.getInstance().getScreenHeight());

            }
            else if(1125 < agentMY)
            {
                agentWY = (agentEntity.getEntityWY() -1*delta / 80.0);
            }
            agentEntity.setEntityWY(agentWY);
        }
    }
}
