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

  int imgDadSmall_X1 = 0;
  int imgDadSmall_Y1 = 560;

  int startTime1;
  int duration1 = 5000;

  // Directional movement variables
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;
  
  // Jumping Variables
  boolean jumpPressed = false;
  int jumpHeight1 = -10;
  int gravity1 = 1;
  int vertSpeed1 = 0;

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
    
  }

  public void setup() {
    background(210, 255, 173);

    // Level 2 setup
    startTime1 = millis();
  }

  public void draw() {
    // Reset background to provide clean animation
    //background(210, 255, 173);

    // Call cutscene1 Method
    //cutscene1();
    
    // Call cutscene2 Method
    //cutscene2();

    // Collision Detection: If the player chooses the Left route on the pathway, call cutscene3 method.
    //if (imgDadMedium_X1 <= 600 && imgDadMedium_Y1 <= 0 && frameCount >= 720) {
      //cutscene3();
    //}

    //if (imgDadMedium_X1 >= 601 && imgDadMedium_Y1 <= 0 && frameCount >= 720) {
      level2();
    //}
  }
 
  // keybinds: if you press these keys, it will move the character
  public void keyPressed() {
    // Keybinds for up/down/left/right movement
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
    // Keybind for jumping
    if (keyCode == BACKSPACE) {
      jumpPressed = true;
    }

  }

  public void keyReleased() {
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
      text("L key for Left, R Key for Right, where to go???", text_X2, text_Y2);
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
    // Draw background and Dad character
    image(imgLevel2Background, 0, 0);
    image(imgDadSmall, imgDadSmall_X1, imgDadSmall_Y1);

    int elapsedTime1 = millis() - startTime1;
    if (elapsedTime1 < duration1) {
      fill(0);
      textSize(50);
      textAlign(CENTER, CENTER);
      text("Press backspace To jump and l/r to move :)", width/2, 350);

      // Set movement booleans to false to prevent player from moving during the text
      leftPressed = false;
      rightPressed = false;
    }

    // Make Character move left and right 
    if (leftPressed == true) {
      imgDadSmall_X1 -= 2;
    }

    if (rightPressed == true) {
      imgDadSmall_X1 += 2;
    }

    vertSpeed1 += gravity1;
    imgDadSmall_Y1 += vertSpeed1;

    if (imgDadSmall_Y1 > 560) {
      imgDadSmall_Y1 = 560;
      vertSpeed1 = 0;
    }

    if (keyCode == BACKSPACE && imgDadSmall_Y1 == 560) {
      vertSpeed1 = jumpHeight1;
    }

  }

}

