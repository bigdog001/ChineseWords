/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycomm.web.ChineseWords;

import com.mycomm.itool.MyPublicTool.SystemUtil;
import com.spreada.utils.chinese.ZHConverter;
import java.io.File;
import net.sourceforge.pinyin4j.PinyinHelper;
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
        String path_out = "C:\\Users\\jw362j\\a\\z_temp\\古文观止\\古文观止_注音注解_繁体_html\\";
        String content = SystemUtil.ReadFromFile(path, null);
        StringBuilder sb_temp = new StringBuilder();
        int length = content.length();
        for (int i = 0; i < length; i++) {
            char ttt = content.charAt(i);
            if (!isChinese(ttt)) {
                sb_temp.append(ttt);
            } else {
                String simplifiedSrc = ttt + "";
                String traditional = ZHConverter.convert(simplifiedSrc, ZHConverter.TRADITIONAL);
                sb_temp.append(traditional);
                log.info(traditional + " is chinese words!");
            }
        }
        SystemUtil.WriteIntoFile(path_out+name, sb_temp.toString(), null);
    }

    @Test
    public void makeDocs() {
        String path = "C:\\Users\\jw362j\\a\\z_temp\\古文观止\\古文观止_注音注解_html";

        File fs = new File(path);
        File[] fs_tmp = fs.listFiles();
        for (int i = 0; i < fs_tmp.length; i++) {
            if (fs_tmp[i].getAbsolutePath().endsWith("html")) {
                makeCodedWords(fs_tmp[i].getAbsolutePath(), fs_tmp[i].getName());
            }
        }

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
