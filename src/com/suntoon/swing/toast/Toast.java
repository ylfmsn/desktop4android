package com.suntoon.swing.toast;

import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ProjectionName desktop
 * @ClassName Toast
 * @Description TODO
 * @Author YueLifeng
 * @Date 2019/4/4 0004下午 1:52
 * @Version 1.0
 */
public class Toast extends JDialog implements ActionListener {
    private Point showPosition = null;
    private Timer timer = null;
    private ToastPane toastPane = null;
    
    public Toast(int delay, String message, Point p) {
        
        initGUI();

        // 初始化数据
        timer = new Timer(delay, this);
        toastPane.setMessage(message);
        this.showPosition = p;
    }

    private void initGUI() {
        //对话框设置全透明
        this.setAlwaysOnTop(true);
        this.setUndecorated(true);   //去掉窗口的装饰
        AWTUtilities.setWindowOpaque(this, false);
        //this.setBackground(new Color(0, 0, 0, 0));
        //contentPane默认在java1.7+是不透明的
        ((JComponent)(this.getContentPane())).setOpaque(false);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);   //采用指定的窗口装饰风格 NONE：无装饰，去掉标题栏，FRAME:普通窗口风格，PLAIN_DIALOG：简单对话框风格

        //初始化主要布局
        toastPane = new ToastPane();
        this.add(toastPane);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // fade out
        for(float i=1.0f; i>=0;i-=0.05f)
            try{
                AWTUtilities.setWindowOpacity(this, i);
                Thread.sleep(50);
            }
            catch (Exception e2){
            }

        // dispose it
        if(timer != null)
            timer.stop();
        this.dispose();
    }

    public Toast showItNow()
    {
        this.pack();
        if(showPosition == null || (showPosition.x < 0 && showPosition.y < 0))
            this.setLocationRelativeTo(null);
        else
            this.setLocation(new Point(showPosition.x < 0 ? 0 : showPosition.x, showPosition.y < 0 ? 0 : showPosition.y));
        this.setVisible(true);
        timer.start();
        return this;
    }

    public static Toast showTost(int delay, String message, Point p)
    {
        return new Toast(delay, message, p).showItNow();
    }
}
