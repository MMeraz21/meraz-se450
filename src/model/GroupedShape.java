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
    private ShapeStack forCopy;
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
//        //x1 and y1 need to be smallest values
//        int newx1 = 10000;
//        int newy1 = 10000;
//        //x2 and y2 need to be largest values
//        int newx2 = -1;
//        int newy2 = -1;
//        for(IShape shape: selectedShapes.shapes()){   //shapes that make up the bigger shape
//            shapes.addShape(shape);
//            //forCopy.addShape(shape);
//            if(shape.getP1().getX() <= newx1){
//                //p1.setPoint(shape.getP1().getX(),shape.getP1().getY());
//                newx1 = shape.getP1().getX();
//            }
//            if(shape.getP2().getX() <= newx1){  //check both xs, get smallest
//                newx1 = shape.getP2().getX();
//            }
//            if(shape.getP1().getY() <= newy1){
//                newy1 = shape.getP1().getY();
//            }
//            if(shape.getP2().getY() <= newy1){  //check both ys, get smallest
//                newy1 = shape.getP2().getY();
//            }
//            if(shape.getP2().getX() >= newx2){
//                //p1.setPoint(shape.getP2().getX(),shape.getP2().getY());
//                newx2 = shape.getP2().getX();
//            }
//            if(shape.getP1().getX() >= newx2){   //check both xs, get largest
//                newx2 = shape.getP1().getX();
//            }
//            if(shape.getP2().getY() >= newy2){
//                //p2.setPoint(shape.getP2().getX(),shape.getP2().getY());
//                newy2 = shape.getP2().getY();
//            }
//            if(shape.getP1().getY() >= newy2){  //check both ys, get largest
//                newy2 = shape.getP1().getY();
//            }
//
//        }
//        p1.setPoint(newx1,newy1);
//        p2.setPoint(newx2,newy2);
//        System.out.println("newx1 = " + newx1);
//        System.out.println("newy1 = " + newy1);
//        System.out.println("newx2 = " + newx2);
//        System.out.println("newy2 = " + newy2);
//        for(IShape shape:shapes.shapes()){//rename shapes its confusing!!!
//            selectedShapes.removeShape(shape);
//                                            //need to remove shapes from shapestack so that their draw method isnt triggered

        }

    @Override
    public void draw(Graphics2D graphics2D) {
        RectStrategy thisstrat = new RectStrategy();
        thisstrat.outlined(p1,p2,graphics2D,Color.BLACK);
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
        GroupedShape newshape = new GroupedShape();
        ShapeStackNP forcopy = new ShapeStackNP();
        //newshape.addShapes(shapes.shapes());
        for(IShape shape:newshape.getShapes().shapes()){
            forcopy.addShape(shape.copy());
        }
        newshape.addShapes(forcopy.shapes());
        System.out.println("newgroupcopy si being returned");
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
        int newx1 = 10000;
        int newy1 = 10000;
        //x2 and y2 need to be largest values
        int newx2 = -1;
        int newy2 = -1;
        for (IShape shape : toadd) {   //shapes that make up the bigger shape
            shapes.addShape(shape);
            //forCopy.addShape(shape);
            if (shape.getP1().getX() <= newx1) {
                //p1.setPoint(shape.getP1().getX(),shape.getP1().getY());
                newx1 = shape.getP1().getX();
            }
            if (shape.getP2().getX() <= newx1) {  //check both xs, get smallest
                newx1 = shape.getP2().getX();
            }
            if (shape.getP1().getY() <= newy1) {
                newy1 = shape.getP1().getY();
            }
            if (shape.getP2().getY() <= newy1) {  //check both ys, get smallest
                newy1 = shape.getP2().getY();
            }
            if (shape.getP2().getX() >= newx2) {
                //p1.setPoint(shape.getP2().getX(),shape.getP2().getY());
                newx2 = shape.getP2().getX();
            }
            if (shape.getP1().getX() >= newx2) {   //check both xs, get largest
                newx2 = shape.getP1().getX();
            }
            if (shape.getP2().getY() >= newy2) {
                //p2.setPoint(shape.getP2().getX(),shape.getP2().getY());
                newy2 = shape.getP2().getY();
            }
            if (shape.getP1().getY() >= newy2) {  //check both ys, get largest
                newy2 = shape.getP1().getY();
            }

        }
        p1.setPoint(newx1, newy1);
        p2.setPoint(newx2, newy2);
        System.out.println("newx1 = " + newx1);
        System.out.println("newy1 = " + newy1);
        System.out.println("newx2 = " + newx2);
        System.out.println("newy2 = " + newy2);
//        for (IShape shape : shapes.shapes()) {//rename shapes its confusing!!!
//            selectedShapes.removeShape(shape);
//            //need to remove shapes from shapestack so that their draw method isnt triggered


        //}
    }
    public ShapeStackNP getGroupshapes(){
        return this.shapes;
    }
}
