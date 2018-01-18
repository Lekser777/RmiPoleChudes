package sample;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * Created by Глеб on 15.04.2017.
 */
public class GameOptions implements Serializable {
    private StringBuilder word;
    private String desc;
    private StringBuilder xword;
    private int fails;
    private int points;
    private String fortune;
    private int fail0;
    private StringBuilder xword0;
    public GameOptions(StringBuilder a,String b,StringBuilder c,int d,int e){
        this.word=a;
        this.desc=b;
        this.xword=c;
        this.fails=d;
        this.points=e;
        this.fortune="";
        this.fail0=d;
        this.xword0=c;
    }

    public String getFortune() {
        return fortune;
    }

    public void setFortune(String fortune) {
        this.fortune = fortune;
    }

    public StringBuilder getXword0() {
        return xword0;
    }

    public int getFail0() {
        return fail0;
    }

    public void setFail0(int fail0) {
        this.fail0 = fail0;
    }

    public void setXword0(StringBuilder xword0) {
        this.xword0 = xword0;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public StringBuilder getWord() throws RemoteException{
        return word;
    }

    public void setWord(StringBuilder word) throws RemoteException {
        this.word = word;
    }

    public String getDesc() throws RemoteException {
        return desc;
    }

    public void setDesc(String desc) throws RemoteException {
        this.desc = desc;
    }

    public StringBuilder getXword() throws RemoteException {
        return xword;
    }

    public void setXword(StringBuilder xword) throws RemoteException {
        this.xword = xword;
    }

    public int getFails() throws RemoteException {
        return fails;
    }

    public void setFails(int fails) throws RemoteException {
        this.fails = fails;
    }
}
