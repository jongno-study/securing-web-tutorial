package com.yjsong.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class FooService {
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void findAll() {
		
	}

}
