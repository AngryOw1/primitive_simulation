package com.pr1;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        Island island = new Island();
        island.setupDefaultEntities();

        Simulation simulation = new Simulation(island);
        simulation.startSimulation();

    }
}
