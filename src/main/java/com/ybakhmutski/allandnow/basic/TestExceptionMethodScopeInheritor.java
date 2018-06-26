package com.ybakhmutski.allandnow.basic;

import java.io.IOException;

/**
 * Created by Yury_Bakhmutski on 2/16/2018.
 */
public class TestExceptionMethodScopeInheritor extends TestExceptionMethodScope {

    @Override
    public void method() throws Exception {
        super.method();
    }
}
