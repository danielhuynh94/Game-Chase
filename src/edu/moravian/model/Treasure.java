/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.model;

import java.awt.Point;

/**
 *
 * @author danielhuynh
 */
public class Treasure extends Entity
{
    public Treasure()
    {
        entityWX = (int) (Math.random()*((ct.getWorldWidth()*32)*ct.getWorldWidth()/ct.getScreenWidth()));
        entityWY = (int) (Math.random()*((ct.getWorldHeight()*32)*ct.getWorldHeight()/ct.getScreenHeight()));
    }

    @Override
    public void update() 
    {
        Point entityCo = ct.worldToScreen(entityWX, entityWY);
        entityMX = (int) entityCo.getX();
        entityMY = (int)(entityCo.getY() - ct.getScreenHeight())*-1;
    }
    
    @Override
    public void reset()
    {
        entityWX = (int) (Math.random()*((ct.getWorldWidth()*32)*ct.getWorldWidth()/ct.getScreenWidth()));
        entityWY = (int) (Math.random()*((ct.getWorldHeight()*32)*ct.getWorldHeight()/ct.getScreenHeight()));
    }
}
