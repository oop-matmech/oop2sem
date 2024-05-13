package robots.model.enemies;

import robots.managers.EnemyManager;

import static robots.model.helpz.Constants.Enemies.WOLF;

public class Wolf extends Enemy {

	public Wolf(float x, float y, int ID, EnemyManager em) {
		super(x, y, ID, WOLF, em);
	}

}
