package com.terwergreen;

import com.terwergreen.lib.HtmlConverterUtil;

/**
 * @author terwer
 */
public class Main {
    public static void main(String[] args) {
        String html = "<html><body><h1>Hello World</h1></body></html>";
        // change it to your own path
        String outpath = "/opt/tmp/test.docx";
        HtmlConverterUtil.convert(html, outpath);
    }
}
