package com.terwergreen.lib.converter;

import com.terwergreen.lib.parser.HTMLParser;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * HTML converter
 *
 * @name: HtmlConverter
 * @author: terwer
 * @date: 2022-04-27 10:08
 **/
public class HtmlConverter {
    private static final Logger logger = LoggerFactory.getLogger(HtmlConverter.class);
    private static final HTMLParser htmlParser;

    private String htmlString;
    private String absolutePath;

    static {
        /**
         * parser init
         */
        htmlParser = new HTMLParser();
    }

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
        logger.info("Before converting, source string:" + htmlString);

        InputStream is = null;
        OutputStream os = null;
        // Output file to stream
        try (XWPFDocument doc = new XWPFDocument()) {
            // Format html via Jsoup
            is = new ByteArrayInputStream(htmlString.getBytes());
            Document htmlDocument = null;
            htmlDocument = Jsoup.parse(is, "UTF-8", "");

            // Parse and generate docx document
            htmlParser.parse(doc, htmlDocument);

            // Write to ouput stream, and save to file
            os = new FileOutputStream(absolutePath);
            doc.write(os);

            logger.info("Converted doc saved to:" + absolutePath);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Convert error:", e);
        } finally {
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
        }
    }
}
