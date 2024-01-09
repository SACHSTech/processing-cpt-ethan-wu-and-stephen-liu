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
  PImage imgUgandanKnuckles;
  
  PImage imgHouse;
  PImage imgDoor;
  PImage imgPathway;
  PImage imgDaWey;
  PImage imgMutahar;

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
  int text_X3 = 1000;
  int text_Y3 = 400;

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
    imgUgandanKnuckles = loadImage("Ugandan Knuckles.jpg");

    imgHouse = loadImage("Family House.jpeg");
    imgDoor = loadImage("Door.png");
    imgPathway = loadImage("Game Pathway.png");
    imgDaWey = loadImage("Game Da Wey.png");
    imgMutahar = loadImage("Mutahar Laugh.jpg");
  }

  public void setup() {
    background(210, 255, 173);
  }

  public void draw() {
    // Reset background to provide clean animation
    background(210, 255, 173);

    // Call cutscene1 Method
    cutscene1();
    
    // Call cutscene2 Method
    cutscene2();

    // Collision Detection: If the player chooses the Left route on the pathway, call cutscene3 method.
    if (imgDadMedium_X <= 400 && imgDadMedium_Y <= 0 && frameCount >= 720) {
      cutscene3();
    }
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
      image(imgDadMedium, imgDadMedium_X, imgDadMedium_Y);
    }
  
    // Adds a text box that gives a player directions on what to do
    if (frameCount >= 660) {
      fill(255, 25, 152);
      rect(175, 630, 850, 50);
      
      fill(0);
      textSize(30);
      text("which path should I take? Hint: press Left/Right arrow Keys", text_X2, text_Y2);
    }

    // If user presses LEFT arrow key, the character will move along the left path.  
    // Collision detection is added in the draw method to see which path the character takes.
    if (frameCount >= 660) {
      if (keyCode == LEFT) {
        imgDadMedium_X -= 5;
        imgDadMedium_Y -= 5;
      }
    }
    
    // If user presses RIGHT arrow key, the character will move along the right path.
    if (frameCount >= 660) {
      if (keyCode == RIGHT) {
        imgDadMedium_X += 5;
        imgDadMedium_Y -= 5;
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

}

