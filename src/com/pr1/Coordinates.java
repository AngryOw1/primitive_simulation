package com.pr1;

public class Coordinates {
    //координаты объектов
    public final Integer x; //паблик что бы обойтись без геттеров
    public final Integer y;

    public Coordinates(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates shift(CoordinatesShift shift){
        return new Coordinates(this.x + shift.shiftX, this.y + shift.shiftY);
    }

    //проверка выхода за предел поля
    public boolean canShift(CoordinatesShift shift, Island island) {
        int x = this.x + shift.shiftX;
        int y = this.y + shift.shiftY;
        if( (x <= 0) || (x > island.size)) {return false;}
        if( (y <= 0) || (y > island.size)) {return false;}

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (x != that.x) return false;
        return y.equals(that.y);
    }

    @Override
    public int hashCode() {
        int result = x.hashCode();
        result = 31 * result + y.hashCode();
        return result;
    }
}
