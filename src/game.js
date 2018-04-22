const GAME = new Object ();

GAME.init = function () {
    GAME.WIDTH = 320;
    GAME.HEIGHT = 240;
    GAME.RATIO = GAME.WIDTH / GAME.HEIGHT;

    GAME.CANVAS = document.getElementById ('game');
    GAME.CANVAS.width = GAME.WIDTH;
    GAME.CANVAS.height = GAME.HEIGHT;
    GAME.CTX = GAME.CANVAS.getContext ('2d');
    GAME.resize ();
};

GAME.resize = function () {
    const winHeight = window.innerHeight;
    const winWidth = window.innerWidth;

    if ((winWidth / winHeight) > GAME.RATIO) {
        GAME.currentHeight = winHeight;
        GAME.currentWidth = GAME.currentHeight * GAME.RATIO;

        GAME.CANVAS.style.top = 0 + 'px';
    }
    else {
        GAME.currentWidth = winWidth;
        GAME.currentHeight = GAME.currentWidth  / GAME.RATIO;

        const topMargin = (winHeight - GAME.currentHeight) / 2;
        GAME.CANVAS.style.top = topMargin + 'px';
    }

    GAME.CANVAS.style.width = GAME.currentWidth + 'px';
    GAME.CANVAS.style.height = GAME.currentHeight + 'px';
};

console.log ();

window.addEventListener ('load', GAME.init, false);
window.addEventListener ('resize', GAME.resize, false);
