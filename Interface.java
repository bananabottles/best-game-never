/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

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
        
        gc.drawImage(direction, 0, 360);
        
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
                gc.clearRect(0,0,720,480);
                gc.drawImage(dialogue, 160, 350);
                gc.drawImage(adam, 5, 280);
                gc.drawImage(cmenu, 570, 350);
                gc.drawImage(harambesmall, 640, 0);
                gc.drawImage(adamsmall, 5, 0);
                gc.drawImage(health, 80, 5);
                gc.drawImage(health, 390, 5);
                gc.fillText("Harambe is glaring at you threateningly.", 170, 375);
                gc.strokeText("Harambe is glaring at you threateningly.", 170, 375);
                
                combatMenu.setVisible(true);
                combatMenu.setManaged(true);
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
                System.out.println("Not yet implemented.");
            }
        });
        
        southBtn.setMaxWidth(30);
        southBtn.setMaxHeight(30);
        southBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Not yet implemented.");
            }
        });

        westBtn.setMaxWidth(30);
        westBtn.setMaxHeight(30);
        westBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Not yet implemented.");
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
                gc.drawImage(harambesmall, 640, 0);
                gc.drawImage(adamsmall, 5, 0);
                gc.drawImage(health, 80, 5);
                gc.drawImage(health, 390, 5);
                gc.fillText("You snipe Harambe for 1 damage.", 170, 375);
                gc.strokeText("You snipe Harambe for 1 damage.", 170, 375);
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
                gc.drawImage(harambesmall, 640, 0);
                gc.drawImage(adamsmall, 5, 0);
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
                gc.drawImage(harambesmall, 640, 0);
                gc.drawImage(adamsmall, 5, 0);
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
                gc.drawImage(harambesmall, 640, 0);
                gc.drawImage(adamsmall, 5, 0);
                gc.drawImage(health, 80, 5);
                gc.drawImage(health, 390, 5);
                gc.fillText("You try to run.", 170, 375);
                gc.strokeText("You try to run.", 170, 375);
                gc.fillText("Harambe easily catches you.", 170, 400);
                gc.strokeText("Harambe easily catches you.", 170, 400);
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
