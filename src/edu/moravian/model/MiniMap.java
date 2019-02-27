/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.model;

import edu.moravian.main.Game;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 *
 * @author danielhuynh
 */
public class MiniMap 
{
    private final int miniMapWidth = 200, miniMapHeight = 200;
    private int miniMapPlayerX, miniMapPlayerY, miniMapAgentX, miniMapAgentY, miniMapAgent1X, miniMapAgent1Y, miniMapAgent2X, miniMapAgent2Y, miniMapTreasureX, miniMapTreasureY;
    private final Image miniMap;
    private final Game game;
    public MiniMap(Game game, Image miniMap)
    {
        this.game = game;
        this.miniMap = miniMap;
    }
    
    public void update()
    {
        miniMapPlayerX = game.getPlayerEntity().getEntityMX()*200/(Game.getInstance().getWorldWidth()*32) + (Game.getInstance().getScreenWidth() - 200 - 10);
        miniMapPlayerY = game.getPlayerEntity().getEntityMY()*200/(Game.getInstance().getWorldHeight()*32) + 10;
        miniMapAgentX = game.getAgentEntity(0).getEntityMX()*200/(Game.getInstance().getWorldWidth()*32) + (Game.getInstance().getScreenWidth() - 200 - 10);
        miniMapAgentY = game.getAgentEntity(0).getEntityMY()*200/(Game.getInstance().getWorldHeight()*32) + 10;
        miniMapAgent1X = game.getAgentEntity(1).getEntityMX()*200/(Game.getInstance().getWorldWidth()*32) + (Game.getInstance().getScreenWidth() - 200 - 10);
        miniMapAgent1Y = game.getAgentEntity(1).getEntityMY()*200/(Game.getInstance().getWorldHeight()*32) + 10;
        miniMapAgent2X = game.getAgentEntity(2).getEntityMX()*200/(Game.getInstance().getWorldWidth()*32) + (Game.getInstance().getScreenWidth() - 200 - 10);
        miniMapAgent2Y = game.getAgentEntity(2).getEntityMY()*200/(Game.getInstance().getWorldHeight()*32) + 10;
        miniMapTreasureX = game.getTreasureEntity().getEntityMX()*200/(Game.getInstance().getWorldWidth()*32) + (Game.getInstance().getScreenWidth() - 200 - 10);
        miniMapTreasureY = game.getTreasureEntity().getEntityMY()*200/(Game.getInstance().getWorldHeight()*32) + 10;
    }
    
    public void render(Graphics grphcs)
    {
        grphcs.setColor(Color.red);
        grphcs.drawRect(Game.getInstance().getScreenWidth() - miniMapWidth - 11, 9, miniMapWidth+1, miniMapHeight+1);
        grphcs.flush();
        miniMap.draw(Game.getInstance().getScreenWidth() - miniMapWidth - 10, 10, miniMapWidth, miniMapHeight);
        grphcs.fillRect(miniMapPlayerX, miniMapPlayerY, 5, 5);
        grphcs.setColor(Color.yellow);
        grphcs.fillRect(miniMapAgentX, miniMapAgentY, 5, 5);
        grphcs.fillRect(miniMapAgent1X, miniMapAgent1Y, 5, 5);
        grphcs.fillRect(miniMapAgent2X, miniMapAgent2Y, 5, 5);
        grphcs.setColor(Color.green);
        grphcs.fillRect(miniMapTreasureX, miniMapTreasureY, 5, 5);

    }
}
