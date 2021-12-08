/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deniskharlamov.internship_multithreading.race_game;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Организация гонок. 
 * Все участники должны стартовать одновременно, несмотря на
 * разное время подготовки. В тоннель не может одновременно заехать больше
 * половины участников (условность). Попробуйте все это синхронизировать. Когда
 * все завершат гонку, нужно выдать объявление об окончании. Можно
 * корректировать классы (в том числе конструктор машин) и добавлять объекты
 * классов из пакета util.concurrent. Обязательно необходимо объявить победителя
 * гонки, он должен быть только один, и это участник первым закончивший
 * последний этап.
 *
 */
public class MainClass {

    public static final int CARS_COUNT = 4;
    public static CyclicBarrier cyclicBarrier;
    public static CountDownLatch countDownLatchStart;
    public static CountDownLatch countDownLatchFinish;
    public static final Object MONITOR = new Object();
    public static Lock lock;
    
    private static int winner;
    private static Car carWin;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        winner = 0;
        cyclicBarrier = new CyclicBarrier(CARS_COUNT);
        countDownLatchStart = new CountDownLatch(CARS_COUNT);
        countDownLatchFinish = new CountDownLatch(CARS_COUNT);
        lock = new ReentrantLock();
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            countDownLatchStart.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        synchronized(MONITOR) {
            MONITOR.notifyAll();
        }
        try {
            countDownLatchFinish.await();
        } catch (InterruptedException ex) {
        	ex.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> ПОБЕДИТЕЛЬ: " + carWin.getName());
    }
    
    public static synchronized void addWinner(Car car) {
        if (winner == 0) {
           winner++;
           carWin = car;
        }
    }
}
