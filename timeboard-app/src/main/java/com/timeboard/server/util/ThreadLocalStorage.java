package com.timeboard.server.util;

public class ThreadLocalStorage {

	private static final ThreadLocal<String> tenant = new ThreadLocal<>();

	public static String getTenant() {
		return tenant.get();
	}

	public static void setTenant(String tenantName) {
		tenant.set(tenantName);
	}

	public static void clear() {
		tenant.remove();
	}

}