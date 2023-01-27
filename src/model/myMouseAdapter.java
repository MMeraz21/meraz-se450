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

public class myMouseAdapter extends MouseAdapter {
    private myPoint firstPt; //first point, used in mousePressed
    private myPoint finalPt; //second point, used in mouseReleased
    private PaintCanvas paintcanvas;
    private ApplicationState appstate;
    private ShapeStack shapeStack;

    public myMouseAdapter(PaintCanvas pcanvas, ApplicationState astate, ShapeStack shapeStack){
        paintcanvas = pcanvas;
        appstate = astate;
        this.shapeStack = shapeStack;
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
            //CreateShape.run(finalPt,finalPt, shapeStack);
            CreateShapeCommand command = new CreateShapeCommand(shapeStack, firstPt, finalPt);
            CommandHistory.add(command);
            command.run();
            //Rectangle newrect = new Rectangle();
            //newrect.setP1(firstPt);
            //newrect.setP2(finalPt);
            //shapeStack.addShape(newrect);
            //paintcanvas.repaint();
            //System.out.println("hello");
            //Graphics graphics2d = paintcanvas.getGraphics();
            //graphics2d.setColor(Color.BLACK);
            //newrect.draw(firstPt,finalPt,paintcanvas);
            //paintcanvas.repaint();
            //Graphics graphics2d = paintcanvas.getGraphics();
            //graphics2d.setColor(Color.BLACK);
        } //might need to remove

    }
}
