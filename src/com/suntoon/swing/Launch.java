package com.suntoon.swing;

import com.suntoon.swing.popup.CoolPopupFactory;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.utils.Platform;

import javax.swing.*;

/**
 * @ProjectionName desktop
 * @ClassName Launch
 * @Description TODO
 * @Author YueLifeng
 * @Date 2019/4/3 0003下午 6:12
 * @Version 1.0
 */
public class Launch {
    private static void initUserInterface() {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty(
                "com.apple.mrj.application.apple.menu.about.name",
                "Draw 9-patch");

        try {
            if(Platform.isWindows())
            {
                UIManager.put("RootPane.setupButtonVisible", false);
                BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
                BeautyEyeLNFHelper.launchBeautyEyeLNF();

                // impl a demo PopupFactory
                PopupFactory.setSharedInstance(new CoolPopupFactory());
            }
            else
                UIManager.setLookAndFeel(UIManager
                        .getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(final String... args) {
        initUserInterface();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String arg = args.length > 0 ? args[0] : null;
                MainFrame frame = new MainFrame(arg);
                frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
//
//				FixtipPane fp = new FixtipPane();
//				fp.show(frame, frame.getJMenuBar(),0,10);
            }
        });
    }
}
