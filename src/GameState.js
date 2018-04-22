GAME.GameState = class {

    mouseClicked (e){
        //nothing
    }

    makeGrid() {
        const spacing = 20;
        let x = 0;
        let y = 0;

        GAME.CTX.fillStyle = 'black';
        for (let i = 1; i <= (GAME.HEIGHT / spacing); i++) {
            GAME.CTX.fillRect(x,(y + (i * spacing)), GAME.WIDTH, 1);
        }

        for (let i = 1; i <= (GAME.WIDTH / spacing); i++) {
            GAME.CTX.fillRect((x + (i * spacing)), y, 1, GAME.HEIGHT);
        }
    }

    update () {
        GAME.CTX.fillStyle = 'AliceBlue';
        GAME.CTX.fillRect (0, 0, GAME.WIDTH, GAME.HEIGHT);
        console.log ("This is the game state");

        this.makeGrid();
    }
};
