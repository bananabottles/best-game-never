/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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
import javafx.util.Duration;

/**
 *
 * @author Bax
 */
public class Interface extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lunar Centrism");
        
        StackPane root = new StackPane();
        root.setId("pane");
        
        Scene scene = new Scene(root, 720, 480);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        
        Canvas canvas = new Canvas(720,480);
        root.getChildren().add(canvas);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        gc.setFill(Color.WHITE);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(0.5);
        Font dialogueFont = Font.font( "Times New Roman", 20);
        gc.setFont(dialogueFont);
        
        Image dialogue = new Image("dialogue.png");
        Image adam = new Image("adam.png");
        Image cmenu = new Image("cmenu.png");
        Image harambesmall = new Image("harambesmall.png");
        Image adamsmall = new Image("adamsmall.png");
        Image health = new Image("health.png");
        Image direction = new Image("direction.png");
        Image livsmall = new Image("livsmall.png");
        Image copsmall = new Image("copsmall.png");
        Image liv = new Image("liv.png");
        
        gc.drawImage(direction, 0, 360);
        gc.drawImage(dialogue, 240, 360);
        gc.fillText("You have entered the Forest.", 245, 380);
        gc.strokeText("You have entered the Forest.", 245, 380);
        
        VBox combatMenu = new VBox(4);
        combatMenu.setPadding(new Insets(355, 0, 0, 575));
        Button attackBtn = new Button("Attack");
        Button defendBtn = new Button("Defend");
        Button healBtn = new Button("Heal");
        Button runBtn = new Button("Run");
        combatMenu.getChildren().addAll(attackBtn, defendBtn, healBtn, runBtn);
        root.getChildren().add(combatMenu);
        combatMenu.setVisible(false);
        combatMenu.setManaged(false);
        
        HBox hbWestEast = new HBox(70);
        hbWestEast.setPadding(new Insets(0, 0, 0, -47));
        Button westBtn = new Button("W");
        Button eastBtn = new Button("E");
        hbWestEast.getChildren().addAll(westBtn, eastBtn);
        root.getChildren().add(hbWestEast);
        
        VBox vbNorthSouth = new VBox(12);
        vbNorthSouth.setPadding(new Insets(368, 0, 0, 73));
        Button northBtn = new Button("N");
        Button southBtn = new Button("S");
        vbNorthSouth.getChildren().addAll(northBtn, hbWestEast, southBtn);
        root.getChildren().add(vbNorthSouth);
        
        northBtn.setMaxWidth(30);
        northBtn.setMaxHeight(30);
        northBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PauseTransition pause1 = new PauseTransition(Duration.seconds(0));
                pause1.setOnFinished(pauseEvent -> {
                    scene.getStylesheets().addAll(this.getClass().getResource("style2.css").toExternalForm());
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
                    gc.drawImage(adam, 5, 280);
                    gc.drawImage(cmenu, 570, 350);
                    gc.drawImage(copsmall, 640, 0);
                    gc.drawImage(adamsmall, 5, -15);
                    gc.drawImage(health, 80, 5);
                    gc.drawImage(health, 390, 5);
                    gc.fillText("The cop is attempting to arrest you.", 170, 375);
                    gc.strokeText("The cop is attempting to arrest you.", 170, 375);
                });
                pause3.play();
            
                hbWestEast.setVisible(false);
                hbWestEast.setManaged(false);
                vbNorthSouth.setVisible(false);
                vbNorthSouth.setManaged(false);
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
        
        eastBtn.setMaxWidth(30);
        eastBtn.setMinWidth(30);
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
        
        southBtn.setMaxWidth(30);
        southBtn.setMaxHeight(30);
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

        westBtn.setMaxWidth(30);
        westBtn.setMaxHeight(30);
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
        
        attackBtn.setMaxWidth(120);
        attackBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gc.clearRect(0,0,720,480);
                gc.drawImage(dialogue, 160, 350);
                gc.drawImage(adam, 5, 280);
                gc.drawImage(cmenu, 570, 350);
                gc.drawImage(copsmall, 640, 0);
                gc.drawImage(adamsmall, 5, -15);
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
                    vbNorthSouth.setVisible(true);
                    vbNorthSouth.setManaged(true);
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
        
        defendBtn.setMaxWidth(120);
        defendBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gc.clearRect(0,0,720,480);
                gc.drawImage(dialogue, 160, 350);
                gc.drawImage(adam, 5, 280);
                gc.drawImage(cmenu, 570, 350);
                gc.drawImage(copsmall, 640, 0);
                gc.drawImage(adamsmall, 5, -15);
                gc.drawImage(health, 80, 5);
                gc.drawImage(health, 390, 5);
                gc.fillText("You take a defensive stance.", 170, 375);
                gc.strokeText("You take a defensive stance.", 170, 375);
            }
        });
        
        healBtn.setMaxWidth(120);
        healBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gc.clearRect(0,0,720,480);
                gc.drawImage(dialogue, 160, 350);
                gc.drawImage(adam, 5, 280);
                gc.drawImage(cmenu, 570, 350);
                gc.drawImage(copsmall, 640, 0);
                gc.drawImage(adamsmall, 5, -15);
                gc.drawImage(health, 80, 5);
                gc.drawImage(health, 390, 5);
                gc.fillText("You heal for 4 HP.", 170, 375);
                gc.strokeText("You heal for 4 HP.", 170, 375);
            }
        });
        
        runBtn.setMaxWidth(120);
        runBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gc.clearRect(0,0,720,480);
                gc.drawImage(dialogue, 160, 350);
                gc.drawImage(adam, 5, 280);
                gc.drawImage(cmenu, 570, 350);
                gc.drawImage(copsmall, 640, 0);
                gc.drawImage(adamsmall, 5, -15);
                gc.drawImage(health, 80, 5);
                gc.drawImage(health, 390, 5);
                gc.fillText("You try to run.", 170, 375);
                gc.strokeText("You try to run.", 170, 375);
                gc.fillText("The cop easily catches you.", 170, 400);
                gc.strokeText("The cop easily catches you.", 170, 400);
            }
        });
        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
