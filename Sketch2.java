import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

public class Sketch2 extends PApplet {
	PImage imgDad;
  PImage imgDadMad;
  PImage imgDadDead;
  PImage imgDadSmall;
  PImage imgDadMedium;
  PImage imgDadMadSmall;
  PImage imgMutahar;
  PImage imgMike;

  int startTime1, startTime2;
  int duration1 = 3000;
  int duration2 = 4000;
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1200, 700);
    imgDad = loadImage("Dad Game Character.png");
    imgDadMad = loadImage("Dad Game Character Kishibe Rohan.png");
    imgDadDead = loadImage("Dad Game Character Dead Lying Down.png");
    imgDadSmall = loadImage("Dad Game Character Small.png");
    imgDadMedium = loadImage("Dad Game Character Medium.png");
    imgDadMadSmall = loadImage("Dad Game Character Kishibe Rohan Small.png");
    imgMutahar = loadImage("Mutahar Laugh.jpg");
    imgMike = loadImage("Mike Wazowski Bruh Face.jpg");
  }

  // Declare variables
  float dadX = 50;
  float dadY = 270;

  // Draw background
  public void setup() {
    background(3, 248, 252);

    startTime1 = millis();  
    startTime2 = millis();
  }

  // Draw background again for clean animations
  public void draw() {
    background(3, 248, 252);

  // Call each level
    level1();
  }

  public void level1(){

  // Draw side walls
  fill(0, 0, 0);
  rect(0, 0, 1200, 260);
  rect(0, 400, 1200, 270);

  // Draw end square with level number
  fill(255, 34, 5);
  rect(1085, 260, 115, 140);
  
  fill(255, 255, 255);
  textSize(35);
  text("Level 1", 1080, 440);

  // Add level instructions
  textSize(25);
  text("Use WASD to control dad. (pro tip: if dad doesnt move, click the game window once ;) )", 70, 100);

  // Draw dad and make dad move based on WASD presses
    if(keyPressed){

      if(key == 'w'){
        dadY-=2;
      }
      else if(key == 's'){
        dadY+=2;
      }
      else if(key == 'a'){
        dadX-=2;
      }
      else if(key == 'd'){
        dadX+= 2;
      }
    }
    image(imgDadMedium, dadX, dadY);

    // Add collision detection to walls and reset character
    if(dadY < 260 || dadY > 277){
      int elaspedTime1 = millis() - startTime1;
      if(elaspedTime1 < duration1){
      image(imgMutahar, 200, 100);
      textSize(30);
      text("lol how did u even hit the wall???", 300, 600);
      }
      // dadX = 50;
      /  = 270;
}
    // Add collision detection and show ending to level 1
    if(dadX >= 1040){
      imgMike.resize(1200, 700);
      image(imgMike, 0, 0);
      textSize(30);
      text("pov: dads reaction to u completing this level", 300, 70);  
  }
}
}
  
