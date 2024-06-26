package ru.nsu.kondrenko.gui.controller.wireframe;

import lombok.RequiredArgsConstructor;
import org.ejml.simple.SimpleMatrix;
import ru.nsu.kondrenko.gui.controller.common.MouseController;
import ru.nsu.kondrenko.model.context.Context;
import ru.nsu.kondrenko.model.wireframe.WireframeUtils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

@RequiredArgsConstructor
public class WireFrameMouseController extends MouseController {
    private static final double SENSITIVITY_DIVIDER = 200;

    private final Context context;

    private int prevX;
    private int prevY;
    private boolean hasPrevPoint = false;

    @Override
    public void mousePressed(MouseEvent e) {
        prevX = e.getX();
        prevY = e.getY();
        hasPrevPoint = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        hasPrevPoint = false;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        final double precision = e.getPreciseWheelRotation();
        final int sensitivity = context.getWireframeSensitivity();
        final SimpleMatrix cameraMatrix = context.getCameraMatrix();
        final double v1 = cameraMatrix.get(1, 1);
        final double v2 = cameraMatrix.get(2, 2);
        final double k = 1 - sensitivity * precision / SENSITIVITY_DIVIDER;
        cameraMatrix.set(1, 1, v1 * k);
        cameraMatrix.set(2, 2, v2 * k);
        context.notifyWireframeListeners();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!hasPrevPoint || !isMouseOnEditor()) {
            return;
        }

        final int deltaX = e.getX() - prevX;
        final int deltaY = e.getY() - prevY;

        context.setRotationMatrix(WireframeUtils.createRotationMatrix(deltaX, deltaY).mult(context.getRotationMatrix()));
        context.notifyWireframeListeners();
        prevX = e.getX();
        prevY = e.getY();
    }
}
