package com.github.sashamikhailau.aemtesttool.config;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class AEMToolsSettingsConfigurable implements Configurable {
    private AEMToolsSettingsForm mySettingsComponent;

    public AEMToolsSettingsConfigurable() {
    }

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "AEM Data Wizard Settings";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return mySettingsComponent.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        mySettingsComponent = new AEMToolsSettingsForm();
        return mySettingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        AEMToolsSettingsState settings = AEMToolsSettingsState.getInstance();
        return !mySettingsComponent.getUserNameText().equals(settings.getPropertiesForClean());
    }

    @Override
    public void apply() {
        AEMToolsSettingsState settings = AEMToolsSettingsState.getInstance();
        settings.setPropertiesForClean(mySettingsComponent.getUserNameText());
    }

    @Override
    public void reset() {
        AEMToolsSettingsState settings = AEMToolsSettingsState.getInstance();
        mySettingsComponent.setUserNameText(settings.getPropertiesForClean());
    }

    @Override
    public void disposeUIResources() {
        mySettingsComponent = null;
    }
}
