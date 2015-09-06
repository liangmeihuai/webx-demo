package com.alibaba.zhu;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

/**
 * AbstractComponentTest
 *
 * @author <a href="mailto:gaozi.zgz@alibaba-inc.com">风袭</a>
 * @version V1.0.0
 * @since 2015-08-27
 */
@ContextConfiguration(value = {"classpath*:spring.xml"})
public abstract class AbstractComponentTest extends AbstractTestNGSpringContextTests {
/*    @BeforeClass
    public void before() throws Exception {
        AbstractScheduledService.Scheduler scheduler = SpringContextHolder.getBean("auditSchedulerFactoryBean");
        String[] groupNames = scheduler.getTriggerGroupNames();
        for (String groupName : groupNames) {
            String[] jobNames = scheduler.getJobNames(groupName);
            for (String jobName : jobNames) {
                scheduler.deleteJob(jobName, groupName);
            }
        }
    }*/

    @BeforeMethod
    public void beforeMethod(Method method) throws Exception {
        // invoke prepareAll and prepare{method.name}
        Class<?> cla = this.getClass();
        try {
            Method prepareAllMethod = cla.getMethod("prepareAll");
            prepareAllMethod.invoke(this);
        } catch (NoSuchMethodException e) {
            //System.out.println("没有方法：prepareAll");
        }
        try {
            Method prepareTestMethod = cla.getMethod("prepare" + method.getName().substring(4));
            prepareTestMethod.invoke(this);
        } catch (NoSuchMethodException e) {
            //System.out.println("没有方法：prepare" + method.getName().substring(4));
        }
    }

    @AfterMethod
    public void afterMethod(Method method) throws Exception {
        Class<?> cla = this.getClass();
        try {
            Method clearX = cla.getMethod("clear" + method.getName().substring(4));
            clearX.invoke(this);
        } catch (NoSuchMethodException e) {
            //System.out.println("没有方法：clearAll");
        }
        try {
            Method clearAll = cla.getMethod("clearAll");
            clearAll.invoke(this);
        } catch (NoSuchMethodException e) {
            //System.out.println("没有方法：clearAll");
        }
    }

}
