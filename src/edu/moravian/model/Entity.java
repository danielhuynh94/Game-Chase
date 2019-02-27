/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.model;

import edu.moravian.main.Game;
import edu.moravian.math.CoordinateTranslator;

/**
 *
 * @author danielhuynh
 */
public abstract class Entity 
{
    protected final CoordinateTranslator ct = Game.getInstance().getCT();
    protected int delta, entityMX, entityMY;
    protected double entityWX, entityWY;
    
    public Entity()
    {
    }
    
    public abstract void update();
    public abstract void reset();

    public int getEntityMX() {
        return entityMX;
    }

    public int getEntityMY() {
        return entityMY;
    }

    public double getEntityWX() {
        return entityWX;
    }

    public double getEntityWY() {
        return entityWY;
    }
}
