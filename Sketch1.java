import processing.core.PApplet;
import processing.core.PImage;
 
public class Sketch1 extends PApplet {
  // Establish variables that will be used throughout game
  PImage imgDad;
  PImage imgDadMad;
  PImage imgDadDead;
  PImage imgDadSmall;
  PImage imgDadMedium;
  PImage imgDadMadSmall;

  // Directional movement variables
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;
  boolean jumpPressed = false;
  

  // Next level boolean
  boolean enterPressed = false;
  
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

  // Level 2 variables
  PImage imgLevel2Background;
  PImage imgTrampoline;
  PImage imgSpikes;
  PImage imgBuilding1;
  PImage imgBuilding2;
  PImage imgBird;
  PImage imgEmoji;

  double imgDadSmall_X1 = 0;
  double imgDadSmall_Y1 = 560;
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

  int startTime1;
  int startTime2;
  int duration1 = 7000;
  int duration2 = 5000;

  boolean isDead;

  // Level 4 Variables
  PImage imgLevel4Background;
  PImage imgHELP;
  PImage imgRUN_NOW;
  PImage imgJoeHamHappy;
  PImage imgJoeHamScary;

    int imgDadMedium_X2 = 0;
    int imgDadMedium_Y2 = 600;
    int jumping_X2 = imgDadMedium_X2;
    int jumping_Y2 = imgDadMedium_Y2;
  
  


  public void settings() {
    size(1200, 700);
    // Dad Image Loading
    imgDad = loadImage("Dad Game Character.png");
    imgDadMad = loadImage("Dad Game Character Kishibe Rohan.png");
    imgDadDead = loadImage("Dad Game Character Dead Lying Down.png");
    imgDadSmall = loadImage("Dad Game Character Small.png");
    imgDadMedium = loadImage("Dad Game Character Medium.png");
    imgDadMadSmall = loadImage("Dad Game Character Kishibe Rohan Small.png");

    // Cutscene 1 Loading
    imgMom = loadImage("Mom Game Character.png");
    imgSon = loadImage("Son Game Character.png");
    imgDaughter = loadImage("Daughter Game Character.png");
    imgDoor = loadImage("Door.png");
    
    // Cutscene 2 Loading
    imgPathway = loadImage("Game Pathway.png");
    
    // Cutscene 3 Loading
    imgUgandanKnuckles = loadImage("Ugandan Knuckles.jpg");
    imgDaWey = loadImage("Game Da Wey.png");
    imgMutahar = loadImage("Mutahar Laugh.jpg");

    // Level 2 Loading
    imgLevel2Background = loadImage("Level 2 Background.png");
    imgTrampoline = loadImage("trampoline transparent.png");
    imgSpikes = loadImage("spikes transparent.png");
    imgBuilding1 = loadImage("building 1.png");
    imgBuilding2 = loadImage("building 2.png");
    imgBird = loadImage("da bird transparent.png");
    imgEmoji = loadImage("emoji disentegrating.png");
    
    // Level 4 Loading
    imgLevel4Background = loadImage("level 4 background.png");
    imgHELP = loadImage("HELP transparent.png");
    imgRUN_NOW = loadImage("RUN NOW transparent.png");
    imgJoeHamHappy = loadImage("Joe Ham Happy.jpeg");
    imgJoeHamScary = loadImage("Joe Ham Scary.jpeg");
  }

  public void setup() {
    background(210, 255, 173);

    // Level 2 setup
      // Timer setup
    startTime1 = millis();
    startTime2 = millis();
      
      // Bird arrays position setup
    for (int i = 0; i < birdCount; i++) {
      birdX[i] = random(width);
      birdY[i] = random(200);
    }


  }

  public void draw() {
    /* 

    // Reset background to provide clean animation
    background(210, 255, 173);

    // Call cutscene1 Method
    cutscene1();
    
    // Call cutscene2 Method
    cutscene2();

    // Collision Detection: If the player chooses the Left route on the pathway, call cutscene3 method.
    if (imgDadMedium_X1 <= 600 && imgDadMedium_Y1 <= 0 && frameCount >= 720) {
      cutscene3();
    }

    */

    //if (imgDadMedium_X1 >= 601 && imgDadMedium_Y1 <= 0 && frameCount >= 720) {
      level2();
    //}
    
    if (jumping_X1 > 1100 && enterPressed == true) {
      level4();
    }
    
    
  }

 
  // keybinds: if you press these keys, it will move the character
  public void keyPressed() {
    // Keybinds for movement
    if (key == 'u') {
      upPressed = true;
    }
    if (key == 'd') {
      downPressed = true;
    }
    if (key == 'l') {
      leftPressed = true;
    }
    if (key == 'r') {
      rightPressed = true;
    }
    if (keyCode == BACKSPACE) {
      jumpPressed = true;
    }
    
    // Next level boolean
    if (keyCode == ENTER) {
      enterPressed = true;
    } 

    
  }

  public void keyReleased() {
    // Movement stops when these keys are released
    if (key == 'u') {
      upPressed = false;
    }
    if (key == 'd') {
      downPressed = false;
    }
    if (key == 'l') {
      leftPressed = false;
    }
    if (key == 'r') {
      rightPressed = false;
    }
    if (keyCode == BACKSPACE) {
      jumpPressed = false;
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
    // Make the Dad move after 3 seconds from the start of the program
    if (frameCount >= 300) {
      imgDad_X1 += 5;
      text_X1 += 800;
    }

    // Wipe Screen to get to next scene
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
        text("woah what is this place?", text_X3, text_Y3);
      
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

            text("who the hell is u?", text_X3, text_Y3);

            // Redraw to refresh the scene.  Draw in Dad Dead image, and add new dialogue.
            if (frameCount >= 1540) {
              image(imgDaWey, 0, 0);
              imgDadDead.resize(150,150);
              image(imgUgandanKnuckles, 510, 400);
              image(imgDadDead, 1000, 500);
              text("ouch", text_X3, text_Y3);

              // Add death message screen, which wipes the screen and turns it white.
              if (frameCount >= 1660) {
                imgMutahar.resize(1200,700);
                image(imgMutahar, 0, 0);
                fill(255);
                textSize(50);
                textAlign(CENTER, CENTER);
                text("YOU DIED... WOMP WOMP", width / 2, 250);

                textSize(30);
                text("YOUR BRAIN SHUT DOWN BECAUSE", width/2, 400);
                text("YOU COULD NOT COMPREHEND WHAT YOU JUST SAW", width/2, 450);
                text("YOU DIED OF STROKE", width/2, 500);
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

    // Provide instructions to the player. Instructions will dissapear after 7 seconds.
    int elapsedTime1 = millis() - startTime1;
    if (elapsedTime1 < duration1) {
      fill(0);
      textSize(40);
      textAlign(CENTER, CENTER);
      text("Press backspace To jump and l/r to move :)", 400, 100);
      text("Jump on trampolines to get over building", 400, 150);
      text("Dont touch spike", 400, 200);

      // Set movement booleans to false to prevent player from moving during the instructions.
      leftPressed = false;
      rightPressed = false;
      hasJumped = true;
    }  

    // Border restriction to prevent player from moving out of the level
    if (jumping_X1 < 0) {
      jumping_X1 += 2;
    }
    if (jumping_X1 > (width - 50)) {
      jumping_X1 -= 2;
    }

    // Make Character move left and right 
    if (leftPressed == true) {
      jumping_X1 -= 2;
    }
    if (rightPressed == true) {
      jumping_X1 += 2;
    }
  
    if (!hasJumped && jumpPressed) {
      ySpeed1 = -12;  // Set jump height
      hasJumped = true;  // Set boolean to true to prevent character from jumping again
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

    // Update character position for jump
    jumping_Y1 += ySpeed1;
    ySpeed1 += gravity1;

    // Stop jumping motion when player hits ground, allow them to jump again
    if (jumping_Y1 >= imgDadSmall_Y1) {
      jumping_Y1 = imgDadSmall_Y1;  
      ySpeed1 = 0;  // Stop the vertical motion
      hasJumped = false;
    }

    // First Building Restrictions
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


    // When player touches spikes, set booleans to prevent them from moving and give them death scene.
    if (jumping_X1 > 40 && jumping_X1 < 110) {
      if (jumping_Y1 > 550) {
        // Prevent further movement and play death cutscene
        leftPressed = false;
        rightPressed = false;
        hasJumped = true;       
        deathScene();
      }
    }
    if (jumping_X1 > 360 && jumping_X1 < 430) {
      if (jumping_Y1 > 550) {
        leftPressed = false;
        rightPressed = false;
        hasJumped = true;       
        deathScene();
      }
    }
    if (jumping_X1 > 630 && jumping_X1 < 700) {
      if (jumping_Y1 > 550) {
        leftPressed = false;
        rightPressed = false;
        hasJumped = true;       
        deathScene();
      }
    }
    if (jumping_X1 > 740 && jumping_X1 < 810) {
      if (jumping_Y1 > 550) {
        leftPressed = false;
        rightPressed = false;
        hasJumped = true;       
        deathScene();
      }
    }
    if (jumping_X1 > 1010 && jumping_X1 < 1080) {
      if (jumping_Y1 > 550) {
        leftPressed = false;
        rightPressed = false;
        hasJumped = true;       
        deathScene();
      }
    }

    drawBirds();

    // Border restriction to set isDead boolean to character upon entering the border
    if (jumping_X1 > 800 && jumping_Y1 < 180) {
      isDead = true;
    }

    // When Dead
    if (isDead) {
      
        // Redraw everything
        level2Background();
        
        // Prevent jumping
        hasJumped = true;
        // Use opposite direction movement to cancel out movement, stopping the player
        if (leftPressed == true) {
          jumping_X1 += 2;
        }
        if (rightPressed == true) {
          jumping_X1 -= 2;
        }

        // Show dead picture
        
        imgDadDead.resize(50,50);
        image(imgDadDead, (float)jumping_X1, (float)jumping_Y1);

        fill(224, 79, 164);
        rect(200, 75, 800, 60);

        fill(0);
        textSize(40);
        textAlign(CENTER, CENTER);
        text("YOU GOT IMPALED BY A FLYING BIRD", width / 2, 100);

        // Laughing Pic
        imgMutahar.resize(300, 500);
        image(imgMutahar, 0, 200);
        // Emoji Pic
        image(imgEmoji, 600, 400);

      }
      
      // When player reaches door at the end, give them instructions to continue to the next level
       if(jumping_X1 > 1100) {
        fill(224, 79, 164);
        rect(200, 75, 800, 60);

        fill(0);
        textSize(40);
        textAlign(CENTER, CENTER);
        text("PRESS ALT TO ENTER", width / 2, 100);

      }

    }
    
  
  
  public void level2Background() {
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

  public void deathScene() {
    imgMutahar.resize(1200,700);
    image(imgMutahar, 0, 0);
    image(imgDadDead, 930, 380);
    image(imgDadDead, 930, 0);
    image(imgDadDead, 0, 380);
    image(imgDadDead, 0, 0);
    fill(255);
    textSize(50);
    textAlign(CENTER, CENTER);
    text("YOU DIED... WOMP WOMP", width / 2, 250);
    text("WE RECCOMMEND NOT DYING", width / 2, 300);
    text("NEXT TIME, DON'T DIE", width / 2, 350);
  }

  public void movementMethod() {
    // Make Character move left and right 
    if (leftPressed == true) {
      jumping_X1 -= 2;
    }
    if (rightPressed == true) {
      jumping_X1 += 2;
    }
  
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
    // Reset next level boolean
    enterPressed = false;
    
    // Draw background and Dad
    image(imgLevel4Background, 0, 0);
    imgDadMedium.resize(100, 80);
    image(imgDadMedium, (float)jumping_X2, (float)jumping_Y2);
    
    movementMethod2();
  }

  public void movementMethod2() {
    // Make Character move left and right 
    if (leftPressed == true) {
      jumping_X2 -= 2;
    }
    if (rightPressed == true) {
      jumping_X2 += 2;
    }
  
    if (!hasJumped && jumpPressed) {
      ySpeed1 = -12;  // Set jump height
      hasJumped = true;  // Set boolean to true to prevent character from jumping again
    }

    // Update character position for jump
    jumping_Y2 += ySpeed1;
    ySpeed1 += gravity1;

    // Stop jumping motion when player hits ground, allow them to jump again
    if (jumping_Y2 >= imgDadMedium_Y2) {
      jumping_Y1 = imgDadMedium_Y2;  
      ySpeed1 = 0;  // Stop the vertical motion
      hasJumped = false;
    }
  }

  public void testMethod() {
    background(233, 69, 12);
    image(imgEmoji, 69, 69);
  }

}

