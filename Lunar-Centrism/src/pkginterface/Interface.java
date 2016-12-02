/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

import javafx.application.Application;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author Bax
 */
public class Interface extends Application {
    // \\\u25BC
    
    @Override
    public void start(Stage primaryStage) {                    // default method for creating a window
        primaryStage.setTitle("Lunar Centrism");                // sets title of window
        primaryStage.setResizable(false);                       // window cannot be maximized or resized
        
        Pane root = new Pane();                                 // creates an empty Pane named root
        root.setId("pane");                                     // sets the ID of the pane so it can be stylized via css
        
        Scene scene = new Scene(root, 720, 480);                // creates a scene inside Pane, setting its dimensions to 720x480
        primaryStage.setScene(scene);                           // adds scene to Stage
        
        Canvas canvas = new Canvas(720, 480);                   // creayes canvas for drawing upon inside Pane
        canvas.setLayoutX(5);
        canvas.setLayoutY(5);
        root.getChildren().add(canvas);                         // adds canvas to Scene
        
        GraphicsContext gc = canvas.getGraphicsContext2D();     // imported GraphicsContext class allows for drawing on the canvas
        
        // loading images and naming them
        Image dialogue = new Image("/pkginterface/resources/dialogue.png");
        Image cmenu = new Image("/pkginterface/resources/cmenu.png");
        Image health = new Image("/pkginterface/resources/health.png");
        Image direction = new Image("/pkginterface/resources/direction.png");
        Image adam = new Image("/pkginterface/resources/adam170x200.png");
        Image adamsmall = new Image("/pkginterface/resources/adam70x100.png");
        Image liv = new Image("/pkginterface/resources/liv170x200.png");
        Image livsmall = new Image("/pkginterface/resources/liv70x100.png");
        Image john = new Image("/pkginterface/resources/john170x200.png");
        Image johnsmall = new Image("/pkginterface/resources/john75x100.png");
        Image copsmall = new Image("/pkginterface/resources/cop70x100.png");
        
        // uses imported class VBox to create a combat menu with 3 buttons on top of one another
        VBox combatMenu = new VBox(4);
        combatMenu.setPadding(new Insets(361, 0, 0, 580));
        Button attackBtn = new Button("Attack");
        Button defendBtn = new Button("Defend");
        Button healBtn = new Button("Heal");
        Button runBtn = new Button("Run");
        combatMenu.getChildren().addAll(attackBtn, healBtn, runBtn);
        root.getChildren().add(combatMenu);
        combatMenu.setVisible(false);
        combatMenu.setManaged(false);
        
        // uses imported classes VBox and HBox to create 4 buttons placed in a compass-esque position on the canvas
        HBox hbWestEast = new HBox(70);
        hbWestEast.setPadding(new Insets(0, 0, 0, -47));
        Button westBtn = new Button("W");
        Button eastBtn = new Button("E");
        hbWestEast.getChildren().addAll(westBtn, eastBtn);
        root.getChildren().add(hbWestEast);
        VBox vbNSWE = new VBox(12);
        vbNSWE.setPadding(new Insets(365, 0, 0, 635));
        Button northBtn = new Button("N");
        Button southBtn = new Button("S");
        vbNSWE.getChildren().addAll(northBtn, hbWestEast, southBtn);
        root.getChildren().add(vbNSWE);
        vbNSWE.setVisible(false);
        vbNSWE.setManaged(false);
        
        // setting title screen background
        scene.getStylesheets().add("pkginterface/resources/title.css");     // attaches a background, details in /Lunar Centrism/src/pkginterface/resources/title.css
        
        // setting title screen text
        gc.setFill(Color.WHITE);
        gc.setStroke(Color.DARKGREY);
        gc.setLineWidth(2);
        Font titleFont = Font.font("Courier", FontPosture.ITALIC, 15);
        gc.setFont(titleFont);
        
        // displaying title screen text
        gc.fillText("Click anywhere to start game", 260, 400);
        gc.strokeText("Click anywhere to start game", 260, 400);
        
        // setting dialogue line width, font, and font size
        gc.setFill(Color.WHITE);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(0.5);
        Font dialogueFont = Font.font("Times New Roman", 20);
        gc.setFont(dialogueFont);
        
        // creates the invisible dialogue button, stylizes it (to be invisible), then sets its width and height in pixels
        Button dButton = new Button();
        dButton.setId("dButton");
        dButton.getStylesheets().add("pkginterface/resources/dButton.css");
        dButton.setLayoutX(175);
        dButton.setLayoutY(355);
        root.getChildren().add(dButton);
        dButton.setMinWidth(400);
        dButton.setMinHeight(120);
        dButton.setVisible(false);
        dButton.setManaged(false);
        
        dButton.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
                gc.clearRect(175, 355, 400, 120);
                gc.drawImage(dialogue, 175, 355);
                gc.fillText("John eats, sleeps, and does everything else here.", 180, 375);
                gc.strokeText("John eats, sleeps, and does everything else here.", 180, 375);
           }
        });
        
        // creates the invisible title screen button, stylizes it (to be invisible), then sets its width and height in pixels
        Button title = new Button();
        title.setId("titlebutton");
        title.getStylesheets().add("pkginterface/resources/titlebutton.css");
        title.setLayoutX(5);
        title.setLayoutY(5);
        root.getChildren().add(title);
        title.setMinWidth(720);
        title.setMinHeight(480);
        
        // how the title button performs when clicked
        title.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gc.clearRect(0, 0, 720, 480);
                gc.drawImage(dialogue, 175, 355);
                gc.drawImage(john, 0, 280);
                gc.fillText("You are in John's room.", 180, 375);
                gc.strokeText("You are in John's room.", 180, 375);
                scene.getStylesheets().add("pkginterface/resources/johnroom.css");
                
                dButton.setVisible(true);
                dButton.setManaged(true);
                title.setVisible(false);
                title.setManaged(false);
                vbNSWE.setVisible(true);
                vbNSWE.setManaged(true);
        }
    });
        
        // the north button's width and height in pixels
        northBtn.setMaxWidth(30);
        northBtn.setMaxHeight(30);
        
        // how the north button performs when clicked
        northBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PauseTransition pause1 = new PauseTransition(Duration.seconds(0));
                pause1.setOnFinished(pauseEvent -> {
                    gc.clearRect(0, 0, 720, 480);
                    gc.drawImage(direction, 0, 360);
                    gc.drawImage(dialogue, 240, 360);
                    gc.fillText("Encounter!", 20, 400);
                    gc.strokeText("Encounter!", 45, 425);
                    gc.fillText("You have entered the desert.", 245, 380);
                    gc.strokeText("You have entered the desrt.", 245, 380);
                });
                pause1.play();
                
                PauseTransition pause2 = new PauseTransition(Duration.seconds(2));
                pause2.setOnFinished(pauseEvent -> {
                    gc.clearRect(0, 0, 720, 480);
                    gc.drawImage(direction, 0, 360);
                    gc.drawImage(dialogue, 240, 360);
                    gc.fillText("Encounter!", 20, 400);
                    gc.strokeText("Encounter!", 45, 425);
                    gc.fillText("A cop has caught you!", 245, 380);
                    gc.strokeText("A cop has caught you!", 245, 380);
                });
                pause2.play();
                
                PauseTransition pause3 = new PauseTransition(Duration.seconds(5));
                pause3.setOnFinished(pauseEvent -> {
                    gc.clearRect(0,0,720,480);
                    combatMenu.setVisible(true);
                    combatMenu.setManaged(true);
                    gc.drawImage(dialogue, 160, 350);
                    gc.drawImage(adam, -5, 280);
                    gc.drawImage(cmenu, 570, 350);
                    gc.drawImage(copsmall, 650, 0);
                    gc.drawImage(adamsmall, 0, 0);
                    gc.drawImage(health, 80, 5);
                    gc.drawImage(health, 390, 5);
                    gc.fillText("The cop is attempting to arrest you.", 170, 375);
                    gc.strokeText("The cop is attempting to arrest you.", 170, 375);
                });
                pause3.play();
            
                hbWestEast.setVisible(false);
                hbWestEast.setManaged(false);
                vbNSWE.setVisible(false);
                vbNSWE.setManaged(false);
                northBtn.setVisible(false);
                northBtn.setManaged(false);
                eastBtn.setVisible(false);
                eastBtn.setManaged(false);
                southBtn.setVisible(false);
                southBtn.setManaged(false);
                westBtn.setVisible(false);
                westBtn.setManaged(false);
            }
        });
        
        // the east button's width and height in pixels
        eastBtn.setMaxWidth(30);
        eastBtn.setMinWidth(30);
        
        // how the east button performs when clicked
        eastBtn.setMaxHeight(30);
        eastBtn.setMinHeight(30);
        eastBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gc.clearRect(0, 0, 720, 480);
                gc.drawImage(direction, 0, 360);
                gc.drawImage(dialogue, 240, 360);
                gc.fillText("The path is blocked.", 245, 380);
                gc.strokeText("The path is blocked.", 245, 380);
            }
        });
        
        // the south button's width and height in pixels
        southBtn.setMaxWidth(30);
        southBtn.setMaxHeight(30);
        
        // how the south button performs when clicked
        southBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gc.clearRect(0, 0, 720, 480);
                gc.drawImage(direction, 0, 360);
                gc.drawImage(dialogue, 240, 360);
                gc.fillText("The path is blocked.", 245, 380);
                gc.strokeText("The path is blocked.", 245, 380);
            }
        });

        // the west button's width and height in pixels
        westBtn.setMaxWidth(30);
        westBtn.setMaxHeight(30);
        
        // how the west button performs when clicked
        westBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gc.clearRect(0, 0, 720, 480);
                gc.drawImage(direction, 0, 360);
                gc.drawImage(dialogue, 240, 360);
                gc.fillText("The path is blocked.", 245, 380);
                gc.strokeText("The path is blocked.", 245, 380);
            }
        });
        
        // the attack button's width and height in pixels
        attackBtn.setMaxWidth(120);
        attackBtn.setMinHeight(33);
        
        // how the attack button performs when clicked
        attackBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gc.clearRect(0,0,720,480);
                gc.drawImage(dialogue, 160, 350);
                gc.drawImage(adam, -5, 280);
                gc.drawImage(cmenu, 570, 350);
                gc.drawImage(copsmall, 650, 0);
                gc.drawImage(adamsmall, 0, 0);
                gc.drawImage(health, 80, 5);
                gc.drawImage(health, 390, 5);
                gc.fillText("You punch the cop for 7 damage.", 170, 375);
                gc.strokeText("You punch the cop for 7 damage.", 170, 375);
                gc.clearRect(398, 16, 234, 21);
                
                PauseTransition pause4 = new PauseTransition(Duration.seconds(1));
                pause4.setOnFinished(pauseEvent -> {
                    gc.clearRect(0,0,720,480);
                    gc.drawImage(direction, 0, 360);
                    gc.drawImage(dialogue, 240, 360);
                    gc.fillText("The cop is unconscious, you have escaped!", 245, 380);
                    gc.strokeText("The cop is unconscious, you have escaped!", 245, 380);
                    gc.fillText("Choose a direction to run.", 245, 400);
                    gc.strokeText("Choose a direction to run.", 245, 400);
                    gc.clearRect(398, 16, 234, 21);
                    combatMenu.setVisible(false);
                    combatMenu.setManaged(false);
                    hbWestEast.setVisible(true);
                    hbWestEast.setManaged(true);
                    vbNSWE.setVisible(true);
                    vbNSWE.setManaged(true);
                    northBtn.setVisible(true);
                    northBtn.setManaged(true);
                    eastBtn.setVisible(true);
                    eastBtn.setManaged(true);
                    southBtn.setVisible(true);
                    southBtn.setManaged(true);
                    westBtn.setVisible(true);
                    westBtn.setManaged(true);
                });
                pause4.play();
            }
        });
        
        // the heal button's width and height in pixels
        healBtn.setMaxWidth(120);
        healBtn.setMinHeight(33);
        
        // how the heal button performs when clicked
        healBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gc.clearRect(0,0,720,480);
                gc.drawImage(dialogue, 160, 350);
                gc.drawImage(adam, -5, 280);
                gc.drawImage(cmenu, 570, 350);
                gc.drawImage(copsmall, 650, 0);
                gc.drawImage(adamsmall, 0, 0);
                gc.drawImage(health, 80, 5);
                gc.drawImage(health, 390, 5);
                gc.fillText("You heal for 4 HP.", 170, 375);
                gc.strokeText("You heal for 4 HP.", 170, 375);
            }
        });
        
        // the run button's width and height in pixels
        runBtn.setMaxWidth(120);
        runBtn.setMinHeight(33);
        
        // how the run button performs when clicked
        runBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gc.clearRect(0,0,720,480);
                gc.drawImage(dialogue, 160, 350);
                gc.drawImage(adam, -5, 280);
                gc.drawImage(cmenu, 570, 350);
                gc.drawImage(copsmall, 650, 0);
                gc.drawImage(adamsmall, 0, 0);
                gc.drawImage(health, 80, 5);
                gc.drawImage(health, 390, 5);
                gc.fillText("You try to run.", 170, 375);
                gc.strokeText("You try to run.", 170, 375);
                gc.fillText("The cop easily catches you.", 170, 400);
                gc.strokeText("The cop easily catches you.", 170, 400);
            }
        });
        
        primaryStage.show();            // makes window and elements within visible
    }

    /**
     * @param args the command line arguments
     */
    //public static void main(String[] args) {
    //    launch(args);
    //}
    
}
