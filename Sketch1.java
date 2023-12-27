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

  // Image Variables
  int imgDad_X = 600;
  int imgDad_Y = 200;

  // Text Variables
  int text_X1 = 700;
  int text_Y1 = 100;


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
  }

  public void draw() {
    // Reset background to provide clean animation
    background(210, 255, 173);

    // Call cutscene1 Method
    cutscene1();

    // Wipe Screen to get to next scene, and reset frame counter
    if (frameCount >= 360) {
      background(255);
      textSize(50);
      textAlign(CENTER, CENTER);
      text("LEAVING THE HOUSE...", width / 2, height / 2);
    }
  }
  
  public void cutscene1() {
    // Draw Images for the Beginning Cutscene
    imgDoor.resize(200, 400);
    image(imgDoor, 1000, 200);
    
    imgDad.resize(300,300);
    image(imgDad, imgDad_X, imgDad_Y);
    
    imgMom.resize(250,250);
    image(imgMom, 200, 200);

    imgSon.resize(150,150);
    image(imgSon, 0, 100);

    imgDaughter.resize(150,150);
    image(imgDaughter,0,400);
  
    // Print out Dad's Dialogue
    textSize(30);
    textAlign(CENTER, CENTER);
    // Use frameCount to delay appearance of text
    if (frameCount >= 60) {
      fill(0, 0, 0); 
      text("Bye Honey, Bye Kids, I Am Going To Get Dinner 👍", text_X1, text_Y1);
    }
    // Make the Dad move after 3 seconds from the start of the program
    if (frameCount >= 300) {
      imgDad_X += 5;
      text_X1 += 800;
    }

  } 
}
