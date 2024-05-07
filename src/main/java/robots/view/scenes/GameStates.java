package robots.view.scenes;

public enum GameStates {

    PLAYING, GAME_OVER;

    public static GameStates gameState = PLAYING;

    public static void SetGameState(GameStates state) {
        gameState = state;
    }

}
