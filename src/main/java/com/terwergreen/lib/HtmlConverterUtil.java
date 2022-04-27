package com.terwergreen.lib;

import com.terwergreen.lib.converter.HtmlConverter;

/**
 * HTML converter tool
 *
 * @name: HtmlConverterUtil
 * @author: terwer
 * @date: 2022-04-27 10:00
 **/
public class HtmlConverterUtil {
    private static final HtmlConverter converter;

    static {
        /**
         * init converter only once
         */
        converter = new HtmlConverter();
    }

    /**
     * do convert from html to docx and save to given path
     *
     * @param htmlString   original html string, must have body tag
     * @param absolutePath absolute path in your system, eg:windows starts with "C:/" or "D:/",linux/macOS start with "/"
     */
    public static void convert(String htmlString, String absolutePath) {
        converter.setHtmlString(htmlString);
        converter.setAbsolutePath(absolutePath);
        converter.doConvert();
    }
}
