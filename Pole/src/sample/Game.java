package sample;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Глеб on 15.04.2017.
 */
public interface Game extends Remote {
    boolean checkletter(String tocheck) throws RemoteException;
    StringBuilder checkletter2(String tocheck) throws RemoteException;
    boolean checkWord(String tocheck) throws  RemoteException;
    String getdesc() throws RemoteException;
    StringBuilder getXword() throws  RemoteException;
    StringBuilder getword() throws RemoteException;
    int getFails() throws RemoteException;
    int getPoints() throws RemoteException;
    String getFortune() throws  RemoteException;
    void setPoints(int pointstoadd) throws  RemoteException;
    StringBuilder getXword0() throws RemoteException;
    int getFails0() throws RemoteException;
    void setFail(int fail0) throws RemoteException;
    void setXword(StringBuilder xword0) throws RemoteException;


}
