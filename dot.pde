class dot {
  int x, y, dx, dy;
  int speed;

  public dot(int x, int y, int speed, int dx, int dy) {
    this.x = x;
    this.y = y;
    this.speed = speed;
    this.dx = dx;
    this.dy = dy;
  }

  public void draw() {
    //print("ok");
    ellipse(this.x, this.y, 6, 6);
  }

  public void update() {
    this.x = this.x +(speed * dx);
    this.y = this.y +(speed * dy);

    if (this.x < 0 || this.x > width) {
      this.dx = this.dx * -1;
      this.speed = (int)random(1,3);
    }
    if (this.y < 0 || this.y > height) {
      this.dy = this.dy * -1;
      this.speed = (int)random(1,3);
    }
  }
}
