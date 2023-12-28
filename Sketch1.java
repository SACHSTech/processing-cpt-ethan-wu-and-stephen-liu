import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

public class Sketch1 extends PApplet {
  // Establish images that will be used
  PImage imgDad;
  PImage imgDadMad;
  PImage imgDadDead;
  PImage imgDadSmall;
  PImage imgDadMedium;
  PImage imgDadMadSmall;
  
  PImage imgMom;
  PImage imgSon;
  PImage imgDaughter;
  
  PImage imgHouse;
  PImage imgDoor;
  PImage imgPathway;

  // Image Variables
  int imgDad_X = 600;
  int imgDad_Y = 200;

  int imgDadMedium_X = 500;
  int imgDadMedium_Y = 500;

  // Text Variables
  int text_X1 = 700;
  int text_Y1 = 100;
  int text_X2 = 600;
  int text_Y2 = 650;

  // Life Variables
  int numLife = 1;


  public void settings() {
    size(1200, 700);
    // Load in images
    imgDad = loadImage("Dad Game Character.png");
    imgDadMad = loadImage("Dad Game Character Kishibe Rohan.png");
    imgDadDead = loadImage("Dad Game Character Dead Lying Down.png");
    imgDadSmall = loadImage("Dad Game Character Small.png");
    imgDadMedium = loadImage("Dad Game Character Medium.png");
    imgDadMadSmall = loadImage("Dad Game Character Kishibe Rohan Small.png");

    imgMom = loadImage("Mom Game Character.png");
    imgSon = loadImage("Son Game Character.png");
    imgDaughter = loadImage("Daughter Game Character.png");

    imgHouse = loadImage("Family House.jpeg");
    imgDoor = loadImage("Door.png");
    imgPathway = loadImage("Game Pathway.png");
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
      text("LEAVING THE HOUSE... BE PATIENT OK", width / 2, height / 2);
    }
    
    // Call cutscene2 Method
    cutscene2();

  }
  
  public void cutscene1() {
    // Draw Images for the Beginning Cutscene
    imgDoor.resize(200, 400);
    image(imgDoor, 1000, 150);
    
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

  public void cutscene2() {
    if (frameCount >= 540) {
      image(imgPathway, 0, 0);
      image(imgDadMedium, imgDadMedium_X, imgDadMedium_Y);
    }
  
    if (frameCount >= 660) {
      fill(255, 25, 152);
      rect(175, 630, 850, 50);
      
      fill(0);
      textSize(30);
      text("Which Path Should I Take? Hint: Press Left/Right Arrow Keys", text_X2, text_Y2);
    }

    if (frameCount >= 660) {
      if (keyCode == LEFT) {
        imgDadMedium_X -= 5;
        imgDadMedium_Y -= 5;
      }
    }
    
    if (frameCount >= 660) {
      if (keyCode == RIGHT) {
        imgDadMedium_X += 5;
        imgDadMedium_Y -= 5;
      }
    }
  }

}

