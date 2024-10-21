package org.example;

import org.example.view.WorttrainerView;

import java.net.MalformedURLException;

/**
 * Main Klasse welche den Worttrainer startet
 */
public class main {

    public static void main(String[] args) throws MalformedURLException {
        WortEintrag we = new WortEintrag("Baum", "https://www.freepnglogos.com/uploads/tree-png/no-background-tree-3.jpg");
        System.out.println(we.checkURL("https://www.freepnglogos.com/uploads/tree-png/no-background-tree-3.jpg"));
        WortTrainer wt = new WortTrainer();

        wt.add("Baum", "https://www.freepnglogos.com/uploads/tree-png/no-background-tree-3.jpg");
        wt.add("Hund", "https://www.freepnglogos.com/uploads/dog-png/bow-wow-gourmet-dog-treats-are-healthy-natural-low-4.png");
        wt.add("Nukleare Bombe", "https://www.freepnglogos.com/uploads/missile-png/missile-nuclear-bomb-by-cdavis-33.png");
        wt.add("Haus", "https://www.freepnglogos.com/uploads/house-png/house-png-commonwealth-magazine-18.png");

        WorttrainerView wtv = new WorttrainerView(wt);

        wtv.start();


    }
}
