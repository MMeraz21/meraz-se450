package model;

import model.interfaces.IDrawShapeStrategy;
import view.gui.PaintCanvas;
import java.awt.*;
import java.awt.*;

public class TriStrategy implements IDrawShapeStrategy {
    @Override
    public void filled(myPoint firstPt, myPoint finalPt, Graphics2D graphics2d, Color primarycolor) {
        graphics2d.setColor(primarycolor);
        int [] xarray = new int[]{firstPt.getX(), firstPt.getX(), finalPt.getX()};
        int [] yarray = new int[]{firstPt.getY(), finalPt.getY(), finalPt.getY()};
        graphics2d.fillPolygon(xarray,yarray,3);
    }

    @Override
    public void outlined(myPoint firstPt, myPoint finalPt, Graphics2D graphics2d, Color primarycolor) {
        graphics2d.setColor(primarycolor);
        int [] xarray = new int[]{firstPt.getX(), firstPt.getX(), finalPt.getX()};
        int [] yarray = new int[]{firstPt.getY(), finalPt.getY(), finalPt.getY()};
        graphics2d.drawPolygon(xarray,yarray,3);
    }

    @Override
    public void both(myPoint firstPt, myPoint finalPt, Graphics2D graphics2d, Color primarycolor, Color secondarycolor) {
        filled(firstPt,finalPt,graphics2d, primarycolor);
        outlined(firstPt, finalPt, graphics2d, secondarycolor);
    }
}
