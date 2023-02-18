package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.*;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;
import model.ShapeStackNP;

import java.awt.*;
import java.util.Collection;
import java.util.EnumMap;
import java.io.*;

public class Main {
    public static void main(String[] args){
        //System.out.println("hello");
        ShapeStack shapeStack = new ShapeStack(); //new
        ShapeStack selectedShapeStack = new ShapeStack();
        PaintCanvas paintCanvas = new PaintCanvas(shapeStack);  //added shapestack to constructor might remove
        shapeStack.getCanvas(paintCanvas);
        selectedShapeStack.getCanvas(paintCanvas);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        //ShapeStack shapeStack = new ShapeStack();  //also new, might need to remove
        //shapeFactory shapefactory = new shapeFactory();//new
        //shapefactory.shapeMaker(shapeStack,paintCanvas); //new
        ApplicationState appState = new ApplicationState(uiModule);
        ShapeStackNP clipboard = new ShapeStackNP();
        IJPaintController controller = new JPaintController(uiModule, appState, shapeStack, selectedShapeStack, clipboard);
        myMouseAdapter mouseAd = new myMouseAdapter(paintCanvas, appState, shapeStack, selectedShapeStack);  //THIS IS
        paintCanvas.addMouseListener(mouseAd);                     //NEW
        //shapefactory.shapeMaker(shapeStack,paintCanvas); //new



        controller.setup();
    }
}
