GAME.GameState = class {
    update () {
        GAME.CTX.fillStyle = 'blue';
        GAME.CTX.fillRect (0, 0, GAME.WIDTH, GAME.HEIGHT);
        console.log ("This is the game state");
    }
};
