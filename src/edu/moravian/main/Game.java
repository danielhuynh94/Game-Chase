/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.moravian.main;

import edu.moravian.math.CoordinateTranslator;
import edu.moravian.model.Agent;
import edu.moravian.model.CollisionDetector;
import edu.moravian.model.Entity;
import edu.moravian.model.LoggingMechanism;
import edu.moravian.model.MiniMap;
import edu.moravian.model.Player;
import edu.moravian.model.Treasure;
import edu.moravian.view.MapRenderer;
import edu.moravian.view.SpriteRenderer;
import java.util.ArrayList;
import org.newdawn.slick.Animation;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author danielhuynh
 */
public class Game extends BasicGame
{
    private static Game instance;
    
    private final int WIDTH = 1024;
    private final int HEIGHT = 720;
    
    private SpriteSheet playeracter, agent;
    private Animation playerAnimation, agentAnimation;
    private Image treasure, miniMapImage;
    private TiledMap map;
    private Music music;
    private Sound getTreasure, getKilled;
    private SpriteRenderer playerRenderer, agentRenderer, agentRenderer1, agentRenderer2, treasureRenderer;
    private MapRenderer mapRenderer;
    private MiniMap miniMap;
    private Entity playerEntity, treasureEntity; 
    private Agent agentEntity, agentEntity1, agentEntity2;
    private ArrayList<Agent> agentArray;
    private LoggingMechanism lm;
    
    private double x, y;
    private int delta, winCount, loseCount;
    private CoordinateTranslator ct;
    
    private boolean exit, log, goRightKey, goLeftKey, goUpKey, goDownKey;
    private boolean agentGoUp, agentGoDown, agentGoLeft, agentGoRight;
    
    private Game(String title)
    {
        super(title);
    }
    
    public static Game getInstance()
    {
        if(instance == null)
            instance = new Game("Chase");
        return instance;
    }

    @Override
    public void init(GameContainer gc) throws SlickException 
    {        
        map = new TiledMap("res/map.tmx");
        ct = new CoordinateTranslator(map.getWidth(), map.getHeight(), WIDTH, HEIGHT, 0, 0);
        
        miniMapImage = new Image("res/minimap.png");
        miniMap = new MiniMap(this, miniMapImage);

        music = new Music("res/backgroundMusic.ogg");
//        music.setVolume(0.0f);
//        music.loop();
        getTreasure = new Sound("res/getTreasure.ogg");
        getKilled = new Sound("res/getKilled.ogg");
        
        playeracter = new SpriteSheet("res/playerSheet.png", 32, 32);
        playerAnimation = new Animation(playeracter, 100);
        playerRenderer = new SpriteRenderer(playerAnimation);
            
        agent = new SpriteSheet("res/agentSheet.png" , 32, 32);
        agentAnimation = new Animation(agent, 100);
        agentRenderer = new SpriteRenderer(agentAnimation);
        agentRenderer1 = new SpriteRenderer(agentAnimation);
        agentRenderer2 = new SpriteRenderer(agentAnimation);
        
        treasure = new Image("res/treasure.png");
        treasureRenderer = new SpriteRenderer(treasure);
        
        mapRenderer = new MapRenderer(map);
        winCount = 0;
        loseCount = 0;
        
        x = 0;
        y = 0;
        playerEntity = new Player();
        agentEntity = new Agent(3000, 5000);
        agentEntity1 = new Agent(2000, 6000);
        agentEntity2 = new Agent(4000, 4000);
        agentArray = new ArrayList();
        agentArray.add(agentEntity);
        agentArray.add(agentEntity1);
        agentArray.add(agentEntity2);
        treasureEntity = new Treasure();
        lm = new LoggingMechanism(this);
        exit = false;
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException 
    {
        this.delta = delta;
        Input input = gc.getInput();
        if(input.isKeyPressed(Input.KEY_TAB))
        {
            log = log == false;
        }
        if(goRightKey)
            x = (x + 1 * delta / 60.0) % WIDTH;
        if(goLeftKey)
            x = (x - 1 * delta / 60.0) % WIDTH;
        if(goDownKey)
            y = (y - 1 * delta / 60.0) % HEIGHT;
        if(goUpKey)
            y = (y + 1 * delta / 60.0) % HEIGHT;        
        
        mapRenderer.update(x, y);
        x = mapRenderer.getX();
        y = mapRenderer.getY();
        
        playerEntity.update();
        agentEntity.update();
        agentEntity1.update();
        agentEntity2.update();
        treasureEntity.update();
        miniMap.update();
        
        //Updating coordinates for rendering
        playerRenderer.update(mapRenderer, playerEntity, goUpKey, goDownKey, goLeftKey, goRightKey);
        agentRenderer.update(mapRenderer, agentEntity, agentGoUp, agentGoDown, agentGoLeft, agentGoRight);
        agentRenderer1.update(mapRenderer, agentEntity1, agentGoUp, agentGoDown, agentGoLeft, agentGoRight);
        agentRenderer2.update(mapRenderer, agentEntity2, agentGoUp, agentGoDown, agentGoLeft, agentGoRight);
        treasureRenderer.update(mapRenderer, treasureEntity, false, false, false, false);

        //Collision detection
        if(CollisionDetector.checkCollision(playerEntity.getEntityMX(), playerEntity.getEntityMY(), treasureEntity.getEntityMX(), treasureEntity.getEntityMY()))
        {
            getTreasure.play();
            winCount += 1;
            treasureEntity.reset();
        }
        
        if(CollisionDetector.checkCollision(playerEntity.getEntityMX(), playerEntity.getEntityMY(), agentEntity.getEntityMX(), agentEntity.getEntityMY())
                || CollisionDetector.checkCollision(playerEntity.getEntityMX(), playerEntity.getEntityMY(), agentEntity1.getEntityMX(), agentEntity1.getEntityMY())
                || CollisionDetector.checkCollision(playerEntity.getEntityMX(), playerEntity.getEntityMY(), agentEntity2.getEntityMX(), agentEntity2.getEntityMY()))
        {
            getKilled.play();
            loseCount += 1;
            x = 0;
            y = 0;
            agentEntity.reset();
            agentEntity1.reset();
            agentEntity2.reset();
        }
        
//        if(loseCount == 5 || winCount == 5)
//        {
//            sbg.enterState(2);
//        }
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException 
    {
        //Map
        mapRenderer.render();
        //Entities
        playerRenderer.render(grphcs);
        agentRenderer.render(grphcs);
        agentRenderer1.render(grphcs);
        agentRenderer2.render(grphcs);
        treasureRenderer.render(grphcs);
        //Minimap
        miniMap.render(grphcs);
        //Console output
        if(log)
            lm.display(grphcs);
    }
    
    @Override
    public void keyPressed(int key, char c)
    {
        if(c == 'q' || c == 'Q')
            exit = true;
        if(c == 'd' || c == 'D')
            goRightKey = true;
        if(c == 'w' || c == 'W')
            goUpKey = true;
        if(c == 'a' || c == 'A')
            goLeftKey = true;
        if(c == 's' || c == 'S')
            goDownKey = true;
    }
    
    @Override
    public void keyReleased(int key, char c)
    {
        if(c == 'd' || c == 'D')
            goRightKey = false;
        if(c == 's' || c == 'S')
            goDownKey = false;
        if(c == 'a' || c == 'A')
            goLeftKey = false;
        if(c == 'w' || c == 'W')
            goUpKey = false;
    }
    
    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
    
    public int getScreenWidth()
    {
        return WIDTH;
    }
    
    public int getScreenHeight()
    {
        return HEIGHT;
    }
    
    public int getWorldWidth()
    {
        return map.getWidth();
    }
    
    public int getWorldHeight()
    {
        return map.getHeight();
    }
    
    public int getWinCount()
    {
        return winCount;
    }
    
    public int getLoseCount()
    {
        return loseCount;
    }
    
    public Entity getPlayerEntity()
    {
        return playerEntity;
    }
    
    public Agent getAgentEntity(int iD)
    {
        return agentArray.get(iD);
    }
    
    public Entity getTreasureEntity()
    {
        return treasureEntity;
    }
    
    public int getDelta()
    {
        return delta;
    }
    
    public CoordinateTranslator getCT()
    {
        return ct;
    }
    
    private void reset()
    {
        winCount = 0;
        loseCount = 0;
        x = 0;
        y = 0;
        agentEntity.reset();
    }
}