GAME.Rect = class {
    constructor (x, y, width, height) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
    }

    get top () {
        return this.y;
    }

    get left () {
        return this.x;
    }

    get bottom () {
        return this.y + this.height;
    }

    get right () {
        return this.x + this.width;
    }

    get area () {
        return this.width * this.height;
    }

    get perimeter () {
        return 2 * (this.width + this.height);
    }

    contains (x, y) {
        return (x >= this.left && x <= this.right &&
                y >= this.top && y <= this.bottom);
    } 
};
