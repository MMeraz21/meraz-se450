package model;
import view.gui.PaintCanvas;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import model.myPoint;
import java.math.*;
import model.persistence.ApplicationState;
import model.MouseMode;
import model.Rectangle;
import model.ShapeStack;
import model.CreateShapeCommand;
import model.CommandHistory;
import model.MoveShapeCommand;
import model.SelectShapeCommand;

public class myMouseAdapter extends MouseAdapter {
    private myPoint firstPt; //first point, used in mousePressed
    private myPoint finalPt; //second point, used in mouseReleased
    private PaintCanvas paintcanvas;
    private ApplicationState appstate;
    private ShapeStack shapeStack;
    private ShapeStack selectedShapes;

    public myMouseAdapter(PaintCanvas pcanvas, ApplicationState astate, ShapeStack shapeStack, ShapeStack selectedShapes){
        paintcanvas = pcanvas;
        appstate = astate;
        this.shapeStack = shapeStack;
        this.selectedShapes = selectedShapes;
    }
    @Override
    public void mousePressed(MouseEvent e){
        firstPt = new myPoint();
        firstPt.setPoint(e.getX(),e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        finalPt = new myPoint();
        finalPt.setPoint(e.getX(),e.getY());
        if(appstate.getActiveMouseMode() == MouseMode.DRAW) {
            CreateShapeCommand command = new CreateShapeCommand(shapeStack, firstPt, finalPt, appstate);
            CommandHistory.add(command);
            command.run();
        }
        if(appstate.getActiveMouseMode() == MouseMode.SELECT){
            SelectShapeCommand command = new SelectShapeCommand(shapeStack,selectedShapes, firstPt,finalPt);
            CommandHistory.add(command);
            command.run();
        }
        if(appstate.getActiveMouseMode() == MouseMode.MOVE){
            MoveShapeCommand command = new MoveShapeCommand(selectedShapes, firstPt, finalPt, shapeStack);
            CommandHistory.add(command);
            command.run();
        }

    }
}
