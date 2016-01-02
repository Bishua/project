package ua.bish.project;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class SpringApplication implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "DispatcherServlet", new DispatcherServlet(getContext()));
        dispatcher.setLoadOnStartup(1);     //means load on startup = true
        dispatcher.addMapping("/");         //path of requests to handle
    }

    //create context and set packages to scan
    public AnnotationConfigWebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("ua.bish.project.config");
        return context;
    }
}
