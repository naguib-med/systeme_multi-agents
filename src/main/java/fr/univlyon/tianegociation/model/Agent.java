package fr.univlyon.tianegociation.model;

import fr.univlyon.tianegociation.controller.MainViewController;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.List;

public class Agent implements Runnable {

    // attributs partagés
    private static Grille configCourante;
    private static Grille configFinale;
    private static List<Message>[] mailBox;

    private static boolean terminated = false;
    private static int nbAgent;
    private static int countTerminated = 0;

    private static MainViewController mainViewController;

    // attributs propres a l'objet
    private int id;
    private String color;
    private Position posCourante;
    private Position posFinale;
    private List<Position> historiquePos = new ArrayList<>();

    public Agent(Position posCourante, Position posFinale, int id, String color) {
        this.posCourante = posCourante;
        this.posFinale = posFinale;
        this.id = id;
        this.color = color;
    }



    //////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////                 METHODE RUN                       /////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public synchronized void run() {
        boolean didIMoved = false;
        while (!terminated){
            List<Message> messages = getNewMessage();
            if (messages != null){
                if (posCourante.equals(posFinale)){
                    didIMoved = true;
                    try {
                        moveToHelp();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else
                    notifyAll();
            }
            if (!posFinale.equals(posCourante)){
                didIMoved = true;
                try {
                    seDeplacer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (posFinale.equals(posCourante) && !didIMoved){
                iAmAtHome();
                didIMoved =true;
            }

            try {
                wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            notifyAll();
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////         COMPORTEMENT ET METHODES UTILE           //////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////

    private synchronized void seDeplacer() throws InterruptedException {
        boolean toLoop = true;
        boolean isSend = false;
        while (toLoop){
            Position nextStep = computeNextStep();
            if(nextStep != null){
                System.out.println("je me deplace naturelement vers ("+nextStep.getI()+", "+ nextStep.getJ()+")");
                moveTo(nextStep);
                toLoop = false;

                //notifyAll();
            }else {
                if (!isSend){
                    Position idealPosition = getIdealPosition();
                    int idReceiver = configCourante.getAgentId(idealPosition.getI(), idealPosition.getJ());
                    Message message = new Message(id, idReceiver, "MOVEPLEASE", idealPosition);

                    if (mailBox[idReceiver-1] == null){
                        mailBox[idReceiver-1] = new ArrayList<>();
                        mailBox[idReceiver-1].add(message);
                    } else
                        mailBox[idReceiver-1].add(message);
                    System.out.println("NO WAY TO MOVE : Ask \""+idReceiver+"\" to move");
                    isSend = true;
                }

                //notifyAll();
                //wait();
                System.out.println("je me reveille du coma");
            }
        }
    }

    private synchronized List<Message> getNewMessage(){
        List<Message> messages = mailBox[id-1];
        mailBox[id-1] = null;
        return messages;
    }

    private synchronized Position computeNextStep(){
        // find the next step or compute an alternative
        Position idealPosition = getIdealPosition();
        int ni = idealPosition.getI();
        int nj = idealPosition.getJ();
        System.out.println("position ideal ("+ni+", "+nj+")");

        if (!configCourante.isOccupied(ni, nj) && !historiquePos.contains(idealPosition) ){
            return new Position(ni, nj);
        } else {
            System.out.println("Ideal position is not empty");
            // find alternative
            int alti, altj;
            alti = posCourante.getI();
            altj = posCourante.getJ();
            System.out.println("\t position courante ("+alti+", "+altj+")");
            if (((alti +1) < configCourante.getMaxI()) && !configCourante.isOccupied((alti +1), altj) && !historiquePos.contains(new Position((alti +1), altj))){
                System.out.println("\t alternative trouver ("+(alti+1)+", "+altj+")");
                return new Position((alti +1), altj);
            } else if (((alti -1) > 0) && !configCourante.isOccupied((alti -1), altj) && !historiquePos.contains(new Position((alti -1), altj))){
                return new Position((alti -1), altj);
            } else if (((altj +1) < configCourante.getMaxJ()) && !configCourante.isOccupied(alti, (altj+1)) && !historiquePos.contains(new Position(alti, (altj+1)))){
                return new Position(alti, (altj+1));
            } else if (((altj -1) > 0) && !configCourante.isOccupied(alti, (altj+1)) && !historiquePos.contains(new Position(alti, (altj-1)))){
                return new Position(alti, (altj-1));
            }
        }
        return null;
    }

    private synchronized Position getIdealPosition(){
        int ni, nj;
        ni = posCourante.getI();
        nj = posCourante.getJ();

        if (ni > posFinale.getI())
            ni--;
        else if (ni < posFinale.getI())
            ni++;
        else {
            if (nj > posFinale.getJ()){
                nj--;
            } else if (nj < posFinale.getJ()) {
                nj++;
            }
        }

        return new Position(ni,nj);
    }

    private synchronized boolean moveTo(Position p){
        Position tmp = posCourante;
        boolean b = configCourante.move(posCourante.getI(), posCourante.getJ(), p.getI(), p.getJ());
        if (b) {
            System.out.println("("+p.getI()+"," + p.getJ()+ ")");
            historiquePos.add(tmp);
            posCourante = p;
            if (posCourante.equals(posFinale)){
                iAmAtHome();
                System.out.println("je suis arrive a destination ");
            }
            moveOnInterface(tmp, p);
        } else
            return false;
        return true;
    }

    private synchronized void iAmAtHome(){
        countTerminated++;
        if (countTerminated == nbAgent){
            terminated = true;
        }
    }

    private synchronized void moveToHelp() throws InterruptedException {
        boolean toLoop = true;
        boolean isSend = false;
        System.out.println("Someone want me to free my place");
        while (toLoop){
            Position position = getEmptyPlace();
            if (position != null){
                System.out.println("I found empty place at ("+position.getI()+", "+position.getJ()+")");
                moveTo(position);
                countTerminated--;
                historiquePos = new ArrayList<>();

                System.out.println("\t I move on it to help");

                toLoop = false;

                //notifyAll();
                wait(1000);
                System.out.println("je me reveille du coma");
            } else {
                if (!isSend){
                    System.out.println("I am also blocked :(");
                    Position position1 = pickRandomNeighbor();
                    if (position1 != null){
                        int idReceiver = configCourante.getAgentId(position1.getI(), position1.getJ());
                        Message message = new Message(id, idReceiver, "MOVEPLEASE", position1);
                        //mailBox[idReceiver-1].add(message);
                        if (mailBox[idReceiver-1] == null){
                            mailBox[idReceiver-1] = new ArrayList<>();
                            mailBox[idReceiver-1].add(message);
                        } else
                            mailBox[idReceiver-1].add(message);
                        System.out.println("I ask "+ idReceiver +"to free his place");


                    }
                    isSend = true;
                }
                //notifyAll();
                //wait();
                System.out.println("je me reveille du coma");
            }

        }

    }

    private synchronized Position getEmptyPlace(){
        int alti, altj;
        alti = posCourante.getI();
        altj = posCourante.getJ();

        if (((alti +1) < configCourante.getMaxI()) && !configCourante.isOccupied((alti +1), altj)){
            return new Position((alti +1), altj);
        } else if (((alti -1) > 0) && !configCourante.isOccupied((alti -1), altj)){
            return new Position((alti +1), altj);
        } else if (((altj +1) < configCourante.getMaxJ()) && !configCourante.isOccupied(alti, (altj+1))){
            return new Position(alti, (altj+1));
        } else if (((altj -1) > 0) && !configCourante.isOccupied(alti, (altj+1))){
            return new Position(alti, (altj-1));
        }
        return null;
    }

    private synchronized Position pickRandomNeighbor(){
        int alti, altj;
        alti = posCourante.getI();
        altj = posCourante.getJ();

        if (((alti +1) < configCourante.getMaxI())){
            return new Position((alti +1), altj);
        } else if (((alti -1) > 0)){
            return new Position((alti +1), altj);
        } else if (((altj +1) < configCourante.getMaxJ())){
            return new Position(alti, (altj+1));
        } else if (((altj -1) > 0)){
            return new Position(alti, (altj-1));
        }
        return  null;
    }

    private synchronized void moveOnInterface(Position src, Position dest){
        Platform.runLater(new Runnable() {
            @Override public void run() {
                mainViewController.exchangeColors(src, dest, id, color);
            }
        });
        //mainViewController.exchangeColors(src, dest, id, color);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////          LES GETTERS ET SETTERS                  //////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Position getPosCourante() {
        return posCourante;
    }

    public void setPosCourante(Position posCourante) {
        this.posCourante = posCourante;
    }

    public Position getPosFinale() {
        return posFinale;
    }

    public void setPosFinale(Position posFinale) {
        this.posFinale = posFinale;
    }

    public static Grille getConfigCourante() {
        return configCourante;
    }

    public static void setConfigCourante(Grille configCourante) {
        Agent.configCourante = configCourante;
    }

    public static Grille getConfigFinale() {
        return configFinale;
    }

    public static void setConfigFinale(Grille configFinale) {
        Agent.configFinale = configFinale;
    }

    public static boolean isTerminated() {
        return terminated;
    }

    public static void setTerminated(boolean terminated) {
        Agent.terminated = terminated;
    }

    public static int getNbAgent() {
        return nbAgent;
    }

    public static void setNbAgent(int nbAgent) {
        Agent.nbAgent = nbAgent;
    }

    public static MainViewController getMainViewController() {
        return mainViewController;
    }

    public static void setMainViewController(MainViewController mainViewController) {
        Agent.mainViewController = mainViewController;
    }

    public static int getCountTerminated() {
        return countTerminated;
    }

    public static void setCountTerminated(int countTerminated) {
        Agent.countTerminated = countTerminated;
    }

    public static void buildMailBox(int size){
        Agent.mailBox = new ArrayList[size];
        for (int i=0; i< size; i++){
            mailBox[i] = null;
        }
    }


}
