package com.suntoon.swing.toast;

import com.suntoon.swing.utils.NPHelper;
import com.suntoon.swing.utils.RawCacheRoot;
import org.jb2011.ninepatch4j.NinePatch;

/**
 * @ProjectionName desktop
 * @ClassName NPIconFactory
 * @Description TODO
 * @Author YueLifeng
 * @Date 2019/4/4 0004下午 2:05
 * @Version 1.0
 */
public class NPIconFactory extends RawCacheRoot<NinePatch> {
    /**  根目录（相对于此NPIconFactory.class）  */
    public final static String IMGS_ROOT = "imgs/np";

    //实例化
    private static NPIconFactory instance = null;

    /** 单例模式实例化 */
    public static NPIconFactory getInstance() {
        if(instance==null)
            instance = new NPIconFactory();
        return instance;
    }

    @Override
    protected NinePatch getResource(String relativePath, Class baseClass)
    {
        return NPHelper.createNinePatch(baseClass.getResource(relativePath), false);
    }

    /**
     * Gets the raw.
     *
     * @param relativePath the relative path
     * @return the raw
     */
    public NinePatch getRaw(String relativePath)
    {
        return  getRaw(relativePath,this.getClass());
    }

    /**
     * Gets the tooltip bg.
     *
     * @return the tooltip bg
     */
    public NinePatch getToastBg()
    {
        return getRaw(IMGS_ROOT+"/toast_bg.9.png");
    }
}
