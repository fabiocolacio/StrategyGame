GAME.MainMenuState = class {
    constructor () {
        this.entries = [
            {
                text: "Play",
                action: function () {
                    console.log ("You clicked on the play button");
                }
            },
            {
                text: "Options",
                action: function () {
                    console.log ("You clicked on the options button");
                }
            }
        ];
    }

    update () {
        GAME.CTX.fillStyle = 'pink';
        GAME.CTX.fillRect (0, 0, GAME.WIDTH, GAME.HEIGHT);

        GAME.CTX.fillStyle = 'black';
        GAME.CTX.font = '20px Georgia';
        GAME.CTX.textAlign="center";
        GAME.CTX.fillText (GAME.TITLE, GAME.WIDTH / 2 , 50);
        GAME.CTX.textAlign="left";
        for (let i = 0; i < this.entries.length; i++) {
            GAME.CTX.fillText (this.entries[i].text, 0, 100 + (i * 25));
        }


    }
};
