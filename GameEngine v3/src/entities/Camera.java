package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

public class Camera {

	private Vector3f position = new Vector3f(5, 5, 0);
	private float pitch = 10;
	private float yaw;
	private float roll;
	// float movAmt = 5;
	float rotamount = 5;

	public Camera() {
	}

	public void move() {

		if (Mouse.isButtonDown(1)) {
			// Mouse.setGrabbed(true);
			float arg_yaw = Mouse.getDX();
			//System.out.println(arg_yaw);
			yaw += arg_yaw / 10;
			float arg_roll = Mouse.getDY();
			pitch += -(arg_roll / 10);
			Mouse.setGrabbed(true);
			if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
				float toZ = ((float) Math.sin(Math.toRadians(yaw + 90)));
				float toX = ((float) Math.cos(Math.toRadians(yaw + 90)));
				position.x -= toX;
				position.z -= toZ;

			}
			if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
				float toZ = ((float) Math.sin(Math.toRadians(yaw + 90)));
				float toX = ((float) Math.cos(Math.toRadians(yaw + 90)));
				position.x += toX;
				position.z += toZ;
			}

			if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
				float toZ = ((float) Math.sin(Math.toRadians(yaw)));
			float toX = ((float) Math.cos(Math.toRadians(yaw)));
				position.x += toX;
				position.z += toZ;
			}

			if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
				float toZ = ((float) Math.sin(Math.toRadians(yaw)));
				float toX = ((float) Math.cos(Math.toRadians(yaw)));
				position.x -= toX;
				position.z -= toZ;
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_E)) {
				position.y += 0.8f;
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_Q)) {
				position.y -= 0.8f;
			}
		} 
		else {
			Mouse.setGrabbed(false);
		}
		// if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
		// System.exit(0);
		// }
	}

	public Vector3f getPosition() {
		return position;
	}

	public float getPitch() {
		return pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public float getRoll() {
		return roll;
	}

}
