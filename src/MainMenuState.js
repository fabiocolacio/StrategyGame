GAME.MainMenuState = class {
    constructor () {
        this.font = '20px Georgia';

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

        GAME.CTX.font = this.font;
        for (let i = 0; i < this.entries.length; i++) {
            let entry = this.entries[i];
            let textSize = GAME.CTX.measureText(entry.text);
            entry.rect = new GAME.Rect(0, 100 + (i * 20), textSize.width, 20);
        }
    }

    update () {
        GAME.CTX.fillStyle = 'pink';
        GAME.CTX.fillRect (0, 0, GAME.WIDTH, GAME.HEIGHT);

        GAME.CTX.font = this.font;
        GAME.CTX.textBaseline = 'top';
        GAME.CTX.textAlign = "center";
        GAME.CTX.fillText (GAME.TITLE, GAME.WIDTH / 2 , 50);
        GAME.CTX.textAlign = "start";
        
        for (let i = 0; i < this.entries.length; i++) {
            let entry = this.entries[i];
            
            if (entry.rect.contains(GAME.mousePosition.x, GAME.mousePosition.y)) {
              GAME.CTX.fillStyle = 'yellow';
              console.log ('cursor with coords (%d, %d) is inside of entry[%d] with (%d, %d, %d, %d)', GAME.mousePosition.x, GAME.mousePosition.y, i, entry.rect.left, entry.rect.top, entry.rect.right, entry.rect.bottom);
            }
            else {
              GAME.CTX.fillStyle = 'black';
            }

            GAME.CTX.fillText (entry.text, entry.rect.x, entry.rect.y);
        }
    }
};
