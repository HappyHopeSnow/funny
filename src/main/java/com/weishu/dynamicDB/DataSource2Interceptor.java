package com.weishu.dynamicDB;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Jackie on 2015/8/24.
 * Email : chenxinhua@ishehui.com
 */
public class DataSource2Interceptor implements MethodBeforeAdvice, AfterReturningAdvice {

    private static final Logger LOGGER = Logger.getLogger(DataSource2Interceptor.class);

    public void beforeMethod() throws Throwable {
    }

    /**
     * 判断该方法是否是写入操作
     *
     * @param methodName
     * @return
     */
    private boolean isWrite(String methodName) {
//        if (methodName.startsWith("insert") ||
//                methodName.startsWith("save") ||
//                methodName.startsWith("add") ||
//                methodName.startsWith("upload") ||
//                methodName.startsWith("modify") ||
//                methodName.startsWith("delete") ||
//                methodName.startsWith("del")
//                ) {
//            return true;
//        }
//        return false;
        return true;
    }



    @Override
    public void before(Method m, Object[] args, Object target) throws Throwable {

        if (LOGGER.isDebugEnabled())
            LOGGER.debug("class name is " + m.getDeclaringClass() + "; method name is " + m.getName());


        if (m.isAnnotationPresent(DataSource.class)) {
            DataSource source = m.getAnnotation(DataSource.class);
            DatabaseContextHolder.setDataSource(source.value().getValue());
        } else {
            if (m.getDeclaringClass().isAnnotationPresent(DataSource.class)) {
                DataSource source = m.getDeclaringClass().getAnnotation(DataSource.class);
                DatabaseContextHolder.setDataSource(source.value().getValue());
            } else {
                if (isWrite(m.getName())) {
                    DatabaseContextHolder.setDataSource(DataSourceName.MASTER.getValue());
                } else {
                    DatabaseContextHolder.setDataSource(DataSourceName.SLAVE.getValue());
                }

            }
        }
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        DatabaseContextHolder.setDataSource(null);
    }
}
