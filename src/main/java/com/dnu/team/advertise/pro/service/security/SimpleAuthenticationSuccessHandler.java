package com.dnu.team.advertise.pro.service.security;

import com.dnu.team.advertise.pro.model.Role;
import com.dnu.team.advertise.pro.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class SimpleAuthenticationSuccessHandler implements
        AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(
      final HttpServletRequest request,  final HttpServletResponse response,
      final Authentication authentication) throws IOException {
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }

    public void handle(final HttpServletRequest request, final HttpServletResponse response,
      final Authentication authentication) throws IOException {
        final String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            return;
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(final Authentication authentication) {
        final User authorizedUser = (User) authentication.getPrincipal();

        if (authorizedUser.getAuthorities().contains(Role.ROLE_ADMIN)) {
            return "/admin";
        }

        if (authorizedUser.getAuthorities().contains(Role.ROLE_CLIENT)) {
            return "/client/";
        }

        if (authorizedUser.getAuthorities().contains(Role.ROLE_AGENT)) {
            return "agent";
        }
        return "/";
    }


    protected void clearAuthenticationAttributes(
      final HttpServletRequest request) {
        final HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    public void setRedirectStrategy(final RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}