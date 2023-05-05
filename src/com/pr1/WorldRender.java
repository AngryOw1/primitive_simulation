package com.pr1;

import com.pr1.creatures.Herbivore;
import com.pr1.creatures.Predator;
//Перезаписывать каждую новую строку (делать все в одном фрейме)
public class WorldRender {
    public static final String RESET_COLOR = "\u001b[0m"; //reset color
    public static final String GROUND_COLOR = "\033[40m"; //black grey  "\u001b[47m"
    public static final String TREE_COLOR = "\u001b[32m"; //green
    public static final String ROCK_COLOR = "\033[1;90m"; //black or gray \033[0;90m "\u001b[30m"
    public static final String PREDATOR_COLOR = "\u001B[31m"; //red
    public static final String HERBIVORE_COLOR = "\u001B[93m";  //yellow
    public static final String GRASS_COLOR = "\033[1;34m"; //blue



    public static final String GRASS_ICON = "\uD83C\uDF30"; //🍀
    public static final String TREE_ICON = "\uD83C\uDF33"; //🌳
    public static final String ROCK_ICON = "\uD83D\uDDFB"; //🗻
    public static final String PREDATOR_ICON = "\uD83D\uDC06"; //🐆
    public static final String HERBIVORE_ICON = "\uD83D\uDC16"; //🐖



    public void render(Island island){
        for (int x = 1; x <= island.size; x++) {
            String currentLine = "";

            for (int y = 1; y <= island.size ; y++) {
                Coordinates coordinates = new Coordinates(x, y);

                if (island.isSquareEmpty(coordinates)){
                    currentLine += getColorForSquare(coordinates); //добавляем пустое закрашеное поле
                }else{
                    currentLine += getEntitySprite(island.getEntity(coordinates));
                }

            }
            currentLine += RESET_COLOR;
            System.out.println(currentLine);

        }
    }

    //установка иконки под каждый объект
    private String selectIconForEntity(Entity entity) {
        if(entity instanceof Tree) {
            return "\u001B[1m" + TREE_COLOR + TREE_ICON; //tree
        } else if(entity instanceof Rock) {
            return "\u001B[1m" + ROCK_COLOR + ROCK_ICON; //rock
        } else if(entity instanceof Herbivore) {
            return HERBIVORE_COLOR + HERBIVORE_ICON ; //pig
        } else if(entity instanceof Predator) {
            return PREDATOR_COLOR + PREDATOR_ICON; //tiger
        } else if(entity instanceof Grass) {
            return GRASS_COLOR + GRASS_ICON; //grass
        }
        return "UFO";
    }

    //установка спрайта расставленных объектов
    private String getEntitySprite(Entity entity) {
        return renderMapGround(" " + selectIconForEntity(entity) + ""); //фон + спрайт конкретного объекта
    }

    ////фон + спрайт
    private String renderMapGround(String sprite) {
        String result = sprite;
        result = GROUND_COLOR + result + RESET_COLOR;
        return result;
    }

    private String getColorForSquare(Coordinates coordinates) {
        return renderMapGround(" - ");                  //клетка без объекта
    }

}
