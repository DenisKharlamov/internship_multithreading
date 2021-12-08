package com.deniskharlamov.internship_multithreading.hippodrome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hippodrome {

	public static Hippodrome game;

	private List<Horse> horses;

	public Hippodrome() {
	}

	public static void main(String[] args) {

		Hippodrome.game = new Hippodrome();
		List<Horse> horses = new ArrayList<>();
		Collections.addAll(horses, 
				new Horse("Fancy", 3, 0), 
				new Horse("Sugar", 3, 0), 
				new Horse("Tucker", 3, 0));
		Hippodrome.game.setHorses(horses);
		Hippodrome.game.run();
		Hippodrome.game.printWinner();
	}
	
	public void run() {
		for (int i = 0; i < 50; i++) {
			move();
			print();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void move() {
		horses.forEach(h -> h.move());
	}
	
	public void print() {
		System.out.println("\n\n\n");
		horses.forEach(h -> h.print());
	}
	
	public Horse getWinner() {
		return horses.stream().sorted(Collections.reverseOrder()).findFirst().get();
	}
	
	public void printWinner() {
		System.out.println("\n\n\n");
		System.out.println("Winner is " + getWinner().getName() + " !");
		System.out.println("\n\n");
	}

	public List<Horse> getHorses() {
		return horses;
	}

	public void setHorses(List<Horse> horses) {
		this.horses = horses;
	}
}
