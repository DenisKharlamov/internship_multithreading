/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deniskharlamov.internship_multithreading.race_game;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Ribbonse
 */
public class Race {

    private ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
