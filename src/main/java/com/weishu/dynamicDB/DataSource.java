package com.weishu.dynamicDB;

import java.lang.annotation.*;

/**
 * 如果不适用默认的数据源, 则需指定
 * Created by zhangshijie on 2015/6/9.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DataSource {
	/** 默认适用master*/
	DataSourceName value() default DataSourceName.MASTER;
}
