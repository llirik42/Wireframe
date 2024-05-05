package ru.nsu.kondrenko.controller;

import lombok.RequiredArgsConstructor;
import ru.nsu.kondrenko.model.Context;
import ru.nsu.kondrenko.model.WireframeUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@RequiredArgsConstructor
public class ResetAngleController implements ActionListener {
    private final Context context;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        context.setRotationMatrix(WireframeUtils.createDefaultRotationMatrix());
    }
}