package com.example.zero.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class LocaleResolverConfig implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String language = httpServletRequest.getParameter("language");
        Locale requestLocale = httpServletRequest.getLocale();
        if (!StringUtils.isEmpty(language)) {
            String[] strings = language.split("_");
            requestLocale = new Locale(strings[0], strings[1]);
        }
        return requestLocale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
