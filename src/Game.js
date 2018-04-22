const GAME = new Object ();

GAME.init = function () {
    GAME.mousePosition = {
      x: -1,
      y: -1
    };
    GAME.TITLE = "Fabio's Nights";
    GAME.WIDTH = 320;
    GAME.HEIGHT = 240;
    GAME.RATIO = GAME.WIDTH / GAME.HEIGHT;

    GAME.CANVAS = document.getElementById ('game');
    GAME.CANVAS.width = GAME.WIDTH;
    GAME.CANVAS.height = GAME.HEIGHT;
    GAME.CTX = GAME.CANVAS.getContext ('2d');
    GAME.resize ();

    GAME.currentState = new GAME.MainMenuState ();
    GAME.interval = setInterval (GAME.update, 20);
};

GAME.update = function () {
    GAME.currentState.update ();
}

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

GAME.mousemoved = function (e) {
    GAME.mousePosition = {
      x: e.pageX - GAME.CANVAS.offsetLeft,
      y: e.pageY + GAME.CANVAS.offsetTop
    };
};

window.addEventListener ('load', GAME.init);
window.addEventListener ('resize', GAME.resize);
document.addEventListener('mousemove', GAME.mousemoved);
