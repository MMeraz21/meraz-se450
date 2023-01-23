package model;
import view.gui.PaintCanvas;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import model.myPoint;
import java.math.*;

public class myMouseAdapter extends MouseAdapter {
    private myPoint firstPt; //first point, used in mousePressed
    private myPoint finalPt; //second point, used in mouseReleased
    private PaintCanvas paintcanvas;

    public myMouseAdapter(PaintCanvas pcanvas){
        paintcanvas = pcanvas;
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
        Graphics graphics2d = paintcanvas.getGraphics();
        graphics2d.setColor(Color.BLACK);
        if(firstPt.getX() < finalPt.getX() && firstPt.getY() < finalPt.getY()) {  //top left -> bottom right
            graphics2d.fillRect(firstPt.getX(), firstPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
        }
        if(firstPt.getX()< finalPt.getX() && firstPt.getY() > finalPt.getY()){  //bottom left -> top right
            graphics2d.fillRect(firstPt.getX(), finalPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
        }
        if(firstPt.getX() > finalPt.getX() && firstPt.getY() < finalPt.getY()){  //top right -> bottom left
            graphics2d.fillRect(finalPt.getX(), firstPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
        }
        if(firstPt.getX() > finalPt.getX() && firstPt.getY() > finalPt.getY()){  //bottom right -> top left
            graphics2d.fillRect(finalPt.getX(), finalPt.getY(), Math.abs(firstPt.getX() - finalPt.getX()), Math.abs(finalPt.getY() - firstPt.getY()));
        }

    }
}
