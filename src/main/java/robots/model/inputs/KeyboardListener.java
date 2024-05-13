package robots.model.inputs;

import robots.model.main.Game;
import robots.model.main.GameStates;
import robots.view.scenes.SceneMethods;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import static robots.model.main.GameStates.EDIT;
import static robots.model.main.GameStates.PLAYING;

public class KeyboardListener implements KeyListener {
	private Game game;

	public KeyboardListener(Game game) {
		this.game = game;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		HashMap<GameStates, SceneMethods> variants = new HashMap<>();
		variants.put(EDIT, game.getEditor());
		variants.put(PLAYING, game.getPlaying());
		variants.get(GameStates.gameState).keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
