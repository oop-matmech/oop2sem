package robots.model.enemies;


import robots.controller.managers.EnemyManager;

import static robots.model.utils.Constants.Enemies.ORC;

public class Orc extends Enemy {

    public Orc(float x, float y, int ID, EnemyManager em) {
        super(x, y, ID, ORC, em);
    }

}
