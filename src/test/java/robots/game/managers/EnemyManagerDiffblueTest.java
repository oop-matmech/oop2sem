package robots.game.managers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Graphics;
import javax.swing.DebugGraphics;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import robots.model.enemies.Enemy;
import robots.model.main.Game;
import robots.model.objects.PathPoint;
import robots.managers.EnemyManager;
import robots.managers.TileManager;
import robots.view.MainApplicationFrame;
import robots.view.scenes.Playing;

class EnemyManagerDiffblueTest {
    MainApplicationFrame test = new MainApplicationFrame();
    /**
     * Method under test: {@link EnemyManager#update()}
     */
    @Test
    void testUpdate() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        EnemyManager enemyManager = new EnemyManager(playing, start, new PathPoint(1, 1));

        // Act
        enemyManager.update();

        // Assert that nothing has changed
        assertEquals(0, enemyManager.getAmountOfAliveEnemies());
    }

    /**
     * Method under test: {@link EnemyManager#update()}
     */
    @Test
    void testUpdate2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        EnemyManager enemyManager = new EnemyManager(playing, start, new PathPoint(1, 1));

        // Act
        enemyManager.update();

        // Assert that nothing has changed
        verify(game, atLeast(1)).getTileManager();
        assertEquals(0, enemyManager.getAmountOfAliveEnemies());
    }

    /**
     * Method under test: {@link EnemyManager#updateEnemyMove(Enemy)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateEnemyMove() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        EnemyManager enemyManager = null;
        Enemy e = null;

        // Act
        enemyManager.updateEnemyMove(e);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link EnemyManager#spawnEnemy(int)}
     */
    @Test
    void testSpawnEnemy() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        EnemyManager enemyManager = new EnemyManager(playing, start, new PathPoint(1, 1));

        // Act
        enemyManager.spawnEnemy(1);

        // Assert
        assertEquals(1, enemyManager.getEnemies().size());
        assertEquals(1, enemyManager.getAmountOfAliveEnemies());
    }

    /**
     * Method under test: {@link EnemyManager#spawnEnemy(int)}
     */
    @Test
    void testSpawnEnemy2() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        EnemyManager enemyManager = new EnemyManager(playing, start, new PathPoint(1, 1));

        // Act
        enemyManager.spawnEnemy(0);

        // Assert
        assertEquals(1, enemyManager.getEnemies().size());
        assertEquals(1, enemyManager.getAmountOfAliveEnemies());
    }

    /**
     * Method under test: {@link EnemyManager#spawnEnemy(int)}
     */
    @Test
    void testSpawnEnemy3() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        EnemyManager enemyManager = new EnemyManager(playing, start, new PathPoint(1, 1));

        // Act
        enemyManager.spawnEnemy(2);

        // Assert
        assertEquals(1, enemyManager.getEnemies().size());
        assertEquals(1, enemyManager.getAmountOfAliveEnemies());
    }

    /**
     * Method under test: {@link EnemyManager#spawnEnemy(int)}
     */
    @Test
    void testSpawnEnemy4() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        EnemyManager enemyManager = new EnemyManager(playing, start, new PathPoint(1, 1));

        // Act
        enemyManager.spawnEnemy(3);

        // Assert
        assertEquals(1, enemyManager.getEnemies().size());
        assertEquals(1, enemyManager.getAmountOfAliveEnemies());
    }

    /**
     * Method under test: {@link EnemyManager#spawnEnemy(int)}
     */
    @Test
    void testSpawnEnemy5() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        EnemyManager enemyManager = new EnemyManager(playing, start, new PathPoint(1, 1));

        // Act
        enemyManager.spawnEnemy(1);

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertEquals(1, enemyManager.getEnemies().size());
        assertEquals(1, enemyManager.getAmountOfAliveEnemies());
    }

    /**
     * Method under test: {@link EnemyManager#addEnemy(int)}
     */
    @Test
    void testAddEnemy() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        EnemyManager enemyManager = new EnemyManager(playing, start, new PathPoint(1, 1));

        // Act
        enemyManager.addEnemy(2);

        // Assert
        assertEquals(1, enemyManager.getEnemies().size());
        assertEquals(1, enemyManager.getAmountOfAliveEnemies());
    }

    /**
     * Method under test: {@link EnemyManager#addEnemy(int)}
     */
    @Test
    void testAddEnemy2() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        EnemyManager enemyManager = new EnemyManager(playing, start, new PathPoint(1, 1));

        // Act
        enemyManager.addEnemy(0);

        // Assert
        assertEquals(1, enemyManager.getEnemies().size());
        assertEquals(1, enemyManager.getAmountOfAliveEnemies());
    }

    /**
     * Method under test: {@link EnemyManager#addEnemy(int)}
     */
    @Test
    void testAddEnemy3() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        EnemyManager enemyManager = new EnemyManager(playing, start, new PathPoint(1, 1));

        // Act
        enemyManager.addEnemy(1);

        // Assert
        assertEquals(1, enemyManager.getEnemies().size());
        assertEquals(1, enemyManager.getAmountOfAliveEnemies());
    }

    /**
     * Method under test: {@link EnemyManager#addEnemy(int)}
     */
    @Test
    void testAddEnemy4() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        EnemyManager enemyManager = new EnemyManager(playing, start, new PathPoint(1, 1));

        // Act
        enemyManager.addEnemy(3);

        // Assert
        assertEquals(1, enemyManager.getEnemies().size());
        assertEquals(1, enemyManager.getAmountOfAliveEnemies());
    }

    /**
     * Method under test: {@link EnemyManager#addEnemy(int)}
     */
    @Test
    void testAddEnemy5() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        EnemyManager enemyManager = new EnemyManager(playing, start, new PathPoint(1, 1));

        // Act
        enemyManager.addEnemy(2);

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertEquals(1, enemyManager.getEnemies().size());
        assertEquals(1, enemyManager.getAmountOfAliveEnemies());
    }

    /**
     * Method under test: {@link EnemyManager#draw(Graphics)}
     */
    @Test
    void testDraw() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        EnemyManager enemyManager = new EnemyManager(playing, start, new PathPoint(1, 1));

        // Act
        enemyManager.draw(new DebugGraphics());

        // Assert that nothing has changed
        assertEquals(0, enemyManager.getAmountOfAliveEnemies());
    }

    /**
     * Method under test: {@link EnemyManager#draw(Graphics)}
     */
    @Test
    void testDraw2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        EnemyManager enemyManager = new EnemyManager(playing, start, new PathPoint(1, 1));

        // Act
        enemyManager.draw(new DebugGraphics());

        // Assert that nothing has changed
        verify(game, atLeast(1)).getTileManager();
        assertEquals(0, enemyManager.getAmountOfAliveEnemies());
    }

    /**
     * Method under test: {@link EnemyManager#getEnemies()}
     */
    @Test
    void testGetEnemies() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        // Act and Assert
        assertTrue((new EnemyManager(playing, start, new PathPoint(1, 1))).getEnemies().isEmpty());
    }

    /**
     * Method under test: {@link EnemyManager#getAmountOfAliveEnemies()}
     */
    @Test
    void testGetAmountOfAliveEnemies() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        // Act and Assert
        assertEquals(0, (new EnemyManager(playing, start, new PathPoint(1, 1))).getAmountOfAliveEnemies());
    }

    /**
     * Method under test: {@link EnemyManager#getAmountOfAliveEnemies()}
     */
    @Test
    void testGetAmountOfAliveEnemies2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        // Act
        int actualAmountOfAliveEnemies = (new EnemyManager(playing, start, new PathPoint(1, 1))).getAmountOfAliveEnemies();

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertEquals(0, actualAmountOfAliveEnemies);
    }

    /**
     * Method under test: {@link EnemyManager#rewardPlayer(int)}
     */
    @Test
    void testRewardPlayer() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        // Act
        (new EnemyManager(playing, start, new PathPoint(1, 1))).rewardPlayer(1);

        // Assert
        verify(game, atLeast(1)).getTileManager();
    }

    /**
     * Method under test: {@link EnemyManager#reset()}
     */
    @Test
    void testReset() {
        // Arrange
        Playing playing = new Playing(new Game(test));
        PathPoint start = new PathPoint(1, 1);

        EnemyManager enemyManager = new EnemyManager(playing, start, new PathPoint(1, 1));

        // Act
        enemyManager.reset();

        // Assert
        assertEquals(0, enemyManager.getAmountOfAliveEnemies());
    }

    /**
     * Method under test: {@link EnemyManager#reset()}
     */
    @Test
    void testReset2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        Playing playing = new Playing(game);
        PathPoint start = new PathPoint(1, 1);

        EnemyManager enemyManager = new EnemyManager(playing, start, new PathPoint(1, 1));

        // Act
        enemyManager.reset();

        // Assert
        verify(game, atLeast(1)).getTileManager();
        assertEquals(0, enemyManager.getAmountOfAliveEnemies());
    }

    /**
     * Method under test:
     * {@link EnemyManager#EnemyManager(Playing, PathPoint, PathPoint)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testNewEnemyManager() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Playing playing = null;
        PathPoint start = null;
        PathPoint end = null;

        // Act
        EnemyManager actualEnemyManager = new EnemyManager(playing, start, end);

        // Assert
        // TODO: Add assertions on result
    }
}
