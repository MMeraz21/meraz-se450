package model.interfaces;
import model.ShapeType;
import model.myPoint;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

import java.awt.*;

public interface IShape {
     //myPoint p1 = new myPoint();  //first point
     //uncomment out later
     //public void getP1(int x, int y);
     //public void getP2(int x, int y);
    //public void setP1();
    //public void setP2();

    void draw(Graphics2D graphics2D);

    void setP1(myPoint point);

    void setP2(myPoint point);
    myPoint getP1();
    myPoint getP2();
    void setStrat(IDrawShapeStrategy strategy);
    IDrawShapeStrategy getStrat();
    void setappState(ApplicationState appState);
    ApplicationState getappState();
    void changecolor();
    void moveshape(int deltax, int deltay);
    IShape copy();
    ShapeType getShapeType();

    }

