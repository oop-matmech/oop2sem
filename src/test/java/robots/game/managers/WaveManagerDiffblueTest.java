package robots.game.managers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import robots.model.events.Wave;
import robots.model.main.Game;
import robots.managers.TileManager;
import robots.managers.WaveManager;
import robots.view.MainApplicationFrame;
import robots.view.scenes.Playing;

class WaveManagerDiffblueTest {
    MainApplicationFrame test = new MainApplicationFrame();
    /**
     * Method under test: {@link WaveManager#update()}
     */
    @Test
    void testUpdate() {
        // Arrange
        WaveManager waveManager = new WaveManager(new Playing(new Game(test)));

        // Act
        waveManager.update();

        // Assert that nothing has changed
        assertEquals(0, waveManager.getNextEnemy());
        assertEquals(0, waveManager.getWaveIndex());
        assertEquals(5.0f, waveManager.getTimeLeft());
        assertEquals(9, waveManager.getWaves().size());
        assertFalse(waveManager.isTimeForNewEnemy());
        assertFalse(waveManager.isWaveTimerOver());
        assertFalse(waveManager.isWaveTimerStarted());
    }

    /**
     * Method under test: {@link WaveManager#update()}
     */
    @Test
    void testUpdate2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        WaveManager waveManager = new WaveManager(new Playing(game));

        // Act
        waveManager.update();

        // Assert that nothing has changed
        verify(game).getTileManager();
        assertEquals(0, waveManager.getNextEnemy());
        assertEquals(0, waveManager.getWaveIndex());
        assertEquals(5.0f, waveManager.getTimeLeft());
        assertEquals(9, waveManager.getWaves().size());
        assertFalse(waveManager.isTimeForNewEnemy());
        assertFalse(waveManager.isWaveTimerOver());
        assertFalse(waveManager.isWaveTimerStarted());
    }

    /**
     * Method under test: {@link WaveManager#increaseWaveIndex()}
     */
    @Test
    void testIncreaseWaveIndex() {
        // Arrange
        WaveManager waveManager = new WaveManager(new Playing(new Game(test)));

        // Act
        waveManager.increaseWaveIndex();

        // Assert
        assertEquals(0, waveManager.getNextEnemy());
        assertEquals(5.0f, waveManager.getTimeLeft());
        assertFalse(waveManager.isWaveTimerOver());
        assertFalse(waveManager.isWaveTimerStarted());
    }

    /**
     * Method under test: {@link WaveManager#increaseWaveIndex()}
     */
    @Test
    void testIncreaseWaveIndex2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        WaveManager waveManager = new WaveManager(new Playing(game));

        // Act
        waveManager.increaseWaveIndex();

        // Assert
        verify(game).getTileManager();
        assertEquals(0, waveManager.getNextEnemy());
        assertEquals(5.0f, waveManager.getTimeLeft());
        assertFalse(waveManager.isWaveTimerOver());
        assertFalse(waveManager.isWaveTimerStarted());
    }

    /**
     * Method under test: {@link WaveManager#getNextEnemy()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetNextEnemy() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        WaveManager waveManager = null;

        // Act
        int actualNextEnemy = waveManager.getNextEnemy();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link WaveManager#isTimeForNewEnemy()}
     */
    @Test
    void testIsTimeForNewEnemy() {
        // Arrange, Act and Assert
        assertTrue((new WaveManager(new Playing(new Game(test)))).isTimeForNewEnemy());
    }

    /**
     * Method under test: {@link WaveManager#isTimeForNewEnemy()}
     */
    @Test
    void testIsTimeForNewEnemy2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());

        // Act
        boolean actualIsTimeForNewEnemyResult = (new WaveManager(new Playing(game))).isTimeForNewEnemy();

        // Assert
        verify(game).getTileManager();
        assertTrue(actualIsTimeForNewEnemyResult);
    }

    /**
     * Method under test: {@link WaveManager#isThereMoreEnemiesInWave()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIsThereMoreEnemiesInWave() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        WaveManager waveManager = null;

        // Act
        boolean actualIsThereMoreEnemiesInWaveResult = waveManager.isThereMoreEnemiesInWave();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link WaveManager#isThereMoreWaves()}
     */
    @Test
    void testIsThereMoreWaves() {
        // Arrange, Act and Assert
        assertTrue((new WaveManager(new Playing(new Game(test)))).isThereMoreWaves());
    }

    /**
     * Method under test: {@link WaveManager#isThereMoreWaves()}
     */
    @Test
    void testIsThereMoreWaves2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());

        // Act
        boolean actualIsThereMoreWavesResult = (new WaveManager(new Playing(game))).isThereMoreWaves();

        // Assert
        verify(game).getTileManager();
        assertTrue(actualIsThereMoreWavesResult);
    }

    /**
     * Method under test: {@link WaveManager#getTimeLeft()}
     */
    @Test
    void testGetTimeLeft() {
        // Arrange, Act and Assert
        assertEquals(5.0f, (new WaveManager(new Playing(new Game(test)))).getTimeLeft());
    }

    /**
     * Method under test: {@link WaveManager#getTimeLeft()}
     */
    @Test
    void testGetTimeLeft2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());

        // Act
        float actualTimeLeft = (new WaveManager(new Playing(game))).getTimeLeft();

        // Assert
        verify(game).getTileManager();
        assertEquals(5.0f, actualTimeLeft);
    }

    /**
     * Method under test: {@link WaveManager#reset()}
     */
    @Test
    void testReset() {
        // Arrange
        WaveManager waveManager = new WaveManager(new Playing(new Game(test)));

        // Act
        waveManager.reset();

        // Assert
        assertEquals(0, waveManager.getNextEnemy());
        assertEquals(0, waveManager.getWaveIndex());
        ArrayList<Wave> waves = waveManager.getWaves();
        assertEquals(9, waves.size());
        assertEquals(11, waves.get(6).getEnemyList().size());
        assertEquals(15, waves.get(7).getEnemyList().size());
        assertEquals(4, waves.get(0).getEnemyList().size());
        assertEquals(5.0f, waveManager.getTimeLeft());
        assertEquals(6, waves.get(1).getEnemyList().size());
        assertEquals(6, waves.get(2).getEnemyList().size());
        assertEquals(9, waves.get(8).getEnemyList().size());
        assertFalse(waveManager.isTimeForNewEnemy());
        assertFalse(waveManager.isWaveTimerOver());
        assertFalse(waveManager.isWaveTimerStarted());
    }

    /**
     * Method under test: {@link WaveManager#reset()}
     */
    @Test
    void testReset2() {
        // Arrange
        Game game = mock(Game.class);
        when(game.getTileManager()).thenReturn(new TileManager());
        WaveManager waveManager = new WaveManager(new Playing(game));

        // Act
        waveManager.reset();

        // Assert
        verify(game).getTileManager();
        assertEquals(0, waveManager.getNextEnemy());
        assertEquals(0, waveManager.getWaveIndex());
        ArrayList<Wave> waves = waveManager.getWaves();
        assertEquals(9, waves.size());
        assertEquals(11, waves.get(6).getEnemyList().size());
        assertEquals(15, waves.get(7).getEnemyList().size());
        assertEquals(4, waves.get(0).getEnemyList().size());
        assertEquals(5.0f, waveManager.getTimeLeft());
        assertEquals(6, waves.get(1).getEnemyList().size());
        assertEquals(6, waves.get(2).getEnemyList().size());
        assertEquals(9, waves.get(8).getEnemyList().size());
        assertFalse(waveManager.isTimeForNewEnemy());
        assertFalse(waveManager.isWaveTimerOver());
        assertFalse(waveManager.isWaveTimerStarted());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link WaveManager#resetEnemyIndex()}
     *   <li>{@link WaveManager#startWaveTimer()}
     *   <li>{@link WaveManager#getWaveIndex()}
     *   <li>{@link WaveManager#getWaves()}
     *   <li>{@link WaveManager#isWaveTimerOver()}
     *   <li>{@link WaveManager#isWaveTimerStarted()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        WaveManager waveManager = new WaveManager(new Playing(new Game(test)));

        // Act
        waveManager.resetEnemyIndex();
        waveManager.startWaveTimer();
        int actualWaveIndex = waveManager.getWaveIndex();
        waveManager.getWaves();
        boolean actualIsWaveTimerOverResult = waveManager.isWaveTimerOver();

        // Assert that nothing has changed
        assertEquals(0, actualWaveIndex);
        assertFalse(actualIsWaveTimerOverResult);
        assertTrue(waveManager.isWaveTimerStarted());
    }

    /**
     * Method under test: {@link WaveManager#WaveManager(Playing)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testNewWaveManager() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Playing playing = null;

        // Act
        WaveManager actualWaveManager = new WaveManager(playing);

        // Assert
        // TODO: Add assertions on result
    }
}
