package com.github.sashamikhailau.aemtesttool.config;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AEMToolsSettingsForm {
    private final JPanel mainPanel;
    private final JBTextField properties = new JBTextField();

    public AEMToolsSettingsForm() {
        mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Enter user name: "), properties, 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return properties;
    }

    @NotNull
    public String getUserNameText() {
        return properties.getText();
    }

    public void setUserNameText(@NotNull String newText) {
        properties.setText(newText);
    }
}
