package org.example;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Speichern und Laden des aktuellen Zustands des Worttrainers mithilfe einer JSON-Datei
 */
public class WortTrainerSave {
    private WortTrainer wt;

    public WortTrainerSave(WortTrainer wt) {
        this.wt = wt;
    }

    /**
     * Speichern der zur Verfügung stehenden Wort-Bild-Paaren,
     * dem aktuell ausgewählten Paar (falls vorhanden) sowie der aktuellen Statistik
     * in einer JSON-Datei
     */
    public void save() {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        for(int i = 0; i < wt.length(); i++) {
            jsonObject.put(wt.getWort(i), wt.getUrl(i));
            jsonArray.put(jsonObject);
            jsonObject = new JSONObject();
        }


        int index = wt.getIndex();
        if(index != -1) {
            jsonObject.put("Index", index);
        }

        jsonObject.put("Richtige Wörter", wt.getRichtigeWortAnzahl());
        jsonObject.put("Insgesamt", wt.getWortAnzahl());

        jsonArray.put(jsonObject);

        try (FileWriter file = new FileWriter("worttrainerSave.json")) {
            file.write(jsonArray.toString());
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben: " + e.toString());
        }
    }

    /**
     * Laden des aktuellen Zustands des Worttrainers aus einer JSON-Datei
     */
    public void load() {
        try (FileReader reader = new FileReader("worttrainerSave.json")) {
            JSONArray jsonArray = new JSONArray(new JSONTokener(reader));

            for (int i = 0; i < jsonArray.length() - 1; i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String wort = jsonObject.keys().next();
                String url = jsonObject.getString(wort);
                wt.add(wort, url);
            }

            JSONObject jsonObject = jsonArray.getJSONObject(jsonArray.length() - 1);
            if (jsonObject.has("Index")) {
                wt.setIndex(jsonObject.getInt("Index"));
            }
            if (jsonObject.has("Richtige Wörter")) {
                wt.setRichtigeWortAnzahl(jsonObject.getInt("Richtige Wörter"));
            }
            if (jsonObject.has("Insgesamt")) {
                wt.setWortAnzahl(jsonObject.getInt("Insgesamt"));
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Laden: " + e.toString());
        }
    }

}
