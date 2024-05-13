package robots.game.managers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Graphics;
import java.awt.geom.Point2D;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import robots.game.enemies.Bat;
import robots.game.enemies.Enemy;
import robots.game.main.Game;
import robots.game.objects.PathPoint;
import robots.game.objects.Tower;
import robots.game.scenes.Playing;

class ProjectileManagerDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link ProjectileManager.Explosion#Explosion(ProjectileManager, Point2D.Float)}
     *   <li>{@link ProjectileManager.Explosion#getIndex()}
     *   <li>{@link ProjectileManager.Explosion#getPos()}
     * </ul>
     */
    @Test
    void testExplosionGettersAndSetters() {
        // Arrange
        ProjectileManager projectileManager = new ProjectileManager(new Playing(new Game()));
        Point2D.Float pos = new Point2D.Float(10.0f, 10.0f);

        // Act
        ProjectileManager.Explosion actualExplosion = projectileManager.new Explosion(pos);
        int actualIndex = actualExplosion.getIndex();

        // Assert
        assertEquals(0, actualIndex);
        assertSame(pos, actualExplosion.getPos());
    }




    /**
     * Method under test: {@link ProjectileManager#draw(Graphics)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDraw() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        ProjectileManager projectileManager = null;
        Graphics g = null;

        // Act
        projectileManager.draw(g);

        // Assert
        // TODO: Add assertions on result
    }



    /**
     * Method under test: {@link ProjectileManager#ProjectileManager(Playing)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testNewProjectileManager() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Playing playing = null;

        // Act
        ProjectileManager actualProjectileManager = new ProjectileManager(playing);

        // Assert
        // TODO: Add assertions on result
    }
}
