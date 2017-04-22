package com.weishu.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CachedThreadPool
{
	protected static ExecutorService executor = Executors.newCachedThreadPool();

	public static ExecutorService getExecutorService() {
		return executor;
	}
}