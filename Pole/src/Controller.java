import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Game;
import sample.GameServer;

import java.awt.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

/**
 * Created by Глеб on 15.04.2017.
 */
public class Controller {

    @FXML private javafx.scene.control.TextArea tf_mod;
    @FXML private javafx.scene.control.Label tf_fail;//
    @FXML private javafx.scene.control.Label tf_points_;//
    @FXML private javafx.scene.control.TextArea tf_word_;
    @FXML private javafx.scene.control.TextArea tf_help_;
    @FXML private javafx.scene.control.TextArea tf_all;
    @FXML private javafx.scene.control.TextArea tf_letter;
    @FXML private javafx.scene.control.Button btn_makemod;
    @FXML private javafx.scene.control.Button btn_try;
    @FXML private javafx.scene.control.Button btn_try_all;
    @FXML private javafx.scene.control.Button btn_start;
    @FXML private javafx.scene.control.Label lb_1;
    int points=0;
    int pointstoadd;
    int rand;
    int port;
    String con;

 public void Init() {}
     public void Start () {
         try {

             //btn_try.setDisable(true);
             // btn_try_all.setDisable(true);
             Random r=new Random();
             rand=r.nextInt(3);

             if (rand == 0) {
                 port=1111;
                 con="Game1";
             }
             if (rand == 1) {
                 port=1112;
                 con="Game2";

             }
             if (rand == 2) {
                 port=1113;
                 con="Game3";

             }
             Registry registry = LocateRegistry.getRegistry(port);
             Game stub = (Game) registry.lookup(con);
             stub.setPoints(0);
             stub.setFail(stub.getFails0());
             stub.setXword(stub.getXword0());
             tf_help_.setText(stub.getdesc());
             tf_word_.setText(stub.getXword().toString());
             //tf_mod.setText(stub.getword().toString());
             tf_fail.setText("" + stub.getFails());

             tf_points_.setText("" + points);
             btn_try.setDisable(false);
             btn_try_all.setDisable(false);
             tf_fail.setDisable(false);
             tf_help_.setDisable(false);
             tf_points_.setDisable(false);
             tf_mod.setDisable(false);
             tf_letter.setDisable(false);
             tf_all.setDisable(false);
             tf_word_.setDisable(false);



         } catch (Exception e) {
             System.err.println("Client exception: " + e.toString());
             e.printStackTrace();
         }
     }

    public void Makemod() {

        Random r = new Random();
        int x = r.nextInt(9);
        if (x == 0) {
            tf_mod.setText("50");
            pointstoadd = 50;
        }
        if (x == 1) {
            tf_mod.setText("50");
            pointstoadd = 50;
        }
        if (x == 2) {
            tf_mod.setText("50");
            pointstoadd = 50;
        }
        if (x == 3) {
            tf_mod.setText("75");
            pointstoadd = 75;
        }
        if (x == 4) {
            tf_mod.setText("75");
            pointstoadd = 75;
        }
        if (x == 5) {
            tf_mod.setText("100");
            pointstoadd = 100;
        }
        if (x == 6) {
            tf_mod.setText("X2");
            pointstoadd = 2;
        }
        if (x == 7) {
            tf_mod.setText("X4");
            pointstoadd = 4;
        }
        if (x == 8) {
            tf_mod.setText("X0");
            pointstoadd = 0;
        }
        btn_makemod.setDisable(true);
        btn_try_all.setDisable(false);
        btn_try.setDisable(false);

    }

    public void Makemod2() {


        try {
            Registry registry = LocateRegistry.getRegistry(port);
            Game stub = (Game) registry.lookup(con);

            String s1 = tf_letter.getText();
            tf_word_.setText(stub.checkletter2(s1).toString());
            tf_points_.setText("" + stub.getPoints());
            if (stub.getXword().toString().compareTo(stub.getword().toString())==0){
                tf_mod.setText("Вы выиграли. Очки: "+stub.getPoints());
                btn_try.setDisable(true);
                btn_try_all.setDisable(true);
                tf_fail.setDisable(true);
                tf_help_.setDisable(true);
                tf_points_.setDisable(true);
                tf_mod.setDisable(true);
                tf_letter.setDisable(true);
                tf_all.setDisable(true);
                tf_word_.setDisable(true);
            }else {
                if (stub.getFails() == 0) {
                    tf_mod.setText("Вы проиграли");
                    btn_try.setDisable(true);
                    btn_try_all.setDisable(true);
                    tf_fail.setDisable(true);
                    tf_help_.setDisable(true);
                    tf_points_.setDisable(true);
                    tf_mod.setDisable(true);
                    tf_letter.setDisable(true);
                    tf_all.setDisable(true);
                    tf_word_.setDisable(true);

                } else {
                    tf_fail.setText("" + stub.getFails());
                    tf_mod.setText("На барабане: " + stub.getFortune());
                }
                //tf_mod.setText(s1);

            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }


    }

    public void Check1() {
        try {
            Registry registry = LocateRegistry.getRegistry(1111);
            Game stub = (Game) registry.lookup("Game1");
            String s1 = tf_letter.getText();
            if (stub.checkletter(s1)) {
                if (pointstoadd == 2) {
                    points = points * 2;
                }
                if (pointstoadd == 4) {
                    points = points * 4;
                }
                if (pointstoadd == 0) {
                    points = 0;
                } else {
                    points = points + pointstoadd;
                }
            } else {

                tf_mod.setText("fail");
            }
            tf_word_.setText(stub.checkletter2(s1).toString());
            tf_points_.setText("" + points);
            tf_mod.setText(s1);
            btn_makemod.setDisable(false);
            btn_try_all.setDisable(true);
            btn_try.setDisable(true);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }


    }

    public void Check2() {
        try {

            Registry registry = LocateRegistry.getRegistry(port);
            Game stub = (Game) registry.lookup(con);
            String s1 = tf_all.getText();
            int toplus=stub.getXword().length();
           /* if (s1.compareTo("Мазурка")==0)
            { tf_mod.setText("True"+"Мы сравниваем "+ s1+" c Мазурка"); }else{tf_mod.setText("False"+"Мы сравниваем "+ s1+" c Мазурка");}

            */
            if (stub.checkWord(s1)) {

                int toadd=stub.getPoints()+(100*toplus);
                stub.setPoints(toadd);

                tf_mod.setText("Вы выиграли. Очки: "+stub.getPoints());
                btn_try.setDisable(true);
                btn_try_all.setDisable(true);
                tf_fail.setDisable(true);
                tf_help_.setDisable(true);
                tf_points_.setDisable(true);
                tf_mod.setDisable(true);
                tf_letter.setDisable(true);
                tf_all.setDisable(true);
                tf_word_.setDisable(true);
               // Dialogs.showInformationDialog(stage,"Вы выиграли. Очки: "+stub.getPoints(),"ПОЗДРАВЛЯЮ","Поле чудес");
            } else {
                tf_mod.setText("Вы проиграли");
                btn_try.setDisable(true);
                btn_try_all.setDisable(true);
                tf_fail.setDisable(true);
                tf_help_.setDisable(true);
                tf_points_.setDisable(true);
                tf_mod.setDisable(true);
                tf_letter.setDisable(true);
                tf_all.setDisable(true);
                tf_word_.setDisable(true);

            }
//            btn_makemod.setDisable(false);
//            btn_try_all.setDisable(true);
 //           btn_try.setDisable(true);


        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }


    }

}
