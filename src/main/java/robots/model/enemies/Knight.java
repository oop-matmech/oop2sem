package robots.model.enemies;


import robots.controller.managers.EnemyManager;

import static robots.model.utils.Constants.Enemies.KNIGHT;

public class Knight extends Enemy {

	public Knight(float x, float y, int ID, EnemyManager em) {
		super(x, y, ID, KNIGHT,em);
		
	}

}
