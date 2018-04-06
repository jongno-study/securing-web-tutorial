package com.chori.securingwebtutorial.security.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SecurityService {
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public List<String> findAll() {
        return Arrays.asList("Foo", "Bar");
    }
}