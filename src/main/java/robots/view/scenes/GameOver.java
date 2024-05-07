package robots.view.scenes;


import robots.view.windows.GameWindow;

import java.awt.*;

import static robots.view.scenes.GameStates.PLAYING;


public class GameOver extends GameScene implements SceneMethods {

	public GameOver(Game game) {
		super(game);
	}

	@Override
	public void render(Graphics g) {
		// game over text
		g.setFont(new Font("LucidaSans", Font.BOLD, 50));
		g.setColor(Color.red);
		g.drawString("Game Over!", 160, 80);
	}

	private void replayGame() {
		// reset everything
		resetAll();

		// change state to playing
		GameStates.SetGameState(PLAYING);

	}

	private void resetAll() {
		game.getPlaying().resetEverything();
	}

	@Override
	public void mouseClicked(int x, int y) {

	}

	@Override
	public void mouseMoved(int x, int y) {

	}

	@Override
	public void mousePressed(int x, int y) {


	}

	@Override
	public void mouseReleased(int x, int y) {

	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub

	}

}
