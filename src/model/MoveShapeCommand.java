package model;

import model.interfaces.IUndoable;
import model.interfaces.Icommand;

public class MoveShapeCommand implements IUndoable, Icommand {
    ShapeStack selectedShapes;
    MoveShapeCommand(ShapeStack selectedShapes){
        this.selectedShapes = selectedShapes;
    }
    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

    @Override
    public void run() {

    }
}
