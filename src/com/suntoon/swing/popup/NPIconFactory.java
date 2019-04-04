package com.suntoon.swing.popup;

import com.suntoon.swing.utils.NPHelper;
import com.suntoon.swing.utils.RawCacheRoot;
import org.jb2011.ninepatch4j.NinePatch;

/**
 * @ProjectionName desktop4android
 * @ClassName NPIconFactory   NinePatch图片的对象工厂（*.9.png）
 * @Description TODO
 * @Author YueLifeng
 * @Date 2019/4/4 0004下午 4:10
 * @Version 1.0
 */
public class NPIconFactory extends RawCacheRoot<NinePatch> {
    /** 根目录（相对于此NPIconFactory.class） */
    public final static String IMGS_ROOT = "imgs/np";

    //实例化
    private static NPIconFactory instance = null;

    //单例模式
    public static NPIconFactory getInstance() {
        if (instance == null)
            instance = new NPIconFactory();
        return instance;
    }

    //获取raw
    public NinePatch getRaw(String relativePath) {
        return getRaw(relativePath, this.getClass());
    }

    //获取popup背景
    public NinePatch getPopupBg() {
        return getRaw(IMGS_ROOT+"/shadow_bg_popup.9.png");
    }

    //获取提示框背景
    public NinePatch getTooltipBg() {
        return getRaw(IMGS_ROOT+"/shadow_bg_tooltip2.9.png");
    }

    //获取滚动面板的边框背景
    public NinePatch getScrollPaneBorderBg() {
        return getRaw(IMGS_ROOT+"/scroll_pane_bg1.9.png");
    }

    @Override
    protected NinePatch getResource(String relativePath, Class baseClass) {
        return NPHelper.createNinePatch(baseClass.getResource(relativePath), false);
    }
}
