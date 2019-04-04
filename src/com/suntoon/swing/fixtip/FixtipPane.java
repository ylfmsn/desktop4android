package com.suntoon.swing.fixtip;

import org.jb2011.ninepatch4j.NinePatch;

import javax.swing.*;
import java.awt.*;

/**
 * @ProjectionName desktop
 * @ClassName FixtipPane
 * @Description TODO
 * @Author YueLifeng
 * @Date 2019/4/3 0003下午 6:32
 * @Version 1.0
 */
public class FixtipPane extends JPanel{
    private NinePatch npBackground = null;
    private JLabel lbTip = null;

    public FixtipPane()
    {
        super(new BorderLayout());

        initGUI();
    }

    /**
     * Override to impl ninepatch image background.
     */
    @Override
    public void paintChildren(Graphics g)
    {
        if(npBackground == null)
            // load the nine patch .PNG
            npBackground = NPIconFactory.getInstance().getFixTipBg();
        if(npBackground != null)
            // paint background with ninepath
            npBackground.draw((Graphics2D)g, 0, 0, this.getWidth(), this.getHeight());
        super.paintChildren(g);
    }

    protected void initGUI()
    {
        this.setOpaque(false);

        // init gui
        this.add(lbTip = createContentLabel(), BorderLayout.CENTER);
        this.setBorder(BorderFactory.createEmptyBorder(10,20,70,10));
    }

    protected JLabel createContentLabel()
    {
        lbTip = new JLabel("");
        return lbTip;
    }

    public FixtipPane setTiptext(String tiptext)
    {
        if(lbTip != null)
            lbTip.setText(tiptext);
        return this;
    }
}
