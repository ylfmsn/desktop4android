package com.suntoon.swing.toast;

import com.suntoon.swing.utils.DragToMove;
import org.jb2011.ninepatch4j.NinePatch;

import javax.swing.*;
import java.awt.*;

/**
 * @ProjectionName desktop
 * @ClassName ToastPane
 * @Description TODO
 * @Author YueLifeng
 * @Date 2019/4/4 0004下午 1:54
 * @Version 1.0
 */
public class ToastPane extends JPanel {
    private NinePatch npBackground = null;
    private JComponent content = null;
    
    public ToastPane () {
        super(new BorderLayout());
        intiGUI();
    }

    //重写集成的ninepatch的图片背景方法
    @Override
    protected void paintChildren(Graphics g) {
        if (npBackground == null) {
            //加载
            npBackground = NPIconFactory.getInstance().getToastBg();
        }

        if (npBackground != null) {
            //用ninepatch来绘制背景
            npBackground.draw((Graphics2D) g, 0, 0, this.getWidth(), this.getHeight());
        }
        super.paintChildren(g);
    }

    private void intiGUI() {
        this.setOpaque(false);
        
        content = createContent();

        //拖拽移动
        DragToMove.apply(new Component[]{content});

        this.add(content, BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(19, 20, 28, 20));
    }

    //子类可以重写继承的方法以实现自身逻辑
    private JComponent createContent() {
        JLabel lb = new JLabel("");
        lb.setForeground(new Color(230, 230, 230));
        return lb;
    }

    //子类可以重写继承的方法以实现自身逻辑
    public void setMessage(String message) {
        ((JLabel)content).setText(message);
    }

    public JComponent getContent(){
        return content;
    }


}
