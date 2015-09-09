package com.alibaba.zhu.utils;

import com.alibaba.zhu.AbstractComponentTest;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * WebUtilsTest
 *
 * @author <a href="mailto:gaozi.zgz@alibaba-inc.com">风袭</a>
 * @version V1.0.0
 * @since 2015-09-09
 */
public class WebUtilsTest extends AbstractComponentTest {

    @Test
    public void testGenerateID() {

        String id = WebUtils.generateID();
        System.out.println(id);

    }
}
