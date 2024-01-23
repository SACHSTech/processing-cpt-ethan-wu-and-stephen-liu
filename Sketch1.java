import processing.core.PApplet;
import processing.core.PImage;
 
public class Sketch1 extends PApplet {
  
  /**
  * Description
  * A program that contains several platformer-style levels, each having different objectives listed in the levels.
  * @author: E. Wu
  */

  // Variables for the player's character, used throughout game
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
        bulletSpeed[i] = random(5, 8);
      }  
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

    // Collision Detection: If the player chooses the Right route on the pathway in cutscene 2, call the level2 method.
    if (imgDadMedium_X1 >= 601 && imgDadMedium_Y1 <= 0) {
      level2();
    }
    
    // When the player reaches the door in level 2, call level 4 method.
    if (jumping_X1 > 1100 && !isDead) {
      level4();
    }

    // If the player successfully calls an airstrike in level 4, call cutscene 4.
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
    
    // Next level boolean
    if (keyCode == ENTER) {
      enterPressed = true;
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

    // Next level boolean
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

  public void level2() {
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
            nukeY +=10;
          } 
        } 
      }
    }
  }

  
  public void movementMethod2() {
    // Make Character move left and right 
    if (leftPressed == true) {
      jumping_X2 -= 2;
    }
    if (rightPressed == true) {
      jumping_X2 += 2;
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

