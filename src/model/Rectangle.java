package model;
import model.interfaces.IDrawShapeStrategy;
import model.interfaces.IShape;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;

import java.awt.*;
import java.io.*;



public abstract class Rectangle{
    private myPoint p1;
    private myPoint p2;
    private PaintCanvas pcanvas;
    //@Override
    public void draw(PaintCanvas paintcanvas){
//        Graphics graphics2d = paintcanvas.getGraphics();
//        //System.out.println("hello");
//        graphics2d.setColor(Color.BLACK);
//        if (firstPt.getX() < finalPt.getX() && firstPt.getY() < finalPt.getY()) {  //top left -> bottom right
//            graphics2d.fillRect(firstPt.getX(), firstPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
//        }
//        if (firstPt.getX() < finalPt.getX() && firstPt.getY() > finalPt.getY()) {  //bottom left -> top right
//            graphics2d.fillRect(firstPt.getX(), finalPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
//        }
//        if (firstPt.getX() > finalPt.getX() && firstPt.getY() < finalPt.getY()) {  //top right -> bottom left
//            graphics2d.fillRect(finalPt.getX(), firstPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
//        }
//        if (firstPt.getX() > finalPt.getX() && firstPt.getY() > finalPt.getY()) {  //bottom right -> top left
//            graphics2d.fillRect(finalPt.getX(), finalPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
//        }

    }
//    public void delRect(myPoint firstPt, myPoint finalPt, PaintCanvas paintCanvas){
//        Graphics graphics2d = paintCanvas.getGraphics();
//        if (firstPt.getX() < finalPt.getX() && firstPt.getY() < finalPt.getY()) {  //top left -> bottom right
//            graphics2d.clearRect(firstPt.getX(), firstPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
//        }
//    }
//    @Override
//    public void setP1(myPoint point){
//        this.p1 = point;
//
//    }
//    @Override
//    public void setP2(myPoint point){
//        this.p2 = point;
//    }
//    @Override
//    public myPoint getP1(){
//        return this.p1;
//    }
//    @Override
//    public myPoint getP2(){
//        return this.p2;
//    }
//
//    @Override
//    public void setStrat(IDrawShapeStrategy strategy) {
//
//    }
//
//    @Override
//    public IDrawShapeStrategy getStrat() {
//        return null;
//    }
//
//    @Override
//    public void setappState(ApplicationState appState) {
//
//    }
//
//    @Override
//    public ApplicationState getappState() {
//        return null;
//    }


}
