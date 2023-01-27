package model;
import java.util.Stack;
import model.interfaces.IUndoable;
import java.io.*;
public class CommandHistory {
	private static final Stack<IUndoable> undoStack = new Stack<IUndoable>();
	private static final Stack<IUndoable> redoStack = new Stack<IUndoable>();

	public static void add(IUndoable cmd) {
		//System.out.println("command has been added");
		undoStack.push(cmd);
		redoStack.clear();
	}
	
	public static boolean undo() {
		//System.out.println("undo in commandhistory reached");
		boolean result = !undoStack.empty();
		if (result) {
			IUndoable c = undoStack.pop();
			redoStack.push(c);
			c.undo();
		}
		return result;
	}

	public static boolean redo() {
		boolean result = !redoStack.empty();
		if (result) {
			IUndoable c = redoStack.pop();
			undoStack.push(c);
			c.redo();
		}
		return result;
	}
}
