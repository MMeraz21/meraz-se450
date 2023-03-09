package controller;

import model.CommandHistory;
import model.ShapeStackNP;
import model.interfaces.IUndoable;
import model.interfaces.Icommand;
import model.ShapeStack;
import model.interfaces.IShape;

public class UnGroupShapeCommand implements Icommand, IUndoable {
    private ShapeStack selectedShapes;
    private ShapeStackNP safeplace;
    private ShapeStack shapeStack;
    public UnGroupShapeCommand(ShapeStack selectedShapes, ShapeStack shapeStack){
        this.shapeStack = shapeStack;
        this.selectedShapes = selectedShapes;
        this.safeplace = new ShapeStackNP();
        CommandHistory.add(this);
    }
    @Override
    public void undo() {
        //need to add all grouped shapes to shapestack and delete all shapes in grouped shapes from shapestack
        for(IShape shape: safeplace.shapes()){
            shapeStack.addShape(shape);
            selectedShapes.addShape(shape);  //add groupedshape from safeplace to shapestack and selected shapes
            for(IShape ingroup : shape.getGroupshapes().shapes()){  //for each shape in the grouped shape
                shapeStack.removeShape(ingroup);
                selectedShapes.removeShape(ingroup);
            }
        }

    }

    @Override
    public void redo() {
        //safeplace is full of grouped shapes, must go through them, delete the grouped shapes from shapestack and add smaller shapes to
        //shapestack
        for(IShape shape: safeplace.shapes()){
            shapeStack.removeShape(shape);
            selectedShapes.removeShape(shape);
            for(IShape ingroup:shape.getGroupshapes().shapes()){
                shapeStack.addShape(ingroup);
                selectedShapes.addShape(ingroup);
            }
        }

    }

    @Override
    public void run() {
        //to ungroup, add all shapes in group to shapestack and delete the grouped shape from shapestack
        for(IShape shape:selectedShapes.shapes()){
            if(shape.getGrouporSingle().equals("Group")){ //if current shape is a grouped shape
                safeplace.addShape(shape);   //needed for undo
                for(IShape ingroup:shape.getGroupshapes().shapes()){   //for each shape that make up the grouped shape
                    shapeStack.addShape(ingroup);    //add shapes that make up groupedshapes to shapestack
                    //selectedShapes.addShape(ingroup); //and to selectedshapes
                }
                //selectedShapes.removeShape(shape); //remove groupedshape from selectedshapes
                shapeStack.removeShape(shape);    //and larger shapestack
            }
        }
        for(IShape con : safeplace.shapes()){   //safeplace full of grouped shapes
            selectedShapes.removeShape(con);
            for(IShape ingroup : con.getGroupshapes().shapes()){
                selectedShapes.addShape(ingroup);
            }
        }
    }
}
