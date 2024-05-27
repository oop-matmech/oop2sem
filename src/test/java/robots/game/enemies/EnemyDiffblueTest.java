package robots.game.enemies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Rectangle;

import org.junit.jupiter.api.Test;
import robots.model.enemies.Bat;
import robots.model.enemies.Enemy;
import robots.model.main.Game;
import robots.managers.EnemyManager;
import robots.managers.TileManager;
import robots.model.objects.PathPoint;
import robots.view.MainApplicationFrame;
import robots.view.scenes.Playing;

class EnemyDiffblueTest {
    MainApplicationFrame test = new MainApplicationFrame();
    /**
     * Method under test: {@link Enemy#hurt(int)}
     */
    @Test
    void testHurt() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act
        bat.hurt(1);

        // Assert
        assertEquals(99, bat.getHealth());
    }

    /**
     * Method under test: {@link Enemy#hurt(int)}
     */
    @Test
    void testHurt2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act
        bat.hurt(1);

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertEquals(99, bat.getHealth());
    }

    /**
     * Method under test: {@link Enemy#kill()}
     */
    @Test
    void testKill() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act
        bat.kill();

        // Assert
        assertEquals(0, bat.getHealth());
        assertFalse(bat.isAlive());
    }

    /**
     * Method under test: {@link Enemy#kill()}
     */
    @Test
    void testKill2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act
        bat.kill();

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertEquals(0, bat.getHealth());
        assertFalse(bat.isAlive());
    }

    /**
     * Method under test: {@link Enemy#slow()}
     */
    @Test
    void testSlow() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act
        bat.slow();

        // Assert
        assertEquals(0, bat.getSlowTick());
    }

    /**
     * Method under test: {@link Enemy#slow()}
     */
    @Test
    void testSlow2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act
        bat.slow();

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertEquals(0, bat.getSlowTick());
    }

    /**
     * Method under test: {@link Enemy#move(float, int)}
     */
    @Test
    void testMove() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act
        bat.move(10.0f, 1);

        // Assert
        Rectangle bounds = bat.getBounds();
        assertEquals(0, bounds.y);
        assertEquals(0.0f, bat.getY());
        assertEquals(1, bat.getLastDir());
        assertEquals(10, bounds.x);
    }

    /**
     * Method under test: {@link Enemy#move(float, int)}
     */
    @Test
    void testMove2() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act
        bat.move(10.0f, 0);

        // Assert
        assertEquals(0, bat.getLastDir());
        Rectangle bounds = bat.getBounds();
        assertEquals(0, bounds.x);
        assertEquals(0.0f, bat.getX());
        assertEquals(10, bounds.y);
    }

    /**
     * Method under test: {@link Enemy#move(float, int)}
     */
    @Test
    void testMove3() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act
        bat.move(10.0f, 2);

        // Assert
        Rectangle bounds = bat.getBounds();
        assertEquals(10, bounds.y);
        assertEquals(2, bat.getLastDir());
        assertEquals(20, bounds.x);
        assertEquals(20.0f, bat.getX());
    }

    /**
     * Method under test: {@link Enemy#move(float, int)}
     */
    @Test
    void testMove4() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act
        bat.move(10.0f, 3);

        // Assert
        Rectangle bounds = bat.getBounds();
        assertEquals(10, bounds.x);
        assertEquals(20, bounds.y);
        assertEquals(20.0f, bat.getY());
        assertEquals(3, bat.getLastDir());
    }

    /**
     * Method under test: {@link Enemy#move(float, int)}
     */
    @Test
    void testMove5() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act
        bat.move(10.0f, 1);

        // Assert
        verify(game, atLeast(1)).getTileManager();
        Rectangle bounds = bat.getBounds();
        assertEquals(0, bounds.y);
        assertEquals(0.0f, bat.getY());
        assertEquals(1, bat.getLastDir());
        assertEquals(10, bounds.x);
    }

    /**
     * Method under test: {@link Enemy#setPos(int, int)}
     */
    @Test
    void testSetPos() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act
        bat.setPos(2, 3);

        // Assert
        assertEquals(2.0f, bat.getX());
        assertEquals(3.0f, bat.getY());
    }

    /**
     * Method under test: {@link Enemy#setPos(int, int)}
     */
    @Test
    void testSetPos2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act
        bat.setPos(2, 3);

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertEquals(2.0f, bat.getX());
        assertEquals(3.0f, bat.getY());
    }

    /**
     * Method under test: {@link Enemy#getHealthBarFloat()}
     */
    @Test
    void testGetHealthBarFloat() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        // Act and Assert
        assertEquals(1.0f,
                (new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)))).getHealthBarFloat());
    }

    /**
     * Method under test: {@link Enemy#getHealthBarFloat()}
     */
    @Test
    void testGetHealthBarFloat2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        // Act
        float actualHealthBarFloat = (new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1))))
                .getHealthBarFloat();

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertEquals(1.0f, actualHealthBarFloat);
    }

    /**
     * Method under test: {@link Enemy#getX()}
     */
    @Test
    void testGetX() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        // Act and Assert
        assertEquals(10.0f, (new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)))).getX());
    }

    /**
     * Method under test: {@link Enemy#getX()}
     */
    @Test
    void testGetX2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        // Act
        float actualX = (new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)))).getX();

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertEquals(10.0f, actualX);
    }

    /**
     * Method under test: {@link Enemy#getY()}
     */
    @Test
    void testGetY() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        // Act and Assert
        assertEquals(10.0f, (new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)))).getY());
    }

    /**
     * Method under test: {@link Enemy#getY()}
     */
    @Test
    void testGetY2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        // Act
        float actualY = (new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)))).getY();

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertEquals(10.0f, actualY);
    }

    /**
     * Method under test: {@link Enemy#getBounds()}
     */
    @Test
    void testGetBounds() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act and Assert
        assertSame(bat.getBounds(), bat.getBounds());
    }

    /**
     * Method under test: {@link Enemy#getBounds()}
     */
    @Test
    void testGetBounds2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act
        Rectangle actualBounds = bat.getBounds();

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertSame(bat.getBounds(), actualBounds);
    }

    /**
     * Method under test: {@link Enemy#getHealth()}
     */
    @Test
    void testGetHealth() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        // Act and Assert
        assertEquals(100, (new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)))).getHealth());
    }

    /**
     * Method under test: {@link Enemy#getHealth()}
     */
    @Test
    void testGetHealth2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        // Act
        int actualHealth = (new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)))).getHealth();

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertEquals(100, actualHealth);
    }

    /**
     * Method under test: {@link Enemy#getID()}
     */
    @Test
    void testGetID() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        // Act and Assert
        assertEquals(1, (new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)))).getID());
    }

    /**
     * Method under test: {@link Enemy#getID()}
     */
    @Test
    void testGetID2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        // Act
        int actualID = (new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)))).getID();

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertEquals(1, actualID);
    }

    /**
     * Method under test: {@link Enemy#getEnemyType()}
     */
    @Test
    void testGetEnemyType() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        // Act and Assert
        assertEquals(1, (new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)))).getEnemyType());
    }

    /**
     * Method under test: {@link Enemy#getEnemyType()}
     */
    @Test
    void testGetEnemyType2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        // Act
        int actualEnemyType = (new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1))))
                .getEnemyType();

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertEquals(1, actualEnemyType);
    }

    /**
     * Method under test: {@link Enemy#getLastDir()}
     */
    @Test
    void testGetLastDir() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        // Act and Assert
        assertEquals(-1, (new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)))).getLastDir());
    }

    /**
     * Method under test: {@link Enemy#getLastDir()}
     */
    @Test
    void testGetLastDir2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        // Act
        int actualLastDir = (new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)))).getLastDir();

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertEquals(-1, actualLastDir);
    }

    /**
     * Method under test: {@link Enemy#isAlive()}
     */
    @Test
    void testIsAlive() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        // Act and Assert
        assertTrue((new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)))).isAlive());
    }

    /**
     * Method under test: {@link Enemy#isAlive()}
     */
    @Test
    void testIsAlive2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        // Act
        boolean actualIsAliveResult = (new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1))))
                .isAlive();

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertTrue(actualIsAliveResult);
    }

    /**
     * Method under test: {@link Enemy#isSlowed()}
     */
    @Test
    void testIsSlowed() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        // Act and Assert
        assertFalse((new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)))).isSlowed());
    }

    /**
     * Method under test: {@link Enemy#isSlowed()}
     */
    @Test
    void testIsSlowed2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        // Act
        boolean actualIsSlowedResult = (new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1))))
                .isSlowed();

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertFalse(actualIsSlowedResult);
    }

    /**
     * Method under test: {@link Enemy#setLastDir(int)}
     */
    @Test
    void testSetLastDir() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act
        bat.setLastDir(1);

        // Assert
        assertEquals(1, bat.getLastDir());
    }

    /**
     * Method under test: {@link Enemy#setLastDir(int)}
     */
    @Test
    void testSetLastDir2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        Bat bat = new Bat(10.0f, 10.0f, 1, new EnemyManager(playing, start, new PathPoint(1, 1)));

        // Act
        bat.setLastDir(1);

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertEquals(1, bat.getLastDir());
    }
}
