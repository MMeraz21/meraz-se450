package model;

import model.interfaces.IUndoable;
import model.interfaces.Icommand;
import model.interfaces.IShape;

public class MoveShapeCommand implements IUndoable, Icommand {
    ShapeStack selectedShapes;
    myPoint p1;
    myPoint p2;
    ShapeStack shapeStack;
    MoveShapeCommand(ShapeStack selectedShapes, myPoint p1, myPoint p2, ShapeStack shapeStack){
        this.selectedShapes = selectedShapes;
        this.p1 = p1;
        this.p2 = p2;
        this.shapeStack = shapeStack;
    }
    @Override
    public void undo() {
        int deltax = p2.getX() - p1.getX();
        int deltay = p2.getY() - p1.getY();
        for (IShape shape: selectedShapes.shapes()){
            shape.moveshape(-deltax, -deltay);
            //shapeStack.addShape(shape);
            shapeStack.justrepaint();
        }

    }

    @Override
    public void redo() {
        int deltax = p2.getX() - p1.getX();
        int deltay = p2.getY() - p1.getY();
        for (IShape shape: selectedShapes.shapes()){
            shape.moveshape(deltax, deltay);
            //shapeStack.addShape(shape);
            shapeStack.justrepaint();
        }


    }

    @Override
    public void run() {
        int deltax = p2.getX() - p1.getX();
        int deltay = p2.getY() - p1.getY(); //moved for optimization
        for(IShape shape: selectedShapes.shapes()){
            //dont need to remove shape
            shape.moveshape(deltax,deltay);   //changes proprties of shape
            shapeStack.justrepaint();
            //shapeStack.addShape(shape);  //dont know if necessary, maybe just repaint?
        }

    }
}
