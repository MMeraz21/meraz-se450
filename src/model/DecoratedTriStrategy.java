package model;

import model.interfaces.IDrawShapeStrategy;

import java.awt.*;

public class DecoratedTriStrategy implements IDrawShapeStrategy {
    @Override
    public void filled(myPoint firstPt, myPoint finalPt, Graphics2D graphics2D, Color primarycolor) {

    }

    @Override
    public void outlined(myPoint firstPt, myPoint finalPt, Graphics2D graphics2D, Color primarycolor) {
        float[] dash1 = {2f,0f,2f};
        BasicStroke basicStroke = new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,1.0f,dash1,2f);
        graphics2D.setStroke(basicStroke);
        graphics2D.setColor(Color.BLACK);
        if (firstPt.getX() < finalPt.getX() && firstPt.getY() < finalPt.getY()) {  //top left -> bottom right
            int [] xarray = new int[]{firstPt.getX()-10, firstPt.getX()-10, finalPt.getX()+35};
            int [] yarray = new int[]{firstPt.getY()-20, finalPt.getY()+15, finalPt.getY()+12};
            graphics2D.drawPolygon(xarray,yarray,3);
        }
        if (firstPt.getX() < finalPt.getX() && firstPt.getY() > finalPt.getY()) {  //bottom left -> top right
            int [] xarray = new int[]{firstPt.getX()-10, firstPt.getX()-10, finalPt.getX()+35};
            int [] yarray = new int[]{firstPt.getY()+20, finalPt.getY()-15, finalPt.getY()-12};
            graphics2D.drawPolygon(xarray,yarray,3);
        }
        if (firstPt.getX() > finalPt.getX() && firstPt.getY() < finalPt.getY()) {  //top right -> bottom left
            int [] xarray = new int[]{firstPt.getX()+10, firstPt.getX()+10, finalPt.getX()-35};
            int [] yarray = new int[]{firstPt.getY()-20, finalPt.getY()+15, finalPt.getY()+12};
            graphics2D.drawPolygon(xarray,yarray,3);        }
        if (firstPt.getX() > finalPt.getX() && firstPt.getY() > finalPt.getY()) {  //bottom right -> top left
            int [] xarray = new int[]{firstPt.getX()+10, firstPt.getX()+10, finalPt.getX()-35};
            int [] yarray = new int[]{firstPt.getY()+20, finalPt.getY()-15, finalPt.getY()-12};
            graphics2D.drawPolygon(xarray,yarray,3);        }
    }

    @Override
    public void both(myPoint firstPt, myPoint finalPt, Graphics2D graphics2D, Color primarycolor, Color secondarycolor) {

    }
}
