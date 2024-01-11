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
  PImage imgLevel3;
  PImage imgPortal;
	
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
    imgLevel3 = loadImage("Level3BG.png");
    imgPortal = loadImage("Portal1BG.png");
  }

  // Declare variables
  float dadX = 50;
  float dadY = 270;
  float dadX1 = 30;
  float dadY1 = 300;

  // Timer variables

  //int timer1;
  //int dura1 = 3000;


  // Draw background
  public void setup() {
    background(3, 248, 252);

    //timer1 = millis();

  }

  // Draw background again for clean animations
  public void draw() {
    background(3, 248, 252);

  // Call each level
    level1();
    // level3();
    // cutScene4();
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
      //int elasped1 = millis() - timer1;
      //if(elasped1 < dura1){
        //imgMutahar.resize(1200, 700);
        //image(imgMutahar, 0, 0);
        dadX = 50;
        dadY = 270;
      }
    {
    // Add collision detection and show ending to level 1
    if(dadX >= 1040){
      imgMike.resize(1200, 700);
      image(imgMike, 0, 0);
      textSize(30);
      text("pov: dads reaction to u completing this level", 300, 70);  
  }
}
  }

  public void level3(){

  // Draw background
  image(imgLevel3, 0, 0);

  // Draw fake portals and portal sign
  image(imgPortal, -220, -50);
  image(imgPortal, 790, 380);
  textSize(20);
  text("real portal", 50, 230);
  text("real portal", 1060, 430);

  // Load dad into level
  image(imgDadMedium, dadX1, dadY1);

  // Add level instructions
  textSize(30);
  fill(0, 0, 0);
  text("Get to the end of the road! >:) ", 750, 50);

  // Make dad move based on WASD
  if(keyPressed){

      if(key == 'w'){
        dadY1-=2;
      }
      else if(key == 's'){
        dadY1+=2;
      }
      else if(key == 'a'){
        dadX1-=2;
      }
      else if(key == 'd'){
        dadX1+= 2;
      }
    }
    image(imgDadMedium, dadX1, dadY1);

  // Add collision detection to detect if player goes off the road
  if(dadY1 < 250 && dadX1 > 170 || dadY1 > 390){
    dadX1 = 30;
    dadY1 = 300;
  }








}
}


  
