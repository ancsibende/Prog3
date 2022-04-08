import javax.swing.*;
import java.io.Serializable;
import java.util.Arrays;

public class Recept implements Serializable {

    String nev;
    String[] hozzavalok;
    int elk_ido;
    String nehezseg;
    String elkeszites;

    public Recept(){
        this.nev="Recept neve";
        this.hozzavalok=null;
        this.elk_ido=0;
        this.nehezseg=  "Könnyű";
        this.elkeszites="Elkészítés menete";
    }

    public Recept(String nev, String[] hozzavalok,int elk_ido,String nehezseg,String elkeszites) {
        this.nev = nev;
        this.hozzavalok=hozzavalok;
        this.elkeszites=elkeszites;
        this.nehezseg=  nehezseg;
        this.elk_ido=elk_ido;
    }

    public String getNev(){ return nev; }
    public String[] getHozzavalok() {return hozzavalok; }
    public String getElkeszites() {return elkeszites; }
    public String getNehezseg() {return nehezseg; }
    public int getElk_ido() {return elk_ido; }

    public void setNev(String n) {
        this.nev = n;
    }
    public void setHozzavalok(String[] h) {
        this.hozzavalok = h;
    }
    public void setElkeszites(String e) {
        this.elkeszites = e;
    }
    public void setElk_ido(int i) {
        this.elk_ido = i;
    }
    public void setNehezseg(String neh) {
        this.nehezseg = neh;
    }


    public void kiir(JTextArea t, Recept r){
        t.append("Név:\n" + r.getNev()+"\n");
        t.append("\nHozzávalók:\n"+Arrays.toString(r.getHozzavalok()) +"\n");
        t.append("\nElkészítési idő:\n"+r.getElk_ido()+" perc\n");
        t.append("\nNehézség:\n"+r.getNehezseg()+"\n");
        t.append("\nElkészítés menete:\n"+ r.getElkeszites());
        t.append("\n" + "------------------------------------------------------------------" + "\n");
    }
}

