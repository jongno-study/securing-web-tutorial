package com.yjsong.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yjsong.service.IAuthenticationFacade;

@RestController
public class SecurityController {
	
	@Autowired
	private IAuthenticationFacade authenticationFacade;
	
	public String currentUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		if(!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
		}
		
		return currentPrincipalName;
	}
	
	@GetMapping("/username")
	public String currentUserName(Principal principal) {
		return principal.getName();
	}

	@GetMapping("/authenticationusername")
	public String currentUserName(Authentication authentication) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		System.out.println("User has authorities: " + userDetails.getAuthorities());
		return authentication.getName();
	}
	
	@GetMapping("/requestusername")
	public String currentUserNameSimple(HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		return principal.getName();
	}
	
	@GetMapping("/authenticationFacadeusername")
	public String currentUserNameSimple() {
		Authentication authentication = authenticationFacade.getAuthentication();
		return authentication.getName();
	}
	
	@RequestMapping
	public void someControllerMethod(HttpServletRequest request) {
	    request.isUserInRole("someAuthority");
	}

}
