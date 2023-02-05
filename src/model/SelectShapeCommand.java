package model;

import model.interfaces.IUndoable;
import model.interfaces.Icommand;
import model.myPoint;
import model.ShapeStack;
import model.interfaces.IShape;
public class SelectShapeCommand implements IUndoable, Icommand {
    private ShapeStack shapeStack;
    private ShapeStack selectedShapes;
    private myPoint p1;
    private myPoint p2;
    SelectShapeCommand(ShapeStack shapeStack, ShapeStack selectedShapes, myPoint p1, myPoint p2){
        this.shapeStack = shapeStack;
        this.selectedShapes = selectedShapes;
        this.p1 = p1;
        this.p2 = p2;
    }
    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

    @Override
    public void run() {
        selectedShapes.clearstack();
        for(IShape shape: shapeStack.shapes()){
            int shapex1 = Math.min(shape.getP1().getX(),shape.getP2().getX());
            int shapey1 = Math.min(shape.getP1().getY(),shape.getP2().getY());
            int shapex2 = Math.max(shape.getP1().getX(),shape.getP2().getX());
            int shapey2 = Math.max(shape.getP1().getY(),shape.getP2().getY());
            int selectx3 = Math.min(p1.getX(),p2.getX());   //could move these for optimization
            int selecty3 = Math.min(p1.getY(),p2.getY());
            int selectx4 = Math.max(p1.getX(),p2.getX());
            int selecty4 = Math.max(p1.getY(),p2.getY());
            if((shapex1 < selectx4) && (selectx3 < shapex2) && (shapey1 < selecty4) && (selecty3 < shapey2)){
                selectedShapes.addShape(shape);
            }
            }
            }
        }


