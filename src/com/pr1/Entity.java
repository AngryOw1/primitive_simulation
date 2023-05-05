package com.pr1;

public abstract class Entity { //абстрактный класс, базовый для всех объектов (живых в том числе)
    public Coordinates coordinates;


    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


}
