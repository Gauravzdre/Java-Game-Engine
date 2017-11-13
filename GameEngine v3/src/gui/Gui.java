package gui;

import static org.lwjgl.opengl.GL11.glViewport;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;

public class Gui{
		
	public Gui() {
		swing();
	}
	
	private static Canvas canvas;
	
	public static void swing() {
		JFrame frame = new JFrame("My Engine");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(new Dimension(1368,768));
		//frame.setSize(1366, 768);
		frame.setLayout(null);
		frame.setVisible(true);
	
		frame.setLayout(new GridLayout());
		canvas = new Canvas();
		frame.add(canvas);
		canvas.setPreferredSize(new Dimension(1280, 768));
		frame.pack();
		// canvas.setIgnoreRepaint(true);

		// if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
		// System.exit(0);
		// 
		
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("Menu"); 
		JMenu submenu = new JMenu("Sub Menu");
		JMenuItem i1 = new JMenuItem("light control");
		JMenuItem i2 = new JMenuItem("Entity tranformation");
		JMenuItem i3 = new JMenuItem("Item 3");
		JMenuItem i4 = new JMenuItem("Item 4");
		JMenuItem i5 = new JMenuItem("Item 5");
		menu.add(i1);
		menu.add(i2);
		menu.add(i3);
		submenu.add(i4);
		submenu.add(i5);
		menu.add(submenu);
		mb.add(menu);
		frame.setJMenuBar(mb); 
		
		i1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame frame = new Frame();
				frame.setVisible(true);
				
			}
		});
	}
	
	public static void createDisplay() {
		ContextAttribs attribs = new ContextAttribs(4, 0).withForwardCompatible(true).withProfileCore(true);
		swing();
		

		try {
			Display.setParent(canvas);
			Display.setDisplayMode(new DisplayMode(1280, 768));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle("my engine");
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		glViewport(0, 0, 1280, 768);
		
		//lastFrameTime = getCurrentTime();
	}

}
