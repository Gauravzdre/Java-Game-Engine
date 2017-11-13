package cameras;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import entities.Player;
import renderEngine.DisplayManager;

public class ThirdPersonCamera {
	public float DistanceFromPlayer = 50;
	private float AngleAroundPlayer = 0;
	
	 private Vector3f position = new Vector3f(0, 0, 0);
	 private float pitch = 20;
	 private float yaw = 0;
	 private float roll;
	 
	 private float sensitivity = 50F;
	 private float viewChange = 1.1F;
	 private int offset = 15;
	 
	 private Player player;
	 
	 public ThirdPersonCamera(Player player)
	 {
	  this.player = player;
	 }
	 
	 public void movement()
	 {
	  calculateCameraPosition();
	  yaw = (float) (180 - player.getRotY());
	  mouseMovements();
	 }
	 
	 public void invertPitch()
	 {
	  pitch = -pitch;
	 }

	 public Vector3f getPosition()
	 {
	  return position;
	 }

	 public float getPitch() 
	 {
	  return pitch;
	 }

	 public float getYaw()
	 {
	  return yaw;
	 }

	 public float getRoll()
	 {
	  return roll;
	 }
	 
	 private void mouseMovements()
	 {
	  Mouse.setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2);
	  player.rotate(0, -Mouse.getDX() * sensitivity * DisplayManager.getFrameTimeSeconds(), 0);
	 //pitch -= Mouse.getDY() * sensitivity * DisplayManager.getFrameTimeSeconds();﻿
	  Mouse.setGrabbed(true);
	 }
	 
	 private void calculateCameraPosition()
	 {
	  position.x = player.getPosition().x;
	  position.z = player.getPosition().z;
	  position.y = player.getPosition().y + 10;
	 }
	 
	 private void calculateZoom() {
		 float zoomWheel = Mouse.getDWheel();
	 }
}
