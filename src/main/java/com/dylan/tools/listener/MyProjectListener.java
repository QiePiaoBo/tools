package com.dylan.tools.listener;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import org.jetbrains.annotations.NotNull;

public class MyProjectListener implements ProjectManagerListener {

    @Override
    public void projectClosing(@NotNull Project project) {
        // do something while project closing.
    }
}