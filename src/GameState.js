GAME.GameState = class {

    mouseClicked (e){
        //nothing
    }

    makeGrid() {
        const spacing = 10;
        let x = 0;
        let y = 0;

        GAME.CTX.fillStyle = 'black';
        for (let i = 0; i < GAME.HEIGHT / 10; i++)
            GAME.CTX.fillRect(x,(y + (i * spacing)), GAME.WIDTH, 1)
    }

    update () {
        GAME.CTX.fillStyle = 'blue';
        GAME.CTX.fillRect (0, 0, GAME.WIDTH, GAME.HEIGHT);
        console.log ("This is the game state");

        this.makeGrid();
    }
};
