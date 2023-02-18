package model;

import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import model.myPoint;
import view.gui.PaintCanvas;
import model.ShapeType;
import model.GetColor;

import java.awt.*;

public class Shape implements IShape {
    private myPoint p1;
    private myPoint p2;
    //private PaintCanvas paintCanvas;
    private IDrawShapeStrategy currStrategy;
    private ApplicationState appState;
    private ShapeType shapeType;
    private ShapeShadingType shapeShadingType;
    private Color PrimaryColor;
    private Color SecondaryColor;
    @Override
    public void draw(Graphics2D graphics2D) {
        //this.paintCanvas = paintcanvas;
        if(shapeShadingType.equals(ShapeShadingType.FILLED_IN)) {
            //System.out.println("filled in reached in shape.java");
            currStrategy.filled(p1, p2, graphics2D,PrimaryColor);
        }
        if(shapeShadingType == ShapeShadingType.OUTLINE){
            //System.out.println("outlined reached");
            currStrategy.outlined(p1,p2,graphics2D, PrimaryColor);
        }
        if(shapeShadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN){
            //System.out.println("both reached");
            currStrategy.both(p1,p2,graphics2D, PrimaryColor,SecondaryColor);
        }
    }

    @Override
    public void setP1(myPoint point) {
        this.p1 = point;
    }

    @Override
    public void setP2(myPoint point) {
        this.p2 = point;
    }

    @Override
    public myPoint getP1() {
        return this.p1;
    }

    @Override
    public myPoint getP2() {
        return this.p2;
    }

    @Override
    public void setStrat(IDrawShapeStrategy strategy) {
        this.currStrategy = strategy;
    }

    @Override
    public IDrawShapeStrategy getStrat() {
        return this.currStrategy;
    }

    @Override
    public void setappState(ApplicationState appState) {
        this.appState = appState;
        this.shapeShadingType = appState.getActiveShapeShadingType();
        this.shapeType = appState.getActiveShapeType();
        this.PrimaryColor = GetColor.getColor(appState.getActivePrimaryColor());
        this.SecondaryColor = GetColor.getColor(appState.getActiveSecondaryColor());
    }

    @Override
    public ApplicationState getappState() {
        return this.appState;
    }
    @Override
    public void changecolor(){
        this.PrimaryColor = Color.RED;  //used for debugging :)
    }
    @Override
    public void moveshape(int deltax, int deltay){
//        int deltax = p2.getX() - p1.getX();
//        int deltay = p2.getY() - p1.getY();
        this.p1.setX(this.p1.getX()+deltax);
        this.p1.setY(this.p1.getY()+deltay);
        this.p2.setX(this.p2.getX()+deltax);
        this.p2.setY(this.p2.getY()+deltay);
    }

    @Override
    public IShape copy() {
    Shape newshape = new Shape();
    myPoint newp1 = new myPoint();
    myPoint newp2 = new myPoint();
    newp1.setPoint(p1.getX()+20,p1.getY()+20);
    newp2.setPoint(p2.getX()+20,p2.getY()+20);
        if (shapeType == ShapeType.RECTANGLE){
            newshape = shapeFactory.createRect(newp1,newp2, appState);
        }
        if(shapeType == ShapeType.ELLIPSE){
            newshape = shapeFactory.createEllipse(newp1,newp2,appState);
        }
        if(shapeType == ShapeType.TRIANGLE){
            newshape = shapeFactory.createTriangle(newp1,newp2,appState);
        }
    //newshape.setappState(appState);
//    newshape.setP1(p1);
//    newshape.setP2(p2);
//    int offsetp1x = p1.getX()+20;
//    int offsetp1y = p1.getY()+20;
//    newshape.getP1().setPoint(offsetp1x,offsetp1y);
//    int offsetp2x = p2.getX()+20;
//    int offsetp2y = p2.getY()+20;
//    newshape.getP2().setPoint(offsetp2x,offsetp2y);
//    newshape.setStrat(currStrategy);
    return newshape;
    }

}
