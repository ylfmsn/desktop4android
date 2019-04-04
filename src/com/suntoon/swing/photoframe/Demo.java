package com.suntoon.swing.photoframe;

import com.sun.awt.AWTUtilities;
import com.suntoon.swing.Launch;
import com.suntoon.swing.utils.DragToMove;
import com.suntoon.swing.utils.NPComponentUtils;
import com.suntoon.swing.utils.NPHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.lnf.beautyeye.widget.border.NinePatchBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ProjectionName desktop
 * @ClassName Demo
 * @Description TODO
 * @Author YueLifeng
 * @Date 2019/4/4 0004上午 9:03
 * @Version 1.0
 */
public class Demo extends JPanel {
    private JDialog dialogForShowingPhoto = null;
    private JPanel panePhotoframe = null;

    private JTextField txtPhotoframeDialogWidth = null;
    private JTextField txtPhotoframeDialogHeight = null;
    private JButton btnShowInFrame = null;
    private JButton btnHideTheFrame = null;
    
    public Demo() {
        super(new BorderLayout());
        
        initGUI();
        initListeners();
    }

    private void initListeners() {
        btnShowInFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNewFrame();
            }
        });
        btnHideTheFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideTheFrame();
            }
        });
    }

    private void hideTheFrame() {
        dialogForShowingPhoto.setVisible(false);
        btnHideTheFrame.setEnabled(false);
        btnShowInFrame.setEnabled(true);

//		dialogForShowingPhoto.remove(panePhotoframe);
        // 重新添加主框
        this.add(panePhotoframe, BorderLayout.CENTER);
    }

    private void showNewFrame() {
        if (dialogForShowingPhoto == null) {
            dialogForShowingPhoto = new JDialog(
                    // bug of JDK1.7: can't repaint!
//				    SwingUtilities.getWindowAncestor(org.jb2011.ninepatch4j.demos.photoframe.Demo.this)
                );

            //设置窗口全透明
            dialogForShowingPhoto.setUndecorated(true);
            AWTUtilities.setWindowOpaque(dialogForShowingPhoto, false);
            // contentPane default is opaque in Java1.7+
            ((JComponent)(dialogForShowingPhoto.getContentPane())).setOpaque(false);
            dialogForShowingPhoto.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            dialogForShowingPhoto.setLocation(100,100);
//			dialogForShowingPhoto.setLocationRelativeTo(null);
            dialogForShowingPhoto.setAlwaysOnTop(true);//
        }

        dialogForShowingPhoto.setSize(Integer.parseInt(txtPhotoframeDialogWidth.getText().trim())
                , Integer.parseInt(txtPhotoframeDialogHeight.getText().trim()));
//		this.remove(panePhotoframe);
        dialogForShowingPhoto.add(panePhotoframe);

        dialogForShowingPhoto.setVisible(true);
        btnHideTheFrame.setEnabled(true);
        btnShowInFrame.setEnabled(false);
    }

    private void initGUI() {
        //初始化组件
        txtPhotoframeDialogWidth = new JTextField();
        txtPhotoframeDialogHeight = new JTextField();
        txtPhotoframeDialogWidth.setText("530");
        txtPhotoframeDialogHeight.setText("450");
        txtPhotoframeDialogWidth.setColumns(10);
        txtPhotoframeDialogHeight.setColumns(10);

        btnShowInFrame = new JButton("在一个新框里展示...");
        btnShowInFrame.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
        btnShowInFrame.setForeground(Color.white);
        btnHideTheFrame = new JButton("隐藏框");
        btnHideTheFrame.setEnabled(false);

        panePhotoframe = createPhotoframe();
        panePhotoframe.add(
                new JLabel(new ImageIcon(Demo.class.getResource("imgs/np/photoframe.png")))
                , BorderLayout.CENTER);

        //初始化布局
        JPanel paneBtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
        paneBtn.setBorder(BorderFactory.createEmptyBorder(12, 0, 0, 0));
        paneBtn.add(new JLabel("框宽： "));
        paneBtn.add(txtPhotoframeDialogWidth);
        paneBtn.add(new JLabel("框高： "));
        paneBtn.add(txtPhotoframeDialogHeight);
        paneBtn.add(btnShowInFrame);
        paneBtn.add(btnHideTheFrame);

        this.setBorder(BorderFactory.createEmptyBorder(12, 20, 10, 20));
        this.add(panePhotoframe, BorderLayout.CENTER);
        this.add(paneBtn, BorderLayout.SOUTH);

        //拖拽相框到父级窗口
        DragToMove.apply(new Component[]{panePhotoframe});
    }

    private JPanel createPhotoframe() {
        //JPanel pf = new JPanel();
        JPanel pf = NPComponentUtils.createPanel_root(NPIconFactory.getInstance().getPhotoframeBg(), new Insets(13, 15, 15, 15));
        pf.setLayout(new BorderLayout());
        pf.setOpaque(false);

        return pf;
    }

    class AABorder extends NinePatchBorder//AbstractBorder
    {

        /** The Constant BOTTOM. */
        private final static int TOP = 17,LEFT = 27,RIGHT = 27,BOTTOM = 37;

        /**
         * Instantiates a new bE shadow border3.
         */
        public AABorder()
        {
            super(new Insets(TOP, LEFT, BOTTOM, RIGHT)
                    , NPHelper.createNinePatch(
                            Launch.class.getResource("imgs/np/225.9.png"), false));
        }
    }
}
