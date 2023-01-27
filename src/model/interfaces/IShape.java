package model.interfaces;
import model.myPoint;
import view.gui.PaintCanvas;

public interface IShape {
     //myPoint p1 = new myPoint();  //first point
     //uncomment out later
     //public void getP1(int x, int y);
     //public void getP2(int x, int y);
    //public void setP1();
    //public void setP2();

    void draw(myPoint firstPt, myPoint finalPt, PaintCanvas paintcanvas);

    void setP1(myPoint point);

    void setP2(myPoint point);
    //void draw();
    myPoint getP1();
    myPoint getP2();
}
