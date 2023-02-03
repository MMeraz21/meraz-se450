package model;
import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.util.*;
public class ShapeStack {
    private PaintCanvas paintCanvas;
    private ArrayList<IShape> shapes = new ArrayList<IShape>();
//    public ShapeStack(PaintCanvas paintCanvas){
//        this.paintCanvas = paintCanvas;
//    }
    public void getCanvas(PaintCanvas paintCanvas){
        this.paintCanvas = paintCanvas;
    }

    public void popShape(){
        shapes.remove(shapes.size()-1);
        paintCanvas.repaint();
    }

    public void addShape(IShape e){
        //System.out.println("hello");
        //System.out.println(e.getP2().getX());
        shapes.add(e);
        paintCanvas.repaint(); //might need to delete this
        //System.out.println(e.getP1().getX());
    }
    public void removeShape(IShape e){
        //System.out.println("remove shape reached");
        //System.out.println(e.getP2().getX());
        shapes.remove(e);
        paintCanvas.repaint();
    }
    public ArrayList<IShape> shapes(){
        return this.shapes;
    }
}
