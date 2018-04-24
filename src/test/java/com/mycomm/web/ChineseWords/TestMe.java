/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomm.web.ChineseWords;

import com.mycomm.itool.MyPublicTool.SystemUtil;
import java.io.File;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jw362j
 */
public class TestMe {

    private static final Logger log = LoggerFactory.getLogger(TestMe.class);

    @Before
    public void setup() {
        log.info("==========================junit setup====================================");
    }

    public void makeCodedWords(String path, String name) {
//        String path = "C:\\Users\\jw362j\\a\\z_temp\\古文观止\\古文观止_注音注解_html\\25.html";
        String path_out = "C:\\Users\\jw362j\\Desktop\\gwgzj\\";
        String content = SystemUtil.ReadFromFile(path, null);
        StringBuilder sb_temp = new StringBuilder();
        int length = content.length();
        for (int i = 0; i < length; i++) {
            char x = content.charAt(i);
            String ttt = x+"";
            if (!isChinese(x)) {
                if ("\n".equals(ttt) || "\t".equals(ttt)) {
                    sb_temp.append("<br/>");
                } else if(" ".equals(ttt)){
                    sb_temp.append("&nbsp;");
                }else{
                    sb_temp.append(ttt);
                }
            } else {
                sb_temp.append("<a class=\"tooltip-test\"  onclick=\"openDictionary('").append(ttt).append("')\">").append(ttt).append("</a> ");
            }
        }
        SystemUtil.WriteIntoFile(path_out + name, sb_temp.toString(), null);
    }

    @Test
    public void makeDocs() {
        String path = "C:\\Users\\jw362j\\Desktop\\gwgzj\\input.txt";
        makeCodedWords(path, "output.txt");

    }

    private boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) {
            return true;
        }
        return false;
    }

}
