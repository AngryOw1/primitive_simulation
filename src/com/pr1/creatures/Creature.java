package com.pr1.creatures;

import com.pr1.*;

import java.util.*;
//реалищовать голод (в симуляции привязать к счетчику зодов)

//Кушает ресурс только если здоровье неполное

//доработать логику хода что бы не бегал обратно

//добавить размножение ?

public abstract class Creature extends Entity {
    boolean haveMotion = true;
    int health;
    int speed;
    Random random = new Random();

    public boolean checkTurn() {     //проверка выполнялся ход или нет
        return this.haveMotion;
    }

    public void doneMotion() {      //пометить что ход был выполнен
        this.haveMotion = false;
    }

    public void prepareMotion(){
        this.haveMotion = true;
    }

    public Creature(Coordinates coordinates, int health, int speed) {
        super(coordinates);
        this.health = health;
        this.speed = speed;
    }

    public void makeMove(Island island) throws InterruptedException {
        WorldRender render = new WorldRender();

        //учитываем скорость существа
        for (int i = 0; i < this.speed ; i++) {
            List<Coordinates> availableMoveSquares = this.getListMove(island);  //список доступных координат для хода
            int index = random.nextInt(availableMoveSquares.size());    //рандом индекс координат в листе
            Coordinates stepTo = availableMoveSquares.get(index);   //куда делает ход
            Coordinates stepFrom = this.coordinates;    //откуда делает ход
            Creature creature = this;


            //совершаем ход
            island.removeEntity(stepFrom);
            island.setEntity(stepTo, creature);

            //рендер кадра + ждем
            render.render(island);
            Thread.sleep(100);
            creature.getResource(island);

            System.out.println("=============================");
            Thread.sleep(500);
        }
        this.doneMotion();  //отметили о выполнении хода
    }

    public abstract ArrayList<CoordinatesShift> zoneFlair();

    public abstract void getResource(Island island);


    public List<Coordinates> getListMove(Island island){
        List<Coordinates> result = new ArrayList<>();

        for (CoordinatesShift shift: getCreatureMoves()) {
            if(coordinates.canShift(shift, island)) {
                Coordinates newCoordinates = coordinates.shift(shift); //координаты сдвига
                if(island.isSquareEmpty(newCoordinates)){   //если ход доступен добавляем сдвиг
                    result.add(newCoordinates);
                }
            }
        }
        return result;
    }


    public abstract ArrayList<CoordinatesShift> getCreatureMoves();


}
