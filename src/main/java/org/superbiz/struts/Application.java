package org.superbiz.struts;

import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import com.opensymphony.module.sitemesh.filter.PageFilter;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBeanStruts() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        FilterDispatcher struts = new FilterDispatcher();
        registrationBean.setFilter(struts);
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBeanStrutsCleanup() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        ActionContextCleanUp strutsCleanup = new ActionContextCleanUp();
        registrationBean.setFilter(strutsCleanup);
        registrationBean.setOrder(2);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBeanPageFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        PageFilter pageFilter = new PageFilter();
        registrationBean.setFilter(pageFilter);
        registrationBean.setOrder(3);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

}


