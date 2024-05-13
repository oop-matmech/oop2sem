package robots.model.enemies;

import robots.managers.EnemyManager;

import static robots.model.helpz.Constants.Enemies.KNIGHT;

public class Knight extends Enemy {

	public Knight(float x, float y, int ID,EnemyManager em) {
		super(x, y, ID, KNIGHT,em);
		
	}

}
