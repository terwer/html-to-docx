package com.terwergreen.lib.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HTML converter
 *
 * @name: HtmlConverter
 * @author: terwer
 * @date: 2022-04-27 10:08
 **/
public class HtmlConverter {
    private static final Logger logger = LoggerFactory.getLogger(HtmlConverter.class);

    private String htmlString;
    private String absolutePath;

    /**
     * empty constructer
     */
    public HtmlConverter() {
    }

    /**
     * a constructer for initializing
     *
     * @param htmlString   original html string, must have body tag
     * @param absolutePath absolute path in your system, eg:windows starts with "C:/" or "D:/",linux/macOS start with "/"
     */
    public HtmlConverter(String htmlString, String absolutePath) {
        this.htmlString = htmlString;
        this.absolutePath = absolutePath;
    }

    /**
     * original html string, must have body tag
     *
     * @return
     */
    public String getHtmlString() {
        return htmlString;
    }

    public void setHtmlString(String htmlString) {
        this.htmlString = htmlString;
    }

    /**
     * absolute path in your system, eg:windows starts with "C:/" or "D:/",linux/macOS start with "/"
     *
     * @return
     */
    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    /**
     * the really doing of converting work
     */
    public void doConvert() {
        logger.info("htmlString = " + htmlString);
        logger.info("absolutePath = " + absolutePath);
    }
}
