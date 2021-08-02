package com.dylan.tools.action;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.ui.popup.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PopupTestAction extends AnAction implements ListSelectionListener, JBPopupListener {
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        // 单选，action被选中可以触发对应的actionPerformed方法
        DefaultActionGroup actionGroup = (DefaultActionGroup) ActionManager.getInstance().getAction("popupGroup");
        ListPopup listPopup = JBPopupFactory.getInstance().createActionGroupPopup("Popup", actionGroup, anActionEvent.getDataContext(), JBPopupFactory.ActionSelectionAid.SPEEDSEARCH, false);
        listPopup.showInFocusCenter();
        listPopup.addListSelectionListener(this);
        listPopup.addListener(this);
    }

    /**
     * 值改变事件监听，通过上下键选择时，可以通过getFirstIndex获取第一个选择的元素，通过getLastIndex可以获取u最后一个选择的元素的索引
     * @param e
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int firstIndex = e.getFirstIndex();
        int lastIndex = e.getLastIndex();
        boolean valueIsAdjusting = e.getValueIsAdjusting();
        System.out.println("firstIndex : " + firstIndex);
        System.out.println("lastIndex : " + lastIndex);
        System.out.println("valueIsAdjusting : " + valueIsAdjusting);

    }

    /**
     * popup 监听弹出菜单关闭动作
     * @param event
     */
    @Override
    public void onClosed(@NotNull LightweightWindowEvent event) {

        JBPopup jbPopup = event.asPopup();
        System.out.println("Popup close.");
        jbPopup.cancel();

    }


}
