import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

public class Sketch1 extends PApplet {
	PImage imgDad;
  PImage imgDadMad;
  PImage imgDadDead;
  
  PImage imgMom;
  PImage imgSon;
  PImage imgDaughter;
  
  PImage imgHouse;
  PImage imgDoor;

  public void settings() {
    size(1200, 700);

    imgDad = loadImage("Dad Game Character.png");
    imgDadMad = loadImage("Dad Game Character Kishibe Rohan.png");
    imgDadDead = loadImage("Dad Game Character Dead Lying Down");

    imgMom = loadImage("Mom Game Character.png");
    imgSon = loadImage("Son Game Character.png");
    imgDaughter = loadImage("Daughter Game Character.png");

    imgHouse = loadImage("Family House.jpeg");
    imgDoor = loadImage("Door.png");
  }

  public void setup() {
    background(210, 255, 173);
  }

  public void draw() {
	  imgDad.resize(300,300);
    image(imgDad, 600, 300);
  }
  
  
}
