package com.suntoon.swing.utils;

import jdk.nashorn.internal.ir.IfNode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @ProjectionName desktop
 * @ClassName DragToMove
 * @Description TODO
 * @Author YueLifeng
 * @Date 2019/4/4 0004上午 10:44
 * @Version 1.0
 */
public class DragToMove implements MouseListener, MouseMotionListener {
    private Component
           /** 鼠标拖动事件发生源 */
           srcCom
           /** 鼠标拖动后要作用的目的对象（即是鼠标拖动位置设置此目的的组件位置） */
           , destCom;

    private int lastX = -1, lastY = -1;

    /**
     * @Author YueLifeng
     * @Description //默认设置移动的目的组件是其父窗口
     * @Date 上午 10:49 2019/4/4 0004
     * @param srcCom
     * @return void
     */
    public DragToMove(Component srcCom) {
        this(srcCom, null);
    }

    public DragToMove(Component srcCom, Component destCom) {
        this.srcCom = srcCom;
        this.destCom = destCom;
        init();
    }

    private void init() {
        srcCom.addMouseListener(this);
        srcCom.addMouseMotionListener(this);
    }

    private void reset() {
        this.lastX = -1;
        this.lastY = -1;
    }

    public static void apply(Component[] coms) {
        apply(coms, null);
    }

    /**
     * @param coms
     * @param destComs (目的destComs如不为空则必须要与coms一一对应）
     */
    public static void apply(Component[] coms, Component[] destComs) {
        if (coms != null) {
              boolean destIsParantWindow = (destComs == null);
              for (int i = 0; i < coms.length; i++) {
                  if (destIsParantWindow)
                      new DragToMove(coms[i]);
                  else
                      new DragToMove(coms[i], destComs[i]);
              }
        }
    }

    /**            MouseListener继承的方法         */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.lastX = e.getX();
        this.lastY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.reset();
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        srcCom.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        srcCom.setCursor(Cursor.getDefaultCursor());
    }
    /**            MouseMotionListener继承的方法         */
    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX(), y = e.getY(), deltaX = x - this.lastX, deltaY = y - this.lastY;
        //目的组件未设置就默认认为是它的父窗口
        Component win = (destCom == null ? SwingUtilities.windowForComponent(srcCom) : destCom);
        if (win != null) {
            setLocationImpl(win, deltaX, deltaY);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    protected void setLocationImpl(Component dest, int deltaX, int deltaY) {
        dest.setLocation((int)(dest.getLocation().getX() + deltaX), (int)(dest.getLocation().getY() + deltaY));
    }

    public static void applyDragToMoveWindow(Component[] coms)
    {
        applyDragToMoveWindow(coms,null);
    }
    /**
     * 给一组组件实现其上的拖动带动窗口的移动(目的destComs如不为空则必须要与coms一一对应）.
     * @param coms
     */
    public static void applyDragToMoveWindow(Component[] coms,Component[] destComs)
    {
        apply(coms,destComs);
    }
}
