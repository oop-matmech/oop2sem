package robots.game.enemies;

import robots.game.managers.EnemyManager;

import static robots.game.helpz.Constants.Enemies.KNIGHT;

public class Knight extends Enemy {

	public Knight(float x, float y, int ID,EnemyManager em) {
		super(x, y, ID, KNIGHT,em);
		
	}

}
