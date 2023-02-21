package model;

import model.interfaces.IDrawShapeStrategy;

import java.awt.*;

public class DecoratedRectStrategy implements IDrawShapeStrategy {
    @Override
    public void filled(myPoint firstPt, myPoint finalPt, Graphics2D graphics2D, Color primarycolor) {

    }

    @Override
    public void outlined(myPoint newp1, myPoint newp2, Graphics2D graphics2D, Color primarycolor) {
        float[] dash1 = {2f,0f,2f};
        BasicStroke basicStroke = new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,1.0f,dash1,2f);
        graphics2D.setStroke(basicStroke);
        graphics2D.setColor(Color.BLACK);
        if (newp1.getX() < newp2.getX() && newp1.getY() < newp2.getY()) {  //top left -> bottom right
            graphics2D.drawRect(newp1.getX()-10, newp1.getY()-10, Math.abs(newp1.getX() - newp2.getX())+20, Math.abs(newp2.getY() - newp1.getY())+20);
        }
        if (newp1.getX() < newp2.getX() && newp1.getY() > newp2.getY()) {  //bottom left -> top right
            graphics2D.drawRect(newp1.getX()-10, newp2.getY()-10, Math.abs(newp1.getX() - newp2.getX())+20, Math.abs(newp2.getY() - newp1.getY())+20);
        }
        if (newp1.getX() > newp2.getX() && newp1.getY() < newp2.getY()) {  //top right -> bottom left
            graphics2D.drawRect(newp2.getX()-10, newp1.getY()-10, Math.abs(newp1.getX() - newp2.getX())+20, Math.abs(newp2.getY() - newp1.getY())+20);
        }
        if (newp1.getX() > newp2.getX() && newp1.getY() > newp2.getY()) {  //bottom right -> top left
            graphics2D.drawRect(newp2.getX()-10, newp2.getY()-10, Math.abs(newp1.getX() - newp2.getX())+20, Math.abs(newp2.getY() - newp1.getY())+20);
        }
    }

    @Override
    public void both(myPoint firstPt, myPoint finalPt, Graphics2D graphics2D, Color primarycolor, Color secondarycolor) {

    }
}
