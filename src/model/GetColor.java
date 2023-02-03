package model;
import model.ShapeColor;
import java.awt.*;

public class GetColor {

    public static Color getColor(ShapeColor color){
        if(color == ShapeColor.BLACK){
            return Color.BLACK;
        }
        if(color == ShapeColor.BLUE){
            return Color.BLUE;
        }
        if(color == ShapeColor.CYAN){
            return Color.CYAN;
        }
        if(color == ShapeColor.GRAY){
            return Color.GRAY;
        }
        if(color == ShapeColor.DARK_GRAY){
            return Color.DARK_GRAY;
        }
        if(color == ShapeColor.GREEN){
            return Color.GREEN;
        }
        if(color == ShapeColor.LIGHT_GRAY){
            return Color.LIGHT_GRAY;
        }
        if(color == ShapeColor.MAGENTA){
            return Color.MAGENTA;
        }
        if(color == ShapeColor.ORANGE){
            return Color.ORANGE;
        }
        if(color == ShapeColor.PINK){
            return Color.PINK;
        }
        if(color == ShapeColor.RED){
            return Color.RED;
        }
        if(color == ShapeColor.WHITE){
            return Color.WHITE;
        }
        if(color == ShapeColor.YELLOW){
            return Color.YELLOW;
        }
        else return Color.BLACK;
    }
}
