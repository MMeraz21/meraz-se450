package controller;

import model.ShapeStackNP;
import model.interfaces.IApplicationState;
import view.EventName;
import view.interfaces.IEventCallback;
import view.interfaces.IUiModule;
//import model.CommandHistory;
import view.gui.PaintCanvas;
import model.ShapeStack;

import java.awt.*;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private ShapeStack shapeStack;
    private ShapeStack selectedShapes;
    private ShapeStackNP clipboard;


    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeStack shapeStack, ShapeStack selectedShapes,
                            ShapeStackNP clipboard) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeStack = shapeStack;
        this.selectedShapes = selectedShapes;
        this.clipboard = clipboard;

    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO,() -> new UndoCommand().run());
        uiModule.addEvent(EventName.REDO, () -> new RedoCommand().run());
        uiModule.addEvent(EventName.DELETE, () -> new DeleteCommand(shapeStack,selectedShapes).run());
        uiModule.addEvent(EventName.COPY, () -> new CopyCommand(selectedShapes, clipboard).run());
        uiModule.addEvent(EventName.PASTE, () -> new PasteCommand(selectedShapes,clipboard,shapeStack).run());
        uiModule.addEvent(EventName.GROUP, () -> new GroupShapeCommand(selectedShapes,shapeStack).run());
        uiModule.addEvent(EventName.UNGROUP, () -> new UnGroupShapeCommand(selectedShapes,shapeStack).run());
    }
}
