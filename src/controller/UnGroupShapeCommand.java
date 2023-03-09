package controller;

import model.interfaces.IUndoable;
import model.interfaces.Icommand;
import model.ShapeStack;
import model.interfaces.IShape;

public class UnGroupShapeCommand implements Icommand, IUndoable {
    private ShapeStack selectedShapes;
    public UnGroupShapeCommand(ShapeStack selectedShapes){
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
        for(IShape shape:selectedShapes.shapes()){
            if(shape.getGrouporSingle().equals("Group")){
                shape.getGroupshapes();
            }
        }

    }
}
