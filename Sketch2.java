import processing.core.PApplet;
import processing.core.PImage;

public class Sketch2 extends PApplet {

  /**
   * Description
   * A program that contains multiple levels including maze and road levels with each level having different elements.
   * @author S. Liu
   */

  // Character images
	PImage imgDad;
  PImage imgDadMad;
  PImage imgDadDead;
  PImage imgDadSmall;
  PImage imgDadMedium;
  PImage imgDadMadSmall;

  // Funny troll images for level 1
  PImage imgMutahar;
  PImage imgMike;

  // Images used in level 3
  PImage imgLevel3;
  PImage imgPortal;
  PImage imgLaugh;
  PImage imgPolice;
  PImage imgCop;
  PImage imgLambo;
  PImage imgTonk;

  // Images used in level 3 cutscene
  PImage imgSoccer;
  PImage imgRonaldo;
  PImage imgSuiii;

  // Images used in level 5
  PImage imgLevel5;
  PImage imgcreditCard;
  PImage imgLinus;
  PImage imgChiron;
  PImage imgHummer;
  PImage imgPorsche;
  PImage imgCreeper;
  PImage imgstickBug;
  PImage imgKaren;
  PImage imgX;
  PImage imgPog;

  // Declare Lambo variables for level 3
  int lamboCount = 1;
  float[] lamboX = new float [lamboCount];
  float[] lamboY = new float [lamboCount];
  double lamboSpeed = 3;
  boolean lamboCrash = false;
  boolean lamboHit = false;

  // Declare tank variables for level 3
  int tankCount = 1;
  float[] tankX = new float [tankCount];
  float[] tankY = new float [tankCount];
  double tankSpeed = 2;
  boolean tankCrash = false;
  boolean tankHit = false;

  // Declare Chrion variables for level 5
  int chrionCount = 1;
  float[] chrionX = new float [chrionCount];
  float[] chrionY = new float [chrionCount];
  double chrionSpeed = 3;
  boolean chrionCrash = false;
  boolean chrionHit = false;

  // Declare Porsche variables for level 5
  int porscheCount = 1;
  float[] porscheX = new float [porscheCount];
  float[] porscheY = new float [porscheCount];
  double porscheSpeed = 3.5;
  boolean porscheCrash = false;
  boolean porscheHit = false;

  // Declare Hummer variables for level 5
  int hummerCount = 1;
  float[] hummerX = new float [hummerCount];
  float[] hummerY = new float [hummerCount];
  double hummerSpeed = 2.5;
  boolean hummerCrash = false;
  boolean hummerHit = false;

  // Declare creeper variables for level 5
  int creeperCount = 1;
  float[] creeperX = new float [creeperCount];
  float[] creeperY = new float [creeperCount];
  double creeperSpeed = 4;
  boolean creeperCrash = false;
  boolean creeperHit = false;

  public void settings() {

	// Load character images
    size(1200, 700);
    imgDad = loadImage("Dad Game Character.png");
    imgDadMad = loadImage("Dad Game Character Kishibe Rohan.png");
    imgDadDead = loadImage("Dad Game Character Dead Lying Down.png");
    imgDadSmall = loadImage("Dad Game Character Small.png");
    imgDadMedium = loadImage("Dad Game Character Medium.png");
    imgDadMadSmall = loadImage("Dad Game Character Kishibe Rohan Small.png");

    // Load images for level 1
    imgMutahar = loadImage("Mutahar Laugh.jpg");
    imgMike = loadImage("Mike Wazowski Bruh Face.jpg");

    // Load images for level 3
    imgLevel3 = loadImage("Level3BG.png");
    imgPortal = loadImage("Portal1BG.png");
    imgLaugh = loadImage("Laugh.jpg");
    imgPolice = loadImage("Popo.png");
    imgCop = loadImage("Cop.png");
    imgLambo = loadImage("Lambo.png");
    imgTonk = loadImage("Tonk.png");

    // Load images for level 3 cutscene
    imgSoccer = loadImage("Soccer Net.jpg");
    imgRonaldo = loadImage("Ronaldo.png");
    imgSuiii = loadImage("Suiii.png");

    // Load images for level 5
    imgLevel5 = loadImage("Level5BG.png");
    imgcreditCard = loadImage("CreditKard.png");
    imgLinus = loadImage("Linus.jpg");
    imgChiron = loadImage("Chrion.png");
    imgHummer = loadImage("Hummer.png");
    imgPorsche = loadImage("Porsche.png");
    imgCreeper = loadImage("Creeper.png");
    imgstickBug = loadImage("StickBug.jpg");
    imgKaren = loadImage("Karen.jpg");
    imgX = loadImage("X.png");
    imgPog = loadImage("Pog.jpg");
  }

  // Declare variables for level 1
  float dadX = 50;
  float dadY = 270;

  // Declare vairables for level 3
  float dadX1 = 30;
  float dadY1 = 300;
  float copX = 840;
  float copY = 950;

  // Declare variables for level 3 cutscene
  float dadX2 = 300;
  float dadY2 = 650;
  float ronaldoX = -130;
  float ronaldoY = 280;

  // Declare variables for level 5
  float dadX3 = 30;
  float dadY3 = 290;


  
  

  // Timer variables

  int timer1;
  int dura1 = 100000;
  int timer3;
  int dura3 = 13000;
  int timer4;
  int dura4 = 100000;
  

  // Declare state for police interoggation
  int state = 0;

  


  // Draw background
  public void setup() {
    background(3, 248, 252);

    // Set each timer to millis
    timer1 = millis();
    timer3 = millis();
    timer4 = millis();

    // Lambo array position setup
    for (int i = 0; i < lamboCount; i++) {
      lamboX[i] = 240;
      lamboY[i] = 0;
    }

    // Tank array position setup
    for(int i = 0; i < tankCount; i++){
      tankX[i] = 530;
      tankY[i] = -50;
    }

    // Chrion array position setup
    for(int i = 0; i < chrionCount; i++){
      chrionX[i] = 260;
      chrionY[i] = -30;
    }

    // Porsche array position setup
    for(int i = 0; i < porscheCount; i++){
      porscheX[i] = 430;
      porscheY[i] = -30;
    }

    // Hummer array position setup
    for(int i = 0; i < hummerCount; i++){
      hummerX[i] = 610;
      hummerY[i] = 700;
    }

    // Creeper array position setup
    for(int i = 0; i < creeperCount; i++){
      creeperX[i] = 850;
      creeperY[i] = 700;
    }
  }

  // Draw background again for clean animations
  public void draw() {
    background(3, 248, 252);

  // Call each level
    level1();
    //level3();
    //cutScene4();
    //level5();
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
        dadY-=2.5;
      }
      else if(key == 's'){
        dadY+=2.5;
      }
      else if(key == 'a'){
        dadX-=2.5;
      }
      else if(key == 'd'){
        dadX+= 2.5;
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
        dadX1+= 2;
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

  // Draw Lambo
  lamboCar();

  // Draw tank
  Tank();
  
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
        copX = 840;
        copY = 950;
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
    background(255, 255, 255);
    imgCop.resize(180, 180);
    image(imgCop, 700, 400);
    imgDadMad.resize(150, 150);
    image(imgDadMad, 500, 440);
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
    text("hopefully it didnt take u too long to find the right ending", 300, 270);
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
    
  
    // Add final death scene (NEEDS FIXING)
      int elasped3 = millis() - timer3;
      if(elasped3 > dura3){
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
    }

    public void lamboCar(){
      for (int i = 0; i < lamboCount; i++) {

        // Update Lambo location
        lamboY[i] += lamboSpeed;
  
        // If Lambo goes off screen, teleport it back to the start
        if (lamboY[i] > 600) {
        lamboX[i] = 240;
        lamboY[i] = 5;
        }
  
        // Draw Lambo
        imgLambo.resize(210, 150);
        image(imgLambo, lamboX[i], lamboY[i]);

        // Detect if player gets hit by Lambo
        if(dist(dadX1, dadX2, lamboX[i], lamboY[i]) < 120 && !lamboCrash){
          lamboHit = true;
        }

        // If player gets hit, display death screen
        if(lamboHit){
          background(255, 255, 255);
          tankY[i] = -250;
          textSize(30);
          text("YOU DIED... WOMP WOMP", 400, 30);
          text("bruh there was literally a sign saying to not jaywalk smh...", 200, 100);
          text("also imagine being so big u take up the whole road LOL", 200, 170);
          text("we recommend not jaywalking and getting plowed by a lambo", 200, 240);
          text("Press Alt to restart...", 450, 310);
          imgDadDead.resize(250, 250);
          image(imgDadDead, 450, 350);
        }

        // Reset player and lamboHit boolean by pressing Alt
        if(keyPressed){
          if(keyCode == ALT){
            lamboHit = false;
            dadX1 = 30;
            dadY1 = 300;
            copX = 840;
            copY = 950;
          }
        }
    }
    }
  

    public void Tank(){
      for(int i = 0; i < tankCount; i++){

        // Update tank location
        tankY[i] += tankSpeed;

        // If tank goes off screen, reset its position
        if(tankY[i] > 600){
          tankX[i] = 530;
          tankY[i] = -50;
        }
        
        // Draw tank
        imgTonk.resize(280, 210);
        image(imgTonk, tankX[i], tankY[i]);

        // Detect if player gets hit by tank
        if(dist(dadX1, dadX2, tankX[i], tankY[i]) < 180 && !tankCrash){
          tankHit = true;
        }
          // Detect if player gets hit by Lambo
        if(dist(dadX1, dadX2, lamboX[i], lamboY[i]) < 120 && !lamboCrash){
          lamboHit = true;
        }

        // If player is hit, display death screen 
        if(tankHit){
          background(255, 255, 255);
          textSize(30);
          text("YOU DIED... WOMP WOMP", 400, 30);
          text("bruh there was literally a sign saying to not jaywalk smh...", 200, 100);
          text("also imagine not seeing the tank smh", 200, 170);
          text("we recommend not jaywalking and getting plowed by a tank", 200, 240);
          text("Press Alt to restart...", 450, 310);
          imgDadDead.resize(250, 250);
          image(imgDadDead, 450, 350);
        }

        // Reset player and tankHit boolean by pressing Alt 
        if(keyPressed){
          if(keyCode == ALT){
            tankHit = false;
            dadX1 = 30;
            dadY1 = 300;
            copX = 840;
            copY = 950;
          }
        }
        }
      }

      public void level5(){

        // Load dad and background and sqaure
        image(imgLevel5, 0, 0);
        image(imgDadMedium, dadX3, dadY3);

        // Load fake cheat codes 
        imgcreditCard.resize(200, 120);
        image(imgcreditCard, 1, 10);
        textSize(20);
        fill(0);
        text("stuck? hover ur mouse over", 0, 170);
        text("the card to buy hacks!", 0, 210);

        // Draw fake Karen ending
        fill(250, 25, 17);
        rect(50, 500, 140, 140);
        textSize(25);
        fill(0);
        text("Speak to Manager", 25, 480);

        // Make dad move based on WASD presses
        if(keyPressed){

          if(key == 'w'){
            dadY3 -=2 ;
          }
          else if(key == 's'){
            dadY3 += 2;
          }
          else if(key == 'a'){
            dadX3 -= 2;
          }
          else if(key == 'd'){
            dadX3 += 2;
          }
        }
        image(imgDadMedium, dadX3, dadY3);

        // Add collision detection to the credit card and screen if player tries to buy hacks
        if(mouseX < 200 && mouseX > 10 && mouseY < 150 && mouseY > 10){
          Cheater();
        }
        
        // Add troll if player presses the mouse
        if(mousePressed){
          imgstickBug.resize(1200, 700);
          image(imgstickBug, 0 ,0);
          textSize(8);
          fill(255, 255, 255);
          text("dont press 1 >:)", 10, 10);
        }

        // Add a hint if player presses a key
        if(keyPressed){
          if(key == '1'){
            imgLevel5.resize(1200, 700);
            image(imgLevel5, 0, 0);
            imgX.resize(30, 30);
            image(imgX, 1150, 10);
          }
        }

        // Add easy ending to level
        if(mouseY < 45 && mouseX < 1180 && mouseX > 1145){
          ezEnding();
        }

        // Add Karen ending
        if(dadY3 > 480 && dadX3 > 0 && dadX3 < 80){
          Karen();
          dadX3 = 60;
          dadY3 = 485;
        }
        

        // Add cars moving
        Chrion();
        Porsche();
        Hummer();
        Creeper();

        // Add ending if player somehow crosses the highway
        if(dadX3 > 970 && dadY3 < 330 && dadY3 > 200){
          background(255, 255, 255);
          textSize(30);
          fill(0);
          text("what? how did u cross the road???", 350, 70);
          text("yk that road was made to be impossible to cross right??", 210, 140);
          text("congrats for getting across ig", 360, 210);
          text("fyi that wasnt how u were supposed to beat the level LOLLLLL", 160, 280);
          text("i hope it didnt take u too long to beat it LOL", 300, 350);
          text("Press Enter to move on LOL...", 400, 580);

          // ADD CODE TO RUN LEVEL 6 METHOD
        }
      }
    
      // If player tries to cheat, display troll screen
      public void Cheater(){
        imgLinus.resize(1200, 700);
        image(imgLinus, 0, 0);
        textSize(30);
        fill(250, 17, 25);
        text("LOL u rlly thought u could cheat LOL", 350, 70);
        text("imagine tryin to buy hacks lol", 400, 140);
        text("im just gonna hope u moved ur mouse here by accident...", 200, 210);
        text("move ur mouse off this to continue...", 350, 600);
      }

      public void Karen(){
        imgKaren.resize(1200, 700);
        image(imgKaren, 0, 0);
        textSize(30);
        fill(0);
        text("BAD ENDING: YOU WENT VIRAL FOR BEING A KAREN... WOMP WOMP", 120, 70);
        text("LOL no way bro just tried to speak to the manager", 270, 140);
        text("bruh imagine speaking to the manager cuz u cant jaywalk on a highway LOL", 50, 210);
        text("next time dont be such a karen LOL", 330, 280);
        fill(255, 255, 255);
        text("You found the Karen ending!", 350, 600);
      }

      public void Chrion(){
        for (int i = 0; i < chrionCount; i++) {
  
          // Update Chiron location
          chrionY[i] += chrionSpeed;
    
          // If Chiron goes off screen, teleport it back to the start
          if (chrionY[i] > 600) {
          chrionX[i] = 260;
          chrionY[i] = -30;
          }
    
          // Draw Chiron
          imgChiron.resize(210, 130);
          image(imgChiron, chrionX[i], chrionY[i]);
  
          // Detect if player gets hit by Chiron
          if(dist(dadX3, dadY3, chrionX[i], chrionY[i]) < 120 && !chrionCrash){
            chrionHit = true;
          }
  
          // If player gets hit, display death screen
          if(chrionHit){
            background(255, 255, 255);
            chrionY[i] = -30;
            textSize(30);
            text("YOU DIED... WOMP WOMP", 400, 30);
            text("bruh imagine tryin to cross a 4 lane road smh", 300, 100);
            text("we recommend not jaywalking on a highway", 300, 170);
            text("Press Alt to restart...", 450, 310);
            imgDadDead.resize(250, 250);
            image(imgDadDead, 450, 350);
          }
  
          // Reset player and chrionHit boolean by pressing Alt
          if(keyPressed){
            if(keyCode == ALT){
              chrionHit = false;
              dadX3 = 30;
              dadY3 = 290;
            }
          }
      }
      }

      public void Porsche(){
        for (int i = 0; i < porscheCount; i++) {
  
          // Update Porsche location
          porscheY[i] += porscheSpeed;
    
          // If Porsche goes off screen, teleport it back to the start
          if (porscheY[i] > 600) {
          porscheX[i] = 430;
          porscheY[i] = -30;
          }
    
          // Draw Porsche
          imgPorsche.resize(210, 130);
          image(imgPorsche, porscheX[i], porscheY[i]);
  
          // Detect if player gets hit by Porsche
          if(dist(dadX3, dadY3, porscheX[i], porscheY[i]) < 120 && !porscheCrash){
            porscheHit = true;
          }
  
          // If player gets hit, display death screen
          if(porscheHit){
            background(255, 255, 255);
            porscheY[i] = -30;
            textSize(30);
            text("YOU DIED... WOMP WOMP", 400, 30);
            text("bruh imagine tryin to cross a 4 lane road smh", 300, 100);
            text("we recommend not jaywalking on a highway", 300, 170);
            text("Press Alt to restart...", 450, 310);
            imgDadDead.resize(250, 250);
            image(imgDadDead, 450, 350);
          }
  
          // Reset player and porschenHit boolean by pressing Alt
          if(keyPressed){
            if(keyCode == ALT){
              porscheHit = false;
              dadX3 = 30;
              dadY3 = 290;
            }
          }
      }
      }

      public void Hummer(){
        for (int i = 0; i < hummerCount; i++) {
  
          // Update Hummer location
          hummerY[i] -= hummerSpeed;
    
          // If Hummer goes off screen, teleport it back to the start
          if (hummerY[i] < 0) {
          hummerX[i] = 610;
          hummerY[i] = 700;
          }
    
          // Draw Hummer
          imgHummer.resize(210, 130);
          image(imgHummer, hummerX[i], hummerY[i]);
  
          // Detect if player gets hit by Hummer
          if(dist(dadX3, dadY3, hummerX[i], hummerY[i]) < 120 && !hummerCrash){
            hummerHit = true;
          }
  
          // If player gets hit, display death screen
          if(hummerHit){
            background(255, 255, 255);
            hummerY[i] = 700;
            textSize(30);
            text("YOU DIED... WOMP WOMP", 400, 30);
            text("bruh imagine tryin to cross a 4 lane road smh", 300, 100);
            text("we recommend not jaywalking on a highway", 300, 170);
            text("Press Alt to restart...", 450, 310);
            imgDadDead.resize(250, 250);
            image(imgDadDead, 450, 350);
          }
  
          // Reset player and hummerHit boolean by pressing Alt
          if(keyPressed){
            if(keyCode == ALT){
              hummerHit = false;
              dadX3 = 30;
              dadY3 = 290;
            }
          }
      }
      }

      public void Creeper(){
        for (int i = 0; i < creeperCount; i++) {
  
          // Update Crepper location
          creeperY[i] -= creeperSpeed;
    
          // If Creeper goes off screen, teleport it back to the start
          if (creeperY[i] < 0) {
          creeperX[i] = 850;
          creeperY[i] = 700;
          }
    
          // Draw Creeper
          imgCreeper.resize(100, 180);
          image(imgCreeper, creeperX[i], creeperY[i]);
  
          // Detect if player gets hit by Creeper
          if(dist(dadX3, dadY3, creeperX[i], creeperY[i]) < 120 && !creeperCrash){
            creeperHit = true;
          }
  
          // If player gets hit, display death screen
          if(creeperHit){
            background(255, 255, 255);
            creeperY[i] = 700;
            textSize(30);
            text("YOU DIED... WOMP WOMP", 400, 30);
            text("uhh well that was interesting", 400, 100);
            text("how did u even get hit by a creeper???", 350, 170);
            text("Press Alt to restart...", 450, 310);
            imgDadDead.resize(250, 250);
            image(imgDadDead, 450, 350);
          }
  
          // Reset player and creeperHit boolean by pressing Alt
          if(keyPressed){
            if(keyCode == ALT){
              creeperHit = false;
              dadX3 = 30;
              dadY3 = 290;
            }
          }
      }
      }
      
      public void ezEnding(){
        imgPog.resize(1200, 700);
          image(imgPog, 0, 0);
          textSize(30);
          fill(255);
          text("YOOO u found the ez ending!!!", 400, 70);
          text("congrats for finding this!", 430, 140);
          text("Press Alt to continue!!", 450, 210);

          // ADD CODE TO RUN LEVEL 6 METHOD
      }
    }
  
  
  



    

    













  
