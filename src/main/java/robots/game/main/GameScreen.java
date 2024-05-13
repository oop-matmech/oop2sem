package robots.game.main;

import robots.game.inputs.KeyboardListener;
import robots.game.inputs.MyMouseListener;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameScreen extends JPanel {

	private final Timer m_timer = initTimer();

	private static Timer initTimer() {
		Timer timer = new Timer("events generator", true);
		return timer;
	}

	private Game game;
	private Dimension size;

	private MyMouseListener myMouseListener;
	private KeyboardListener keyboardListener;

	public GameScreen(Game game) {
		this.game = game;

		setPanelSize();

		m_timer.schedule(new TimerTask() {
			@Override
			public void run() {
				onRedrawEvent();
			}
		}, 0, 50);
	}

	public void initInputs() {
		myMouseListener = new MyMouseListener(game);
		keyboardListener = new KeyboardListener(game);

		addMouseListener(myMouseListener);
		addMouseMotionListener(myMouseListener);
		addKeyListener(keyboardListener);

		requestFocus();
	}

	private void setPanelSize() {
		size = new Dimension(640, 800);

		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		game.getRender().render(g);

	}

	protected void onRedrawEvent() {
		EventQueue.invokeLater(this::repaint);
	}

}