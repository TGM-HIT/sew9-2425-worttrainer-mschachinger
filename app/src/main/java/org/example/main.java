package org.example;

import org.example.view.WorttrainerView;

import java.net.MalformedURLException;

/**
 * Main Klasse welche den Wor
 */
public class main {

    public static void main(String[] args) throws MalformedURLException {
        WortEintrag we = new WortEintrag("Baum", "https://www.freepnglogos.com/uploads/tree-png/no-background-tree-3.jpg");
        System.out.println(we.checkURL("https://www.freepnglogos.com/uploads/tree-png/no-background-tree-3.jpg"));
        WortTrainer wt = new WortTrainer();

        wt.add("Baum", "https://www.freepnglogos.com/uploads/tree-png/no-background-tree-3.jpg");
        wt.add("Hund", "https://www.freepnglogos.com/uploads/dog-png/bow-wow-gourmet-dog-treats-are-healthy-natural-low-4.png");
        WorttrainerView wtv = new WorttrainerView(wt);

        wtv.start();


    }
}
