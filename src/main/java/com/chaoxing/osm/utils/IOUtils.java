package com.chaoxing.osm.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @ClassName IOUtils
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2020-06-12 14:39
 */
public class IOUtils {
    /**
     * 关闭对象，连接
     * @param closeable
     */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
