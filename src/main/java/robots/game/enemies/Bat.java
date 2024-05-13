package robots.game.enemies;

import robots.game.managers.EnemyManager;

import static robots.game.helpz.Constants.Enemies.BAT;

public class Bat extends Enemy {

	public Bat(float x, float y, int ID, EnemyManager em) {
		super(x, y, ID, BAT,em);
		
	}

}
