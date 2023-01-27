package model;

import model.interfaces.IUndoable;
import model.interfaces.Icommand;
import model.ShapeStack;
import model.myPoint;
import org.w3c.dom.css.Rect;

public class CreateShapeCommand implements Icommand, IUndoable {
    private final ShapeStack shapeStack;
    private myPoint p1;
    private myPoint p2;
    private Rectangle newrect;
    CreateShapeCommand(ShapeStack shapeStack, myPoint p1, myPoint p2){
        this.shapeStack = shapeStack;
        this.p1 = p1;
        this.p2 = p2;
    }
    @Override
    public void run(){
        //ShapeStack idk = new ShapeStack();
        Rectangle newrect = new Rectangle();
        newrect.setP1(p1);
        newrect.setP2(p2);
        shapeStack.addShape(newrect);
        System.out.println(newrect.getP1().getX());
    }
    @Override
    public void undo(){
        shapeStack.popShape();
        Rectangle newrect = new Rectangle();
        newrect.setP1(p1);
        newrect.setP2(p2);
        System.out.println(newrect.getP1().getX());
        shapeStack.removeShape(newrect);
    }
    @Override
    public void redo(){
        Rectangle newrect = new Rectangle();
        newrect.setP1(p1);
        newrect.setP2(p2);
        shapeStack.addShape(newrect);
    }

}
