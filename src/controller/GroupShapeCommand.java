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
            shapeStack.addShape(shape);
        }
        shapeStack.removeShape(thisShape);
    }

    @Override
    public void redo() {
        GroupedShape groupedShape = new GroupedShape();
        groupedShape.addShapes(selectedShapes.shapes());
        thisShape = groupedShape;
        shapeStack.addShape(groupedShape);
        selectedShapes.clearstack();
        for(IShape shape :groupedShape.getShapes().shapes()){
            shapeStack.removeShape(shape);
        }
    }

    @Override
    public void run() {
        GroupedShape groupedShape = new GroupedShape();
        groupedShape.addShapes(selectedShapes.shapes());
        thisShape = groupedShape;
        shapeStack.addShape(groupedShape);
        selectedShapes.clearstack();
        for (IShape shape : groupedShape.getShapes().shapes()) {  //need to remove from primary stack so that
            shapeStack.removeShape(shape);                        //draw and select are not called on the shapes
        }



    }
}
