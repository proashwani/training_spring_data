package com.javacodegeeks.spring.auditor;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl  implements AuditorAware<String> {
	@Override
	public String getCurrentAuditor() {
		return "SYSTEM";
	}
}
