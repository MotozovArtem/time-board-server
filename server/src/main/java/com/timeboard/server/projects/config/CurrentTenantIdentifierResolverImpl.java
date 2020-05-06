package com.timeboard.server.projects.config;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;

import com.timeboard.server.util.ThreadLocalStorage;

public class CurrentTenantIdentifierResolverImpl
		implements CurrentTenantIdentifierResolver {

	private static final String DEFAULT_TENANT_ID = "project_test";

	@Override
	public String resolveCurrentTenantIdentifier() {
		String tenant = ThreadLocalStorage.getTenant();
		if (tenant == null) {
			return DEFAULT_TENANT_ID;
		}
		return !tenant.isBlank() ? tenant : DEFAULT_TENANT_ID;
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		return true;
	}
}
