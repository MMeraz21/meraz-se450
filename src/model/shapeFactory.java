package model;

import model.interfaces.IShape;
import model.ShapeStack;
import model.interfaces.IShape;
import model.Rectangle;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

import java.awt.*;
import java.util.ArrayList;
import model.ShapeShadingType;
import model.myPoint;
import model.EllipseStrategy;
public class shapeFactory{

    public static Shape createRect(myPoint firstPt, myPoint finalPt, ApplicationState appState){
        //Rectangle newrect = new Rectangle();
        Shape newrect = new Shape();
        newrect.setP1(firstPt);
        newrect.setP2(finalPt);
        RectStrategy rectStrategy = new RectStrategy();
        newrect.setStrat(rectStrategy);
        newrect.setappState(appState);
        return newrect;
        }
        public static Shape createEllipse(myPoint firstPt, myPoint finalPt, ApplicationState appState){
        Shape newellipse = new Shape();
        newellipse.setP1(firstPt);
        newellipse.setP2(finalPt);
        EllipseStrategy ellipStrategy = new EllipseStrategy();
        newellipse.setStrat(ellipStrategy);
        newellipse.setappState(appState);
        return newellipse;
        }
        public static Shape createTriangle(myPoint firstPt, myPoint finalPt, ApplicationState appState){
        Shape newtri = new Shape();
        newtri.setP1(firstPt);
        newtri.setP2(finalPt);
        TriStrategy triStrategy = new TriStrategy();
        newtri.setStrat(triStrategy);
        newtri.setappState(appState);
        return newtri;
        }
    }

