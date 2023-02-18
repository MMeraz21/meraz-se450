package controller;

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


    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeStack shapeStack, ShapeStack selectedShapes) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.shapeStack = shapeStack;
        this.selectedShapes = selectedShapes;

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
    }
}
