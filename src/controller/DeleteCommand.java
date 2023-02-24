package controller;

import model.CommandHistory;
import model.ShapeStack;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.interfaces.Icommand;
import model.ShapeStackNP;

public class DeleteCommand implements IUndoable, Icommand {
    private ShapeStack shapeStack;
    private ShapeStack selectedShapes;
    private ShapeStackNP todelete;
    DeleteCommand(ShapeStack shapeStack,ShapeStack selectedShapes){
        this.shapeStack = shapeStack;
        this.selectedShapes = selectedShapes;
        this.todelete = new ShapeStackNP();
        CommandHistory.add(this);

    }
    @Override
    public void undo() {
        for(IShape shape:todelete.shapes()){
            selectedShapes.addShape(shape);
            shapeStack.addShape(shape);
        }

    }

    @Override
    public void redo() {
        for(IShape shape : selectedShapes.shapes()){
            //todelete.addShape(shape);
            shapeStack.removeShape(shape);
        }
        selectedShapes.clearstack();
    }

    @Override
    public void run() {
        for(IShape shape: selectedShapes.shapes()){
            todelete.addShape(shape);
            shapeStack.removeShape(shape);
        }
        selectedShapes.clearstack();
    }
}
