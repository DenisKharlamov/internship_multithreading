/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deniskharlamov.internship_multithreading.race_game;

import java.util.concurrent.BrokenBarrierException;

/**
 *
 * @author Ribbonse
 */
public class Car implements Runnable {

    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            MainClass.cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException ex) {
        	ex.printStackTrace();
        }
        MainClass.countDownLatchStart.countDown();
        synchronized(MainClass.MONITOR) {
            try {
                MainClass.MONITOR.wait();
            } catch (InterruptedException ex) {
            	ex.printStackTrace();
            }
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        MainClass.countDownLatchFinish.countDown();
        MainClass.addWinner(this);
    }
}
