package robots.view.scenes;

import robots.controller.managers.EnemyManager;
import robots.controller.managers.ProjectileManager;
import robots.controller.managers.TowerManager;
import robots.controller.managers.WaveManager;
import robots.model.enemies.Enemy;
import robots.model.objects.PathPoint;
import robots.model.objects.Tower;
import robots.model.utils.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static robots.model.utils.Constants.Tiles.GRASS_TILE;

public class Playing extends GameScene implements SceneMethods {

    private int[][] lvl;

    private int mouseX, mouseY;
    private EnemyManager enemyManager;
    private TowerManager towerManager;
    private ProjectileManager projManager;
    private WaveManager waveManager;
    private PathPoint start, end;
    private Tower selectedTower;
    private int goldTick;
    private boolean gamePaused;

    public Playing(Game game) {
        super(game);
        loadDefaultLevel();
        projManager = new ProjectileManager(this);
        enemyManager = new EnemyManager(this, start, end);
        towerManager = new TowerManager(this);
        waveManager = new WaveManager(this);
    }

    private void loadDefaultLevel() {
        lvl = LoadSave.GetLevelData();
        ArrayList<PathPoint> points = LoadSave.GetLevelPathPoints();
        start = points.get(0);
        end = points.get(1);
    }

    public void setLevel(int[][] lvl) {
        this.lvl = lvl;
    }

    public void update() {

        updateTick();
        waveManager.update();

        // money tick
        goldTick++;

        if (isAllEnemiesDead()) {
            if (isThereMoreWaves()) {
                waveManager.startWaveTimer();
                if (isWaveTimerOver()) {
                    waveManager.increaseWaveIndex();
                    enemyManager.getEnemies().clear();
                    waveManager.resetEnemyIndex();

                }
            }
        }

        if (isTimeForNewEnemy()) {
            if (!waveManager.isWaveTimerOver())
                spawnEnemy();
        }

        enemyManager.update();
        towerManager.update();
        projManager.update();
    }


    private boolean isWaveTimerOver() {

        return waveManager.isWaveTimerOver();
    }

    private boolean isThereMoreWaves() {
        return waveManager.isThereMoreWaves();

    }

    private boolean isAllEnemiesDead() {

        if (waveManager.isThereMoreEnemiesInWave())
            return false;

        for (Enemy e : enemyManager.getEnemies())
            if (e.isAlive())
                return false;

        return true;
    }

    private void spawnEnemy() {
        enemyManager.spawnEnemy(waveManager.getNextEnemy());
    }

    private boolean isTimeForNewEnemy() {
        if (waveManager.isTimeForNewEnemy()) {
            if (waveManager.isThereMoreEnemiesInWave())
                return true;
        }

        return false;
    }

    public void setSelectedTower(Tower selectedTower) {
        this.selectedTower = selectedTower;
    }

    @Override
    public void render(Graphics g) {

        drawLevel(g);
        enemyManager.draw(g);
        towerManager.draw(g);
        projManager.draw(g);

        drawSelectedTower(g);
        drawHighlight(g);

    }

    private void drawHighlight(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(mouseX, mouseY, 32, 32);

    }

    private void drawSelectedTower(Graphics g) {
        if (selectedTower != null)
            g.drawImage(towerManager.getTowerImgs()[selectedTower.getTowerType()], mouseX, mouseY, null);
    }

    private void drawLevel(Graphics g) {

        for (int y = 0; y < lvl.length; y++) {
            for (int x = 0; x < lvl[y].length; x++) {
                int id = lvl[y][x];
                if (isAnimation(id)) {
                    g.drawImage(getSprite(id, animationIndex), x * 32, y * 32, null);
                } else
                    g.drawImage(getSprite(id), x * 32, y * 32, null);
            }
        }
    }

    public int getTileType(int x, int y) {
        int xCord = x / 32;
        int yCord = y / 32;

        if (xCord < 0 || xCord > 19)
            return 0;
        if (yCord < 0 || yCord > 19)
            return 0;

        int id = lvl[y / 32][x / 32];
        return game.getTileManager().getTile(id).getTileType();
    }

    @Override
    public void mouseClicked(int x, int y) {

        if (selectedTower != null) {
            // Trying to place a tower
            if (isTileGrass(mouseX, mouseY)) {
                if (getTowerAt(mouseX, mouseY) == null) {
                    towerManager.addTower(selectedTower, mouseX, mouseY);
                    selectedTower = null;
                }
            }
        }

    }

    public void upgradeTower(Tower displayedTower) {
        towerManager.upgradeTower(displayedTower);
    }

    public void removeTower(Tower displayedTower) {
        towerManager.removeTower(displayedTower);
    }

    private Tower getTowerAt(int x, int y) {
        return towerManager.getTowerAt(x, y);
    }

    private boolean isTileGrass(int x, int y) {
        int id = lvl[y / 32][x / 32];
        int tileType = game.getTileManager().getTile(id).getTileType();
        return tileType == GRASS_TILE;
    }

    public void shootEnemy(Tower t, Enemy e) {
        projManager.newProjectile(t, e);

    }

    public void setGamePaused(boolean gamePaused) {
        this.gamePaused = gamePaused;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            selectedTower = null;
        }
    }

    @Override
    public void mouseMoved(int x, int y) {

        mouseX = (x / 32) * 32;
        mouseY = (y / 32) * 32;

    }

    @Override
    public void mousePressed(int x, int y) {

    }

    @Override
    public void mouseReleased(int x, int y) {
    }

    @Override
    public void mouseDragged(int x, int y) {

    }

    public TowerManager getTowerManager() {
        return towerManager;
    }

    public EnemyManager getEnemyManger() {
        return enemyManager;
    }

    public WaveManager getWaveManager() {
        return waveManager;
    }

    public boolean isGamePaused() {
        return gamePaused;
    }

    public void removeOneLife() {
    }

    public void resetEverything() {

        // managers
        enemyManager.reset();
        towerManager.reset();
        projManager.reset();
        waveManager.reset();

        mouseX = 0;
        mouseY = 0;

        selectedTower = null;
        goldTick = 0;
        gamePaused = false;

    }

}