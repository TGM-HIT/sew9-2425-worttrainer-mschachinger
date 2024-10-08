package org.example;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Erstellt einen Worttrainer mit einer Wortliste
 * @author Marcel Schachinger
 * @version 2022-13-09
 */
public class WortTrainer implements Serializable {
    private List<WortEintrag> wl;
    private int index;
    private int wortAnzahl;
    private int richtigeWortAnzahl;

    public WortTrainer(String wort, String url) {
        wl = new ArrayList<>();
        index = 0;
        randomEintrag();
    }

    public WortTrainer() {
        wl = new ArrayList<>();
        index = 0;
    }

    /**
     * Sucht einen zufaelligen Worteintrag aus der Liste aus und gibt ihn zur�ck
     * @return
     */
    public void randomEintrag() {
        Random generator = new Random();
        int zufall = generator.nextInt(wl.size());
        index = zufall;
    }

    /**
     * Gibt das aktuelle Wort zurueck
     * @return
     */
    public String getWort(int i) {
        return wl.get(i).getWort();
    }


    /**
     * Gibt die aktuelle Url zurueck
     * @return
     */
    public String getUrl(int i) {
        return wl.get(i).getUrl();
    }

    /**
     * ÜberprÜft ob der aktuelle WortEintrag der selbe ist wie der Übergebene
     * @return
     */
    public boolean check(String wort, String url) {
        WortEintrag we = new WortEintrag(wort, url);
        wortAnzahl++;
        if((this.wl.get(index).equals(we.getWort()))) {
            richtigeWortAnzahl++;
            return true;
        }
        return false;
    }

    /**
     * UeberprÜft ob der aktuelle WortEintrag der selbe ist wie der Übergebene,  ignoriert Großschreibung
     */
    public boolean checkIgnoreCase(String wort, String url) {
        WortEintrag we = new WortEintrag(wort, url);
        wortAnzahl++;
        if((this.wl.get(index).getWort().toLowerCase().equals(we.getWort()))) {
            richtigeWortAnzahl++;
            return true;
        }
        return false;
    }

    /**
     * Gibt eine Statistik aus
     */
    public String statistik() {
        return "Richtige Woerter: " + richtigeWortAnzahl + "\nWoerter insgesamt: " + wortAnzahl;
    }

    /**
     * Added ein Wort
     */
    public void add(String wort, String url) {
        wl.add(new WortEintrag(wort, url));
    }

    @Override
    public String toString() {
        return wl.toString() + statistik();
    }

    public boolean loescheWort (String wort, String url) {
        return wl.remove(new WortEintrag(wort, url));
    }

    public int length() {
        return wl.size();
    }

    /**
     * @return the wortAnzahl
     */
    public int getWortAnzahl() {
        return wortAnzahl;
    }

    /**
     * @return the richtigeWortAnzahl
     */
    public int getRichtigeWortAnzahl() {
        return richtigeWortAnzahl;
    }

    /**
     * @param wortAnzahl the wortAnzahl to set
     */
    public void setWortAnzahl(int wortAnzahl) {
        this.wortAnzahl = wortAnzahl;
    }

    /**
     * @param richtigeWortAnzahl the richtigeWortAnzahl to set
     */
    public void setRichtigeWortAnzahl(int richtigeWortAnzahl) {
        this.richtigeWortAnzahl = richtigeWortAnzahl;
    }

    public void addWortAnzahl() {
        this.wortAnzahl++;
    }
    /**
     * Addiert 1 zu RichtigeWortAnzahl
     */
    public void addRichtigeWortAnzahl() {
        this.richtigeWortAnzahl++;
    }
    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }


    /**
     * addiert +1 zu index
     */
    public void addIndex() {
        this.index++;
    }

    /**
     * Setzt den Index zu einem gewünschten Wert
     */
    public void setIndex(int index) {
        this.index = index;
    }

}
