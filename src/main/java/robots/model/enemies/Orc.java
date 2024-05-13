package robots.model.enemies;

import robots.model.managers.EnemyManager;

import static robots.model.helpz.Constants.Enemies.ORC;

public class Orc extends Enemy {

	public Orc(float x, float y, int ID, EnemyManager em) {
		super(x, y, ID, ORC,em);
	}

}
