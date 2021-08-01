package com.dylan.tools.swingsource;

import com.intellij.ui.JBColor;

import javax.swing.*;
import java.awt.*;

public class FormTestSwing {

    private JPanel north  = new JPanel();
    private JPanel south  = new JPanel();
    private JPanel center  = new JPanel();

    //为了让位于底部的按钮可以拿到组件内容，这里把表单组件做成类属性
    private JLabel r1 = new JLabel("Out");
    private JLabel r2 = new JLabel("NULL");

    private JLabel name = new JLabel("Name");
    private JTextField nameContent = new JTextField();

    private JLabel age = new JLabel("Age");
    private JTextField ageContent = new JTextField();

    /**
     * 定义表单最上方标题部分内容
     * @return
     */
    public JPanel initNorth(){
        JLabel title = new JLabel("表单测试");
        title.setFont(new Font("微软雅黑", Font.PLAIN, 26));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        north.add(title);
        return north;
    }

    /**
     * 定义表单中间主体部分
     * @return
     */
    public JPanel initCenter(){
        // 3行2列的表格布局
        center.setLayout(new GridLayout(3, 2));
        // row1 按钮事件触发后将结果打印在这里
        // 设置字体颜色并添加到center中
        r1.setForeground(JBColor.CYAN);
        r2.setForeground(JBColor.CYAN);
        center.add(r1);
        center.add(r2);

        center.add(name);
        center.add(nameContent);

        center.add(age);
        center.add(ageContent);

        return center;
    }

    /**
     * 定义底部提交按钮部分 放置到IDEA会话框的底部位置
     * @return
     */
    public JPanel initSouth(){
        JButton submit = new JButton("提交");
        submit.setHorizontalAlignment(SwingConstants.CENTER);
        submit.setVerticalTextPosition(SwingConstants.CENTER);
        south.add(submit);

        // 事件绑定
        submit.addActionListener(e -> {
            String name = nameContent.getText();
            String age = ageContent.getText();
            r2.setText(String.format("name:%s, age:%s", name, age));
        });
        return south;
    }
}
