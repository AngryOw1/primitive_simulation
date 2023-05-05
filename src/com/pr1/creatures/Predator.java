package com.pr1.creatures;

import com.pr1.Coordinates;
import com.pr1.CoordinatesShift;
import com.pr1.Grass;
import com.pr1.Island;

import java.util.*;

public class Predator extends Creature {
    // На что может потратить ход хищник:
    // Переместиться (чтобы приблизиться к жертве - травоядному)
    // Атаковать травоядное. При этом количество HP травоядного уменьшается на силу атаки хищника.
    // Если значение HP жертвы опускается до 0, травоядное исчезает
    int atackPower;

    public Predator(Coordinates coordinates, int health, int speed, int atackPower) {
        super(coordinates, health, speed);
        this.atackPower = atackPower;
    }

    @Override
    public ArrayList<CoordinatesShift> zoneFlair() {    //радиус обнаружения ресурса (1)
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
            if(island.getEntity(newCoordinates) instanceof Herbivore){
                island.removeEntity(newCoordinates);
            }

        }
    }


    public ArrayList<CoordinatesShift> getCreatureMoves(){
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
}
