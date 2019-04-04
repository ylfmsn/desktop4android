package com.suntoon.swing.popup;

import com.suntoon.swing.Launch;
import com.suntoon.swing.fixtip.FixtipPane;
import com.suntoon.swing.fixtip.FloatableDialog;
import com.suntoon.swing.utils.NPComponentUtils;
import com.suntoon.swing.utils.NPHelper;
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
 * @Date 2019/4/3 0003下午 5:40
 * @Version 1.0
 */
public class Demo extends JPanel {
    private JButton btnShow = new JButton("点击我试试！");
    
    public Demo() {
        super(new BorderLayout());
        
        initGUI();
        initListeners();
    }

    private void initGUI() {
        btnShow.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        btnShow.setForeground(Color.white);
        btnShow.setToolTipText("Hey, 鹏哥！");

        JPanel btnPane = NPComponentUtils.createPanel_root(NPHelper.createNinePatch(Launch.class.getResource("imgs/np/cool_tool_tip_demo_bg.9.png"), false), new Insets(150, 150, 50, 50));

        btnPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnPane.add(btnShow);

        // init main ui
        this.add(btnPane, BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
    }

    private void initListeners()
    {
		btnShow.addActionListener(new ActionListener(){
		    FloatableDialog fixtipDialog = null;
			@Override
			public void actionPerformed(ActionEvent e)
			{
			    if (fixtipDialog != null)
			        fixtipDialog.exit();

				fixtipDialog = FloatableDialog.createDialog(
							new FixtipPane().setTiptext("Hello SUNTOON！")
							, SwingUtilities.getWindowAncestor(Demo.this)
							, btnShow);
				fixtipDialog.display();

			}
		});
    }


}
