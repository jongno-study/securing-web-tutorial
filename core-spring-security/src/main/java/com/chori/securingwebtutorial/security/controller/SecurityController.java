package com.chori.securingwebtutorial.security.controller;

import com.chori.securingwebtutorial.security.service.IAuthenticationFacade;
import com.chori.securingwebtutorial.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;

@RequestMapping("/security")
@RestController
public class SecurityController {
    Logger logger = Logger.getLogger("com.chori.securingwebtutorial.security.controller");

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/testAuthentication")
    public String someControllerMethod() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        logger.info(currentPrincipalName);

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            logger.info(currentUserName);
        }

        return currentPrincipalName;
    }

    @GetMapping("/principalUsername")
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/authenticationUsername")
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }

    @GetMapping("/requestUsername")
    public String currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }

    @GetMapping("/authenticationFacadeUsername")
    public String currentUserNameSimple() {
        Authentication authentication = authenticationFacade.getAuthentication();
        return authentication.getName();
    }

    @GetMapping("/testPreAuthorize")
    public String testPreAuthorize(HttpServletRequest request) {
        logger.info(String.valueOf(request.isUserInRole("ROLE_MANAGER")));
        // 왜 권한 체크를 안하지?
        List<String> strings = securityService.findAll();
        strings.forEach(logger::info);

        return "Success";
    }
}
