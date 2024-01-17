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
  PImage imgSoccer;
  PImage imgRonaldo;
  PImage imgSuiii;
  PImage imgLaugh;
  PImage imgPolice;
  PImage imgCop;
	
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
    imgSoccer = loadImage("Soccer Net.jpg");
    imgRonaldo = loadImage("Ronaldo.png");
    imgSuiii = loadImage("Suiii.png");
    imgLaugh = loadImage("Laugh.jpg");
    imgPolice = loadImage("Popo.png");
    imgCop = loadImage("Cop.png");
  }

  // Declare variables
  float dadX = 50;
  float dadY = 270;
  float dadX1 = 30;
  float dadY1 = 300;
  float dadX2 = 300;
  float dadY2 = 650;
  float ronaldoX = -130;
  float ronaldoY = 280;
  float copX = 840;
  float copY = 950;

  // Timer variables

  int timer1;
  int dura1 = 100000;
  int timer2;
  int dura2 = 3000;
  int timer3;
  int dura3 = 8000;
  int timer4;
  int dura4 = 100000;
  int timer5;
  int dura5 = 4000;

  int state = 0;

  


  // Draw background
  public void setup() {
    background(3, 248, 252);

    timer1 = millis();
    timer2 = millis();
    timer3 = millis();
    timer4 = millis();
    timer5 = millis();

  }

  // Draw background again for clean animations
  public void draw() {
    background(3, 248, 252);

  // Call each level
    //level1();
    //level3();
    cutScene4();
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
  text("oh u only have 10 mins >:)", 400, 180);

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
      int elasped1 = millis() - timer1;
      if(elasped1 < dura1){
        imgMutahar.resize(1200, 700);
        image(imgMutahar, 0, 0);
        fill(255);
        textSize(40);
        text("lol how did u even hit the wall???", 280, 80);
        text("Press Alt to restart lol", 350, 600);

        if(keyPressed){
          if(keyCode == ALT){
            dadX = 50;
            dadY = 270;
          }
        }
      }
      }
    
    // Add collision detection and show ending to level 1
    if(dadX >= 1040){
      imgMike.resize(1200, 700);
      image(imgMike, 0, 0);
      textSize(30);
      text("pov: dads reaction to u completing this level", 300, 70); 
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
        dadX1+= 8;
      }
    }
    image(imgDadMedium, dadX1, dadY1);

  // Add police guy and car and warning sign
  imgPolice.resize(150, 180);
  image(imgPolice, 890, 470);
  imgCop.resize(180, 180);
  image(imgCop, copX, copY);
  fill(0);
  textSize(20);
  text("No Jaywalking!", 30, 500);
  text("Penalty: jail lol", 30, 530);
  
  // Add collision detection to detect if player goes off the road and reset player
  if(dadY1 < 250 && dadX1 > 170 || dadY1 > 390){
    int elasped4 = millis() - timer4;
      if(elasped4 < dura4){
    imgLaugh.resize(1200, 700);
    image(imgLaugh, 0, 0);
    fill(255);
    textSize(30);
    text("all u had to do was follow the road -_-", 300, 50);
    text("Press Alt to restart ._.", 410, 120);
  }
      if(keyPressed){
      if(keyCode == ALT){
        dadX1 = 30;
        dadY1 = 300;
      }
    }
  }

  // Add collision detection to the fake portal
  if(dadX1 <= 250 && dadY1 <= 90){
    cutScene4();
  }

  // If dad walks near police car, cop will appear on screen
  if(dadX1 > 500){
    copY -= 5;
    if(copY < 270){
      copY += 5;
    }
  }

  // If dad hits cop, he gets arrested
  if(dadX1 >= copX){
    dadX -= 2;
      background(255, 255, 255);
      imgCop.resize(180, 180);
      image(imgCop, 700, 400);
      imgDadMad.resize(150, 150);
      image(imgDadMad, 500, 440);
      

 // Ask user to choose a path
 if (state == 0) {
  textSize(30);
  text("Cop: Y were u jaywalking???", 420, 30);
  text("Choose either: 1. no clue OR 2. i do not care (Press 1 or 2)", 220, 100);
}
// If user chooses option 1, display 2 possible endings
 else if (state == 1) {
  imgCop.resize(180, 180);
  image(imgCop, 700, 400);
  imgDadMad.resize(150, 150);
  image(imgDadMad, 500, 440);
  textSize(30);
  text("Cop: ok u need to pay a $1 fine", 420, 30);
  text("Choose either: 1. pay fine OR 2. fight cop", 280, 100);
} 

// If user chooses option 2, display 2 possible endings
else if (state == 2) {
  imgCop.resize(180, 180);
  image(imgCop, 700, 400);
  imgDadMad.resize(150, 150);
  image(imgDadMad, 500, 440);
  textSize(30);
  text("Cop: u rlly dont care that ur jaywalking??", 300, 30);
  text("Choose either: 1. care less OR 2. bribe cop", 320, 100);
  } 

  // If user chooses to pay fine, display bad ending
  else if(state == 3){
  imgCop.resize(180, 180);
  image(imgCop, 700, 400);
  imgDadMad.resize(150, 150);
  image(imgDadMad, 500, 440);
  textSize(30);
  text("BAD ENDING: YOU GOT ARRESTED... WOMP WOMP", 300, 30);
  text("u pulled out ur wallet just to realize you have no money", 300, 100);
  text("u got arrested for not paying a $1 fine LOL", 300, 170);
  text("You found the arrested over $1 fine ending!", 300, 240);
  }
  
  // If user chooses to fight the cop, display bad ending
  else if(state == 4){
    background(255, 255, 255);
    imgCop.resize(180, 180);
    image(imgCop, 700, 400);
    imgDadDead.resize(150, 150);
    image(imgDadDead, 500, 440);
    textSize(30);
    text("BAD ENDING: YOU GOT SHOT... WOMP WOMP", 300, 30);
    text("u tried to take the cops gun but he was too fast", 300, 100);
    text("u got shot and died on the scene", 300, 170);
    text("what were u even thinking smh... smooth brain", 300, 240);
    text("You found the shot to death ending!", 300, 310);
} 

  // If user chooses to not care, display cutscene
  else if(state == 5){
    imgCop.resize(180, 180);
    image(imgCop, 700, 400);
    imgDadMedium.resize(150, 150);
    image(imgDadMedium, 500, 440);
    textSize(30);
    text("Cop: so u dont even care???", 400, 30);
    text("Press Alt to continue...", 430, 100);
}

  // If user chooses to bribe cop, display bad ending
  else if(state == 6){
    imgCop.resize(180, 180);
    image(imgCop, 700, 400);
    imgDadMedium.resize(150, 150);
    image(imgDadMedium, 500, 440);
    textSize(30);
    text("BAD ENDING: YOU GOT ARRESTED LOL... WOMP WOMP", 300, 30);
    text("u cared so little that u tried to bribe a cop", 300, 100);
    text("u realized u only had $10 and tried to give the cop $10", 300, 170);
    text("the cop didnt accept ur bribe and u got arrested", 300, 240);
    text("You found the bribery ending!", 300, 310);
} 

  // If user chooses to not care, display good ending and let them continue to level 4
  else if(state == 7){
    imgCop.resize(180, 180);
    image(imgCop, 700, 400);
    imgDadMedium.resize(150, 150);
    image(imgDadMedium, 500, 440);
    textSize(30);
    text("Cop: k since u dont care and i dont, imma just let u go", 300, 30);
    text("GOOD ENDING: YOU DIDN'T GET ARRESTED!", 300, 200);
    text("u realized u only had $10 and tried to give the cop $10", 300, 270);
    text("Press Alt to continue...", 400, 400);
}
  }
}
// Detect which key is being pressed and where to direct the player (Soccer scene included)
  public void keyPressed() {
    if (state == 0) {
      if (key == '1') {
        state = 1;
      } else if (key == '2') {
        state = 2;
      }
    } else if (state == 1) {
      if (key == '1') {
        state = 3;
      } else if (key == '2') {
        state = 4;
      }
    } else if(state == 2){
      if(key == '1'){
        state = 5;
      }else if(key == '2'){
        state = 6;
      }
    } if(state == 5){
      if(keyCode == ALT){
        state = 7;
      }
    } if(state == 7){
      if(keyCode == ALT){
        // Insert level 4 method
      }
    } 
  }


  
  
  public void cutScene4() {

    // Load background
    imgSoccer.resize(1200, 700);
    image(imgSoccer, 0, 0);

    // Load dad and Ronaldo into map
    image(imgDadSmall, dadX2, dadY2); 
    imgRonaldo.resize(200, 130);
    image(imgRonaldo, ronaldoX, ronaldoY);

    // Make dad move into position
    if(dadY2 > 370){
      dadY2 -= 1.5;
    }

    // Once dad stops moving, Ronaldo runs into frame
    if(dadY2 < 380){
      ronaldoX += 6;
    }

    // Make Ronaldo kick dad and make dad fly into net
    if(ronaldoX > 175){
      ronaldoX -= 6;
      dadX2 += 10;
    }

    // Add collision detection to net and add death scene
    if(dadX2 >= 850){
      dadX2 -= 10;
        imgSoccer.resize(1200, 700);
        image(imgSoccer, 0, 0);
        fill(255);
        textSize(30);
        text("SUIIIIIIIIII", 170, 250);
        image(imgSuiii, 175, 250);
        imgDadDead.resize(50, 50);
        image(imgDadDead, 820, dadY2);
        fill(255, 0, 34);
        textSize(25);
        text("wasted", 700, dadY2);
    }
  
    // Add final death scene (NEEDS FIXING)
    
      background(255, 255, 255);
      fill(0);
      textSize(50);
      text("YOU DIED... WOMP WOMP", 300, 150);
      textSize(30);
      text("lol imagine walkin onto a soccer field", 320, 250);
      text("and imagine being confused for the ball LOL", 290, 350);
      text("suiiiiiiiiiiiiiiiiiii", 500, 450);
      }
    }
  
  



    

    













  
