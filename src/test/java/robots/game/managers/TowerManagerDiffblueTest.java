package robots.game.managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import robots.model.managers.TowerManager;
import robots.model.objects.Tower;
import robots.view.scenes.Playing;

class TowerManagerDiffblueTest {
    /**
     * Method under test: {@link TowerManager#addTower(Tower, int, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddTower() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        TowerManager towerManager = null;
        Tower selectedTower = null;
        int xPos = 0;
        int yPos = 0;

        // Act
        towerManager.addTower(selectedTower, xPos, yPos);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link TowerManager#removeTower(Tower)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRemoveTower() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        TowerManager towerManager = null;
        Tower displayedTower = null;

        // Act
        towerManager.removeTower(displayedTower);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link TowerManager#upgradeTower(Tower)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpgradeTower() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        TowerManager towerManager = null;
        Tower displayedTower = null;

        // Act
        towerManager.upgradeTower(displayedTower);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link TowerManager#update()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        TowerManager towerManager = null;

        // Act
        towerManager.update();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link TowerManager#draw(Graphics)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDraw() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        TowerManager towerManager = null;
        Graphics g = null;

        // Act
        towerManager.draw(g);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link TowerManager#getTowerAt(int, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTowerAt() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        TowerManager towerManager = null;
        int x = 0;
        int y = 0;

        // Act
        Tower actualTowerAt = towerManager.getTowerAt(x, y);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link TowerManager#getTowerImgs()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTowerImgs() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        TowerManager towerManager = null;

        // Act
        BufferedImage[] actualTowerImgs = towerManager.getTowerImgs();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link TowerManager#reset()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testReset() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        TowerManager towerManager = null;

        // Act
        towerManager.reset();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link TowerManager#TowerManager(Playing)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testNewTowerManager() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        Playing playing = null;

        // Act
        TowerManager actualTowerManager = new TowerManager(playing);

        // Assert
        // TODO: Add assertions on result
    }
}
