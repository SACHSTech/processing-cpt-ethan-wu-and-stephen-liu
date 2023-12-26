import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

public class Sketch1 extends PApplet {
	// Establish images that will be used
  PImage imgDad;
  PImage imgDadMad;
  PImage imgDadDead;
  
  PImage imgMom;
  PImage imgSon;
  PImage imgDaughter;
  
  PImage imgHouse;
  PImage imgDoor;
  PImage imgDirectionSign;

  // Delay Counters
  int initialFrame1;
  int initialFrame2;

  int delayFrames1 = 60;
  int delayFrames2 = 360;

  public void settings() {
    size(1200, 700);
    // Load in images
    imgDad = loadImage("Dad Game Character.png");
    imgDadMad = loadImage("Dad Game Character Kishibe Rohan.png");
    imgDadDead = loadImage("Dad Game Character Dead Lying Down");

    imgMom = loadImage("Mom Game Character.png");
    imgSon = loadImage("Son Game Character.png");
    imgDaughter = loadImage("Daughter Game Character.png");

    imgHouse = loadImage("Family House.jpeg");
    imgDoor = loadImage("Door.png");
    imgDirectionSign = loadImage("Direction Sign.png");
  }

  public void setup() {
    background(210, 255, 173);
    initialFrame1 = frameCount;
    initialFrame2 = frameCount;
  }

  public void draw() {
    // Call cutscene1 Method
    cutscene1();

    // Wipe Screen to get to next scene, and reset frame counter
    if (frameCount - initialFrame2 >= delayFrames2) {
      background(255);
      textSize(50);
      textAlign(CENTER, CENTER);
      text("LEAVING THE HOUSE...", width / 2, height / 2);
    }
  }
  
  public void cutscene1() {
    // Draw Images for the Beginning Cutscene
    imgDad.resize(300,300);
    image(imgDad, 600, 200);
    
    imgMom.resize(250,250);
    image(imgMom, 200, 200);

    imgSon.resize(150,150);
    image(imgSon, 0, 100);

    imgDaughter.resize(150,150);
    image(imgDaughter,0,400);

    imgDoor.resize(200, 400);
    image(imgDoor, 1000, 200);

    // Print out Dad's Dialogue
    textSize(30);
    textAlign(CENTER, CENTER);
      // Use counter to delay the appearance of the text
    if (frameCount - initialFrame1 >= delayFrames1) {
      fill(0, 0, 0); // Red color
      text("Bye Honey, Bye Kids, I Am Going To Get Dinner 👍", 700, 100);
    }
  }

}
