package renderEngine;

import static org.lwjgl.opengl.GL11.glViewport;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;
//import org.omg.PortableServer.ServantRetentionPolicyValue;

public class DisplayManager {

	private static final int WIDTH = 1280;
	private static final int HEIGHT = 00;
	private static final int FPS_CAP = 120;
	
	private static long lastFrameTime;
	private static float delta;
	

	public static void createDisplay() {
		ContextAttribs attribs = new ContextAttribs(4, 0).withForwardCompatible(true).withProfileCore(true);
		
		

		try {
			//Display.setParent(canvas);
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle("my engine");
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		glViewport(0, 0, WIDTH, HEIGHT);
		
		lastFrameTime = getCurrentTime();
	}

	public static void updateDisplay() {

		Display.sync(FPS_CAP);
		Display.update();
		long currentFrame = getCurrentTime();
		delta = (currentFrame - lastFrameTime)/1000f;
		lastFrameTime = currentFrame;
	}

	public static float getFrameTimeSeconds() {
		return delta;
	}
	
	public static void closeDisplay() {

		Display.destroy();

	}

	public static long getCurrentTime() {
		return (long) (Sys.getTime() * 1000 / Sys.getTimerResolution());
	}

	public void createDisplay(int width, int height, Canvas canvas) {
		ContextAttribs attribs = new ContextAttribs(4, 0).withForwardCompatible(true).withProfileCore(true);
		try {
			Display.setParent(canvas);
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle("my engine");
		} catch (LWJGLException e) {
			e.printStackTrace();
		}		
	}
}
