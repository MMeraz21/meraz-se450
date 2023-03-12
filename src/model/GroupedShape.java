package model;

import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;
import model.persistence.ApplicationState;

import java.awt.*;
import java.util.ArrayList;

public class GroupedShape implements IShape {
    private myPoint p1;
    private myPoint p2;
    private ShapeStackNP shapes;
    private ShapeStack selectedShapes;
    private ShapeStackNP forCopy;
    private IDrawShapeStrategy strategy;
    private ShapeType shapeType;
    private String type;
    public GroupedShape(){
        ShapeStackNP shapes = new ShapeStackNP();
        this.type = "Group";
        this.shapeType = ShapeType.RECTANGLE;
        this.strategy = new RectStrategy();
        this.shapes = shapes;
        //this.selectedShapes = selectedShapes;
        this.p1 = new myPoint();
        this.p2 = new myPoint();
        }

    @Override
    public void draw(Graphics2D graphics2D) {
        RectStrategy thisstrat = new RectStrategy();
        //thisstrat.outlined(p1,p2,graphics2D,Color.BLACK);   //for debugging dont forget to comment out
        for (IShape shape:shapes.shapes()){
            shape.draw(graphics2D);
        }
    }

    @Override
    public void setP1(myPoint point) {
        p1 = point;
    }

    @Override
    public void setP2(myPoint point) {
        p2 = point;
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

    }

    @Override
    public IDrawShapeStrategy getStrat() {
        return this.strategy;
    }

    @Override
    public void setappState(ApplicationState appState) {

    }

    @Override
    public ApplicationState getappState() {
        return null;
    }

    @Override
    public void changecolor() {

    }

    @Override
    public void moveshape(int deltax, int deltay) {
        this.p1.setX(this.p1.getX()+deltax);
        this.p1.setY(this.p1.getY()+deltay);
        this.p2.setX(this.p2.getX()+deltax);
        this.p2.setY(this.p2.getY()+deltay);
        for(IShape shape: shapes.shapes()){
            shape.moveshape(deltax,deltay);
        }
    }

    @Override
    public IShape copy() {
        GroupedShape newshape = new GroupedShape();   //new group shape with copied shapes to be returned
        ShapeStackNP forcopy = new ShapeStackNP();   //need to add copys of shapes in this shape to forcopy
        for(IShape shape : this.getShapes().shapes()){
            forcopy.addShape(shape.copy());
        }
        newshape.addShapes(forcopy.shapes());
        return newshape;
    }

    @Override
    public ShapeType getShapeType() {
        return this.shapeType;
    }

    @Override
    public ShapeShadingType getShapeShadingType() {
        return null;
    }

    @Override
    public Color getPrimaryColor() {
        return null;
    }

    @Override
    public Color getSecondaryColor() {
        return null;
    }

    @Override
    public String getGrouporSingle() {
        return this.type;
    }

    public ShapeStackNP getShapes(){
        return this.shapes;
    }
    public void addShapes(ArrayList<IShape> toadd) {
        //x1 and y1 need to be smallest values
        int newx1;
        int newy1;
        //x2 and y2 need to be largest values
        int newx2;
        int newy2;
        newx1 = toadd.get(0).getP1().getX();
        newy1 = toadd.get(0).getP1().getY();
        newx2 = toadd.get(0).getP2().getX();
        newy2 = toadd.get(0).getP2().getY();
        for (IShape shape : toadd) {   //shapes that make up the bigger shape
            shapes.addShape(shape);
            //if (shape.getP1().getX() <= newx1) {
            if (shape.getP1().getX() <= newx1) {
                newx1 = shape.getP1().getX();
                //this.p1.setX(shape.getP1().getX());
            }
            if (shape.getP2().getX() <= newx1) {  //check both xs, get smallest
                newx1 = shape.getP2().getX();
                //this.p1.setX(shape.getP2().getX());
            }
            if (shape.getP1().getY() <= newy1) {
                newy1 = shape.getP1().getY();
                //this.p1.setY(shape.getP1().getY());
            }
            if (shape.getP2().getY() <= newy1) {  //check both ys, get smallest
                newy1 = shape.getP2().getY();
                //this.p1.setY(shape.getP2().getY());
            }
            if (shape.getP2().getX() >= newx2) {
                newx2 = shape.getP2().getX();
                //this.p2.setX(shape.getP2().getX());
            }
            if (shape.getP1().getX() >= newx2) {   //check both xs, get largest
                newx2 = shape.getP1().getX();
                //this.p2.setX(shape.getP1().getX());
            }
            if (shape.getP2().getY() >= newy2) {
                newy2 = shape.getP2().getY();
                //this.p2.setY(shape.getP2().getY());
            }
            if (shape.getP1().getY() >= newy2) {  //check both ys, get largest
                newy2 = shape.getP1().getY();
                //this.p2.setY(shape.getP1().getY());
            }

        }
        p1.setPoint(newx1, newy1);
        p2.setPoint(newx2, newy2);
//        System.out.println("newx1 = " + this.p1.getX());
//        System.out.println("newy1 = " + this.p1.getY());
//        System.out.println("newx2 = " + this.p2.getX());
//        System.out.println("newy2 = " + this.p2.getY());
    }
    public ShapeStackNP getGroupshapes(){
        return this.shapes;
    }
}
