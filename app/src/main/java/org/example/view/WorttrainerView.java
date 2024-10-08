package org.example.view;
import org.example.WortTrainer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class WorttrainerView {

    private WortTrainer wortTrainer;
    public WorttrainerView(WortTrainer wortTrainer) {
        this.wortTrainer = wortTrainer;

    }

    public void start() throws MalformedURLException {
        /**

        //auswahl ob ein speichestand geladen werden soll
        int auswahl = JOptionPane.showConfirmDialog(null, "Möchten Sie einen Speicherstand laden?", "Speicherstand", JOptionPane.YES_NO_OPTION);
        if(auswahl == JOptionPane.YES_OPTION) {
            //wortTrainer.laden();
        }

        //auswahl ob ein neuer Eintrag hinzugefügt werden soll
        auswahl = JOptionPane.showConfirmDialog(null, "Möchten Sie einen neuen Eintrag hinzufügen?", "Neuer Eintrag", JOptionPane.YES_NO_OPTION);
        if(auswahl == JOptionPane.YES_OPTION) {
           String wort = JOptionPane.showInputDialog("Bitte geben Sie das Wort ein");
           String url = JOptionPane.showInputDialog("Bitte geben Sie die URL ein");
           wortTrainer.add(wort, url);
        }
         */

        do {

            //zeige bild an
            ImageIcon icon;
            String link = wortTrainer.getUrl(wortTrainer.getIndex());
            try {
                URL url = new URI(link).toURL();
                Image image = ImageIO.read(url);


                int maxWidth = 600;
                int maxHeight = 600;


                int imageWidth = image.getWidth(null);
                int imageHeight = image.getHeight(null);


                double widthScale = (double) maxWidth / imageWidth;
                double heightScale = (double) maxHeight / imageHeight;
                double scaleFactor = Math.min(widthScale, heightScale);

                if (scaleFactor < 1) {
                    int newWidth = (int) (imageWidth * scaleFactor);
                    int newHeight = (int) (imageHeight * scaleFactor);
                    image = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                }

                ImageIcon imageIcon = new ImageIcon(image);
                JOptionPane.showMessageDialog(null, "", "Bildanzeige", JOptionPane.INFORMATION_MESSAGE, imageIcon); // Bild anzeigen
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }

            //wort eingabe und prüfen
            String eingabe = JOptionPane.showInputDialog("Bitte geben Sie das Wort ein");
            if (eingabe.equals(wortTrainer.getWort(wortTrainer.getIndex()))) {
                wortTrainer.randomEintrag();
                wortTrainer.addRichtigeWortAnzahl();
                wortTrainer.addWortAnzahl();
                //message dialog mit statistik option und ok option
                JOptionPane.showOptionDialog(null, "Richtig", "Ergebnis", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Statistik", "OK"}, "Statistik");
            } else {
                wortTrainer.addWortAnzahl();
                JOptionPane.showMessageDialog(null, "Falsch", "Ergebnis", JOptionPane.INFORMATION_MESSAGE);
            }
        } while (true);

    }

}
