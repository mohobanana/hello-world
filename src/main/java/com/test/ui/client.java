package com.test.ui;

import com.test.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class client {
    /**
     * ApplicationContext 常用实现类：
     *  ClassPathXmlApplicationContext:加载类路径下的配置文件。
     *  FileSystemXmlApplicationContext:加载磁盘路径下的配置文件（需要权限）。
     *  AnnotationConfigurationContext:用于读取注解创建容器。
     *
     * 核心容器的两个接口：
     *  ApplicationContext:立即加载。单例对象。
     *  BeanFactory:延迟加载。多例对象。
     *
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        AccountServiceImpl as =(AccountServiceImpl) ac.getBean("accountService");
        as.saveAccount();
    }
}
