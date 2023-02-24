package model;

import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;
import model.persistence.ApplicationState;

import java.awt.*;

public class DecoratedShape implements IShape {
    ShapeType shapeType;
    ApplicationState applicationState;
    IDrawShapeStrategy strat;
    IShape shape;
    myPoint newp1;
    myPoint newp2;

    public DecoratedShape(IShape shape){
        //this.strat = shape.getStrat();
        this.shape = shape;
        this.newp1 = new myPoint();
        this.newp2 = new myPoint();
        newp1.setPoint(shape.getP1().getX(),shape.getP1().getY());
        newp2.setPoint(shape.getP2().getX(),shape.getP2().getY());
        this.setappState(shape.getappState());
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
