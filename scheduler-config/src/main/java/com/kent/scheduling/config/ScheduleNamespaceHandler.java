package com.kent.scheduling.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author kongtong.ouyang on 2018/2/6.
 */
public class ScheduleNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        this.registerBeanDefinitionParser("annotation-driven", new ScheduleBeanDefinitionParser());
    }

}
