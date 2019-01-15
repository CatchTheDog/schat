package com.majq.schat.constant;

import java.awt.*;
import java.io.File;

public interface FrameConstant {

    Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * 主窗口标题
     */
    String TITLE = "SChat";
    /**
     * 默认主窗口宽度 屏幕宽度的40%
     */
    int DEFAULT_WIDTH = SCREEN_SIZE.width * 40 / 100;
    /**
     * 默认主窗口高度 屏幕高度的80%
     */
    int DEFAULT_HEIGHT = SCREEN_SIZE.height * 80 / 100;
    /**
     * 主窗口默认显示位置-X 即窗口左上角距屏幕左上角x方向距离 屏幕宽度的30%
     */
    int DEFAULT_LOCATION_X = SCREEN_SIZE.width * 30 / 100;
    /**
     * 主窗口默认显示位置-Y 即窗口左上角距屏幕左上角y方向距离 屏幕高度的10%
     */
    int DEFAULT_LOCATION_Y = SCREEN_SIZE.height * 10 / 100;

    String IMG_PATH = "/image";

    String ICON_IMAGE_PATH = IMG_PATH + File.separator + "logo.jpg";

    String DEFAULT_PORTRAIT_IMG = IMG_PATH + File.separator + "default_portrait.jpeg";


}
