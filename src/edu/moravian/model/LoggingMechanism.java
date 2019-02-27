/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.model;

import edu.moravian.main.Game;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 *
 * @author danielhuynh
 */
public class LoggingMechanism 
{
    private final Game game;    
    public LoggingMechanism(Game game)
    {
        this.game = game;
    }
    
    public void display(Graphics grphcs)
    {
        grphcs.setColor(Color.black);
        grphcs.drawString("Player's map coor: (" + game.getPlayerEntity().getEntityMX() + "," + game.getPlayerEntity().getEntityMY() +")", 10, 30);
        grphcs.drawString("Player's world coor: (" + game.getPlayerEntity().getEntityWX() + "," + game.getPlayerEntity().getEntityWY() +")", 10, 50);
        grphcs.drawString("Agent's map coor: (" + game.getAgentEntity(0).getEntityMX() + "," + game.getAgentEntity(0).getEntityMY() +")", 10, 70);
        grphcs.drawString("Treasure's map coor: (" + game.getTreasureEntity().getEntityMX() + "," + game.getTreasureEntity().getEntityMY() +")",10, 90);
        grphcs.drawString("winCount: " + game.getWinCount() +"," + " loseCount: " + game.getLoseCount(), 10, 110);
        grphcs.drawString("agentEnergy0: " + game.getAgentEntity(0).getEnergy() +"/" + game.getAgentEntity(0).getMaxEnergy() +" agentHealth1: " + game.getAgentEntity(0).getHealth() +"/" + game.getAgentEntity(0).getMaxHealth(), 10, 130);
        grphcs.drawString("agentEnergy1: " + game.getAgentEntity(1).getEnergy() +"/" + game.getAgentEntity(1).getMaxEnergy() +" agentHealth1: " + game.getAgentEntity(1).getHealth() +"/" + game.getAgentEntity(1).getMaxHealth(), 10, 150);
        grphcs.drawString("agentEnergy2: " + game.getAgentEntity(2).getEnergy() +"/" + game.getAgentEntity(2).getMaxEnergy() +" agentHealth1: " + game.getAgentEntity(2).getHealth() +"/" + game.getAgentEntity(2).getMaxHealth(), 10, 170);
    }
}
