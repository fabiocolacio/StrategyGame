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
        GAME.CTX.font = '20px Georgia';
        for (let i = 0; i < this.entries.length; i++){
            let textSize = GAME.CTX.measureText(this.entries[i].text);
            this.entries[i].rect = new GAME.Rect(0, 100 + (i * 25), textSize.width, 20);
        }
    }

    update () {
        GAME.CTX.fillStyle = 'pink';
        GAME.CTX.fillRect (0, 0, GAME.WIDTH, GAME.HEIGHT);

        GAME.CTX.font = '20px Georgia';
        GAME.CTX.textAlign="center";
        GAME.CTX.fillText (GAME.TITLE, GAME.WIDTH / 2 , 50);
        GAME.CTX.textAlign="left";
        for (let i = 0; i < this.entries.length; i++) {
            if (this.entries[i].rect.contains(GAME.mousePosition.x, GAME.mousePosition.y)) {
              GAME.CTX.fillStyle = 'yellow'
            }
            else {
              GAME.CTX.fillStyle = 'black';
            }
            GAME.CTX.fillText (this.entries[i].text, this.entries[i].rect.x, this.entries[i].rect.y);
        }


    }
};
