import java.util.Vector;


Vector<dot> dotlist;

void setup() {
  size(displayWidth, displayHeight);
  dotlist = new Vector<dot>();
  int dir[] = {1, -1};
  for (int i=0; i<20; i++) {
    dotlist.add(new dot((int)random(width), (int)random(height), (int)random(1, 3), dir[(int)random(2)], dir[(int)random(2)]));
  }
}

void draw() {
  background(10);
  noStroke();
  fill(255);
  for (dot d : dotlist) {
    d.draw();
    d.update();
  }
  stroke(255);
  for (dot d : dotlist) {
    for (dot d2 : dotlist) {
      if (d.x != d2.x && d.y != d2.x) {
        int dis = (int)sqrt((int)sq(d.x-d2.x) +(int)sq(d.y-d2.y));
        //println(dis);
        if (dis < 200) {
          line(d.x, d.y, d2.x, d2.y);
        }
      }
    }
    if (mousePressed == true) {
      int dis = (int)sqrt((int)sq(d.x-mouseX) +(int)sq(d.y-mouseY));
      if (dis < 500) {
        line(d.x, d.y, mouseX, mouseY);
      }
    }
  }
}

void 
