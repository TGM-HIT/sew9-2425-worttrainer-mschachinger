package org.example;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.example.*;
import org.example.view.WorttrainerView;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WortTrainerTest {
    @Test
    @DisplayName("Test 1 | Check URL Test")
    public void checkURLTest() {
        WortEintrag we = new WortEintrag("Baum", "https://www.freepnglogos.com/uploads/tree-png/no-background-tree-3.jpg");
        assertTrue(we.checkURL("https://www.freepnglogos.com/uploads/tree-png/no-background-tree-3.jpg"));
    }




}
