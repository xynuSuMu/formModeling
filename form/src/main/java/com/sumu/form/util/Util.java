package com.sumu.form.util;

import java.io.InputStream;

/**
 * @author 陈龙
 * @version 1.0
 * @date 2020-12-09 13:33
 */
public class Util {

    private final static String MYBATIS_CONFIG = "com/sumu/form/db/mapping.xml";

    public static InputStream getInputStream() {
        String path = MYBATIS_CONFIG;
        ClassLoader classLoader = Util.class.getClassLoader();
        InputStream resourceStream = classLoader.getResourceAsStream(path);
        return resourceStream;
    }
}
