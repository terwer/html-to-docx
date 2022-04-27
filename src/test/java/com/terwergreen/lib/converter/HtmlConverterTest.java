package com.terwergreen.lib.converter;

import com.terwergreen.lib.HtmlConverterUtilTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Unit test for HtmlConverter
 */
public class HtmlConverterTest {
    private static final Logger logger = LoggerFactory.getLogger(HtmlConverterTest.class);

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
    public void doConvert() {
        HtmlConverter converter = new HtmlConverter(HTML, OUTPATH);
        converter.doConvert();
        Assert.assertTrue(new File(OUTPATH).exists());
    }
}