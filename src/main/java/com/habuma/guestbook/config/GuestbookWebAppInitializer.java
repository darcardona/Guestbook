package com.habuma.guestbook.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class GuestbookWebAppInitializer implements WebApplicationInitializer {
    private static final Logger logger = LoggerFactory.getLogger(GuestbookWebAppInitializer.class);

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        logger.debug("*****  onStartup  *****");
        container.setInitParameter("contextConfigLocation", "com.habuma.guestbook.config");

        AnnotationConfigWebApplicationContext contextLoaderContext = new AnnotationConfigWebApplicationContext();
        container.addListener(new ContextLoaderListener(contextLoaderContext));
//        contextLoaderContext.register(WebConfig.class);

        AnnotationConfigWebApplicationContext dispatcherServletContext = new AnnotationConfigWebApplicationContext();
        dispatcherServletContext.setConfigLocation("");
        ServletRegistration.Dynamic dispatcher =
                container.addServlet("appServlet", new DispatcherServlet(dispatcherServletContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
