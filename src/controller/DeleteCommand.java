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
            shapeStack.addShape(shape);
        }

    }

    @Override
    public void redo() {
        for(IShape shape : selectedShapes.shapes()){
            shapeStack.removeShape(shape);
        }
    }

    @Override
    public void run() { //finish this, only deleting a shape at a time
//        for(IShape shape:shapeStack.shapes()){
//            for(IShape selshape: selectedShapes.shapes()){
//                if(shape == selshape){
//                    //todelete.addShape(shape);
//                    shapeStack.removeShape(shape);
//                }
//            }
//        }

        for(IShape shape: selectedShapes.shapes()){
            todelete.addShape(shape);
            shapeStack.removeShape(shape);
        }
    }
}
