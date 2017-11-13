package gui;

import static org.lwjgl.opengl.GL11.glViewport;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;

import renderEngine.DisplayManager;

public class GameWindow{

	private static JFrame frame;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameWindow window = new GameWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameWindow() {
		initialize();
		createDisplay();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static Canvas canvas;
	private static void initialize() {
				
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(0, 0, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Canvas canvas = new Canvas();
		canvas.setBounds(0, 0, WIDTH, HEIGHT);
		frame.getContentPane().add(canvas);
		
		Button button = new Button("Exit");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(900, 10, 70, 22);
		frame.getContentPane().add(button);
		
		Button button_1 = new Button("Save");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(900, 67, 70, 22);
		frame.getContentPane().add(button_1);
	}
	public static void createDisplay() {
		ContextAttribs attribs = new ContextAttribs(4, 0).withForwardCompatible(true).withProfileCore(true);
		initialize();
		

		try {
			Display.setParent(canvas);
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle("my engine");
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		glViewport(0, 0, WIDTH, HEIGHT);
		
		//lastFrameTime = getCurrentTime();
	}
}
