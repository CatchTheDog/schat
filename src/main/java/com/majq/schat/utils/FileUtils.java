package com.majq.schat.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * 文件工具
 *
 * @author Mr.X
 * @version 1.0.0
 * @since 2019/01/10 14:31
 */
public class FileUtils {
    /**
     * 复制文件
     *
     * @param srcFile    源文件
     * @param targetPath 目标文件存放目录
     * @return true:复制成功  false:复制失败
     */
    public static File copyFile(File srcFile, String targetPath) throws Exception {
        if (!StringUtils.isBlank(targetPath) && null != srcFile) {
            File targetFile = new File(targetPath);
            if (targetFile.isDirectory()) {
                targetFile = new File(targetPath + File.separator + srcFile.getName());
            }
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile))
            ) {
                int len;
                byte[] buff = new byte[1024];
                while ((len = bis.read(buff)) > 0) {
                    bos.write(buff, 0, len);
                }
            }
            return targetFile;
        } else throw new IllegalArgumentException("srcFile|targetPath is null!");
    }
}
