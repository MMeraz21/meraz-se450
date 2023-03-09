package model;

import model.persistence.ApplicationState;
import model.interfaces.IShape;

public class DecoratedShapeFactory {
    public static DecoratedShape createRect(myPoint firstPt, myPoint finalPt, ApplicationState appState, IShape shape){
        //Rectangle newrect = new Rectangle();
        DecoratedShape newrect = new DecoratedShape(shape);
        newrect.setP1(firstPt);
        newrect.setP2(finalPt);
        DecoratedRectStrategy rectStrategy = new DecoratedRectStrategy();
        newrect.setStrat(rectStrategy);
        //newrect.setappState(appState);
        return newrect;
    }
    public static DecoratedShape createEllipse(myPoint firstPt, myPoint finalPt, ApplicationState appState, IShape shape){
        DecoratedShape newellipse = new DecoratedShape(shape);
        newellipse.setP1(firstPt);
        newellipse.setP2(finalPt);
        DecoratedEllipStrategy ellipStrategy = new DecoratedEllipStrategy();
        newellipse.setStrat(ellipStrategy);
        //newellipse.setappState(appState);
        return newellipse;
    }
    public static DecoratedShape createTriangle(myPoint firstPt, myPoint finalPt, ApplicationState appState, IShape shape){
        DecoratedShape newtri = new DecoratedShape(shape);
        newtri.setP1(firstPt);
        newtri.setP2(finalPt);
        DecoratedTriStrategy triStrategy = new DecoratedTriStrategy();
        newtri.setStrat(triStrategy);
        //newtri.setappState(appState);
        return newtri;
    }
}
