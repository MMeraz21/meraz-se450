package model.interfaces;
import model.myPoint;

import view.gui.PaintCanvas;

import java.awt.*;

public interface IDrawShapeStrategy {
    public void filled(myPoint firstPt, myPoint finalPt, Graphics2D graphics2D, Color primarycolor);
    public void outlined(myPoint firstPt, myPoint finalPt, Graphics2D graphics2D, Color primarycolor);
    public void both(myPoint firstPt, myPoint finalPt, Graphics2D graphics2D,Color primarycolor, Color secondarycolor);
}
