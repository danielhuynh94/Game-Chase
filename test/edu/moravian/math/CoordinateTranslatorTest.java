/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.math;

import java.awt.Point;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danielhuynh
 */
public class CoordinateTranslatorTest 
{
    @Test
    public void testOnetoOne()
    {
        CoordinateTranslator ct = new CoordinateTranslator(800, 600, 800, 600, 0, 0);
        for(int i = 0; i < 801; i += 160)
            for(int j = 0; j < 601; j+= 120)
            {
                //screenToWorld
                Point2D worldPoint0 = ct.screenToWorld(i, j);
                assertEquals(i, worldPoint0.getX(), 0.00001);
                assertEquals(600 - j, worldPoint0.getY(), 0.00001);
                
                Point testScreenPoint = new Point(i, j);
                Point2D worldPoint1 = ct.screenToWorld(testScreenPoint);
                assertEquals(i, worldPoint1.getX(), 0.00001);
                assertEquals(600 - j, worldPoint1.getY(), 0.00001);
                
                //worldToScreen
                Point screenPoint0 = ct.worldToScreen(i, j);
                assertEquals(i, screenPoint0.getX(), 0.00001);
                assertEquals(600 - j, screenPoint0.getY(), 0.00001);
                
                Point2D testWorldPoint = new Point2D(i, j);
                Point screenPoint1 = ct.worldToScreen(testWorldPoint);
                assertEquals(i, screenPoint1.getX(), 0.00001);
                assertEquals(600 - j, screenPoint1.getY(), 0.00001); 
            }
        for(int i = -800; i < 1; i += 160)
            for(int j = -600; j < 1; j+= 120)
            {
                //screenToWorld
                Point2D worldPoint0 = ct.screenToWorld(i, j);
                assertEquals(i, worldPoint0.getX(), 0.00001);
                assertEquals(600 - j, worldPoint0.getY(), 0.00001);
                
                Point testScreenPoint = new Point(i, j);
                Point2D worldPoint1 = ct.screenToWorld(testScreenPoint);
                assertEquals(i, worldPoint1.getX(), 0.00001);
                assertEquals(600 - j, worldPoint1.getY(), 0.00001);
                
                //worldToScreen
                Point screenPoint0 = ct.worldToScreen(i, j);
                assertEquals(i, screenPoint0.getX(), 0.00001);
                assertEquals(600 - j, screenPoint0.getY(), 0.00001);
                
                Point2D testWorldPoint = new Point2D(i, j);
                Point screenPoint1 = ct.worldToScreen(testWorldPoint);
                assertEquals(i, screenPoint1.getX(), 0.00001);
                assertEquals(600 - j, screenPoint1.getY(), 0.00001); 
            }
    }
    
    @Test
    public void testSameSizeWithOffset()
    {
        CoordinateTranslator ct = new CoordinateTranslator(800, 600, 800, 600, 100, 200);
        for(int i = 0; i < 801; i += 160)
            for(int j = 0; j < 601; j+= 120)
            {
                //screenToWorld
                Point2D worldPoint0 = ct.screenToWorld(i, j);
                assertEquals(100 + i, worldPoint0.getX(), 0.00001);
                assertEquals(600 + 200 - j, worldPoint0.getY(), 0.00001);
                
                Point testScreenPoint = new Point(i, j);
                Point2D worldPoint1 = ct.screenToWorld(testScreenPoint);
                assertEquals(100 + i, worldPoint1.getX(), 0.00001);
                assertEquals(600 + 200 - j, worldPoint1.getY(), 0.00001);
                
                //worldToScreen
                Point screenPoint0 = ct.worldToScreen(i, j);
                assertEquals(i - 100, screenPoint0.getX(), 0.00001);
                assertEquals(600 + 200 - j, screenPoint0.getY(), 0.00001);
                
                Point2D testWorldPoint = new Point2D(i, j);
                Point screenPoint1 = ct.worldToScreen(testWorldPoint);
                assertEquals(i - 100, screenPoint1.getX(), 0.00001);
                assertEquals(600 + 200 - j, screenPoint1.getY(), 0.00001); 
            }
        for(int i = -800; i < 1; i += 160)
            for(int j = -600; j < 1; j+= 120)
            {
                //screenToWorld
                Point2D worldPoint0 = ct.screenToWorld(i, j);
                assertEquals(100 + i, worldPoint0.getX(), 0.00001);
                assertEquals(600 + 200 - j, worldPoint0.getY(), 0.00001);
                
                Point testScreenPoint = new Point(i, j);
                Point2D worldPoint1 = ct.screenToWorld(testScreenPoint);
                assertEquals(100 + i, worldPoint1.getX(), 0.00001);
                assertEquals(600 + 200 - j, worldPoint1.getY(), 0.00001);
                
                //worldToScreen
                Point screenPoint0 = ct.worldToScreen(i, j);
                assertEquals(i - 100, screenPoint0.getX(), 0.00001);
                assertEquals(600 + 200 - j, screenPoint0.getY(), 0.00001);
                
                Point2D testWorldPoint = new Point2D(i, j);
                Point screenPoint1 = ct.worldToScreen(testWorldPoint);
                assertEquals(i - 100, screenPoint1.getX(), 0.00001);
                assertEquals(600 + 200 - j, screenPoint1.getY(), 0.00001); 
            }
    }
    
    @Test
    public void testProportionalSize()
    {
        CoordinateTranslator ct = new CoordinateTranslator(80, 60, 800, 600, 0, 0);
        for(int i = 0; i < 801; i += 160)
            for(int j = 0; j < 601; j+= 120)
            {
                //screenToWorld
                Point2D worldPoint0 = ct.screenToWorld(i, j);
                assertEquals(i/10, worldPoint0.getX(), 0.00001);
                assertEquals(60 - (j/10), worldPoint0.getY(), 0.00001);
                
                Point testScreenPoint = new Point(i, j);
                Point2D worldPoint1 = ct.screenToWorld(testScreenPoint);
                assertEquals(i/10, worldPoint1.getX(), 0.00001);
                assertEquals(60 - (j/10), worldPoint1.getY(), 0.00001);
                
                //worldToScreen
                Point screenPoint0 = ct.worldToScreen(i, j);
                assertEquals(i*10, screenPoint0.getX(), 0.00001);
                assertEquals(600 - (j*10), screenPoint0.getY(), 0.00001);
                
                Point2D testWorldPoint = new Point2D(i, j);
                Point screenPoint1 = ct.worldToScreen(testWorldPoint);
                assertEquals(i*10, screenPoint1.getX(), 0.00001);
                assertEquals(600 - (j*10), screenPoint1.getY(), 0.00001); 
            }
        for(int i = -800; i < 1; i += 160)
            for(int j = -600; j < 1; j+= 120)
            {
                //screenToWorld
                Point2D worldPoint0 = ct.screenToWorld(i, j);
                assertEquals(i/10, worldPoint0.getX(), 0.00001);
                assertEquals(60 - (j/10), worldPoint0.getY(), 0.000001);
                
                Point testScreenPoint = new Point(i, j);
                Point2D worldPoint1 = ct.screenToWorld(testScreenPoint);
                assertEquals(i/10, worldPoint1.getX(), 0.00001);
                assertEquals(60 - (j/10), worldPoint1.getY(), 0.00001);
                
                //worldToScreen
                Point screenPoint0 = ct.worldToScreen(i, j);
                assertEquals(i*10, screenPoint0.getX(), 0.00001);
                assertEquals(600 - (j*10), screenPoint0.getY(), 0.00001);
                
                Point2D testWorldPoint = new Point2D(i, j);
                Point screenPoint1 = ct.worldToScreen(testWorldPoint);
                assertEquals(i*10, screenPoint1.getX(), 0.00001);
                assertEquals(600 - (j*10), screenPoint1.getY(), 0.00001); 
            }
    }
    
    @Test
    public void testProportionalSizeWithOffset()
    {
        CoordinateTranslator ct = new CoordinateTranslator(80, 60, 800, 600, -40, -30);
        for(int i = 0; i < 801; i += 160)
            for(int j = 0; j < 601; j+= 120)
            {
                //screenToWorld
                Point2D worldPoint0 = ct.screenToWorld(i, j);
                assertEquals((i/10) - 40, worldPoint0.getX(), 0.00001);
                assertEquals(60 + (-30) - (j/10), worldPoint0.getY(), 0.00001);
                
                Point testScreenPoint = new Point(i, j);
                Point2D worldPoint1 = ct.screenToWorld(testScreenPoint);
                assertEquals((i/10) - 40, worldPoint1.getX(), 0.00001);
                assertEquals(60 + (-30) - (j/10), worldPoint1.getY(), 0.00001);
                
                //worldToScreen
                Point screenPoint0 = ct.worldToScreen(i, j);
                assertEquals((i - (-40))*10, screenPoint0.getX(), 0.00001);
                assertEquals((60 - j + (-30))*10, screenPoint0.getY(), 0.00001);
                
                Point2D testWorldPoint = new Point2D(i, j);
                Point screenPoint1 = ct.worldToScreen(testWorldPoint);
                assertEquals((i - (-40))*10, screenPoint1.getX(), 0.00001);
                assertEquals((60 - j + (-30))*10, screenPoint1.getY(), 0.00001); 
            }
        for(int i = -800; i < 1; i += 160)
            for(int j = -600; j < 1; j+= 120)
            {
                //screenToWorld
                Point2D worldPoint0 = ct.screenToWorld(i, j);
                assertEquals((i/10) - 40, worldPoint0.getX(), 0.00001);
                assertEquals(60 + (-30) - (j/10), worldPoint0.getY(), 0.00001);
                
                Point testScreenPoint = new Point(i, j);
                Point2D worldPoint1 = ct.screenToWorld(testScreenPoint);
                assertEquals((i/10) - 40, worldPoint1.getX(), 0.00001);
                assertEquals(60 + (-30) - (j/10), worldPoint1.getY(), 0.00001);
                
                //worldToScreen
                Point screenPoint0 = ct.worldToScreen(i, j);
                assertEquals((i - (-40))*10, screenPoint0.getX(), 0.00001);
                assertEquals((60 - j + (-30))*10, screenPoint0.getY(), 0.00001);
                
                Point2D testWorldPoint = new Point2D(i, j);
                Point screenPoint1 = ct.worldToScreen(testWorldPoint);
                assertEquals((i - (-40))*10, screenPoint1.getX(), 0.00001);
                assertEquals((60 - j + (-30))*10, screenPoint1.getY(), 0.00001); 
            }
    }
}
