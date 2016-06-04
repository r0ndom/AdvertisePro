package com.dnu.team.advertise.pro.service;

import com.dnu.team.advertise.pro.model.User;
import com.dnu.team.advertise.pro.model.UserSession;
import com.dnu.team.advertise.pro.service.session.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class SessionService {

    @Autowired
    private Storage<UserSession> sessionStorage;

    public void createSession(Authentication authentication, HttpServletResponse response) {
        final User authorizedUser = (User) authentication.getPrincipal();
        UserSession session = UserSession.newBuilder()
                .setId(authorizedUser.getId())
                .setEmail(authorizedUser.getContacts().getEmail())
                .build();
        String key = sessionStorage.storeObject(session);
        Cookie userCookie = new Cookie(UserSession.USER_KEY_NAME_COOKIE, key);
        response.addCookie(userCookie);
    }
}
