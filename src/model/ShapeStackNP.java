package model;

import model.interfaces.IShape;

import java.util.ArrayList;

public class ShapeStackNP {
    private ArrayList<IShape> shapes = new ArrayList<>();
    public void addShape(IShape e){
        shapes.add(e);
    }
    public void removeShape(IShape e){
        shapes.remove(e);
    }
    public void clearstack(){
        shapes.clear();
    }
    public ArrayList<IShape> shapes(){
        return this.shapes;
    }
}
