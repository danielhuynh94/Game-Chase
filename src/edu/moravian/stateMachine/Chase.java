/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.stateMachine;

import edu.moravian.main.Game;
import edu.moravian.model.Agent;
import edu.moravian.model.Entity;

/**
 *
 * @author danielhuynh
 */
public class Chase implements AgentState
{
    private static Chase instance;
    private final Entity playerEntity;
    private Agent agentEntity;
    private double agentWX, agentWY;
    
    private Chase()
    {
        playerEntity = Game.getInstance().getPlayerEntity();
    }
    
    public static Chase getInstance()
    {
        if(instance == null)
            instance = new Chase();
        return instance;
    }

    @Override
    public void Execute(Agent agentEntity) 
    {
        this.agentEntity = agentEntity;
        int energy = agentEntity.getEnergy();
        int health = agentEntity.getHealth();
        if(energy != 0 && health != 0)
        {
            this.performAction(agentEntity);
            energy -= 1;
            health -= 1;
            agentEntity.setEnergy(energy);
            agentEntity.setHealth(health);
        }
        else if (health == 0 && energy == 0 || energy == 0)
        {
            agentEntity.changeState(Rest.getInstance());
        }
        else
        {
            agentEntity.changeState(Eat.getInstance());
        }
    }

    @Override
    public void performAction(Agent agentEntity) 
    {
        int playerMX = playerEntity.getEntityMX();
        int playerMY = playerEntity.getEntityMY();
        int agentMX = agentEntity.getEntityMX();
        int agentMY = agentEntity.getEntityMY();
        int delta = Game.getInstance().getDelta();
        if(playerMX != agentMX)
        {
            if(playerMX > agentMX)
            {
                if((playerMX - agentMX) > Game.getInstance().getWorldWidth()*32/2)
                {
                    agentWX = (agentEntity.getEntityWX() -1*delta / 80.0);
                    if(agentWX < 0)
                        agentWX = Game.getInstance().getWorldWidth()*32*Game.getInstance().getWorldWidth()/Game.getInstance().getScreenWidth();
                }
                else
                    agentWX =(agentEntity.getEntityWX() +1*delta / 80.0) % ((Game.getInstance().getWorldWidth()*32*Game.getInstance().getWorldWidth())/Game.getInstance().getScreenWidth());
            }
            else if(playerMX < agentMX)
            {
                if((agentMX - playerMX) > Game.getInstance().getWorldWidth()*32/2)
                    agentWX =(agentEntity.getEntityWX() +1*delta / 80.0) % ((Game.getInstance().getWorldWidth()*32*Game.getInstance().getWorldWidth())/Game.getInstance().getScreenWidth());
                else
                {
                    agentWX = (agentEntity.getEntityWX() -1*delta / 80.0);
                    if(agentWX < 0)
                        agentWX = Game.getInstance().getWorldWidth()*32*Game.getInstance().getWorldWidth()/Game.getInstance().getScreenWidth();
                }
            }
            agentEntity.setEntityWX(agentWX);
        }
        if(playerMY != agentMY)
        {
            if(playerMY > agentMY)
            {
                if((playerMY - agentMY) > Game.getInstance().getWorldHeight()*32/2)
                {
                    agentWY = (agentEntity.getEntityWY() -1*delta / 80.0);
                    if(agentWY < 0)
                        agentWY = Game.getInstance().getWorldHeight()*32*Game.getInstance().getWorldHeight()/Game.getInstance().getScreenHeight();
                }
                else
                    agentWY =(agentEntity.getEntityWY() +1*delta / 80.0) % ((Game.getInstance().getWorldHeight()*32*Game.getInstance().getWorldHeight())/Game.getInstance().getScreenHeight());
            }
            else if(playerMY < agentMY)
            {
                if((agentMY - playerMY) > Game.getInstance().getWorldHeight()*32/2)
                    agentWY =(agentEntity.getEntityWY() +1*delta / 80.0) % ((Game.getInstance().getWorldHeight()*32*Game.getInstance().getWorldHeight())/Game.getInstance().getScreenHeight());
                else
                {
                    agentWY = (agentEntity.getEntityWY() -1*delta / 80.0);
                    if(agentWY < 0)
                        agentWX = Game.getInstance().getWorldHeight()*32*Game.getInstance().getWorldHeight()/Game.getInstance().getScreenHeight();
                }
            }
            agentEntity.setEntityWY(agentWY);
        }
    }
}
