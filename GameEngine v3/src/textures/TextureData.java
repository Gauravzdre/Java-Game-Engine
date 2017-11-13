package textures;

import java.nio.ByteBuffer;

public class TextureData {

	private int height;
	private int width;
	private ByteBuffer buffer;
	public TextureData(int height, int width, ByteBuffer buffer) {
		
		this.height = height;
		this.width = width;
		this.buffer = buffer;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public ByteBuffer getBuffer() {
		return buffer;
	}
	
	
}
