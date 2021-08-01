package com.dylan.tools.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.popup.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ConfirmPopupAction extends AnAction implements ListSelectionListener, JBPopupListener {


    /**
     * 确认类型Popup,展示两个选项，只有yes有动作
     * @param anActionEvent
     */
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        ListPopup confirmation = JBPopupFactory.getInstance().createConfirmation("Confirm", "Yes", "No",
                ()-> Messages.showMessageDialog("Yes", "Yes", Messages.getInformationIcon())
                , 0);
        confirmation.showInBestPositionFor(anActionEvent.getDataContext());
        confirmation.addListSelectionListener(this);
        confirmation.addListener(this);
    }


    /**
     * 上下键选择事件，仅仅是改变，而不是按住回车之后的选择
     * @param e
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int firstIndex = e.getFirstIndex();
        int lastIndex = e.getLastIndex();
        boolean valueIsAdjusting = e.getValueIsAdjusting();
        System.out.println("firstIndex:" + firstIndex);
        System.out.println("lastIndex:" + lastIndex);
        System.out.println("valueIsAdjusting:" + valueIsAdjusting);
    }

    /**
     * popup 关闭监听
     * @param event
     */
    @Override
    public void onClosed(@NotNull LightweightWindowEvent event) {
        JBPopup jbPopup = event.asPopup();
        System.out.println("关闭popup");
        jbPopup.cancel();
    }
}