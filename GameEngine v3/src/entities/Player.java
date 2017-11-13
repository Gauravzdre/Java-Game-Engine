package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import models.TexturedModel;
import renderEngine.DisplayManager;
import terrains.Terrain;

public class Player extends Entity{

	private final static float runSpeed = 15;
	private final static float turnSpeed = 160;
	private static final float GRAVITY = -50;
	private static final float JUMP_POWER = 36;
	private static final float TERRAIN_HEIGHT = 0;
	
	private float currentSpeed = 0;
	private float currentTurnSpeed = 0;
	private float upwardSpeed = 0;
	private boolean isInAir = false;
	float i,f,j;
	
	public Player(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
		super(model, position, rotX, rotY, rotZ, scale);
	}
	
	public void move(Terrain terrain) {
		processInput();
		super.increaseRotation(0, currentTurnSpeed * DisplayManager.getFrameTimeSeconds(), 0);
		float distance = currentSpeed * DisplayManager.getFrameTimeSeconds();
		
		float dx = (float) (distance * Math.sin(Math.toRadians(super.getRotY())));
		float dz = (float) (distance * Math.cos(Math.toRadians(super.getRotY())));
		super.increasePosition(dx, 0, dz);
		upwardSpeed += GRAVITY * DisplayManager.getFrameTimeSeconds();
		super.increasePosition(0, upwardSpeed * DisplayManager.getFrameTimeSeconds(), 0);
		
		float terrainHeight = terrain.terrainHeight(super.getPosition().x, super.getPosition().z);
		
		if(super.getPosition().y < terrainHeight) {
			upwardSpeed = 0;
			isInAir = false; 
			super.getPosition().y = terrainHeight;
		}
		
	}
	public void processInput() {
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			this.currentSpeed = runSpeed;
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			this.currentSpeed = -runSpeed;
		}
		else {
			this.currentSpeed = 0;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			this.currentTurnSpeed = turnSpeed;
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			this.currentTurnSpeed = -turnSpeed;
		}
		else {
			this.currentTurnSpeed = 0;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			if(!isInAir) {
			this.isInAir = true;
			this.upwardSpeed = JUMP_POWER;
			}
		}
	}

	public void rotate(float i, float f, float j) {
		this.i = getRotX();
		this.f = getRotY();
		this.j = getRotZ();
	}
	
	
}
