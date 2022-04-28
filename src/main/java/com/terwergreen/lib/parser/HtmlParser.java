package com.terwergreen.lib.parser;

import com.terwergreen.lib.util.StyleUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * HTML parser
 *
 * @name: HtmlParser
 * @author: terwer
 * @date: 2022-04-27 13:31
 **/
public class HtmlParser {
    private static final Logger logger = LoggerFactory.getLogger(HtmlParser.class);

    /**
     * Parse  html document to docx document
     *
     * @param doc          XWPF document
     * @param htmlDocument html document
     */
    public void parse(XWPFDocument doc, Document htmlDocument) {
        logger.info("HTML is parsing...");
        // get all html tag
        Elements es = htmlDocument.body().children();

        //create paragraph
        for (Element e : es) {
            createXwpfParagraph(doc, e);
        }

        logger.info("HTML is parsed successfully.");
    }

    /**
     * Create paragraph
     *
     * @param doc XWPF document
     * @param e   HTML Element
     */
    private void createXwpfParagraph(XWPFDocument doc, Element e) {
        // Save styles
        List<String> allStyles = new ArrayList<>();
        // Default no endline
        XWPFParagraph paragraph = null;
        // Create content and set style
        createXwpfRun(doc, paragraph, e, allStyles);
    }

    /**
     * Create paragraph run
     *
     * @param doc       XWPF document
     * @param paragraph paragraph
     * @param e         HTML Element
     * @param allStyles style
     */
    private void createXwpfRun(XWPFDocument doc, XWPFParagraph paragraph, Element e, List<String> allStyles) {
        List<Node> nodes = e.childNodes();
        if (CollectionUtils.isNotEmpty(nodes)) {
            for (Node node : nodes) {
                // Ignore null
                if (StringUtils.isEmpty(node.toString().trim())) {
                    continue;
                }

                // If a tag is TextNode, then it's a single tag
                if (node instanceof TextNode) {
                    TextNode textNode = (TextNode) node;
                    String nodeText = textNode.text().trim();

                    // Ignore null
                    if (StringUtils.isEmpty(nodeText)) {
                        continue;
                    }

                    if (null == paragraph) {
                        paragraph = doc.createParagraph();
                    }
                    XWPFRun run = paragraph.createRun();
                    // Set default run
                    run.setText(nodeText.trim());
                    // Set default font family
                    run.setFontFamily(StyleUtil.DEFAULT_FONT_FAMILY);
                    run.getCTR().getRPr().getRFonts().setAscii(StyleUtil.DEFAULT_FONT_FAMILY);
                    run.getCTR().getRPr().getRFonts().setEastAsia(StyleUtil.DEFAULT_FONT_FAMILY);
                    run.getCTR().getRPr().getRFonts().setHAnsi(StyleUtil.DEFAULT_FONT_FAMILY);
                    // Default font size
                    run.setFontSize(StyleUtil.DEFAULT_FONT_SIZE);
                    // Default font color
                    run.setColor(StyleUtil.DEFAULT_COLOR);
                    // Drfault style
                    run.setBold(false);
                } else if (node instanceof Element) {
                    // If a node is a Element,then it contains sub tags
                    Element child = (Element) node;

                    // loop
                    if (CollectionUtils.isNotEmpty(child.childNodes())) {
                        createXwpfRun(doc, paragraph, child, allStyles);
                    }
                }
            }
        }
    }
}
