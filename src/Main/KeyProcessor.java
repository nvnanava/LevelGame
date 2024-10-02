package Main;

import logic.Control;
import Data.Vector2D;
import Data.spriteInfo;
import java.util.ArrayList;
import timer.stopWatchX;


public class KeyProcessor{
	// Static Fields
	private static char last = ' ';			// For debouncing purposes
	private static stopWatchX sw = new stopWatchX(250);
	public static Vector2D currentVec = new Vector2D(-100, -100);
	public static ArrayList<spriteInfo> right = new ArrayList<>(); //split the total sprites into groups of 4
	public static ArrayList<spriteInfo> up = new ArrayList<>();
	public static ArrayList<spriteInfo> down = new ArrayList<>();
	public static ArrayList<spriteInfo> left = new ArrayList<>();
	public static int currentSpriteIndex = 0;
	
	// Static Method(s)
	public static boolean processKey(char key){
		if(key == ' ')				return false;
		// Debounce routine below...
		if(key == last)
			if(sw.isTimeUp() == false)			return false;
		last = key;
		sw.resetWatch();
		
		/* TODO: You can modify values below here! */
		switch(key){
		case '%':								// ESC key
			System.exit(0);
			break;
			
		case 'w':
			Main.pressW(); //call key presses from main
			
			
			return true;
		
		case 's': 
			Main.pressS();
			return true;
			
		case 'a':
			Main.pressA();
			
			
			return true;
		
		case'd': 
			Main.pressD();
			return true;
			
			
		
			
		case 'm':
			// For mouse coordinates
			Control.isMouseCoordsDisplayed = !Control.isMouseCoordsDisplayed;
			return true;
		}
		return false;
	}
}