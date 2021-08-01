package com.dylan.tools.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.popup.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * 自定义样式的他弹出菜单
 */
public class ComponentPopupAction extends AnAction implements ListSelectionListener, JBPopupListener {
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        // 自定义popup样式
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTextField textField = new JTextField();
        panel.add(textField, BorderLayout.NORTH);
        JButton button = new JButton("提交");
        panel.add(button, BorderLayout.CENTER);
        ComponentPopupBuilder componentPopupBuilder = JBPopupFactory.getInstance().createComponentPopupBuilder(panel, textField);
        JBPopup jbPopup = componentPopupBuilder.createPopup();
        jbPopup.setRequestFocus(true);
        jbPopup.showInBestPositionFor(anActionEvent.getDataContext());

    }

    /**
     * 上下键选择时间，仅仅是改变，而不是按住回车之后的选择
     * @param e
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int firstIndex = e.getFirstIndex();
        int lastIndex = e.getLastIndex();
        boolean valueIsAdjusting = e.getValueIsAdjusting();
        System.out.println("First index is :" + firstIndex);
        System.out.println("Last index is :" + lastIndex);
        System.out.println("ValueIsAdjusting is :" + valueIsAdjusting);
    }

    /**
     * 关闭监听
     * @param event
     */
    @Override
    public void onClosed(@NotNull LightweightWindowEvent event) {
        JBPopup jbPopup = event.asPopup();
        System.out.println("关闭popup");
        jbPopup.cancel();
    }
}
