package io.github.lvbo.learn.guava.reflection;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author lvbo
 * @version V1.0
 * @date 2020/9/27 08:43
 */
public class ReflectionTest {

    @Test
    public void jdkNewProxyTest() {
        AddServiceImpl service = new AddServiceImpl();
        JdkInvocationHandlerImpl<AddService> addServiceHandler = new JdkInvocationHandlerImpl<>(service);
        AddService proxy = addServiceHandler.getProxy();
        Assert.assertEquals(3, proxy.add(1, 2));
    }

    @Test
    public void guavaNewProxyTest() {
        AddServiceImpl service = new AddServiceImpl();
        GuavaInvocationHandlerImpl<AddService> addServiceHandler = new GuavaInvocationHandlerImpl<>(AddService.class, service);
        AddService proxy = addServiceHandler.getProxy();
        Assert.assertEquals(3, proxy.add(1, 2));
    }

    @Test
    public void guavaNewProxyTest1() {
        AddServiceImpl service = new AddServiceImpl();
        GuavaAbstractInvocationHandlerImpl<AddService> addServiceHandler = new GuavaAbstractInvocationHandlerImpl<>(AddService.class, service);
        AddService proxy = addServiceHandler.getProxy();
        Assert.assertEquals(3, proxy.add(1, 2));
    }

}
