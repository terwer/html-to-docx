package com.terwergreen.lib;

import com.terwergreen.lib.converter.HtmlConverter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Unit test for HtmlConverterUtil
 */
public class HtmlConverterUtilTest {
    private static final Logger logger = LoggerFactory.getLogger(HtmlConverterUtilTest.class);

    private static final String HTML = "<html><body><h1>Hello World</h1></body></html>";
    // change it to your own path
    private static final String OUTPATH = "/opt/tmp/test.docx";

    @Before
    public void setUp() throws Exception {
        File file = new File(OUTPATH);
        if (file.exists()) {
            file.delete();
            logger.info("Deleting exist file");
        }
    }

    @Test
    public void convert() {
        HtmlConverterUtil.convert(HTML, OUTPATH);
        Assert.assertTrue(new File(OUTPATH).exists());
    }
}