package processing.test.wall;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.Vector; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Wall extends PApplet {




Vector<dot> dotlist;

public void setup() {
  
  dotlist = new Vector<dot>();
  int dir[] = {1, -1};
  for (int i=0; i<20; i++) {
    dotlist.add(new dot((int)random(width), (int)random(height), (int)random(1, 3), dir[(int)random(2)], dir[(int)random(2)]));
  }
}

public void draw() {
  background(10);
  noStroke();
  fill(255);
  for (dot d : dotlist) {
    d.draw();
    d.update();
  }
  stroke(75, 168, 201);
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
        ellipse(mouseX,mouseY,10,10);
      }
    }
  }
}
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
  public void settings() {  size(displayWidth, displayHeight); }
}
