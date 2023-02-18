package controller;

import model.CommandHistory;
import model.ShapeStack;
import model.interfaces.IUndoable;
import model.interfaces.Icommand;
import model.ShapeStackNP;
import model.interfaces.IShape;

public class CopyCommand implements Icommand, IUndoable {
    private ShapeStack selectedShapes;
    private ShapeStackNP clipboard;
    CopyCommand(ShapeStack selectedShapes, ShapeStackNP clipboard){
        this.selectedShapes = selectedShapes;
        this.clipboard = clipboard;
        CommandHistory.add(this);
    }
    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

    @Override
    public void run() {
        clipboard.clearstack();
        for(IShape shape:selectedShapes.shapes()){
            clipboard.addShape(shape);
            //shape.changecolor();
        }


    }
}
