package robots.game.enemies;

import robots.game.managers.EnemyManager;

import static robots.game.helpz.Constants.Enemies.WOLF;

public class Wolf extends Enemy {

	public Wolf(float x, float y, int ID, EnemyManager em) {
		super(x, y, ID, WOLF, em);
	}

}
