package com.suntoon.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ProjectionName desktop
 * @ClassName MainFrame
 * @Description TODO
 * @Author YueLifeng
 * @Date 2019/4/3 0003下午 5:32
 * @Version 1.0
 */
public class MainFrame extends JFrame {
    private JPanel mainPane = new JPanel(new BorderLayout());

    public MainFrame(String path) {
        super("SUNTOON");

        initGUI();

        setSize(900, 680);
    }

    private void initGUI() {
        this.mainPane.add(createMainTabs(), BorderLayout.CENTER);
        
        this.getContentPane().add(mainPane);
        this.setJMenuBar(createMenubar());
    }

    private JMenuBar createMenubar() {
        //------------------------------------ MenuDemo1
		JMenu fileMenu = new JMenu("文件");
		JMenuItem openMenuItem = new JMenuItem("新建");
		JMenuItem saveMenuItem = new JMenuItem("打开");
		JMenuItem exitMenuItem = new JMenuItem("设置");
		fileMenu.add(openMenuItem);
		saveMenuItem.setEnabled(false);
		fileMenu.add(saveMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);

        //------------------------------------ MenuDemo2
		JMenu fileMenu2 = new JMenu("视图");
		fileMenu2.add(new JMenuItem("上一视图"));
		fileMenu2.add(new JMenuItem("下一视图"));
		fileMenu2.addSeparator();
		fileMenu2.add(new JMenuItem("字节编码"));
		fileMenu2.add(new JMenuItem("参数信息"));
		fileMenu2.addSeparator();
		fileMenu2.add(new JMenuItem("工具条"));
		fileMenu2.add(new JMenuItem("工具按钮"));
		fileMenu2.add(new JMenuItem("状态按钮"));
		fileMenu2.add(new JMenuItem("导航按钮"));

        //------------------------------------ About
        JMenu aboutMenu = new JMenu("关于");
        JMenuItem aboutMenuItem = new JMenuItem("关于本软件");
        aboutMenuItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                JOptionPane.showMessageDialog(rootPane, "SUNTOON Desktop" +
                        "\n - 本软件是为SUNTOON桌面端实现的Swing组件或UI效果." +
                        "\n - 软件内的UI组件或效果为桌面端软件做准备." +
                        "\n");
            }
        });
        aboutMenu.add(aboutMenuItem);

        JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(fileMenu2);
        menuBar.add(aboutMenu);

        return menuBar;
    }

    private JComponent createMainTabs() {
        JTabbedPane tbs = new JTabbedPane();

        tbs.add(new com.suntoon.swing.popup.Demo(), "林调通");
        tbs.add(new com.suntoon.swing.fixtip.Demo(), "森警通");
        tbs.add(new com.suntoon.swing.photoframe.Demo(), "水保通");
        //		tbs.add(new JPanel(), "Cool border demo");
//		tbs.add(new JPanel(), "仿手机短信内容查看");
//		tbs.add(new JPanel(), "Cool 名片");
        tbs.add(new com.suntoon.swing.toast.Demo(), "巡护系统");

        tbs.setToolTipTextAt(0, "酷炫的提示框！");
        tbs.setToolTipTextAt(1, "酷炫的修复框！");
        tbs.setToolTipTextAt(2, "相框！");
//		tbs.setToolTipTextAt(3, "Cool border demo");
//		tbs.setToolTipTextAt(4, "仿手机短信内容查看");
//		tbs.setToolTipTextAt(5, "Cool 名片");
        tbs.setToolTipTextAt(3, "举杯");

        return tbs;

    }


}
