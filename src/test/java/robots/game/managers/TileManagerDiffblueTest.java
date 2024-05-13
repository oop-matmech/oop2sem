package robots.game.managers;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import robots.model.objects.Tile;
import robots.model.managers.TileManager;

class TileManagerDiffblueTest {
    /**
     * Method under test: {@link TileManager#getTile(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTile() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 0
        //       at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.base/java.util.Objects.checkIndex(Objects.java:361)
        //       at java.base/java.util.ArrayList.get(ArrayList.java:427)
        //       at robots.game.managers.TileManager.getTile(TileManager.java:75)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        TileManager tileManager = new TileManager();
        tileManager.tiles = new ArrayList<>();

        // Act
        tileManager.getTile(1);
    }

    /**
     * Method under test: {@link TileManager#getSprite(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetSprite() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 0
        //       at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.base/java.util.Objects.checkIndex(Objects.java:361)
        //       at java.base/java.util.ArrayList.get(ArrayList.java:427)
        //       at robots.game.managers.TileManager.getSprite(TileManager.java:79)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        TileManager tileManager = new TileManager();
        tileManager.tiles = new ArrayList<>();

        // Act
        tileManager.getSprite(1);
    }

    /**
     * Method under test: {@link TileManager#isSpriteAnimation(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testIsSpriteAnimation() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 0
        //       at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.base/java.util.Objects.checkIndex(Objects.java:361)
        //       at java.base/java.util.ArrayList.get(ArrayList.java:427)
        //       at robots.game.managers.TileManager.isSpriteAnimation(TileManager.java:101)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        TileManager tileManager = new TileManager();
        tileManager.tiles = new ArrayList<>();

        // Act
        tileManager.isSpriteAnimation(1);
    }

    /**
     * Method under test: {@link TileManager#getTypeArr()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetTypeArr() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        TileManager tileManager = null;

        // Act
        int[][] actualTypeArr = tileManager.getTypeArr();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link TileManager#getAniSprite(int, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetAniSprite() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 0
        //       at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //       at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //       at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        //       at java.base/java.util.Objects.checkIndex(Objects.java:361)
        //       at java.base/java.util.ArrayList.get(ArrayList.java:427)
        //       at robots.game.managers.TileManager.getAniSprite(TileManager.java:83)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        TileManager tileManager = new TileManager();
        tileManager.tiles = new ArrayList<>();

        // Act
        tileManager.getAniSprite(1, 1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link TileManager#getBeaches()}
     *   <li>{@link TileManager#getCorners()}
     *   <li>{@link TileManager#getIslands()}
     *   <li>{@link TileManager#getRoadsC()}
     *   <li>{@link TileManager#getRoadsS()}
     * </ul>
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGettersAndSetters() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        TileManager tileManager = null;

        // Act
        ArrayList<Tile> actualBeaches = tileManager.getBeaches();
        ArrayList<Tile> actualCorners = tileManager.getCorners();
        ArrayList<Tile> actualIslands = tileManager.getIslands();
        ArrayList<Tile> actualRoadsC = tileManager.getRoadsC();
        ArrayList<Tile> actualRoadsS = tileManager.getRoadsS();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: default or parameterless constructor of
     * {@link TileManager}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testNewTileManager() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange and Act
        // TODO: Populate arranged inputs
        TileManager actualTileManager = new TileManager();

        // Assert
        // TODO: Add assertions on result
    }
}
