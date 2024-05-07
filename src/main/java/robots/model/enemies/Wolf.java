package robots.model.enemies;


import robots.controller.managers.EnemyManager;

import static robots.model.utils.Constants.Enemies.WOLF;

public class Wolf extends Enemy {

	public Wolf(float x, float y, int ID, EnemyManager em) {
		super(x, y, ID, WOLF, em);
	}

}
