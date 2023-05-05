package com.pr1.creatures;

import com.pr1.Coordinates;
import com.pr1.CoordinatesShift;
import com.pr1.Grass;
import com.pr1.Island;

import java.util.*;
//доработать логику хода - ход не должен заканчиваться рядом с хищником

public class Herbivore extends Creature {
    public Herbivore(Coordinates coordinates, int health, int speed) {
        super(coordinates, health, speed);
    }

    @Override
    public ArrayList<CoordinatesShift> zoneFlair() {   //радиус обнаружения ресурса (1)
        return new ArrayList<>(Arrays.asList(
                new CoordinatesShift(-1, 0),
                new CoordinatesShift(0, 1),
                new CoordinatesShift(-1, -1),
                new CoordinatesShift(-1, 1),
                new CoordinatesShift(1, 0),
                new CoordinatesShift(1, -1),
                new CoordinatesShift(0, -1),
                new CoordinatesShift(1, 1)
        ));
    }
    
    public void getResource(Island island){
        List<Coordinates> resource = new ArrayList<>();

        for (CoordinatesShift flairShift : zoneFlair()) {
            Coordinates newCoordinates = coordinates.shift(flairShift);
            if(island.getEntity(newCoordinates) instanceof Grass){
                island.removeEntity(newCoordinates);
            }

        }
    }



    //Стремятся найти ресурс (траву), может потратить свой ход на движение в сторону травы, либо на её поглощение.

    public ArrayList<CoordinatesShift> getCreatureMoves(){      //логика выбора хода без проверки доступности клетки
        return new ArrayList<>(Arrays.asList(
                new CoordinatesShift(-1, 0),
                new CoordinatesShift(0, 1),
                // new CoordinatesShift(-1, -1),
                // new CoordinatesShift(-1, 1),
                new CoordinatesShift(1, 0),
                // new CoordinatesShift(1, -1),
                new CoordinatesShift(0, -1)
                // new CoordinatesShift(1, 1)
        ));
    }

}
