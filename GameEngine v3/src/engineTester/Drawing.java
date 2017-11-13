package engineTester;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;
import entities.Entity;
import entities.Light;
import entities.Player;
import models.RawModel;
import models.TexturedModel;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import rendering2d.GuiRenderer;
import rendering2d.GuiTextures;
import terrains.Terrain;
import textures.ModelTexture;
import textures.TerrainTexturePack;
import textures.TerrainTextures;
import toolbox.MousePicker;

public class Drawing {
	List<Entity> entities;
	public TexturedModel staticModel, bunnyTexture, grassTexture, fernTexture,droneTexture,boxTexture;
	Loader loader;
	RawModel model, bunny, grass, fern, drone, box;
	MasterRenderer renderer;
	Camera camera;
	Terrain terrain;
	Terrain terrain2;
	Light light, light2;
	Player player;
	TerrainTextures backgroundTexture, redTexture, greenTexture, blueTexture, blendMap;
	TerrainTexturePack texturePack;
	List<Light> lights;
	MousePicker picker;
	Entity playerEntity;
	List<GuiTextures> guis;
	GuiTextures gui;
	GuiRenderer guirenderer;

	public Drawing() {

		loader = new Loader();

		model = OBJLoader.loadObjModel("pine", loader);

		staticModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("pine")));

		entities = new ArrayList<Entity>();
		bunny = OBJLoader.loadObjModel("person", loader);
		bunnyTexture = new TexturedModel(bunny, new ModelTexture(loader.loadTexture("playerTexture")));

		grass = OBJLoader.loadObjModel("grassModel", loader);
		grassTexture = new TexturedModel(grass, new ModelTexture(loader.loadTexture("grassTexture")));

		fern = OBJLoader.loadObjModel("fern", loader);
		fernTexture = new TexturedModel(fern, new ModelTexture(loader.loadTexture("fern")));
		
		box = OBJLoader.loadObjModel("box", loader);
		boxTexture = new TexturedModel(box, new ModelTexture(loader.loadTexture("box")));
		
		drone = OBJLoader.loadObjModel("dragon", loader);
		droneTexture = new TexturedModel(drone, new ModelTexture(loader.loadTexture("white")));

		player = new Player(bunnyTexture, new Vector3f(25, 0, -25), 0, 0, 0, 0.8f);

		renderer = new MasterRenderer(loader);

		camera = new Camera();

		backgroundTexture = new TerrainTextures(loader.loadTexture("grassy2"));
		redTexture = new TerrainTextures(loader.loadTexture("dirt"));
		greenTexture = new TerrainTextures(loader.loadTexture("mud"));
		blueTexture = new TerrainTextures(loader.loadTexture("mud"));

		texturePack = new TerrainTexturePack(backgroundTexture, redTexture, greenTexture, blueTexture);
		blendMap = new TerrainTextures(loader.loadTexture("blendMap"));

		picker = new MousePicker(camera, renderer.getProjectionMatrix(),terrain);
		playerEntity = new Entity(bunnyTexture, new Vector3f(25, 0, -25), 0, 0, 0, 0.8f);
		//entities.add(playerEntity);

	}

	public void draw() {

		
		//guis = new ArrayList<GuiTextures>();
		
		//guirenderer = new GuiRenderer(loader);
		
		//gui = new GuiTextures(loader.loadTexture("health"), new Vector2f(0.5f,0.5f), new Vector2f(0.25f,0.25f));
		terrain = new Terrain(0, -1, loader, texturePack, blendMap, "map.png");
		terrain2 = new Terrain(0, 0, loader, texturePack, blendMap, "jha.jpg");
		//guis.add(gui);

		//if (texturePack.getTexture() == backgroundTexture) {

			Random random = new Random(676452);

			for (int i = 0; i < 500; i++) {
//				if (i % 20 == 0) {
//					float x = random.nextFloat() * 600;
//					float z = random.nextFloat() * 600;
//					float y = terrain2.terrainHeight(x, z);
//					entities.add(new Entity(staticModel, new Vector3f(x, y, z), 0, 0, 0, 1.1f));
//					// entities.add(new Entity(grassTexture, new Vector3f(x,y,z),0,0,0,0.8f));
//					// entities.add(new Entity(fernTexture, new Vector3f(x,y,z),0,0,0,1f));
//				}
//
//				if (i % 2 == 0) {
//					float x = random.nextFloat() * 600;
//					float z = random.nextFloat() * 600 - 400;
//					float y = terrain2.terrainHeight(x, z);
//					entities.add(new Entity(grassTexture, new Vector3f(x, y, z), 0, 0, 0, 1f));
//				}
//
//				if (i % 7 == 0) {
//					float x = random.nextFloat() * 600;
//					float z = random.nextFloat() * 600;
//					float y = terrain2.terrainHeight(x, z);
//					entities.add(new Entity(fernTexture, new Vector3f(x, y, z), 0, 0, 0, 1f));
//				}
				if (i % 20 == 0) {
					float x = random.nextFloat() * 600;
					float z = random.nextFloat() * -600;
					float y = terrain.terrainHeight(x, z);
					entities.add(new Entity(staticModel, new Vector3f(x, y, z), 0, 0, 0, 1.1f));
					// entities.add(new Entity(grassTexture, new Vector3f(x,y,z),0,0,0,0.8f));
					// entities.add(new Entity(fernTexture, new Vector3f(x,y,z),0,0,0,1f));
				}

				if (i % 2 == 0) {
					float x = random.nextFloat() * 600;
					float z = random.nextFloat() * -600;
					float y = terrain.terrainHeight(x, z);
					entities.add(new Entity(grassTexture, new Vector3f(x, y, z), 0, 0, 0, 1f));
				}

				if (i % 7 == 0) {
					float x = random.nextFloat() * 600;
					float z = random.nextFloat() * -600;
					float y = terrain.terrainHeight(x, z);
					entities.add(new Entity(fernTexture, new Vector3f(x, y, z), 0, 0, 0, 1f));
				}
			
		}

		
		lights = new ArrayList<Light>();
		light = new Light(new Vector3f(20000,20000,2000),new Vector3f(0.5f,0.5f,0.3f));
		light2 = new Light(new Vector3f(200, 100, 200),new Vector3f(1 , 0.01f , 0.002f));
		lights.add(light);
		lights.add(new Light(new Vector3f(0, 0, 0), new Vector3f(2, 1, 0), new Vector3f(1 , 0.01f , 0.002f)));
		lights.add(new Light(new Vector3f(25, 18, -25), new Vector3f(0, 2, 2), new Vector3f(1 , 0.01f , 0.002f)));
		lights.add(new Light(new Vector3f(200, 100, 200), new Vector3f(0, 2, 2), new Vector3f(1 , 0.01f , 0.002f)));
		
		
		lights.add(new Light(new Vector3f(0,10,1),new Vector3f(2,2,1),new Vector3f(1,0.01f,0.2f)));
		//entities.add(new Entity(staticModel, new Vector3f(0, 10, 1), 0, 2, 0, 0));
		
		
		// entities.add(new Entity(bunnyTexture, new Vector3f(5,0,-40),0,0,0,3));

		// light = new Light(new Vector3f(20000,20000,2000),new Vector3f(1,1,1));

		// terrain2 = new Terrain(0,0,loader,new
		// ModelTexture(loader.loadTexture("grass"))

		//entities.add(new Entity(staticModel, new Vector3f(25, 18, -25), 0, 0, 0, 3));
		//entities.add(new Entity(staticModel, new Vector3f(1, 0, -30), 0, 2, 0, 0));
		// entities.add(new Entity(bunnyTexture, new Vector3f(5,0,-20),0,0,0,3));

		// if(Keyboard.isKeyDown(Keyboard.KEY_UP)) {
		// entities.add(new Entity(bunnyTexture , new Vector3f(51,2,-35),0,0,0,3));
		// }
		
		//entities.add(new Entity(droneTexture, new Vector3f(50,2,50),0,0,0,1));
	//	entities.add(new Entity(boxTexture, new Vector3f(5,2,50),0,0,0,2));
		
	}

	public void render() {
		//player.move(terrain);
		camera.move();
		picker.update();
		
		Vector3f terrainPoint = picker.getCurrentTerrainPoint();
		System.out.println(picker.getCurrentRay());
		//if(terrainPoint != null) {
			//playerEntity.setPosition(new Vector3f(terrainPoint.x,terrainPoint.y+15,terrainPoint.z));
		//	light.setPosition(new Vector3f(terrainPoint.x,terrainPoint.y+15,terrainPoint.z));
			
//			for(Entity entity : entities) {
//				entity.setPosition(terrainPoint);
//				//light.setPosition(terrainPoint);
//			}
			//player.setPosition(terrainPoint);
	//	}
	//	
		for (Entity entity : entities) {
			renderer.processEntity(entity);
		}
		
		renderer.processEntity(player);
		renderer.processTerrain(terrain);
		//renderer.processTerrain(terrain2);
		renderer.render(lights, camera);
		player.move(terrain);
//		if (player.getPosition().x > 600 || player.getPosition().z > 600) {
//			player.move(terrain);
//		} else {
//			player.move(terrain2);
//		}
		//guirenderer.render(guis);
		
	}

	public void cleanUp() {
		guirenderer.cleanUp();

		renderer.cleanUp();
		loader.cleanUp();
		}
}
