package robots.model.main;

import robots.model.helpz.LoadSave;
import robots.managers.TileManager;
import robots.view.scenes.Editing;
import robots.view.scenes.GameOver;
import robots.view.scenes.Menu;
import robots.view.scenes.Playing;

import javax.swing.*;

public class Game extends JPanel implements Runnable {

	public GameScreen gameScreen;
	private Thread gameThread;

	private final double FPS_SET = 120.0;
	private final double UPS_SET = 60.0;

	// Classes
	private Render render;
	private Menu menu;
	private Playing playing;
	private Editing editing;
	private GameOver gameOver;

	private TileManager tileManager;

	public Game() {

		LoadSave.CreateFolder();

		createDefaultLevel();
		initClasses();

//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setLocationRelativeTo(null);
//		setResizable(false);
//		setTitle("Your Game");
//		//add(gameScreen);
//		pack();
		setVisible(true);

	}

	private void createDefaultLevel() {
		int[] arr = new int[400];
		for (int i = 0; i < arr.length; i++)
			arr[i] = 0;

		LoadSave.CreateLevel(arr);

	}

	private void initClasses() {
		tileManager = new TileManager();
		render = new Render(this);
		gameScreen = new GameScreen(this);
		menu = new Menu(this);
		playing = new Playing(this);
		editing = new Editing(this);
		gameOver = new GameOver(this);

	}

	public void start() {
		gameThread = new Thread(this) {
		};

		gameThread.start();
	}

	private void updateGame() {
		switch (GameStates.gameState) {
		case EDIT:
			editing.update();
			break;
		case MENU:
			break;
		case PLAYING:
			playing.update();
			break;
		default:
			break;
		}
	}

	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;

		long lastFrame = System.nanoTime();
		long lastUpdate = System.nanoTime();
		long lastTimeCheck = System.currentTimeMillis();

		int frames = 0;
		int updates = 0;

		long now;

		while (true) {
			now = System.nanoTime();

			// Render
			if (now - lastFrame >= timePerFrame) {
				repaint();
				lastFrame = now;
				frames++;
			}

			// Update
			if (now - lastUpdate >= timePerUpdate) {
				updateGame();
				lastUpdate = now;
				updates++;
			}

		}

	}

	// Getters and setters
	public Render getRender() {
		return render;
	}

	public Menu getMenu() {
		return menu;
	}

	public Playing getPlaying() {
		return playing;
	}

	public Editing getEditor() {
		return editing;
	}

	public GameOver getGameOver() {
		return gameOver;
	}

	public TileManager getTileManager() {
		return tileManager;
	}

}