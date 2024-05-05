package ru.nsu.kondrenko.gui;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@Getter
public class WireframeMenuArea extends JPanel {
    private static final Font FONT = new Font("G0", Font.PLAIN, 14);

    private final JMenuBar menuBar;

    public WireframeMenuArea(ActionListener openListener,
                             ActionListener saveListener,
                             ActionListener exitListener,
                             ActionListener resetAngleListener,
                             ActionListener resetDistanceListener,
                             ActionListener helpListener,
                             ActionListener aboutListener) {
        final Color menuBackgroundColor = new Color(100, 100, 100);
        final Color buttonsFontColor = new Color(200, 200, 200);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(menuBackgroundColor);

        menuBar = new JMenuBar();
        menuBar.setBackground(menuBackgroundColor);

        menuBar.add(createFileMenu(
                openListener,
                saveListener,
                exitListener,
                menuBackgroundColor,
                buttonsFontColor,
                FONT
        ));

        menuBar.add(createViewMenu(
                resetAngleListener,
                resetDistanceListener,
                menuBackgroundColor,
                buttonsFontColor,
                FONT
        ));
    }

    private static JMenu createFileMenu(ActionListener openListener,
                                        ActionListener saveListener,
                                        ActionListener exitListener,
                                        Color menuBackgroundColor,
                                        Color buttonsFontColor,
                                        Font font) {
        final JMenu result = createMenu("File", menuBackgroundColor, buttonsFontColor, font);
        result.add(createItem("Open", openListener, font, menuBackgroundColor));
        result.add(createItem("Save", saveListener, font, menuBackgroundColor));
        result.add(createItem("Exit", exitListener, font, menuBackgroundColor));
        return result;
    }

    private static JMenu createViewMenu(ActionListener resetAngleListener,
                                        ActionListener resetDistanceListener,
                                        Color menuBackgroundColor,
                                        Color buttonsFontColor,
                                        Font font) {
        final JMenu result = createMenu("View", menuBackgroundColor, buttonsFontColor, font);
        result.add(createItem("Reset angle", resetAngleListener, font, menuBackgroundColor));
        result.add(createItem("Reset distance", resetDistanceListener, font, menuBackgroundColor));
        return result;
    }

    private static JMenu createMenu(String label,
                                    Color menuBackgroundColor,
                                    Color buttonsFontColor,
                                    Font font) {
        JMenu result = new JMenu(label);
        result.setBackground(menuBackgroundColor);
        result.setForeground(buttonsFontColor);
        result.setFont(font);
        return result;
    }

    private static JMenuItem createItem(String label,
                                        ActionListener actionListener,
                                        Font font,
                                        Color menuBackgroundColor) {
        final JMenuItem result = new JMenuItem(label);
        initButton(result, actionListener, font, menuBackgroundColor);
        return result;
    }

    private static void initButton(AbstractButton button,
                                   ActionListener actionListener,
                                   Font font,
                                   Color menuBackgroundColor) {
        button.setBorderPainted(false);
        button.setFont(font);
        button.setForeground(menuBackgroundColor);
        button.addActionListener(actionListener);
    }
}