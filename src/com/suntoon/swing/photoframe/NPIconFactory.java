package com.suntoon.swing.photoframe;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.suntoon.swing.utils.NPHelper;
import com.suntoon.swing.utils.RawCacheRoot;
import org.jb2011.ninepatch4j.NinePatch;

/**
 * @ProjectionName desktop
 * @ClassName NPIconFactory
 * @Description TODO
 * @Author YueLifeng
 * @Date 2019/4/4 0004上午 9:22
 * @Version 1.0
 */
public class NPIconFactory extends RawCacheRoot<NinePatch> {
    //根目录 相对于 NPIconFactory.class这个类
    public final static String IMGS_ROOT = "imgs/np";

    //实例化
    public static NPIconFactory instance = null;

    //单例模式创建对象
    public static NPIconFactory getInstance() {
        if (instance == null) {
            instance = new NPIconFactory();
        }
        return instance;
    }

    @Override
    protected NinePatch getResource(String relativePath, Class baseClass) {
        return NPHelper.createNinePatch(baseClass.getResource(relativePath), false);
    }

    //获取行
    public NinePatch getRaw(String relativePath) {
        return getRaw(relativePath, this.getClass());
    }

    public NinePatch getPhotoframeBg() {
        return getRaw(getPhotoframeBg_PATH());
    }

    private String getPhotoframeBg_PATH() {
        return IMGS_ROOT + "/photoframe_bg2.9.png";
    }
}
