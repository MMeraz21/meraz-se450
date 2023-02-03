package view.gui;

import model.ShapeStack;

import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import model.interfaces.IShape;

public class PaintCanvas extends JComponent {
    private ShapeStack shapeStack;
    public PaintCanvas(ShapeStack shapeStack){
        this.shapeStack = shapeStack;
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D)g;
        //graphics2d.setColor(Color.BLACK);
        for(IShape shape: shapeStack.shapes()){
            System.out.println("attempting to draw shape");
            shape.draw(graphics2d);
        }
//            if (shape.getP1().getX() < shape.getP2().getX() && shape.getP1().getY() < shape.getP2().getY()) {//top left -> bottom right
//                graphics2d.fillRect(shape.getP1().getX(), shape.getP1().getY(), Math.abs(shape.getP1().getX() - shape.getP2().getX()), Math.abs(shape.getP2().getY() - shape.getP1().getY()));
//            }
//            if (shape.getP1().getX() < shape.getP2().getX() && shape.getP1().getY() > shape.getP2().getY()) {  //bottom left -> top right
//                graphics2d.fillRect(shape.getP1().getX(), shape.getP2().getY(), Math.abs(shape.getP1().getX() - shape.getP2().getX()), Math.abs(shape.getP2().getY() - shape.getP1().getY()));
//            }
//            if (shape.getP1().getX() > shape.getP2().getX() && shape.getP1().getY() < shape.getP2().getY()) {  //top right -> bottom left
//                graphics2d.fillRect(shape.getP2().getX(), shape.getP1().getY(), Math.abs(shape.getP1().getX() - shape.getP2().getX()), Math.abs(shape.getP2().getY() - shape.getP1().getY()));
//            }
//            if (shape.getP1().getX() > shape.getP2().getX() && shape.getP1().getY() > shape.getP2().getY()) {  //bottom right -> top left
//                graphics2d.fillRect(shape.getP2().getX(), shape.getP2().getY(), Math.abs(shape.getP1().getX() - shape.getP2().getX()), Math.abs(shape.getP2().getY() - shape.getP1().getY()));
//            }
//        }
        // For example purposes only; remove all lines below from your final project.
        // Draw all shapes here

//        graphics2d.setColor(Color.GREEN);
//        graphics2d.fillRect(12, 13, 200, 400);
//
//        // Outlined rectangle
//        graphics2d.setStroke(new BasicStroke(5));
//        graphics2d.setColor(Color.BLUE);
//        graphics2d.drawRect(12, 13, 200, 400);
//
//        // Selected Shape
//        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
//        graphics2d.setStroke(stroke);
//        graphics2d.setColor(Color.BLACK);
//        graphics2d.drawRect(7, 8, 210, 410);
    }
}
