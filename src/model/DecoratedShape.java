package model;

import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;
import model.persistence.ApplicationState;

import java.awt.*;

public class DecoratedShape implements IShape {
    ShapeType shapeType;
    private final ApplicationState applicationState;
    IDrawShapeStrategy strat;
    IShape shape;
    myPoint newp1;
    myPoint newp2;
    int height;
    int width;
    int x;
    int y;
    public DecoratedShape(IShape shape){
        //this.strat = shape.getStrat();
        this.shape = shape;
        this.newp1 = new myPoint();
        this.newp2 = new myPoint();
        newp1.setPoint(shape.getP1().getX(),shape.getP1().getY());
        newp2.setPoint(shape.getP2().getX(),shape.getP2().getY());
        this.setappState(shape.getappState());
//        if(shape.getappState().getActiveShapeType() == ShapeType.RECTANGLE){
//            DecoratedRectStrategy newstrat = new DecoratedRectStrategy();
//            this.setStrat(newstrat);
//        }
//        if(shape.getappState().getActiveShapeType() == ShapeType.ELLIPSE){
//            DecoratedEllipStrategy newstrat = new DecoratedEllipStrategy();
//            this.setStrat(newstrat);
//        }
//        height = Math.abs(newp1.getX()- newp2.getX())+10;
//        width = Math.abs(newp1.getY()- newp2.getY()+10);
//        x = newp2.getX();
//        if(newp1.getX()< newp2.getX()){
//            x = newp1.getX();
//        }
//        y = newp2.getY();
//        if(newp1.getY()< newp2.getY()){
//            y = newp1.getY();
//        }

        applicationState = shape.getappState();
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        this.getStrat().outlined(newp1,newp2,graphics2D,Color.BLACK);
    }

    @Override
    public void setP1(myPoint point) {

    }

    @Override
    public void setP2(myPoint point) {

    }

    @Override
    public myPoint getP1() {
        return null;
    }

    @Override
    public myPoint getP2() {
        return null;
    }

    @Override
    public void setStrat(IDrawShapeStrategy strategy) {
        this.strat = strategy;
    }

    @Override
    public IDrawShapeStrategy getStrat() {
        return this.strat;
    }

    @Override
    public void setappState(ApplicationState appState) {
        this.shapeType = shape.getappState().getActiveShapeType();
//        if(shapeType == ShapeType.RECTANGLE){
//            DecoratedRectStrategy newstrat = new DecoratedRectStrategy();
//            this.setStrat(newstrat);
//        }
//        if(shapeType == ShapeType.ELLIPSE){
//            DecoratedEllipStrategy newstrat = new DecoratedEllipStrategy();
//            this.setStrat(newstrat);
//        }
    }

    @Override
    public ApplicationState getappState() {
        return this.applicationState;
    }

    @Override
    public void changecolor() {

    }

    @Override
    public void moveshape(int deltax, int deltay) {

    }

    @Override
    public IShape copy() {
        return null;
    }

    @Override
    public ShapeType getShapeType() {
        return this.shapeType;
    }
}
