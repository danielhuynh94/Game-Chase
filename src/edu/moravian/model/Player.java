/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.model;

import edu.moravian.main.Game;
import java.awt.Point;

/**
 *
 * @author danielhuynh
 */
public class Player extends Entity
{
    private int mapX, mapY;
    
    public Player()
    {
    }

    @Override
    public void update() 
    {
        Point entityCo = ct.worldToScreen(Game.getInstance().getX(), Game.getInstance().getY());
        
        mapX = (int) entityCo.getX();
        mapY = (int) entityCo.getY() - ct.getScreenHeight();
        
        entityMX = (int)mapX + ct.getScreenWidth()/2;
        entityMY = (int)mapY + ct.getScreenHeight()/2;
        
        entityWX = (entityMX*ct.getWorldWidth()/ct.getScreenWidth());
        entityWY = (ct.getWorldHeight()*32-entityMY)*ct.getWorldHeight()/ct.getScreenHeight();
    }

    @Override
    public void reset() 
    {
    }
}
