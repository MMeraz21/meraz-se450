package controller;

import model.CommandHistory;
import model.ShapeStack;
import model.ShapeStackNP;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.interfaces.Icommand;

public class PasteCommand implements Icommand, IUndoable {
    ShapeStack shapeStack;
    ShapeStack selectedShapes;
    ShapeStackNP clipboard;
    ShapeStackNP safeplace;
    PasteCommand(ShapeStack selectedShapes, ShapeStackNP clipboard, ShapeStack shapeStack){
        this.shapeStack = shapeStack;
        this.selectedShapes = selectedShapes;
        this.clipboard = clipboard;
        this.safeplace = new ShapeStackNP();
        CommandHistory.add(this);
    }
    @Override
    public void undo() {
        for(IShape shape: safeplace.shapes()){
            shapeStack.removeShape(shape);
        }
    }

    @Override
    public void redo() {
        for(IShape shape: clipboard.shapes()){
            IShape newshape = shape.copy();
            shapeStack.addShape(newshape);
            safeplace.addShape(newshape);
        }

    }

    @Override
    public void run() {
        //for(IShape shape: selectedShapes.shapes()){
        for(IShape shape: clipboard.shapes()){
            IShape newshape = shape.copy();
            shapeStack.addShape(newshape);
            safeplace.addShape(newshape);
        }
    }
}
