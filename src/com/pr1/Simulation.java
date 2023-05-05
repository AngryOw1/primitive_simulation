package com.pr1;

import com.pr1.creatures.Creature;

//реалищовать голод привязать к счетчику зодов

//рост (респ) новой травы ?

//конец симуляции если все вымерли

public class Simulation {

    private final Island island;
    private WorldRender wRender = new WorldRender();
    private int count = 1;
    public Simulation(Island island) {
        this.island = island;
    }

    public void startSimulation() throws InterruptedException {

        wRender.render(island); //отображение карты до начала хода
        Thread.sleep(2000);

        while (true){
            System.out.println("==============================");
            System.out.println("            Turn: " + count++); //счетчик ходов
            System.out.println("==============================");

            for (int x = 1; x <= island.size; x++) {
                for (int y = 1; y <= island.size ; y++) {
                    Coordinates coordinates = new Coordinates(x, y);
                    if((island.getEntity(coordinates) instanceof Creature) && ((Creature) island.getEntity(coordinates)).checkTurn() == true){
                        ((Creature) island.getEntity(coordinates)).makeMove(island);
                    }
                    if ((coordinates.x == island.size) && (coordinates.y == island.size)){
                        resetMotions();
                    }
                }
            }
        }
    }

    private void resetMotions(){
        for (int x = 1; x <= island.size; x++) {
            for (int y = 1; y <= island.size ; y++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (island.getEntity(coordinates) instanceof Creature){
                    ((Creature)island.getEntity(coordinates)).prepareMotion();
                }
            }
        }
    }
}
