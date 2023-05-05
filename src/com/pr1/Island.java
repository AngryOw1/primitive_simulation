package com.pr1;

import com.pr1.creatures.Herbivore;
import com.pr1.creatures.Predator;

import java.util.HashMap;

public class Island {
    public final int size = 10; //размер острова (сторона квадрата)
    HashMap<Coordinates, Entity> entityObjects = new HashMap<>();

    //установить объект/существо
    public void setEntity(Coordinates coordinates, Entity entityObject){
        entityObject.coordinates = coordinates;             //координаты записаны не только в карте но и в самом объекте, туда их и дублируем
        entityObjects.put(coordinates, entityObject);
    }

    public void removeEntity(Coordinates coordinates){
        entityObjects.remove(coordinates);
    }

    //проверка пустая клетка или нет
    public boolean isSquareEmpty(Coordinates coordinates) {
        return !entityObjects.containsKey(coordinates);
    }

    //получить объект по координатам
    public Entity getEntity(Coordinates coordinates) {
        return entityObjects.get(coordinates);
    }

    //расстановка по умолчанию
    public void setupDefaultEntities(){

        int speedPig = 4;       //значения скорости по умолчанию
        int speedTiger = 3;

        //стадо травоядных
        setEntity(new Coordinates(4, 2), new Herbivore(new Coordinates(4, 2), 10, speedPig));
        setEntity(new Coordinates(3, 4), new Herbivore(new Coordinates(3, 4), 10, speedPig));
        setEntity(new Coordinates(2, 2), new Herbivore(new Coordinates(2, 2), 10, speedPig));
        setEntity(new Coordinates(6, 8), new Herbivore(new Coordinates(6, 8), 10, speedPig));

        //стая хищников
        setEntity(new Coordinates(9, 10), new Predator(new Coordinates(9, 10), 5, speedTiger, 5));
        setEntity(new Coordinates(10, 10), new Predator(new Coordinates(10, 10), 5, speedTiger, 5));
        setEntity(new Coordinates(9, 5), new Predator(new Coordinates(9, 5), 5, speedTiger, 5));

        //деревья
        setEntity(new Coordinates(1, 10), new Tree(new Coordinates(1, 10)));
        setEntity(new Coordinates(3, 3), new Tree(new Coordinates(3, 3)));
        setEntity(new Coordinates(3, 7), new Tree(new Coordinates(3, 7)));
        setEntity(new Coordinates(4, 6), new Tree(new Coordinates(4, 6)));
        setEntity(new Coordinates(10, 1), new Tree(new Coordinates(10, 1)));
        setEntity(new Coordinates(10, 2), new Tree(new Coordinates(10, 2)));

        setEntity(new Coordinates(8, 6), new Tree(new Coordinates(8, 6)));
        setEntity(new Coordinates(9, 6), new Tree(new Coordinates(9, 6)));

        //скалы
        setEntity(new Coordinates(7, 6), new Rock(new Coordinates(7, 6)));
        setEntity(new Coordinates(9, 8), new Rock(new Coordinates(9, 8)));
        setEntity(new Coordinates(10, 8), new Rock(new Coordinates(10, 8)));
        setEntity(new Coordinates(10, 9), new Rock(new Coordinates(10, 9)));

        //трава
        setEntity(new Coordinates(2, 1), new Grass(new Coordinates(2, 1)));
        setEntity(new Coordinates(1, 2), new Grass(new Coordinates(1, 2)));
        setEntity(new Coordinates(2, 4), new Grass(new Coordinates(2, 4)));
        setEntity(new Coordinates(6, 1), new Grass(new Coordinates(6, 1)));
        setEntity(new Coordinates(6, 3), new Grass(new Coordinates(6, 3)));
        setEntity(new Coordinates(8, 2), new Grass(new Coordinates(8, 2)));
        setEntity(new Coordinates(8, 3), new Grass(new Coordinates(8, 3)));
        setEntity(new Coordinates(9, 3), new Grass(new Coordinates(9, 3)));
        setEntity(new Coordinates(2, 8), new Grass(new Coordinates(2, 8)));
        setEntity(new Coordinates(4, 7), new Grass(new Coordinates(4, 7)));
        setEntity(new Coordinates(6, 9), new Grass(new Coordinates(5, 9)));
        setEntity(new Coordinates(7, 7), new Grass(new Coordinates(7, 7)));
        setEntity(new Coordinates(10, 7), new Grass(new Coordinates(10, 7)));
        setEntity(new Coordinates(3, 6), new Grass(new Coordinates(3, 6)));

    }

    //расстановка объектов случайным образом
    public void setupRandomEntities(){
        //использовать список
    }

    //генерация ландшафвта горы, деревья, размер карты (возможно добавить озера)
    public void setupRandomIsland(){
        //использовать список
    }

}
