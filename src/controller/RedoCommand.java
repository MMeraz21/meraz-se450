package controller;
import model.CommandHistory;
public class RedoCommand {
    public void run(){
        CommandHistory.redo();
    }
}
