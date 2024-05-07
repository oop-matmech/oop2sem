package robots.view.scenes;

import robots.controller.managers.TileManager;
import robots.model.utils.LoadSave;
import robots.view.Render;
import robots.view.windows.GameWindow;


import javax.swing.JPanel;

public class Game extends JPanel implements Runnable {

    private Thread gameThread;
    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    // Classes
    private Render render;
    private Playing playing;
    private GameOver gameOver;

    private TileManager tileManager;

    public Game() {
        initClasses();
        LoadSave.CreateFolder();
        createDefaultLevel();
        setVisible(true);
    }

    private void createDefaultLevel() {
        int[] arr = new int[400];
        for (int i = 0; i < arr.length; i++)
            arr[i] = 0;
        LoadSave.CreateLevel(arr);

    }

    private void initClasses() {
        render = new Render(this);
        tileManager = new TileManager();
        playing = new Playing(this);
        gameOver = new GameOver(this);

    }

    public void start() {
        gameThread = new Thread(this) {
        };

        gameThread.start();
    }

    private void updateGame() {
        switch (GameStates.gameState) {
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

//			if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
//				System.out.println("FPS: " + frames + " | UPS: " + updates);
//				frames = 0;
//				updates = 0;
//				lastTimeCheck = System.currentTimeMillis();
//			}

        }

    }

    // Getters and setters
    public Render getRender() {
        return render;
    }


    public Playing getPlaying() {
        return playing;
    }

    public GameOver getGameOver() {
        return gameOver;
    }

    public TileManager getTileManager() {
        return tileManager;
    }


}
