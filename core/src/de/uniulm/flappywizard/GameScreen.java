package de.uniulm.flappywizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class GameScreen implements Screen, InputProcessor {

	final FlappyWizardGame game;
	
	OrthographicCamera camera;

	float PIXELS_TO_METERS = 100f;
	
	public GameScreen(FlappyWizardGame game) {
		this.game = game;

		Gdx.input.setInputProcessor(this);
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 720);
	}	

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

		camera.update();

		//DAS WAR
		//Gdx.gl.glClearColor(0, 0.5f, 0.5f, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//
		//int harry_width = (int)(game.harry.getWidth() * 0.125);
		//int harry_height = (int)(game.harry.getHeight() * 0.125);
		//
		//game.batch.begin();
		////DRAWING GOES IN HERE
		//game.batch.draw(game.harry
		//		, camera.viewportWidth / 2 - harry_width / 2
		//		, camera.viewportHeight / 2 - harry_height / 2
		//		, harry_width
		//		, harry_height
		//	);
		//game.batch.end();


		game.world.step(Gdx.graphics.getDeltaTime(), 6 , 2);


		// Now update the spritee position accordingly to it's now updated Physics body
		game.lunaSprite.setPosition((game.lunaBody.getPosition().x * PIXELS_TO_METERS) - game.lunaSprite.
						getWidth()/2 ,
				(game.lunaBody.getPosition().y * PIXELS_TO_METERS) -game.lunaSprite.getHeight()/2);

		// You know the rest...




		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		game.batch.setProjectionMatrix(camera.combined);

		game.batch.begin();
		//debugRenderer.render(game.world, camera.combined);
		//game.batch.draw(game.lunaSprite, game.lunaSprite.getX(), game.lunaSprite.getY());
		//if(Gdx.input.isTouched()){
		//	System.out.println("Hey");
		//}

		game.batch.draw(game.lunaSprite, game.lunaSprite.getX(), game.lunaSprite.getY(),game.lunaSprite.getOriginX(),
				game.lunaSprite.getOriginY(),
				game.lunaSprite.getWidth(),game.lunaSprite.getHeight(),game.lunaSprite.getScaleX(),game.lunaSprite.
						getScaleY(),game.lunaSprite.getRotation());

		//game.lunaBody.applyTorque(100f, true);
		//game.lunaBody.applyForceToCenter(-10f,-10f,true);
		//game.lunaSprite.draw(game.batch);
		//game.batch.draw(game.lunaSprite, game.lunaSprite.getX(), game.lunaSprite.getY());
		game.batch.end();

		game.debugRenderer.render(game.world, game.batch.getProjectionMatrix().cpy().scale(PIXELS_TO_METERS,
				PIXELS_TO_METERS, 0));

	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
	}








	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		game.lunaBody.applyForceToCenter(1f,1f,true);
		//body.applyTorque(0.4f,true);
		return true;
	}


	// On touch we apply force from the direction of the users touch.
	// This could result in the object "spinning"
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		game.lunaBody.applyForce(1f,1f,screenX,screenY,true);
		//body.applyTorque(0.4f,true);
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
