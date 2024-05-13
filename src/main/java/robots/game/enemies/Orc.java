package robots.game.enemies;

import robots.game.managers.EnemyManager;

import static robots.game.helpz.Constants.Enemies.ORC;

public class Orc extends Enemy {

	public Orc(float x, float y, int ID, EnemyManager em) {
		super(x, y, ID, ORC,em);
	}

}
