package fr.univlyon.tianegociation.controller;

import fr.univlyon.tianegociation.model.Agent;
import fr.univlyon.tianegociation.model.Position;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.WindowEvent;

import java.util.ArrayList;
import java.util.List;

import static javafx.stage.WindowEvent.WINDOW_CLOSE_REQUEST;

public class MainViewController {

    @FXML private Button case11;    @FXML private Button case12;    @FXML private Button case13;    @FXML private Button case14;    @FXML private Button case15;
    @FXML private Button case21;    @FXML private Button case22;    @FXML private Button case23;    @FXML private Button case24;    @FXML private Button case25;
    @FXML private Button case31;    @FXML private Button case32;    @FXML private Button case33;    @FXML private Button case34;    @FXML private Button case35;
    @FXML private Button case41;    @FXML private Button case42;    @FXML private Button case43;    @FXML private Button case44;    @FXML private Button case45;
    @FXML private Button case51;    @FXML private Button case52;    @FXML private Button case53;    @FXML private Button case54;    @FXML private Button case55;

    @FXML private Button btnLunch;

    private List<Agent> agents = new ArrayList<>();

    public void showRecap(List<Agent> agents){
        this.agents = agents;

        Agent.setNbAgent(agents.size());
        Agent.buildMailBox(agents.size());

        for (Agent agent: agents) {
            colorGrid(agent);
        }
    }

    @FXML
    void handleLunch(ActionEvent event) {
        Agent.setMainViewController(this);

        for (Agent agent : agents) {
            new Thread(agent).start();
        }
    }


    private void colorGrid(Agent agent){
        if((agent.getPosCourante().getI() == 1) && (agent.getPosCourante().getJ() == 1)){
            case11.setText(agent.getId()+"");
            case11.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 1) && (agent.getPosCourante().getJ() == 2)) {
            case12.setText(agent.getId()+"");
            case12.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 1) && (agent.getPosCourante().getJ() == 3)) {
            case13.setText(agent.getId()+"");
            case13.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 1) && (agent.getPosCourante().getJ() == 4)) {
            case14.setText(agent.getId()+"");
            case14.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 1) && (agent.getPosCourante().getJ() == 5)) {
            case15.setText(agent.getId()+"");
            case15.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 2) && (agent.getPosCourante().getJ() == 1)) {
            case21.setText(agent.getId()+"");
            case21.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 2) && (agent.getPosCourante().getJ() == 2)) {
            case22.setText(agent.getId()+"");
            case22.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 2) && (agent.getPosCourante().getJ() == 3)) {
            case23.setText(agent.getId()+"");
            case23.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 2) && (agent.getPosCourante().getJ() == 4)) {
            case24.setText(agent.getId()+"");
            case24.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 2) && (agent.getPosCourante().getJ() == 5)) {
            case25.setText(agent.getId()+"");
            case25.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 3) && (agent.getPosCourante().getJ() == 1)) {
            case31.setText(agent.getId()+"");
            case31.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 3) && (agent.getPosCourante().getJ() == 2)) {
            case32.setText(agent.getId()+"");
            case32.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 3) && (agent.getPosCourante().getJ() == 3)) {
            case33.setText(agent.getId()+"");
            case33.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 3) && (agent.getPosCourante().getJ() == 4)) {
            case34.setText(agent.getId()+"");
            case34.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 3) && (agent.getPosCourante().getJ() == 5)) {
            case35.setText(agent.getId()+"");
            case35.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 4) && (agent.getPosCourante().getJ() == 1)) {
            case41.setText(agent.getId()+"");
            case41.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 4) && (agent.getPosCourante().getJ() == 2)) {
            case42.setText(agent.getId()+"");
            case42.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 4) && (agent.getPosCourante().getJ() == 3)) {
            case43.setText(agent.getId()+"");
            case43.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 4) && (agent.getPosCourante().getJ() == 4)) {
            case44.setText(agent.getId()+"");
            case44.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 4) && (agent.getPosCourante().getJ() == 5)) {
            case45.setText(agent.getId()+"");
            case45.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 5) && (agent.getPosCourante().getJ() == 1)) {
            case51.setText(agent.getId()+"");
            case51.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 5) && (agent.getPosCourante().getJ() == 2)) {
            case52.setText(agent.getId()+"");
            case52.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 5) && (agent.getPosCourante().getJ() == 3)) {
            case53.setText(agent.getId()+"");
            case53.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 5) && (agent.getPosCourante().getJ() == 4)) {
            case54.setText(agent.getId()+"");
            case54.setStyle("-fx-background-color:"+ agent.getColor() +";");
        } else if ((agent.getPosCourante().getI() == 5) && (agent.getPosCourante().getJ() == 5)) {
            case55.setText(agent.getId()+"");
            case55.setStyle("-fx-background-color:"+ agent.getColor() +";");
        }
    }

    public void exchangeColors(Position p1, Position p2, int id, String newColor){
        int iSrc = p1.getI();
        int jSrc = p1.getJ();
        int iDest = p2.getI();
        int jDest = p2.getJ();

        if((iDest == 1) && (jDest == 1)){
            case11.setStyle("-fx-background-color:"+ newColor);
            case11.setText(id+"");
            if ((iSrc == 1) && (jSrc == 2)){
                case12.setStyle("-fx-background-color: #07AC9F");
                case12.setText("Empty");
            } else if ((iSrc == 2) && (jSrc == 1)){
                case21.setStyle("-fx-background-color: #07AC9F");
                case21.setText("Empty");
            }
        } else if ((iDest == 1) && (jDest == 2)) {
            case12.setStyle("-fx-background-color:"+ newColor);
            case12.setText(id+"");
            if ((iSrc == 1) && (jSrc == 1)){
                case11.setStyle("-fx-background-color: #07AC9F");
                case11.setText("Empty");
            } else if ((iSrc == 1) && (jSrc == 3)){
                case13.setStyle("-fx-background-color: #07AC9F");
                case13.setText("Empty");
            } else if ((iSrc == 2) && (jSrc == 2)){
                case22.setStyle("-fx-background-color: #07AC9F");
                case22.setText("Empty");
            }
        } else if ((iDest == 1) && (jDest == 3)) {
            case13.setStyle("-fx-background-color:"+ newColor);
            case13.setText(id+"");
            if ((iSrc == 1) && (jSrc == 2)){
                case12.setStyle("-fx-background-color: #07AC9F");
                case12.setText("Empty");
            } else if ((iSrc == 1) && (jSrc == 4)){
                case14.setStyle("-fx-background-color: #07AC9F");
                case14.setText("Empty");
            } else if ((iSrc == 2) && (jSrc == 3)){
                case23.setStyle("-fx-background-color: #07AC9F");
                case23.setText("Empty");
            }
        } else if ((iDest == 1) && (jDest == 4)) {
            case14.setStyle("-fx-background-color:"+ newColor);
            case14.setText(id+"");
            if ((iSrc == 1) && (jSrc == 3)){
                case13.setStyle("-fx-background-color: #07AC9F");
                case13.setText("Empty");
            } else if ((iSrc == 1) && (jSrc == 5)){
                case15.setStyle("-fx-background-color: #07AC9F");
                case15.setText("Empty");
            } else if ((iSrc == 2) && (jSrc == 4)){
                case24.setStyle("-fx-background-color: #07AC9F");
                case24.setText("Empty");
            }
        } else if ((iDest == 1) && (jDest == 5)) {
            case15.setStyle("-fx-background-color:"+ newColor);
            case15.setText(id+"");
            if ((iSrc == 1) && (jSrc == 4)){
                case14.setStyle("-fx-background-color: #07AC9F");
                case14.setText("Empty");
            } else if ((iSrc == 2) && (jSrc == 5)){
                case25.setStyle("-fx-background-color: #07AC9F");
                case25.setText("Empty");
            }
        } else if ((iDest == 2) && (jDest == 1)) {
            case21.setStyle("-fx-background-color:"+ newColor);
            case21.setText(id+"");
            if ((iSrc == 3) && (jSrc == 1)){
                case31.setStyle("-fx-background-color: #07AC9F");
                case31.setText("Empty");
            } else if ((iSrc == 2) && (jSrc == 2)){
                case22.setStyle("-fx-background-color: #07AC9F");
                case22.setText("Empty");
            } else if ((iSrc == 1) && (jSrc == 1)){
                case11.setStyle("-fx-background-color: #07AC9F");
                case11.setText("Empty");
            }
        } else if ((iDest == 2) && (jDest == 2)) {
            case22.setStyle("-fx-background-color:"+ newColor);
            case22.setText(id+"");
            if ((iSrc == 2) && (jSrc == 1)){
                case21.setStyle("-fx-background-color: #07AC9F");
                case21.setText("Empty");
            } else if ((iSrc == 1) && (jSrc == 2)){
                case12.setStyle("-fx-background-color: #07AC9F");
                case12.setText("Empty");
            } else if ((iSrc == 2) && (jSrc == 3)){
                case23.setStyle("-fx-background-color: #07AC9F");
                case23.setText("Empty");
            } else if ((iSrc == 3) && (jSrc == 2)){
                case32.setStyle("-fx-background-color: #07AC9F");
                case32.setText("Empty");
            }
        } else if ((iDest == 2) && (jDest == 3)) {
            case23.setStyle("-fx-background-color:"+ newColor);
            case23.setText(id+"");
            if ((iSrc == 2) && (jSrc == 2)){
                case22.setStyle("-fx-background-color: #07AC9F");
                case22.setText("Empty");
            } else if ((iSrc == 1) && (jSrc == 3)){
                case13.setStyle("-fx-background-color: #07AC9F");
                case13.setText("Empty");
            } else if ((iSrc == 2) && (jSrc == 4)){
                case24.setStyle("-fx-background-color: #07AC9F");
                case24.setText("Empty");
            } else if ((iSrc == 3) && (jSrc == 3)){
                case33.setStyle("-fx-background-color: #07AC9F");
                case33.setText("Empty");
            }
        } else if ((iDest == 2) && (jDest == 4)) {
            case24.setStyle("-fx-background-color:"+ newColor);
            case24.setText(id+"");
            if ((iSrc == 1) && (jSrc == 4)){
                case14.setStyle("-fx-background-color: #07AC9F");
                case14.setText("Empty");
            } else if ((iSrc == 2) && (jSrc == 5)){
                case25.setStyle("-fx-background-color: #07AC9F");
                case25.setText("Empty");
            } else if ((iSrc == 2) && (jSrc == 3)){
                case23.setStyle("-fx-background-color: #07AC9F");
                case23.setText("Empty");
            } else if ((iSrc == 3) && (jSrc == 4)){
                case34.setStyle("-fx-background-color: #07AC9F");
                case34.setText("Empty");
            }
        } else if ((iDest == 2) && (jDest == 5)) {
            case25.setStyle("-fx-background-color:"+ newColor);
            case25.setText(id+"");
            if ((iSrc == 2) && (jSrc == 4)){
                case24.setStyle("-fx-background-color: #07AC9F");
                case24.setText("Empty");
            } else if ((iSrc == 1) && (jSrc == 5)){
                case15.setStyle("-fx-background-color: #07AC9F");
                case15.setText("Empty");
            } else if ((iSrc == 3) && (jSrc == 5)){
                case35.setStyle("-fx-background-color: #07AC9F");
                case35.setText("Empty");
            }
        } else if ((iDest == 3) && (jDest == 1)) {
            case31.setStyle("-fx-background-color:"+ newColor);
            case31.setText(id+"");
            if ((iSrc == 2) && (jSrc == 1)){
                case21.setStyle("-fx-background-color: #07AC9F");
                case21.setText("Empty");
            } else if ((iSrc == 4) && (jSrc == 1)){
                case41.setStyle("-fx-background-color: #07AC9F");
                case41.setText("Empty");
            } else if ((iSrc == 3) && (jSrc == 2)){
                case32.setStyle("-fx-background-color: #07AC9F");
                case32.setText("Empty");
            }
        } else if ((iDest == 3) && (jDest == 2)) {
            case32.setStyle("-fx-background-color:"+ newColor);
            case32.setText(id+"");
            if ((iSrc == 3) && (jSrc == 1)){
                case31.setStyle("-fx-background-color: #07AC9F");
                case31.setText("Empty");
            } else if ((iSrc == 2) && (jSrc == 2)){
                case22.setStyle("-fx-background-color: #07AC9F");
                case22.setText("Empty");
            } else if ((iSrc == 3) && (jSrc == 3)){
                case33.setStyle("-fx-background-color: #07AC9F");
                case33.setText("Empty");
            } else if ((iSrc == 4) && (jSrc == 2)){
                case42.setStyle("-fx-background-color: #07AC9F");
                case42.setText("Empty");
            }
        } else if ((iDest == 3) && (jDest == 3)) {
            case33.setStyle("-fx-background-color:"+ newColor);
            case33.setText(id+"");
            if ((iSrc == 3) && (jSrc == 2)){
                case32.setStyle("-fx-background-color: #07AC9F");
                case32.setText("Empty");
            } else if ((iSrc == 2) && (jSrc == 3)){
                case23.setStyle("-fx-background-color: #07AC9F");
                case23.setText("Empty");
            } else if ((iSrc == 3) && (jSrc == 4)){
                case34.setStyle("-fx-background-color: #07AC9F");
                case34.setText("Empty");
            } else if ((iSrc == 4) && (jSrc == 3)){
                case43.setStyle("-fx-background-color: #07AC9F");
                case43.setText("Empty");
            }
        } else if ((iDest == 3) && (jDest == 4)) {
            case34.setStyle("-fx-background-color:"+ newColor);
            case34.setText(id+"");
            if ((iSrc == 3) && (jSrc == 3)){
                case33.setStyle("-fx-background-color: #07AC9F");
                case33.setText("Empty");
            } else if ((iSrc == 2) && (jSrc == 4)){
                case24.setStyle("-fx-background-color: #07AC9F");
                case24.setText("Empty");
            } else if ((iSrc == 3) && (jSrc == 5)){
                case35.setStyle("-fx-background-color: #07AC9F");
                case35.setText("Empty");
            } else if ((iSrc == 4) && (jSrc == 4)){
                case44.setStyle("-fx-background-color: #07AC9F");
                case44.setText("Empty");
            }
        } else if ((iDest == 3) && (jDest == 5)) {
            case35.setStyle("-fx-background-color:"+ newColor);
            case35.setText(id+"");
            if ((iSrc == 3) && (jSrc == 4)){
                case34.setStyle("-fx-background-color: #07AC9F");
                case34.setText("Empty");
            } else if ((iSrc == 2) && (jSrc == 5)){
                case25.setStyle("-fx-background-color: #07AC9F");
                case25.setText("Empty");
            } else if ((iSrc == 4) && (jSrc == 5)){
                case45.setStyle("-fx-background-color: #07AC9F");
                case45.setText("Empty");
            }
        } else if ((iDest == 4) && (jDest == 1)) {
            case41.setStyle("-fx-background-color:"+ newColor);
            case41.setText(id+"");
            if ((iSrc == 3) && (jSrc == 1)){
                case31.setStyle("-fx-background-color: #07AC9F");
                case31.setText("Empty");
            } else if ((iSrc == 4) && (jSrc == 2)){
                case42.setStyle("-fx-background-color: #07AC9F");
                case42.setText("Empty");
            } else if ((iSrc == 5) && (jSrc == 1)){
                case51.setStyle("-fx-background-color: #07AC9F");
                case51.setText("Empty");
            }
        } else if ((iDest == 4) && (jDest == 2)) {
            case42.setStyle("-fx-background-color:"+ newColor);
            case42.setText(id+"");
            if ((iSrc == 4) && (jSrc == 1)){
                case41.setStyle("-fx-background-color: #07AC9F");
                case41.setText("Empty");
            } else if ((iSrc == 3) && (jSrc == 2)){
                case32.setStyle("-fx-background-color: #07AC9F");
                case32.setText("Empty");
            } else if ((iSrc == 4) && (jSrc == 3)){
                case43.setStyle("-fx-background-color: #07AC9F");
                case43.setText("Empty");
            } else if ((iSrc == 5) && (jSrc == 2)){
                case52.setStyle("-fx-background-color: #07AC9F");
                case52.setText("Empty");
            }
        } else if ((iDest == 4) && (jDest == 3)) {
            case43.setStyle("-fx-background-color:"+ newColor);
            case43.setText(id+"");
            if ((iSrc == 4) && (jSrc == 2)){
                case42.setStyle("-fx-background-color: #07AC9F");
                case42.setText("Empty");
            } else if ((iSrc == 3) && (jSrc == 3)){
                case33.setStyle("-fx-background-color: #07AC9F");
                case33.setText("Empty");
            } else if ((iSrc == 4) && (jSrc == 4)){
                case44.setStyle("-fx-background-color: #07AC9F");
                case44.setText("Empty");
            } else if ((iSrc == 5) && (jSrc == 3)){
                case53.setStyle("-fx-background-color: #07AC9F");
                case53.setText("Empty");
            }
        } else if ((iDest == 4) && (jDest == 4)) {
            case44.setStyle("-fx-background-color:"+ newColor);
            case44.setText(id+"");
            if ((iSrc == 4) && (jSrc == 3)){
                case43.setStyle("-fx-background-color: #07AC9F");
                case43.setText("Empty");
            } else if ((iSrc == 3) && (jSrc == 4)){
                case34.setStyle("-fx-background-color: #07AC9F");
                case34.setText("Empty");
            } else if ((iSrc == 4) && (jSrc == 5)){
                case45.setStyle("-fx-background-color: #07AC9F");
                case45.setText("Empty");
            } else if ((iSrc == 5) && (jSrc == 4)){
                case54.setStyle("-fx-background-color: #07AC9F");
                case54.setText("Empty");
            }
        } else if ((iDest == 4) && (jDest == 5)) {
            case45.setStyle("-fx-background-color:"+ newColor);
            case45.setText(id+"");
            if ((iSrc == 4) && (jSrc == 4)){
                case44.setStyle("-fx-background-color: #07AC9F");
                case44.setText("Empty");
            } else if ((iSrc == 3) && (jSrc == 5)){
                case35.setStyle("-fx-background-color: #07AC9F");
                case35.setText("Empty");
            } else if ((iSrc == 5) && (jSrc == 5)){
                case55.setStyle("-fx-background-color: #07AC9F");
                case55.setText("Empty");
            }
        } else if ((iDest == 5) && (jDest == 1)) {
            case51.setStyle("-fx-background-color:"+ newColor);
            case51.setText(id+"");
            if ((iSrc == 4) && (jSrc == 1)){
                case41.setStyle("-fx-background-color: #07AC9F");
                case41.setText("Empty");
            } else if ((iSrc == 5) && (jSrc == 2)){
                case52.setStyle("-fx-background-color: #07AC9F");
                case52.setText("Empty");
            }
        } else if ((iDest == 5) && (jDest == 2)) {
            case52.setStyle("-fx-background-color:"+ newColor);
            case52.setText(id+"");
            if ((iSrc == 5) && (jSrc == 1)){
                case51.setStyle("-fx-background-color: #07AC9F");
                case51.setText("Empty");
            } else if ((iSrc == 4) && (jSrc == 2)){
                case42.setStyle("-fx-background-color: #07AC9F");
                case42.setText("Empty");
            } else if ((iSrc == 5) && (jSrc == 3)){
                case53.setStyle("-fx-background-color: #07AC9F");
                case53.setText("Empty");
            }
        } else if ((iDest == 5) && (jDest == 3)) {
            case53.setStyle("-fx-background-color:"+ newColor);
            case53.setText(id+"");
            if ((iSrc == 5) && (jSrc == 2)){
                case52.setStyle("-fx-background-color: #07AC9F");
                case52.setText("Empty");
            } else if ((iSrc == 4) && (jSrc == 3)){
                case43.setStyle("-fx-background-color: #07AC9F");
                case43.setText("Empty");
            } else if ((iSrc == 5) && (jSrc == 4)){
                case54.setStyle("-fx-background-color: #07AC9F");
                case54.setText("Empty");
            }
        } else if ((iDest == 5) && (jDest == 4)) {
            case54.setStyle("-fx-background-color:"+ newColor);
            case54.setText(id+"");
            if ((iSrc == 5) && (jSrc == 3)){
                case53.setStyle("-fx-background-color: #07AC9F");
                case53.setText("Empty");
            } else if ((iSrc == 4) && (jSrc == 4)){
                case44.setStyle("-fx-background-color: #07AC9F");
                case44.setText("Empty");
            } else if ((iSrc == 5) && (jSrc == 5)){
                case55.setStyle("-fx-background-color: #07AC9F");
                case55.setText("Empty");
            }
        } else if ((iDest == 5) && (jDest == 5)) {
            case55.setStyle("-fx-background-color:"+ newColor);
            case55.setText(id+"");
            if ((iSrc == 5) && (jSrc == 4)){
                case54.setStyle("-fx-background-color: #07AC9F");
                case54.setText("Empty");
            } else if ((iSrc == 4) && (jSrc == 5)){
                case45.setStyle("-fx-background-color: #07AC9F");
                case45.setText("Empty");
            }
        }
    }

}
