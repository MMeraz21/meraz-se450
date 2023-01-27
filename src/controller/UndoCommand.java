package controller;
import model.CommandHistory;
import model.interfaces.IUndoable;
import model.ShapeStack;
import model.interfaces.Icommand;

public class UndoCommand implements Icommand{
    @Override
    public void run(){
        CommandHistory.undo();
    }




}
