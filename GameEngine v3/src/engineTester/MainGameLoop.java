package engineTester;

import org.lwjgl.opengl.Display;

import gui.GameWindow;
import gui.Gui;
import renderEngine.DisplayManager;
import toolbox.MousePicker;

public class MainGameLoop {

	public static void main(String[] args) {
	
		Gui.createDisplay();
		Drawing draw =  new Drawing();
		draw.draw();	
		
		while(!Display.isCloseRequested()){
					
			draw.render();			
			
			DisplayManager.updateDisplay();
		}
		
		draw.cleanUp();
		DisplayManager.closeDisplay();

	}

}
