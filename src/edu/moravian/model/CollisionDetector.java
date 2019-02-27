/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.model;

/**
 *
 * @author Daniel Huynh
 */
public class CollisionDetector 
{
    public static boolean checkCollision(int x1, int y1, int x2, int y2)
    {
        return Math.pow(16.0+16.0, 2) > (Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }
}
