// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package com.github.sashamikhailau.aemtesttool.action;

import com.github.sashamikhailau.aemtesttool.config.AEMToolsSettingsState;
import com.intellij.json.JsonLanguage;
import com.intellij.json.psi.JsonContainer;
import com.intellij.json.psi.JsonProperty;
import com.intellij.json.psi.impl.JsonPsiImplUtils;
import com.intellij.lang.xml.XMLLanguage;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiRecursiveElementVisitor;
import com.intellij.psi.xml.XmlAttribute;
import com.intellij.psi.xml.XmlTag;
import com.yevdo.jwildcard.JWildcard;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class TestDataCleaningAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        PsiFile affectedFile = event.getData(CommonDataKeys.PSI_FILE);
        if (affectedFile != null) {
            WriteCommandAction.runWriteCommandAction(event.getProject(), () -> {
                affectedFile.getOriginalFile().accept(new JsonPropertyRemovalVisitor());
            });
        }
    }

    @Override
    public void update(AnActionEvent e) {
        PsiFile fileData = e.getData(CommonDataKeys.PSI_FILE);
        e.getPresentation().setEnabledAndVisible(e.getProject() != null && fileData != null &&
                (fileData.getLanguage().isKindOf(JsonLanguage.INSTANCE) || fileData.getLanguage().isKindOf(XMLLanguage.INSTANCE)));
    }

    private static class JsonPropertyRemovalVisitor extends PsiRecursiveElementVisitor {
        @Override
        public void visitElement(@NotNull PsiElement element) {
            super.visitElement(element);
            if (element instanceof JsonContainer || element instanceof XmlTag) {
                Arrays.stream(element.getChildren())
                        .forEach(this::visitElement);
            }
            if (element instanceof JsonProperty property) {
                if (isSubjectForClean(property.getName())) {
                    JsonPsiImplUtils.delete(property);
                }
            } else if (element instanceof XmlAttribute xmlAttribute) {
                if (isSubjectForClean(xmlAttribute.getName())) {
                    xmlAttribute.delete();
                }
            }
        }

        private static boolean isSubjectForClean(String propertyName) {
            AEMToolsSettingsState settings = AEMToolsSettingsState.getInstance();
            String propertiesForClean = settings.getPropertiesForClean();
            if (StringUtils.isNotBlank(propertiesForClean)) {
                return Arrays.stream(propertiesForClean.split(","))
                        .anyMatch(wildCard -> JWildcard.matches(wildCard, propertyName));
            }
            return false;
        }
    }
}