package com.dylan.tools.action;

import com.dylan.tools.dialog.FormTestDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * 对话框
 */
public class DialogTestAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        FormTestDialog formTestDialog = new FormTestDialog(anActionEvent.getProject());
        formTestDialog.show();
    }
}
