package sample;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

/**
 * Created by Глеб on 15.04.2017.
 */
public class GameServer implements Game {


    private GameOptions x;
    public GameServer(GameOptions x){
        this.x=x;
    }

    @Override
    public void setFail(int fail0) throws RemoteException {
        this.x.setFails(fail0);
    }

    @Override
    public void setXword(StringBuilder xword0) throws RemoteException {
        this.x.setXword(xword0);
    }

    @Override
    public String getFortune() throws RemoteException {
        return x.getFortune();
    }

    @Override//
    public StringBuilder getXword0() throws RemoteException {
        return x.getXword0();
    }

    @Override//
    public int getFails0() throws RemoteException {
        return x.getFail0();
    }

    @Override
    public int getPoints() throws RemoteException {
        return x.getPoints();
    }

    @Override
    public void setPoints(int pointstoadd) throws RemoteException {
        this.x.setPoints(pointstoadd);

    }

    @Override
    public StringBuilder checkletter2(String tocheck) throws RemoteException {
        StringBuilder x1 = x.getWord();
        StringBuilder x2 = x.getXword();
        int pointsx=x.getPoints();
        int failstoend=x.getFails();

        for (int i=0;i<x1.length();i++) {
            String stocheck=x1.substring(i,i+1);
            if (tocheck.compareTo(stocheck)==0){
                x2.replace(i,i+1,stocheck);

                Random r=new Random();
                int xr=r.nextInt(9);
                if(xr==0){

                    pointsx=pointsx+50;
                    x.setFortune("50");
                }
                if(xr==1){

                    pointsx=pointsx+50;
                    x.setFortune("50");
                }
                if(xr==2){

                    pointsx=pointsx+50;
                    x.setFortune("50");
                }
                if(xr==3){

                    pointsx=pointsx+75;
                    x.setFortune("75");
                }
                if(xr==4){

                    pointsx=pointsx+75;
                    x.setFortune("75");
                }
                if(xr==5){

                    pointsx=pointsx+100;
                    x.setFortune("100");
                }
                if(xr==6){

                    pointsx=pointsx*2;
                    x.setFortune("X2");
                }
                if(xr==7){

                    pointsx=pointsx*4;
                    x.setFortune("X4");
                }
                if(xr==8){

                    pointsx=pointsx*0;
                    x.setFortune("Сектор банкрот");
                }


                x.setPoints(pointsx);
            }
            }
        failstoend--;
        x.setFails(failstoend);
        return x2;
        }





    @Override
    public int getFails() throws RemoteException {
        return x.getFails();
    }

    @Override
    public StringBuilder getword() throws RemoteException {
        return x.getWord();
    }

    @Override
    public StringBuilder getXword() throws RemoteException {
        return x.getXword();
    }

    @Override
    public String getdesc() throws RemoteException {
        return x.getDesc();
    }

    @Override
    public boolean checkletter(String tocheck) throws RemoteException {
        StringBuilder x1 = x.getWord();
        StringBuilder x2 = x.getXword();
        boolean a=true;

        for (int i = 0; i < x1.length(); i++) {
            String stocheck = x1.substring(i, i + 1);
            if (tocheck.compareTo(stocheck) == 0) {
                x2.replace(i, i + 1, stocheck);
                a= true;
            } else {
                a= false;
            }
        }

        /*for (int i=0;i<x1.length();i++) {
            String stocheck=x1.substring(i,i+1);
            if (tocheck.compareTo(stocheck)==0){
                x2.replace(i,i+1,stocheck);

            }
        }
        return x2;*/
        return a;
    }

    @Override
    public boolean checkWord(String tocheck) throws RemoteException {

        if(tocheck.compareTo(x.getWord().toString())==0){
            return true;
        }
        else
        { return false;}

    }
    public static void main(String args[]){
        try{


            // GeometryServer server=new GeometryServer();

                StringBuilder a1 = new StringBuilder("мазурка");
                StringBuilder b1 = new StringBuilder("*******");
                String c1 = "Бальный танец?";
                int d1 = 10;
                int e1 = 0;


                GameOptions go1 = new GameOptions(a1, c1, b1, d1, e1);

            GameServer server = new GameServer(go1);

            Game stub = (Game) UnicastRemoteObject.exportObject(server, 0);
            Registry registry = LocateRegistry.createRegistry(1111);
            registry.rebind("Game1", stub);
            System.out.println(go1.getDesc() + go1.getWord());
            System.err.println("Server ready");

                StringBuilder a12 = new StringBuilder("галлон");
                StringBuilder b12 = new StringBuilder("******");
                String c12 = "Этим в Англии меряют объём?";
                int d12 = 10;
                int e12 = 0;


                GameOptions go12 = new GameOptions(a12, c12, b12, d12, e12);
            GameServer server2 = new GameServer(go12);

            Game stub2 = (Game) UnicastRemoteObject.exportObject(server2, 0);
            Registry registry2 = LocateRegistry.createRegistry(1112);
            registry2.rebind("Game2", stub2);
            System.out.println(go12.getDesc() + go12.getWord());
            System.err.println("Server ready");


                StringBuilder a13 = new StringBuilder("космет");
                StringBuilder b13 = new StringBuilder("******");
                String c13 = "Раб в Древней Греции, исполнявший обязанности массажиста?";
                int d13 = 10;
                int e13 = 0;


                GameOptions go13 = new GameOptions(a13, c13, b13, d13, e13);

                GameServer server3 = new GameServer(go13);

                Game stub3 = (Game) UnicastRemoteObject.exportObject(server3, 0);
                Registry registry3 = LocateRegistry.createRegistry(1113);
                registry3.rebind("Game3", stub3);
                System.out.println(go13.getDesc() + go13.getWord());
                System.err.println("Server ready");



        }
        catch (Exception e){
            System.out.println("Server error"+ e.toString());
        }
    }

}
