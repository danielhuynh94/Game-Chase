/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

/**
 *
 * @author danielhuynh
 */
public class Main 
{
    public static void main(String[]args)
    {
        try
        {
            Game play = Game.getInstance();
            AppGameContainer agc = new AppGameContainer(play, play.getScreenWidth(), play.getScreenHeight(), false);
            agc.start();
        }
        catch(SlickException ex)
        {
            System.out.println("Error starting game");
        }
    }
}
