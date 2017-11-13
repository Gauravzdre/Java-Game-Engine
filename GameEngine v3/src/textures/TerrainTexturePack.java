package textures;

public class TerrainTexturePack {
	
	private TerrainTextures backgroundTexture;
	private TerrainTextures rTexture;
	private TerrainTextures gTexture;
	private TerrainTextures bTexture;
	
	
	public TerrainTexturePack(TerrainTextures backgroundTexture, TerrainTextures rTexture, TerrainTextures gTexture,
			TerrainTextures bTexture) {
		this.backgroundTexture = backgroundTexture;
		this.rTexture = rTexture;
		this.gTexture = gTexture;
		this.bTexture = bTexture;
	}
	
	
	public TerrainTextures getBackgroundTexture() {
		return backgroundTexture;
	}
	
	public TerrainTextures getrTexture() {
		return rTexture;
	}
	
	public TerrainTextures getgTexture() {
		return gTexture;
	}
	
	public TerrainTextures getbTexture() {
		return bTexture;
	}
	
}
