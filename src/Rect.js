GAME.Rect = class {
    constructor(x, y, width, height){
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
    }
    area(){
      return this.width * this.height;

    }
    perimeter(){
      return 2 *(this.width + this.height);
    }
    contains(x, y){
      return (x >= this.x && x <= this.x + this.width &&
              y >= this.y && y <= this.y + this.height);
    }
    
};
