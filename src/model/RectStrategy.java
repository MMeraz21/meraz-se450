package model;

import model.interfaces.IDrawShapeStrategy;
import view.gui.PaintCanvas;
import java.awt.*;

public class RectStrategy implements IDrawShapeStrategy {
    @Override
    public void filled(myPoint firstPt, myPoint finalPt, Graphics2D graphics2d, Color primarycolor){
        System.out.println("filled reached");
        //Graphics graphics2d = paintCanvas.getGraphics();
        graphics2d.setColor(primarycolor);
        if (firstPt.getX() < finalPt.getX() && firstPt.getY() < finalPt.getY()) {  //top left -> bottom right
            graphics2d.fillRect(firstPt.getX(), firstPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
        }
        if (firstPt.getX() < finalPt.getX() && firstPt.getY() > finalPt.getY()) {  //bottom left -> top right
            graphics2d.fillRect(firstPt.getX(), finalPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
        }
        if (firstPt.getX() > finalPt.getX() && firstPt.getY() < finalPt.getY()) {  //top right -> bottom left
            graphics2d.fillRect(finalPt.getX(), firstPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
        }
        if (firstPt.getX() > finalPt.getX() && firstPt.getY() > finalPt.getY()) {  //bottom right -> top left
            graphics2d.fillRect(finalPt.getX(), finalPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
        }
    }
    @Override
    public void outlined(myPoint firstPt, myPoint finalPt, Graphics2D graphics2d, Color primarycolor){
        //Graphics graphics2d = paintCanvas.getGraphics();
        graphics2d.setColor(primarycolor);
        if (firstPt.getX() < finalPt.getX() && firstPt.getY() < finalPt.getY()) {  //top left -> bottom right
            graphics2d.drawRect(firstPt.getX(), firstPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
        }
        if (firstPt.getX() < finalPt.getX() && firstPt.getY() > finalPt.getY()) {  //bottom left -> top right
            graphics2d.drawRect(firstPt.getX(), finalPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
        }
        if (firstPt.getX() > finalPt.getX() && firstPt.getY() < finalPt.getY()) {  //top right -> bottom left
            graphics2d.drawRect(finalPt.getX(), firstPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
        }
        if (firstPt.getX() > finalPt.getX() && firstPt.getY() > finalPt.getY()) {  //bottom right -> top left
            graphics2d.drawRect(finalPt.getX(), finalPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
        }
    }
    @Override
    public void both(myPoint firstPt, myPoint finalPt, Graphics2D graphics2D, Color primarycolor, Color secondarycolor){
        filled(firstPt,finalPt,graphics2D, primarycolor);
        outlined(firstPt, finalPt, graphics2D, secondarycolor);
    }
}
