package com.suntoon.swing.utils;

import org.jb2011.ninepatch4j.NinePatch;

import javax.swing.*;
import java.awt.*;
import java.io.InputStreamReader;

/**
 * @ProjectionName desktop
 * @ClassName NPComponentUtils
 * @Description TODO
 * @Author YueLifeng
 * @Date 2019/4/3 0003下午 5:54
 * @Version 1.0
 */
public class NPComponentUtils {
    public static JPanel createPanel_root(final NinePatch n9, Insets is) {
        JPanel p = new JPanel() {
            public void paintChildren(Graphics g) {
                if (n9 != null) {
                    n9.draw((Graphics2D) g, 0, 0, this.getWidth(), this.getHeight());
                }
                super.paintChildren(g);
            }
        };
        if (is != null) {
            p.setBorder(BorderFactory.createEmptyBorder(is.top, is.left, is.bottom, is.right));
        }
        return p;
    }

    public static JLabel createLabel_root(String text, final NinePatch n9, Insets is, Color foregroundColor, Font f) {
        JLabel l = new JLabel(text) {
          public void paintComponent(Graphics g) {
              n9.draw((Graphics2D) g, 0, 0, this.getWidth(), this.getHeight());
              super.paintComponent(g);
          }
        };
        if (is != null) {
            l.setBorder(BorderFactory.createEmptyBorder(is.top, is.left, is.bottom, is.right));
        }
        if (foregroundColor != null) {
            l.setForeground(foregroundColor);
        }
        if (f != null) {
           l.setFont(f);
        }
        return l;
    }
}
