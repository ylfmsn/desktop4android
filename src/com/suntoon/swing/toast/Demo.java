package com.suntoon.swing.toast;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ProjectionName desktop
 * @ClassName Demo
 * @Description TODO
 * @Author YueLifeng
 * @Date 2019/4/4 0004上午 11:36
 * @Version 1.0
 */
public class Demo extends JPanel {
    private JTextArea txtMsg = null;
    private JTextField txtPositionX = null;
    private JTextField txtPositionY = null;
    private JTextField txtDelay = null;
    private JButton btnShowToast = null;
    
    public Demo () {
        super(new BorderLayout());
        
        initGUI();
        initListeners();
    }

    private void initListeners() {
        btnShowToast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Toast.showTost(
                        Integer.parseInt(txtDelay.getText().trim())
                        , txtMsg.getText()
                        , new Point(Integer.parseInt(txtPositionX.getText().trim()), Integer.parseInt(txtPositionY.getText().trim()))
                );
            }
        });
    }

    private void initGUI() {
        txtMsg = new JTextArea(5, 5);
        txtPositionX = new JTextField();
        txtPositionY = new JTextField();
        txtDelay = new JTextField();
        btnShowToast = new JButton("举杯祝酒！");

        //初始化子控件
        txtMsg.setText(
                "<html>\n" +
                        "<body>\n" +
                            "Hello 鹏哥， you are <b>so cool</b>!\n" +
                        "</body>\n" +
                "</html>");
        txtPositionX.setText("-1");
        txtPositionY.setText("-1");
        txtDelay.setText("3000");
        txtPositionX.setColumns(10);
        txtPositionY.setColumns(10);
        txtDelay.setColumns(10);
        btnShowToast.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        btnShowToast.setForeground(Color.white);

        //初始化按钮面板
        JPanel btnPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPane.add(new JLabel("位置 X : "));
        btnPane.add(txtPositionX);
        btnPane.add(new JLabel("位置 Y ： "));
        btnPane.add(txtPositionY);
        btnPane.add(new JLabel("延迟（毫秒）： "));
        btnPane.add(txtDelay);
        btnPane.add(btnShowToast);

        //初始化主界面
        this.add(btnPane, BorderLayout.SOUTH);
        this.add(new JScrollPane(txtMsg), BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(10, 100, 20, 100));
    }


}
