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
    private static final HtmlConverter HTML_CONVERTER;

    static {
        // init converter only once
        HTML_CONVERTER = new HtmlConverter();
    }

    /**
     * do convert from html to docx and save to given path
     *
     * @param htmlString   original html string, must have body tag
     * @param absolutePath absolute path in your system, eg:windows starts with "C:/" or "D:/",linux/macOS start with "/"
     */
    public static void convert(String htmlString, String absolutePath) {
        HTML_CONVERTER.setHtmlString(htmlString);
        HTML_CONVERTER.setAbsolutePath(absolutePath);
        HTML_CONVERTER.doConvert();
    }
}
