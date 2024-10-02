package Main;

//import java.awt.Color;
//import java.awt.RenderingHints.Key;
//import java.awt.event.KeyEvent;
//import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Data.Vector2D;
import Data.spriteInfo;
import logic.Control;
import timer.stopWatchX;

public class Main{
	// Fields (Static) below...
	//public static Color c = new Color(0,153,0);
	public static Vector2D currentVec = new Vector2D(-100, -100);
	public static boolean isImageDrawn = false;
	public static stopWatchX timer = new stopWatchX(250);
	public static ArrayList<spriteInfo> move = new ArrayList<>(); 
	public static int currentSpriteIndex = 0;
	public static int SpriteOffset = 0;
	
	
	
	public static void pressW() {
		//retrieve the current SpriteInfo Object
		spriteInfo currentSprite = move.get(currentSpriteIndex);
		//Vector2D  currentPosition = up.getCoords();
		//get the current position of the sprite
		Vector2D  currentPosition = currentSprite.getCoords();
		//calculate the new position by decrementing the y coordinate by 10, allows it to go in the up direction
		Vector2D newPosition = new Vector2D(currentPosition.getX(), currentPosition.getY()-50);
		if(newPosition.getY() < 72) {
			return;
		}
		SpriteOffset = 12;
		updateSpritePosition(newPosition);
		
		
		
		
	}
		
		
	
		
	   
		
		
	
	
	
	public static void pressS() {
		spriteInfo presentSprite = move.get(currentSpriteIndex);
		
		Vector2D presentPosition = presentSprite.getCoords();
		
		Vector2D newnewPosition = new Vector2D(presentPosition.getX(), presentPosition.getY()+50);
		
		//presentSprite.setCoords(newnewPosition);
		if(newnewPosition.getY() > 600) {

			return;
			}
		SpriteOffset = 0;
		updateSpritePosition(newnewPosition);
		
		
		
		
		
		
		
	}
	public static void pressA() {
		spriteInfo nowSprite = move.get(currentSpriteIndex);
		
		Vector2D nowPosition = nowSprite.getCoords();
		
		Vector2D brandnewPosition = new Vector2D(nowPosition.getX()-50, nowPosition.getY());
		
		//nowSprite.setCoords(brandnewPosition);
		if(brandnewPosition.getX() < 171) {
			return;
		}
		
		SpriteOffset = 4;
		
		updateSpritePosition(brandnewPosition);
		
		
	}
	
	public static void pressD() {
		spriteInfo nownowSprite = move.get(currentSpriteIndex);
		
		Vector2D nownowPosition = nownowSprite.getCoords();
		
		Vector2D recentPosition = new Vector2D(nownowPosition.getX()+50, nownowPosition.getY()); 
		if(recentPosition.getX() > 1049) {
			return;
		}
		
		SpriteOffset = 8;
		
		updateSpritePosition(recentPosition);
		
		
		
		
	}
	
	public static void updateSpritePosition(Vector2D NewPosition) {
		
		for(int i = 0; i<move.size(); i++) {
			spriteInfo temp = move.get(i);
			temp.setCoords(NewPosition);
			}
		
	}
	
	// End Static fields...
	
	public static void main(String[] args) {
		Control ctrl = new Control();				// Do NOT remove!
		ctrl.gameLoop();							// Do NOT remove!
	}
	
	// This is your access to things BEFORE the game loop starts 
	public static void start(){
		// TODO: Populate sprites, total of 16 split into 4 arrayLists
		
		//String[] directions = {"up","down","left","right"};
		int frameCounter = 1;
		
		
		spriteInfo down1 = new spriteInfo(new Vector2D(500,388), "down1");
		spriteInfo down2 = new spriteInfo(new Vector2D(501,388), "down2");
		spriteInfo down3 = new spriteInfo(new Vector2D(502,388), "down3");
		spriteInfo down4 = new spriteInfo(new Vector2D(503,388), "down4");
		
		spriteInfo left1 = new spriteInfo(new Vector2D(504,388), "left1");
		spriteInfo left2= new spriteInfo(new Vector2D(505,388), "left2");
		spriteInfo left3 = new spriteInfo(new Vector2D(506,388), "left3");
		spriteInfo left4 = new spriteInfo(new Vector2D(507,388), "left4");
		
		spriteInfo right1 = new spriteInfo(new Vector2D(508,388), "right1");
		spriteInfo right2 = new spriteInfo(new Vector2D(509,388), "right2");
		spriteInfo right3 = new spriteInfo(new Vector2D(510,388), "right3");
		spriteInfo right4 = new spriteInfo(new Vector2D(511,388), "right4");
		
		spriteInfo up1 = new spriteInfo(new Vector2D(512,388), "up1");
		spriteInfo up2 = new spriteInfo(new Vector2D(513,388), "up2");
		spriteInfo up3 = new spriteInfo(new Vector2D(514,388), "up3");
		spriteInfo up4 = new spriteInfo(new Vector2D(515,388), "up4");
		
		move.add(down1); 
		move.add(down2);
		move.add(down3);
		move.add(down4);
		
		move.add(left1); 
		move.add(left2);
		move.add(left3);
		move.add(left4);
		
		move.add(right1); 
		move.add(right2);
		move.add(right3);
		move.add(right4);
		
		move.add(up1); 
		move.add(up2);
		move.add(up3);
		move.add(up4);
		
		if (frameCounter == 3) {
           frameCounter = 0;
        }
       frameCounter++;
    
    // Set the currentSpriteIndex to the initial position of the first sprite in the animation sequence
    currentSpriteIndex = 0;
   
	    currentVec = move.get(currentSpriteIndex).getCoords();
	   
	    }
	
	 //This is your access to the "game loop" (It is a "callback" method from the Control class (do NOT modify that class!))
	public static void update(Control ctrl) {
		// TODO: This is where you can code! (Starting code below is just to show you how it works)
		
		//check for key presses and then update sprite positions
//		
	    //Render Sprites to display
	    
	    
	    if(timer.isTimeUp()) {
            currentSpriteIndex++;

            currentSpriteIndex %= 4;
            currentSpriteIndex += SpriteOffset;
       




            timer.resetWatch();
        
	    
	    
	    
		
				}
	    spriteInfo Temp = move.get(currentSpriteIndex);
	    ctrl.addSpriteToFrontBuffer(0,0,"background");
	    ctrl.addSpriteToFrontBuffer(Temp.getCoords().getX(), Temp.getCoords().getY(), Temp.getTag());
	    //ctrl.addSpriteToFrontBuffer(0,0,"layout");
	}
}
	

	
			
			
			
			
		
		
		
		
	
	
	// Additional Static methods below...(if needed)

	


			


