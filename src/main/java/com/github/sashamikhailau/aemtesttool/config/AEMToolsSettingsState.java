package com.github.sashamikhailau.aemtesttool.config;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;

/**
 * Supports storing the application settings in a persistent way.
 * The {@link State} and {@link Storage} annotations define the name of the data and the file name where
 * these persistent application settings are stored.
 */
@State(
        name = "AEMToolsSetting",
        storages = @Storage("AEMToolsSetting.xml")
)
public class AEMToolsSettingsState implements PersistentStateComponent<AEMToolsSettingsState> {

    private static final String DEFAULT_PROPERTIES_FOR_CLEAN = "jcr:uuid,cq:lastModified*,jcr:lastModified*,jcr:created*,jcr:isCheckedOut," +
            "cq:lastReplicat*,dam:extracted,dam:assetState,dc:modified,*_x0040_*";
    private String propertiesForClean = DEFAULT_PROPERTIES_FOR_CLEAN;

    public String getPropertiesForClean() {
        return propertiesForClean;
    }

    public void setPropertiesForClean(String propertiesForClean) {
        this.propertiesForClean = propertiesForClean;
    }

    public static AEMToolsSettingsState getInstance() {
        return ApplicationManager.getApplication().getService(AEMToolsSettingsState.class);
    }

    @Override
    public AEMToolsSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull AEMToolsSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

}
