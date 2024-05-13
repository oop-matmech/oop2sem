package robots.model.enemies;

import robots.managers.EnemyManager;

import static robots.model.helpz.Constants.Enemies.BAT;

public class Bat extends Enemy {

	public Bat(float x, float y, int ID, EnemyManager em) {
		super(x, y, ID, BAT,em);

	}


}
