package ru.nsu.kondrenko.gui.controller.bspline;

import lombok.RequiredArgsConstructor;
import ru.nsu.kondrenko.model.context.Context;
import ru.nsu.kondrenko.model.context.ContextUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@RequiredArgsConstructor
public class BSplineNormalizationController implements ActionListener {
    private final Context context;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ContextUtils.normalizeContext(context);
    }
}
