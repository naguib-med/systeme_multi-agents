package fr.univlyon.tianegociation.controller;

import fr.univlyon.tianegociation.Jeu;
import fr.univlyon.tianegociation.model.Agent;
import fr.univlyon.tianegociation.model.Grille;
import fr.univlyon.tianegociation.model.Position;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static javafx.stage.WindowEvent.WINDOW_CLOSE_REQUEST;

public class StartViewController {
    @FXML private Button btnAdd;
    @FXML private Button btnTerminer;
    @FXML private VBox myVbox;
    @FXML private TextField inputNumber;

    private List<Agent> agents = new ArrayList<>();
    private int ids = 0;
    Grille currentConfig = new Grille();
    Grille finalConfig = new Grille();


    //Fonction de génération des agents
    void addAgent() {
        ids++;

        int iSrc = (int)(Math.random() * 5 + 1);
        int jSrc = (int)(Math.random() * 5 + 1);
        int iDest = (int)(Math.random() * 5 + 1);
        int jDest = (int)(Math.random() * 5 + 1);
        System.out.println(iSrc + "," + jSrc);
        System.out.println(iDest + "," + jDest);


        //Choix de la couleur de l'agent
        Random obj = new Random();
        int rand_num = obj.nextInt(0xffffff + 1);
        String color = String.format("#%06x", rand_num);


        //Pour éviter que les agents se placent à la même position au début et à la fin
        for(int i = 0; i < agents.size(); i++) {
            while(iSrc == agents.get(i).getPosCourante().getI() && jSrc == agents.get(i).getPosCourante().getJ()) {
                iSrc = (int)(Math.random() * 5 + 1);
                jSrc = (int)(Math.random() * 5 + 1);
            }
            while(iDest == agents.get(i).getPosFinale().getI() && jDest == agents.get(i).getPosFinale().getJ()) {
                iDest = (int)(Math.random() * 5 + 1);
                jDest = (int)(Math.random() * 5 + 1);
            }
        }

        Position pDepart = new Position(iSrc, jSrc);
        Position pArrive = new Position(iDest, jDest);

        Agent agent = new Agent(pDepart, pArrive, ids, color);

        agents.add(agent);

        currentConfig.setAgent(pDepart.getI(), pDepart.getJ(), ids);
        finalConfig.setAgent(pArrive.getI(), pArrive.getJ(), ids);

        /////// Ajout de l'agent a la list des agents sur l'ecran
        Label label = new Label("id = " + ids + " color "+ color + " position depart("+pDepart.getI()+","+pDepart.getJ()+") position finale("+pArrive.getI()+","+pArrive.getJ()+")");
        myVbox.getChildren().add(label);
    }

    //Génération des agents en aléatoire
    @FXML void addAgents(ActionEvent event) {
        int nombreAgent = Integer.parseInt(inputNumber.getText());
        System.out.println(nombreAgent);

        for(int i = 0; i < nombreAgent; i++) {
            addAgent();
        }
    }

    //Fonction losqu'on appuie sur le bouton "terminer"
    @FXML void handleTerminer(ActionEvent event) {
        try{

            Agent.setConfigCourante(currentConfig);
            Agent.setConfigFinale(finalConfig);

            FXMLLoader fxmlLoader = new FXMLLoader(Jeu.class.getResource("main-view.fxml"));
            Parent root = fxmlLoader.load();

            MainViewController mainViewController = fxmlLoader.getController();

            mainViewController.showRecap(agents);

            Stage stage = new Stage();
            stage.setTitle("recapitulatif de la generation des agents");
            stage.setScene(new Scene(root));
            stage.show();

            stage.setOnCloseRequest(e -> {
                EventType<WindowEvent> window = e.getEventType();
                if (window == WINDOW_CLOSE_REQUEST) {
                    /*
                    FXMLLoader fxmlLoader1 = new FXMLLoader(Jeu.class.getResource("start-view.fxml"));
                    Parent root1 = null;
                    try {
                        root1 = fxmlLoader1.load();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                    Stage stage1 = new Stage();
                    stage1.setTitle("creation des agents");
                    stage1.setScene(new Scene(root1));
                    stage1.show();

                     */
                    System.out.println("fermeture de main-view");
                }
            });

            Stage oldStage = (Stage) btnTerminer.getScene().getWindow();
            oldStage.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
