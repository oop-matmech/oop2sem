package robots.game.scenes;

import robots.view.UiChangedListener;

import java.awt.*;
import java.awt.event.KeyEvent;

public interface SceneMethods {

	public void render(Graphics g);

	public void mouseClicked(int x, int y);

	public void mouseMoved(int x, int y);

	public void mousePressed(int x, int y);

	public void mouseReleased(int x, int y);

	public void mouseDragged(int x, int y);

	public void keyPressed(KeyEvent e);

}
