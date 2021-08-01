package com.dylan.tools.dialog;

import com.dylan.tools.swingsource.FormTestSwing;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class FormTestDialog extends DialogWrapper {

    private FormTestSwing formTestSwing = new FormTestSwing();

    public FormTestDialog(@Nullable Project project) {
        super(true);
        setTitle("表单测试"); // 会话框标题
        init(); // 必须调用一下init()方法 否则swing内容无法显示出来
    }

    @Override
    protected JComponent createNorthPanel() {
        return formTestSwing.initNorth();
    }

    @Override
    protected JComponent createSouthPanel() {
        return formTestSwing.initSouth();
    }

    @Override
    protected JComponent createCenterPanel() {
        return formTestSwing.initCenter();
    }
}