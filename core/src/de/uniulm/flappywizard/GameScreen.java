package de.uniulm.flappywizard;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen, InputProcessor {


	final FlappyWizardGame game;
	
	OrthographicCamera camera;

	float PIXELS_TO_METERS = 100f;
	float velocity = 7f;

	float lunaHeight = 0f;

	List<TupleTurm> TupleTurmListe = new ArrayList<TupleTurm>();
	int letzteElement = 0;

	Sprite fml = new Sprite(game.luna);
	Sprite tester = new Sprite(game.dementorCutted);



	
	public GameScreen(FlappyWizardGame game) {
		this.game = game;

		Gdx.input.setInputProcessor(this);
		
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 720);

		int k = 0;
		for(int i = 0; i<20; i++){
			TupleTurmListe.add( new TupleTurm(game.turm_gryffindor, game.dementorCutted, 50, k));
			k += 10;
			if(k>400){
				k=0;
			}
			TupleTurmListe.get(i).setPosX(Gdx.graphics.getWidth());
		}
		TupleTurmListe.get(0).setPosX(Gdx.graphics.getWidth()-10);


		{//Sprite Test
			fml.setScale(0.1f);
			tester.setScale(0.1f);

			fml.setPosition(100f, 100f);
			tester.setPosition(400f, 100f);
		}
	}	



	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

		{
			/**
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
			 */
		}


		if(true){//Standart
			camera.update();

			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			game.batch.setProjectionMatrix(camera.combined);
		}


		if(true){//Zeichnen
			game.batch.begin();
			game.font.draw(game.batch, "Drops Collected: ", Gdx.graphics.getWidth()*0.5f, 480);

			//game.batch.draw(bucketImage, bucket.x, bucket.y, bucket.width, bucket.height); //selbe wie unten
			game.batch.draw(game.luna, camera.viewportWidth/2 - game.luna.getWidth()*0.2f /2, lunaHeight, game.luna.getWidth()*0.1f, game.luna.getWidth()*0.2f);

			//int index = 0;
			//for (TupleTurm tupleElement : TupleTurmListe) {
			//	game.batch.draw(tupleElement.getTurm(), tupleElement.getPosX()-10*delta, tupleElement.getHeightTurm(),
			//			game.turm_gryffindor.getWidth()*0.1f, game.turm_gryffindor.getWidth()*0.1f);
//
			//	game.batch.draw(tupleElement.getDementor(), tupleElement.getPosX()-10*delta, tupleElement.getHeightDementor(),
			//			game.dementor.getWidth()*0.1f, game.dementor.getWidth()*0.2f);
//
//
//
//
			//	index += 1;
			//}

			//for(int i = 0; i<TupleTurmListe.size(); i++){
			for(int i = 0; i<=letzteElement; i++){
				TupleTurmListe.get(i).setPosX(TupleTurmListe.get(i).getPosX() - 100*delta);
				game.batch.draw(TupleTurmListe.get(i).getTurm(), TupleTurmListe.get(i).getPosX(), TupleTurmListe.get(i).getHeightTurm(),
						game.turm_gryffindor.getWidth()*0.1f, game.turm_gryffindor.getHeight()*0.1f);

				game.batch.draw(TupleTurmListe.get(i).getDementor(), TupleTurmListe.get(i).getPosX(), TupleTurmListe.get(i).getHeightDementor(),
						game.dementorCutted.getWidth()*0.1f, game.dementorCutted.getHeight()*0.2f);
			}






			game.batch.end();
		}



		if(true){ // das es immer das nächste holt
			if(TupleTurmListe.get(letzteElement + 1).getPosX() - TupleTurmListe.get(letzteElement).getPosX() > 500f){
				letzteElement += 1;
			}

			if(TupleTurmListe.get(0).getPosX() + game.dementorCutted.getWidth() < 0){
				TupleTurmListe.remove(0); //remove Index, nicht Objekt
				TupleTurmListe.add(new TupleTurm(game.turm_gryffindor, game.dementorCutted, 50, 100)); //XXX Hier sollte Height verändert werden, damit nicht immer gleich bleibt
				letzteElement -= 1;
			}
		}


		if(true){//Bewegung der Hexe
			//sollte eigentlich auch mit delta hoch gehen
			if(Gdx.input.isTouched()){
				lunaHeight += 20f;
				velocity = 7f;
			}
			if(velocity>=0){
				velocity += 1f*delta;
			}else {
				velocity = 0f;
			}

			//System.out.println("" + delta + " " + velocity + " " + lunaHeight);
			lunaHeight -= 10f*delta + velocity;
			//lunaHeight -= 10f*delta;
		}


		{//Sprite Test
			if(Intersector.)
		}




		//Bewegung der Türme
		//20 Türme erstellen und sobald abstand zum anderen

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
