package controller;

import model.CommandHistory;
import model.GroupedShape;
import model.ShapeStackNP;
import model.interfaces.IShape;
import model.interfaces.IUndoable;
import model.interfaces.Icommand;
import model.ShapeStack;

public class GroupShapeCommand implements Icommand, IUndoable {
    ShapeStack selectedShapes;
    ShapeStack shapeStack;
    GroupedShape thisShape;
    public GroupShapeCommand(ShapeStack selectedShapes, ShapeStack shapeStack){
        this.selectedShapes = selectedShapes;
        this.shapeStack = shapeStack;
        CommandHistory.add(this);
    }
    @Override
    public void undo() {
        for(IShape shape : thisShape.getShapes().shapes()) {
            selectedShapes.addShape(shape);
        }
        shapeStack.removeShape(thisShape);
    }

    @Override
    public void redo() {
        GroupedShape groupedShape = new GroupedShape(selectedShapes);
        thisShape = groupedShape;
        shapeStack.addShape(groupedShape);
    }

    @Override
    public void run() {
        GroupedShape groupedShape = new GroupedShape(selectedShapes);
        thisShape = groupedShape;
        shapeStack.addShape(groupedShape);


    }
}
