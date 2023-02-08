package model;

import model.interfaces.IUndoable;
import model.interfaces.Icommand;
import model.ShapeStack;
import model.myPoint;
import model.persistence.ApplicationState;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import model.ShapeType;

public class CreateShapeCommand implements Icommand, IUndoable {
    private ShapeStack shapeStack; //might need to make final
    private myPoint p1;
    private myPoint p2;
    private Shape newshape;
    private ApplicationState appState; //might need to change this
    private ShapeType shapeType;

    CreateShapeCommand(ShapeStack shapeStack, myPoint p1, myPoint p2, ApplicationState appState){
        this.shapeStack = shapeStack;
        this.p1 = p1;
        this.p2 = p2;
        this.appState = appState;
        this.shapeType = appState.getActiveShapeType();
    }
    @Override
    public void run(){
        Shape newshape = new Shape();
        if (shapeType == ShapeType.RECTANGLE){
            newshape = shapeFactory.createRect(p1,p2, appState);
        }
        if(shapeType == ShapeType.ELLIPSE){
            newshape = shapeFactory.createEllipse(p1,p2,appState);
        }
        if(shapeType == ShapeType.TRIANGLE){
            newshape = shapeFactory.createTriangle(p1,p2,appState);
        }
        shapeStack.addShape(newshape);
    }
    @Override
    public void undo(){
        shapeStack.popShape();
    }
    @Override
    public void redo(){
        if (shapeType == ShapeType.RECTANGLE){
            newshape = shapeFactory.createRect(p1,p2, appState);
        }
        if(shapeType == ShapeType.ELLIPSE){
            newshape = shapeFactory.createEllipse(p1,p2,appState);
        }
        if(shapeType == ShapeType.TRIANGLE){
            newshape = shapeFactory.createTriangle(p1,p2,appState);
        }
        shapeStack.addShape(newshape);
    }

}
