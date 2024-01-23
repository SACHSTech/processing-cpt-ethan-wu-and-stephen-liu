import processing.core.PApplet;
import processing.core.PImage;
 
public class Sketch extends PApplet {
  
  /**
  * Description
  * A program that contains several levels, each with different objectives
  * @author: E. Wu, S. Liu
  */

  PImage imgDad;
  PImage imgDadMad;
  PImage imgDadDead;
  PImage imgDadSmall;
  PImage imgDadMedium;

  // Directional movement variables
  boolean leftPressed = false;
  boolean rightPressed = false;
  boolean jumpPressed = false;
  boolean shiftPressed = false;
  
  // Cutscene 1 variables
  PImage imgMom;
  PImage imgSon;
  PImage imgDaughter;
  PImage imgHouse;
  PImage imgDoor;

  int imgDad_X1 = 600;
  int imgDad_Y1 = 200;
  int text_X1 = 700;
  int text_Y1 = 100;

  // Cutscene 2 variables
  PImage imgPathway;

  int imgDadMedium_X1 = 500;
  int imgDadMedium_Y1 = 500;
  int text_X2 = 600;
  int text_Y2 = 650;
  
  // Cutscene 3 variables
  PImage imgUgandanKnuckles;
  PImage imgDaWey;
  PImage imgMutahar;

  int text_X3 = 1000;
  int text_Y3 = 400;

  String[] cutscene3Strings = 
  {
    "woah what is this place?",
    "who the hell is u?",
    "ouch",
    "YOU DIED... WOMP WOMP",
    "YOUR BRAIN SHUT DOWN BECAUSE",
    "YOU COULD NOT COMPREHEND WHAT YOU JUST SAW",
    "YOU DIED OF STROKE"
  };

  // Level 2 variables
  double imgDadSmall_X1 = 0;
  double imgDadSmall_Y1 = 560;

  PImage imgLevel2Background;
  PImage imgTrampoline;
  PImage imgSpikes;
  PImage imgBuilding1;
  PImage imgBuilding2;
  PImage imgBird;
  PImage imgEmoji;

  // Reset level 2 booleans
  boolean isDead = false;
  boolean enterPressed = false;

  // Array locations of trampoline, spikes, buildings in level 2
  int tramp_locations[] = {130, 450, 940};
  int spike_locations[] = {80, 400, 670, 780, 1050};
  int building_locations[] = {200, 520, 1100};

  // Level 2 Jumping 
  double jumping_X1 = imgDadSmall_X1;
  double jumping_Y1 = imgDadSmall_Y1;
  double xSpeed1 = 2; 
  double ySpeed1 = 0;
  double gravity1 = 0.5;
  boolean hasJumped = false;

  // Part of Level 2, but it's in the drawBirds() method
  int birdCount = 50;
  float[] birdX = new float [birdCount];
  float[] birdY = new float [birdCount];
  float birdSpeed = 20;

  // Level 4 Variables
  PImage imgLevel4Background;
  PImage imgJoeHamHappy;
  PImage imgSignRead;
  PImage imgEyeballs;
  PImage imgShotgun;
  PImage imgWalkieTalkie;
  PImage imgNuke;

  // Level 4 Eyeballs feature variables
  int eyeballCount = 20;
  float[] eyeballX = new float [eyeballCount];
  int eyeballY = 500;

  // Level 4 timer variables
  int startTime;
  int duration = 10000;

  // Level 4 jumping variables
  int imgDadMedium_X2 = 0;
  int imgDadMedium_Y2 = 600;
  int jumping_X2 = imgDadMedium_X2;
  int jumping_Y2 = imgDadMedium_Y2;
  double xSpeed2 = 2; 
  double ySpeed2 = 0;
  double gravity2 = 0.5;
  boolean hasJumped2 = false;
  
  // Level 4 sign variables to detect if mouse is hovering over sign
  int signX = 200;
  int signY = 580;
  int signWidth = 100;
  int signHeight = 50;
  boolean mouseOverSign = false;

  // Level 4 gun shooting variables
  int bullet_count = 20;
  float[] bulletX = new float[bullet_count];
  int bulletY = 630;
  float[] bulletSpeed = new float[bullet_count];
  int numLives = 15;
  float playerRadius = 40;

  // Level 4 nuke variables
  int nukeX = 100;
  int nukeY = -500;

  // Cutscene 4 variables
  PImage imgNukeBackground;

  // Level 1 variables
  PImage imgMike;
  float dadX = 50;
  float dadY = 270;

  // Variables used in level 3
  PImage imgLevel3;
  PImage imgPortal;
  PImage imgLaugh;
  PImage imgPolice;
  PImage imgCop;
  PImage imgLambo;
  PImage imgTonk;

  float dadX1 = 30;
  float dadY1 = 300;
  float copX = 840;
  float copY = 950;

  // Level 3 cutscene variables
  float dadX2 = 300;
  float dadY2 = 650;
  float ronaldoX = -130;
  float ronaldoY = 280;

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

  float dadX3 = 30;
  float dadY3 = 290;

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

  // Timer variables
  int timer1;
  int dura1 = 100000;
  int timer3;
  int dura3 = 13000;
  int timer4;
  int dura4 = 100000;

  // Declare state for police interoggation
  int state = 0;

  public void settings() {
    size(1200, 700);
    // Dad Image Loading
    imgDad = loadImage("Dad Game Character.png");
    imgDadMad = loadImage("Dad Game Character Kishibe Rohan.png");
    imgDadDead = loadImage("Dad Game Character Dead Lying Down.png");
    imgDadSmall = loadImage("Dad Game Character Small.png");
    imgDadMedium = loadImage("Dad Game Character Medium.png");

    // Cutscene 1 Image Loading
    imgMom = loadImage("Mom Game Character.png");
    imgSon = loadImage("Son Game Character.png");
    imgDaughter = loadImage("Daughter Game Character.png");
    imgDoor = loadImage("Door.png");
    
    // Cutscene 2 Image Loading
    imgPathway = loadImage("Game Pathway.png");
    
    // Cutscene 3 Image Loading
    imgUgandanKnuckles = loadImage("Ugandan Knuckles.jpg");
    imgDaWey = loadImage("Game Da Wey.png");
    imgMutahar = loadImage("Mutahar Laugh.jpg");

    // Level 2 Image Loading
    imgLevel2Background = loadImage("Level 2 Background.png");
    imgTrampoline = loadImage("trampoline transparent.png");
    imgSpikes = loadImage("spikes transparent.png");
    imgBuilding1 = loadImage("building 1.png");
    imgBuilding2 = loadImage("building 2.png");
    imgBird = loadImage("da bird transparent.png");
    imgEmoji = loadImage("emoji disentegrating.png");
    
    // Level 4 Image Loading
    imgLevel4Background = loadImage("level 4 background.png");
    imgJoeHamHappy = loadImage("joe ham happy transparent.png");
    imgSignRead = loadImage("sign read.png");
    imgEyeballs = loadImage("eyeballs.png");
    imgShotgun = loadImage("joe ham shotgun.png");
    imgWalkieTalkie = loadImage("walkie talkie.png");
    imgNuke = loadImage("nuke.png");

    // Cutscene 4 Image loading
    imgNukeBackground = loadImage("nuke background.jpg");

    // Load images for level 1
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

  public void setup() {
    
    // Level 2 timer setup
    startTime = millis();
      
    // Level 2 Bird arrays position setup. Initialize their positions with array.
    for (int i = 0; i < birdCount; i++) {
      birdX[i] = random(width);
       
      for (int j = 0; j < birdCount; j++) {
        birdY[i] = random(200);
      }
    }

    // Level 4 timer setup
    startTime = millis();

    // Level 4 Eyeball setup. Initialize their positions with array.
    for (int i = 0; i < eyeballCount; i++) {
      eyeballX[i] = random(width);
    }

    // Level 4 Bullet setup. Initialize their positions with array.
    for (int i = 0; i < bullet_count; i++) {
      bulletX[i] = random(width);
      
      for (int j = 0; j < bullet_count; j++) {
        bulletSpeed[i] = random(7, 10);
      }  
    }  

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

  public void draw() {
    // Reset background to provide clean animation
    background(210, 255, 173);

    // Call cutscene1 Method
    cutscene1();
    
    // Call cutscene2 Method
    cutscene2();

    // Collision Detection: If the player chooses the Left route on the pathway in cutscene 2, call cutscene3 method.
    if (imgDadMedium_X1 <= 600 && imgDadMedium_Y1 <= 0 && frameCount >= 720) {
      cutscene3();
    }

    //// Collision Detection: If the player chooses the Right route on the pathway in cutscene 2, call the level2 method.
    if (imgDadMedium_X1 >= 601 && imgDadMedium_Y1 <= 0) {
        level1();
      }
    
    // When the player reaches the door in level 2, call level 4 method.
    if (jumping_X1 > 1100 && !isDead) {
        level2();
      }

    if (dadX >= 1040) {
        level3();
    }  

    if (state == 8) {
      level5();
    }

    if (state == 9) {
      level4();
    }

    if (nukeY > 400) {
      cutscene4();
    }
  }

  /**
   * Keybinds: if you press these keys, it will move the character
   * @param leftPressed boolean that allows left movement
   * @param rightPressed boolean that allows right movement
   * @param jumpPressed boolean that allows jump
   * @param shiftPressed boolean that allows sprint
   * @param enterPressed boolean that allows enter next level
   */
  public void keyPressed() {
    // Keybinds for movement
    if (key == 'l') {
      leftPressed = true;
    }
    if (key == 'r') {
      rightPressed = true;
    }
    if (keyCode == BACKSPACE) {
      jumpPressed = true;
    }
    if (keyCode == SHIFT) {
      shiftPressed = true;
    }
    
    // Reset level 2 boolean
    if (keyCode == ENTER) {
      enterPressed = true;
    } 

    // 

    // Detect which key is being pressed and where to direct the player (Soccer scene included)
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
          state = 8;
        }
      } if (state == 8) {
        if(keyCode == CONTROL) {
          if (dadX3 > 900 || mouseY < 45 && mouseX < 1180 && mouseX > 1145) {
            state = 9;
          }
          
        }  

      }
  }


  /**
   * Movement stops when the corresponding keys are released
   * @param leftPressed boolean that allows left movement
   * @param rightPressed boolean that allows right movement
   * @param jumpPressed boolean that allows jump
   * @param shiftPressed boolean that allows sprint
   * @param enterPressed boolean that allows enter next level
   */
  public void keyReleased() {
    // Keybinds for movement
    if (key == 'l') {
      leftPressed = false;
    }
    if (key == 'r') {
      rightPressed = false;
    }
    if (keyCode == BACKSPACE) {
      jumpPressed = false;
    }
    if (keyCode == SHIFT) {
      shiftPressed = false;
    }

    // Reset level boolean
    if (keyCode == ENTER) {
      enterPressed = false;
    }
  }


  public void cutscene1() {
    // Draw Images for the Beginning Cutscene
    imgDoor.resize(200, 400);
    image(imgDoor, 1000, 150);
    
    imgDad.resize(300,300);
    image(imgDad, imgDad_X1, imgDad_Y1);
    
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

    // Make the Dad move after 3 seconds from the start of the program.  Update text's position so that it goes offscreen.
    if (frameCount >= 300) {
      imgDad_X1 += 5;
      text_X1 += 800;
    }

    // Wipe Screen to draw a transitioning screen
    if (frameCount >= 360) {
      background(255);
      textSize(50);
      textAlign(CENTER, CENTER);
      text("LEAVING THE HOUSE... BE PATIENT OK", width / 2, height / 2);
    }
  } 


  public void cutscene2() {
    // Draw the new background, which is an image
    if (frameCount >= 540) {
      image(imgPathway, 0, 0);
      image(imgDadMedium, imgDadMedium_X1, imgDadMedium_Y1);
    }
  
    // Adds a text box that gives a player directions on what to do
    if (frameCount >= 660) {
      fill(255, 25, 152);
      rect(175, 630, 850, 50);
      
      fill(0);
      textSize(30);
      text("L letter key to move Left, R letter Key for Right", text_X2, text_Y2);
    }

    // If user presses L key, the character will move along the left path.  
    // Collision detection is added in the draw method to see which path the character takes.
    if (frameCount >= 660) {
      if (leftPressed == true) {
        imgDadMedium_X1 -= 5;
        imgDadMedium_Y1 -= 5;
      }
    }
    
    // If user presses R key, the character will move along the right path.
    if (frameCount >= 660) {
      if (rightPressed == true) {
        imgDadMedium_X1 += 5;
        imgDadMedium_Y1 -= 5;
      }
    }

  }

  public void cutscene3() {
    // Add a white loading screen that has a message
    if (frameCount >= 720) {
      background(255);
      textSize(50);
      textAlign(CENTER, CENTER);
      text("GOOD CHOICE ...", width / 2, height / 2);
      text("LOADING ...", width / 2, 420);
    }
    
    // Series of nested if statements that will carry out code based on the frame count.
    // Draw the new background image, and draw the Dad
    if (frameCount >= 960) {
      image(imgDaWey, 0, 0);
      image(imgDadMedium, 1000, 500);
      
      // Add dialogue that the Dad says
      if (frameCount >= 1040) {
        fill(0);
        textSize(30);
        text(cutscene3Strings[0], text_X3, text_Y3);
      
        // Draw Ugandan Knuckles image
        if (frameCount >= 1260) {
          imgUgandanKnuckles.resize(200, 163);
          image(imgUgandanKnuckles, 510, 400);

          // Redraw the background to refresh the scene. Draw in Dad with angry face, redraw Ugandan Knuckles, add new dialogue.
          if (frameCount >= 1300) {
            image(imgDaWey, 0, 0);
            imgDadMad.resize(150, 150);
            image(imgUgandanKnuckles, 510, 400);
            image(imgDadMad, 1000, 500);

            text(cutscene3Strings[1], text_X3, text_Y3);

            // Redraw to refresh scene, add new dialogue
            if (frameCount >= 1540) {
              image(imgDaWey, 0, 0);
              imgDadDead.resize(150,150);
              image(imgUgandanKnuckles, 510, 400);
              image(imgDadDead, 1000, 500);
              text(cutscene3Strings[2], text_X3, text_Y3);

              // Show death message screen
              if (frameCount >= 1660) {
                imgMutahar.resize(1200,700);
                image(imgMutahar, 0, 0);
                fill(255);
                textSize(50);
                textAlign(CENTER, CENTER);
                text(cutscene3Strings[3], width / 2, 250);

                textSize(30);
                text(cutscene3Strings[4], width/2, 400);
                text(cutscene3Strings[5], width/2, 450);
                text(cutscene3Strings[6], width/2, 500);
              }
            }
          }
        }
      }
    }
  }

  public void level1() {
    // Draw level and Dad character
    level2Background();
    image(imgDadSmall, (float)jumping_X1, (float)jumping_Y1);

    // Give level instructions
    textSize(40);
    textAlign(CENTER, CENTER);
    text("Press backspace To jump and l/r to move :)", 400, 100);
    text("Jump on trampolines to get over building", 400, 150);
    text("Dont touch spike", 400, 200);

    // Border restriction to prevent player from moving out of the level
    if (jumping_X1 < 0) {
      jumping_X1 += 2;
    }
    if (jumping_X1 > (width - 50)) {
      jumping_X1 -= 2;
    }

    // Allow jumping on trampoline to happen when player is at trampoline coordinates
    if (!hasJumped && jumping_X1 > 120 && jumping_X1 < 150 ) {
      ySpeed1 = -23;
      hasJumped = true;
    }
    if (!hasJumped && jumping_X1 > 440 && jumping_X1 < 470 ) {
      ySpeed1 = -23;
      hasJumped = true;
    }
    if (!hasJumped && jumping_X1 > 930 && jumping_X1 < 960 ) {
      ySpeed1 = -23;
      hasJumped = true;
    }

    // Allow movement based on player input, such as moving left/right and jumping.
    movementMethod();

    // First Building Restrictions so that the player does not go through the building
    if (jumping_X1 + imgDadSmall.width > 200 && jumping_X1 < 200 + imgBuilding2.width && jumping_Y1 + imgDadSmall.height > 250) {
      jumping_Y1 = 250 - imgDadSmall.height;
      ySpeed1 = 0;
      hasJumped = false;
    }

    // Second building restrictions
    if (jumping_X1 + imgDadSmall.width > 520 && jumping_X1 < 520 + imgBuilding2.width && jumping_Y1 + imgDadSmall.height > 250) {
      jumping_Y1 = 250 - imgDadSmall.height;
      ySpeed1 = 0;
      hasJumped = false;
    }

    // When player touches spikes, reset player position to original.
    if (jumping_X1 > 40 && jumping_X1 < 110 && jumping_Y1 > 550 && !isDead) {
      jumping_X1 = imgDadSmall_X1;
      jumping_Y1 = imgDadSmall_Y1;
    }
    if (jumping_X1 > 360 && jumping_X1 < 430 && jumping_Y1 > 550 && !isDead) {
      jumping_X1 = imgDadSmall_X1;
      jumping_Y1 = imgDadSmall_Y1;
    }
    if (jumping_X1 > 630 && jumping_X1 < 700 && jumping_Y1 > 550 && !isDead) {
      jumping_X1 = imgDadSmall_X1;
      jumping_Y1 = imgDadSmall_Y1;
    }
    if (jumping_X1 > 740 && jumping_X1 < 810 && jumping_Y1 > 550 && !isDead) {
      jumping_X1 = imgDadSmall_X1;
      jumping_Y1 = imgDadSmall_Y1;
    }
    if (jumping_X1 > 1010 && jumping_X1 < 1080 && jumping_Y1 > 550 && !isDead) {
      jumping_X1 = imgDadSmall_X1;
      jumping_Y1 = imgDadSmall_Y1;
    }

    // Call drawBirds method so that birds will spawn in
    drawBirds();

    // Border restriction to set isDead boolean to character upon entering the border
    if (jumping_X1 > 800 && jumping_Y1 < 180) {
      isDead = true;
    }

    // When Dead
    if (isDead) {

        // Redraw everything
        level2Background();

        // Show dead picture     
        imgDadDead.resize(50,50);
        image(imgDadDead, (float)jumping_X1, (float)jumping_Y1);

        // Show Death message
        fill(224, 79, 164);
        rect(200, 75, 800, 120);

        fill(0);
        textSize(40);
        textAlign(CENTER, CENTER);
        text("YOU GOT IMPALED BY A FLYING BIRD", width / 2, 100);
        text("PRESS ENTER TO RESET", width / 2, 150);

        // Laughing Pic
        imgMutahar.resize(300, 500);
        image(imgMutahar, 0, 200);
        // Emoji Pic
        image(imgEmoji, 600, 400);

        if (enterPressed) {
          jumping_X1 = imgDadSmall_X1;
          jumping_Y1 = imgDadSmall_Y1;

          // Reset variables back to original
          isDead = false;
          hasJumped = false;

          // Redraw level
          level2Background();
          
          // Redraw the character
          image(imgDadSmall, (float) jumping_X1, (float) jumping_Y1);

          // Allow movement again
          movementMethod();
        }
      }
      
      // When player reaches door at the end, give them instructions to continue to the next level
       if(jumping_X1 > 1100) {
        fill(224, 79, 164);
        rect(200, 75, 800, 60);

        fill(0);
        textSize(40);
        textAlign(CENTER, CENTER);
        text("U ARE DEAD, STOP TRYING TO CHEAT", width / 2, 100);
      }
    }
  
  
  public void level2Background() {
    // Draw background and objects for level 2
    image(imgLevel2Background, 0, 0);
    
    image(imgTrampoline, tramp_locations[0], 580);
    image(imgTrampoline, tramp_locations[1], 580);
    image(imgTrampoline, tramp_locations[2], 580);

    image(imgSpikes, spike_locations[0], 580);
    image(imgSpikes, spike_locations[1], 580);
    image(imgSpikes, spike_locations[2], 580);
    image(imgSpikes, spike_locations[3], 580);
    image(imgSpikes, spike_locations[4], 580);
    
    image(imgBuilding1, building_locations[0], 250);
    image(imgBuilding1, building_locations[1], 250);
    image(imgBuilding2, building_locations[2], 250);
  }


  public void drawBirds() {
  // Birds will move when player gets to x position = 900
    if (jumping_X1 > 900) {
      for (int i = 0; i < birdCount; i++) {
        // Update bird positions
        birdX[i] -= birdSpeed;

        // If bird goes off screen, teleport them back to the start
        if (birdX[i] < 0) {
        birdX[i] = 1200;
        birdY[i] = random(200);
        }

        // Draw birds
        imgBird.resize(80, 50);
        image(imgBird, birdX[i], birdY[i]);
      }
    }
  }


  public void movementMethod() {
    // Make Character move left and right 
    if (leftPressed == true) {
      jumping_X1 -= 2;
    }
    if (rightPressed == true) {
      jumping_X1 += 2;
    }
    
    // Allow jumping when pressing BACKSPACE key.
    if (!hasJumped && jumpPressed) {
      ySpeed1 = -12;  // Set jump height
      hasJumped = true;  // Set boolean to true to prevent character from jumping again
    }

    // Update character position for jump
    jumping_Y1 += ySpeed1;
    ySpeed1 += gravity1;

    // Stop jumping motion when player hits ground, allow them to jump again
    if (jumping_Y1 >= imgDadSmall_Y1) {
      jumping_Y1 = imgDadSmall_Y1;  
      ySpeed1 = 0;  // Stop the vertical motion
      hasJumped = false;
    }
  }

  public void level2(){

    background(3, 248, 252);

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

          dadY = -69420;
  
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
              if(dist(dadX1, dadX2, lamboX[i], lamboY[i]) < 80 && !lamboCrash){
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
              if(dist(dadX1, dadX2, tankX[i], tankY[i]) < 120 && !tankCrash){
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
                    dadY3 -=3;
                  }
                  else if(key == 's'){
                    dadY3 += 3;
                  }
                  else if(key == 'a'){
                    dadX3 -= 3;
                  }
                  else if(key == 'd'){
                    dadX3 += 3;
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
                  text("Press Ctrl to move on LOL...", 400, 580);
        
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
                  text("Press Ctrl to continue!!", 450, 210);
        
                  // ADD CODE TO RUN LEVEL 6 METHOD
              }

    
              public void level4() {
                // Player will not be able to move left in this level
                leftPressed = false;
                
                // Draw background and Dad
                image(imgLevel4Background, 0, 0);
                imgWalkieTalkie.resize(100,100);
                image(imgWalkieTalkie, 1100, 600);
                image(imgNuke, nukeX, nukeY);
            
                imgDadMedium.resize(100, 80);
                image(imgDadMedium, (float)jumping_X2, (float)jumping_Y2);
                
                // Load in movement
                movementMethod2();
            
                // Border restriction to prevent player from moving out of level
                if (jumping_X2 > 1100) {
                  shiftPressed = false;
                  jumping_X2 -= 4;
                }
                if (jumping_Y2 < 430) {
                  jumping_Y2 = imgDadMedium_Y2;
                }
            
                // Display level instructions
                fill(0);
                textSize(40);
                textAlign(CENTER, CENTER);
                text("HINT: CLICK & HOLD MOUSE", width / 2, 50);
                text("OVER THE SIGN WHILE NEAR SIGN", width / 2, 100);
                text("DEFEAT JOE HAM USING THE DEVICE", width / 2, 150);
                text("REACH THE DEVICE AND PUT MOUSE CURSOR OVER IT", width/ 2, 200);
            
                // Detect is mouse is hovering over sign
                if (mouseX > signX && mouseX < signX + signWidth &&
                  mouseY > signY && mouseY < signY + signHeight) {
                  mouseOverSign = true;
                } 
                else {
                  mouseOverSign = false;
                }
            
                // Display sign contents if mouse is clicking sign
                if(mouseOverSign == true && mousePressed) {
                  image(imgSignRead, 150, 100);
                }
                
                // Draw eyeballs when the player is actively moving
                if (rightPressed || leftPressed || jumpPressed == true) {
                  for (int i = 0; i < eyeballCount; i++) {
                    imgEyeballs.resize(70,70);
                    image(imgEyeballs, eyeballX[i], eyeballY);
                  }
                }
            
                // Boolean that will trigger the code underneath it
                boolean joeHamAppeared = false;
            
                // Draw Joe Ham Enemy and set joeHamAppeared after 10 second delay using millis() timer.
                if (!joeHamAppeared && millis() - startTime >= duration) {
                    imgJoeHamHappy.resize(200,200);
                    image(imgJoeHamHappy, 0, 500);
                    imgShotgun.resize(100,60);
                    image(imgShotgun, 150, 610);
            
                    joeHamAppeared = true;
                    
                }
                
                // When boolean joeHamAppeeared is true, draw his guns and allow bullets to move, and activate collision detection
                if (joeHamAppeared) {
            
                  for (int i = 0; i < bullet_count; i++) {
                    // Draw bullet
                    
                      fill(255, 255, 255);
                      ellipse(bulletX[i], bulletY, 15, 15);
                    
                      
                    // Update bullet position
                    bulletX[i] += bulletSpeed[i];
            
                    if (bulletX[i] > width) {
                      bulletX[i] = 260;
                    }
            
                    // Detect if bullets hit player
                    float distanceShot = dist(bulletX[i], bulletY, jumping_X2, jumping_Y2);
                    if (distanceShot < playerRadius - 9) { 
                      // Collision detected, reduce lives
                      numLives--;
                      // Reset bullet position after it hits player
                      bulletX[i] = 260;
                    }
            
                    // When player's lives are gone, reset their positions and reset variables back to original. Call movement method to allow movement again.
                    if (numLives <= 0) {
                      hasJumped2 = false;
                      numLives = 5;
                      jumping_X2 = imgDadMedium_X2;
                      jumping_Y2 = imgDadMedium_Y2;
                      movementMethod2();
                      nukeY = -500;
                    }
                  }
            
                  // When player is near the walkie talkie device and their cursor is hovering over it, lower the nuke so that it "falls" onto the enemy.
                  if (jumping_X2 > 1050) {
                    if (mouseX > 1100 && mouseY > 600) {
                      if (numLives > 0) {
                        nukeY +=15;
                      } 
                    } 
                  }
                }
              }
            
              
              public void movementMethod2() {
                // Make Character move left and right 
                if (leftPressed == true) {
                  jumping_X2 -= 3;
                }
                if (rightPressed == true) {
                  jumping_X2 += 3;
                }
              
                if (!hasJumped2 && jumpPressed) {
                  ySpeed2 = -12;  // Set jump height
                  hasJumped2 = true;  // Set boolean to true to prevent character from jumping again
                }
            
                // Update character position for jump
                jumping_Y2 += ySpeed2;
                ySpeed2 += gravity2;
            
                // Stop jumping motion when player hits ground, allow them to jump again
                if (jumping_Y2 >= imgDadMedium_Y2) {
                  jumping_Y2 = imgDadMedium_Y2;  
                  ySpeed2 = 0;  // Stop the vertical motion
                  hasJumped2 = false;
                }
            
                // Allow sprinting when holding shift while moving
                if (rightPressed == true && shiftPressed == true) {
                  jumping_X2 = jumping_X2 + 4;
                }
              }
            
            
              public void cutscene4() {
                // After beating the game, make player (almost) invincible so that level 4 does not reset.
                numLives = 690000;
            
                // Draw background
                imgNukeBackground.resize(1200,700);
                image(imgNukeBackground, 0, 0);
            
                // Print congratulations message
                fill(0, 34, 255);
                textSize(50);
                textAlign(CENTER, CENTER);
                text("CONGRATULATIONS", width / 2, 200);
                text("YOU CALLED AN AIRSTRIKE", width / 2, 280);
                text("TO DEFEAT THE EVIL JOE HAM", width / 2, 360);
                text("AND YOU RETURNED HOME", width / 2, 440);
                text("WITH FRESH PORK FOR DINNER", width / 2, 520);
              }  




}   